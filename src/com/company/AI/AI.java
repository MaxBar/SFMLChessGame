package com.company.AI;

import com.company.Engine.GameEngine;
import com.company.Engine.GameState;
import com.company.Entities.King;
import com.company.Entities.Pawn;
import com.company.Entities.Piece;
import com.company.Enums.PieceTypes;
import com.company.GameStates.MenuState;
import com.company.GameStates.PlayState;
import com.company.Utility.DrawLine;
import com.company.Utility.Pair;
import org.jsfml.graphics.Color;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.Sprite;
import org.jsfml.system.Vector2f;

import java.io.IOException;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.awt.SystemColor.window;

public class AI {

    private List<Piece> existingPieces;
    private ArrayList<List<Pair<Integer>>> possibleMovementPair;
    private Random random;
    private int newPosRow;
    private int newPosColumn;
    private int oldPosRow;
    private int oldPosColumn;
    
    private List<List<DrawLine>> line;
    private DrawLine moveLine;
    private int classPieceToMove;
    private int classToMove;
    
    private int count;


    public AI(List<Piece> existingPieces) {
        this.existingPieces = existingPieces;
        possibleMovementPair = new ArrayList<>();
        random = new Random();
        line = new ArrayList<>();
        count = 0;
        classPieceToMove = 0;
    }

    public void handleEvents(Piece[][] allPieces, Sprite[][] sprites, AI ai, GameEngine game, RenderWindow window) throws IOException {
        
        
        //existingPieces.forEach(Piece::clearPair);
        
        switch(count) {
            /*case 0:
                clearMoveLine();
                checkForCheck(allPieces, ai);
                ++count;
                break;*/
            case 0:
                clearMoveLine();
                while(!possibleMovementPair.isEmpty()) {
                    possibleMovementPair.clear();
                }
                while(!line.isEmpty()) {
                    line.clear();
                }
                existingPieces.forEach(Piece::clearPair);
                for (Piece piece : existingPieces) {
                    piece.checkMovement(allPieces, piece.getY(), piece.getX());
                    possibleMovementPair.add(piece.getPair());
                    line.add(piece.getLines());
                }
                //checkForCheck(allPieces, ai);
                ++count;
                break;
            case 1:
                clearLines();
                checkForCheck(allPieces, sprites, ai, game, window);
                //drawMoveLine(allPieces);
                ++count;
                break;
            case 2:
                count = 0;
                break;
                
        }
        /*for (Piece piece : existingPieces) {
            piece.checkMovement(allPieces, piece.getY(), piece.getX());
            possibleMovementPair.add(piece.getPair());
            line.add(piece.getLines());
        }*/

        /*for (int i = 0; i < possibleMovementPair.size(); i++) {
            System.out.println(possibleMovementPair.get(i));
        }
        System.out.println(possibleMovementPair.size());*/
        //System.out.println(line);
        //move(sprites, allPieces, ai);
    }
    
    private void checkForCheck(Piece[][] allPieces, Sprite[][] sprites, AI ai, GameEngine game, RenderWindow window) throws IOException {
        King kingPiece = (King) existingPieces.stream()
                .filter(p -> p.type() == PieceTypes.KING)
                .findFirst()
                .get();
        ArrayList<List<Pair<Integer>>> kingsPossibleMovementPair = new ArrayList<>();
        if(kingPiece.getIsChecked()) {
            kingPiece.checkMovement(allPieces, kingPiece.getY(), kingPiece.getX());
            kingsPossibleMovementPair.add(kingPiece.getPair());
            kingsPossibleMovementPair.forEach(System.out::println);
            moveKing(allPieces, sprites, kingsPossibleMovementPair, kingPiece, ai, game, window);
        } else {
            move(sprites, allPieces, ai);
        }
    }
    
    private void moveKing(Piece[][] allPieces, Sprite[][] sprites, ArrayList<List<Pair<Integer>>> pairList, King kingPiece, AI ai, GameEngine game, RenderWindow window) throws IOException {
        // Checking kings list
        boolean breakLoop = false;
        
        for(List<Pair<Integer>> pair : pairList) {
            for(Pair<Integer> p : pair) {
                
                // Checking every enemy piece list
                for(List<Pair<Integer>> possPair : ai.possibleMovementPair) {
                    for(Pair<Integer> pPair : possPair) {
                        if(!p.getRow().equals(pPair.getRow()) && !p.getColumn().equals(pPair.getColumn())) {
                            //Piece tempPiece = kingPiece;
                            oldPosRow = kingPiece.getY();
                            oldPosColumn = kingPiece.getX();
                            System.out.println("OldPosRow: " + oldPosRow);
                            System.out.println("OldPosColumn: " + oldPosColumn);
                            System.out.println("What is there: " + allPieces[oldPosRow][oldPosColumn]);
                            Sprite tempSprite = sprites[oldPosRow][oldPosColumn];
                            System.out.println(tempSprite);
                            Sprite emptySprite = new Sprite();
                            
                            for(int i = 0; i < pairList.size(); ++i) {
                                for(int j = 0; j < pairList.get(i).size(); ++j) {
                                    newPosRow = pairList.get(i).get(j).getRow();
                                    newPosColumn = pairList.get(i).get(j).getColumn();
                                }
                            }
                            Vector2f vector2f = new Vector2f(newPosColumn * 128 + 19, newPosRow * 128 + 19);
                            sprites[kingPiece.getY()][kingPiece.getX()].setPosition(vector2f.x, vector2f.y);
                            
                            allPieces[newPosRow][newPosColumn] = kingPiece;
                            System.out.println("newPosRow: " + newPosRow);
                            System.out.println("newPosColumn: " + newPosColumn);
                            System.out.println("What is at new pos: " + allPieces[newPosRow][newPosColumn]);
                            allPieces[kingPiece.getY()][kingPiece.getX()] = null;
                            sprites[newPosRow][newPosColumn] = tempSprite;
                            System.out.println(sprites[newPosRow][newPosColumn]);
                            sprites[oldPosRow][oldPosColumn] = emptySprite;
                            King[] kingArray = {(King) allPieces[newPosRow][newPosColumn]};
                            kingArray[0].setIsChecked(false);
    
                            for(int i = 0; i < ai.existingPieces.size(); ++i) {
                                if(ai.existingPieces.get(i).getX() == kingPiece.getX() && ai.existingPieces.get(i).getY() == kingPiece.getY()) {
                                    System.out.println("Removed from list : " + ai.existingPieces.get(i));
                                    ai.existingPieces.remove(i);
                                }
                            }
                            allPieces[newPosRow][newPosColumn].setX(newPosColumn);
                            allPieces[newPosRow][newPosColumn].setY(newPosRow);
                            
                            breakLoop = true;
                            break;
                        } else {
                            game.changeState(MenuState.getInstance(), window);
                        }
                    }
                    if(breakLoop)
                        break;
                }
                if(breakLoop)
                    break;
            }
            if(breakLoop)
                break;
        }
    }


    private void move(Sprite[][] sprites, Piece[][] allPieces, AI ai) {
        int min = 0;
        int max = possibleMovementPair.size() - 1;
        int pieceToMove;
        int toMove;

        do {
            pieceToMove = random.nextInt((max - min) + 1) + min;

        } while (possibleMovementPair.get(pieceToMove).size() <= 0);

        classPieceToMove = pieceToMove;
        
        max = possibleMovementPair.get(pieceToMove).size() - 1;
        
        toMove = random.nextInt((max - min) + 1) + min;
        classToMove = toMove;
        newPosRow = possibleMovementPair.get(pieceToMove).get(toMove).getRow();
        newPosColumn = possibleMovementPair.get(pieceToMove).get(toMove).getColumn();


        // Sätter en vector till nya positionen på brädet
        Vector2f vector2f = new Vector2f(newPosColumn * 128 + 19, newPosRow * 128 + 19);
        // Flyttar spriten till den nya positionen via vectorns x och y värden
        sprites[existingPieces.get(pieceToMove).getY()][existingPieces.get(pieceToMove).getX()].setPosition(vector2f.x, vector2f.y);
        
        oldPosRow = existingPieces.get(pieceToMove).getY();
        oldPosColumn = existingPieces.get(pieceToMove).getX();
        
        Piece tempPiece = allPieces[existingPieces.get(pieceToMove).getY()][existingPieces.get(pieceToMove).getX()];
        tempPiece.setHasMoved(true);
        
        Sprite tempSprite = sprites[oldPosRow][oldPosColumn];
        Sprite emptySprite = new Sprite();
        
        
        // Sätter pjäsen som rörde sig till nytt y-värde via newPosColumn
        existingPieces.get(pieceToMove).setX(newPosColumn);
        
        
        // Sätter pjäsen som rörde sig till nytt y-värde via newPosColumn
        existingPieces.get(pieceToMove).setY(newPosRow);
        
        
        
        
        allPieces[newPosRow][newPosColumn] = tempPiece;
        
        
        for(int i = 0; i < ai.existingPieces.size(); ++i) {
            if(ai.existingPieces.get(i).getX() == tempPiece.getX() && ai.existingPieces.get(i).getY() == tempPiece.getY()) {
                System.out.println("Removed from list : " + ai.existingPieces.get(i));
                ai.existingPieces.remove(i);
            }
        }
        // För att sätta i schack
        /*
        Efter man har flyttat på pjäsen, så skall den kolla allas sina nya possible movemenets
        Den ska kolla om varje != null är Piecetype.KING och om det är det så ska setIsChecked sättas till true
         */
        
        
        
        
    
        //System.out.println(ai.existingPieces);
        //Predicate<Piece> pieceToDelete = piece -> ai.
        //ai.existingPieces.stream().anyMatch()
        sprites[newPosRow][newPosColumn] = tempSprite;
        sprites[oldPosRow][oldPosColumn] = emptySprite;
        allPieces[oldPosRow][oldPosColumn] = null;
        
        // Set King to checked if checked
        /*List<List<Pair<Integer>>> tempPossibleMovementPair = new ArrayList<>();
        existingPieces.get(pieceToMove).checkMovement(allPieces, existingPieces.get(pieceToMove).getY(), existingPieces.get(pieceToMove).getX());
        tempPossibleMovementPair.add(existingPieces.get(pieceToMove).getPair());
        for(List<Pair<Integer>> pair : tempPossibleMovementPair) {
            for(Pair<Integer> p : pair) {
                System.out.println("Possible movement: X " + p.getColumn() + " | Y: " + p.getRow());
                if(allPieces[p.getRow()][p.getColumn()] != null) {
                    if (allPieces[p.getRow()][p.getColumn()].type() == PieceTypes.KING) {
                        System.out.println("Setting king to checked");
                        King king = (King) allPieces[p.getRow()][p.getColumn()];
                        king.setIsChecked(true);
                    }
                }
            }
        }*/
        
        /*for(int i = 0; i < tempPossibleMovementPair.size(); ++i) {
            for(int j = 0; j < tempPossibleMovementPair.get(i).size(); ++j) {
                if(allPieces[tempPossibleMovementPair.get(i).get(j).getColumn()][tempPossibleMovementPair.get(i).get(j).getRow()].type() == PieceTypes.KING) {
                    King king = (King) allPieces[tempPossibleMovementPair.get(i).get(j).getColumn()][tempPossibleMovementPair.get(i).get(j).getRow()];
                    king.setIsChecked(true);
                    System.out.println("Seeting king to checked");
                }
            }
        }*/
            
            //allPieces[newPosRow][newPosColumn]
            //existingPieces.get(pieceToMove).setX(newPosColumn);
            //piece.checkMovement(allPieces, piece.getY(), piece.getX());
            //possibleMovementPair.add(piece.getPair());
    }

    public void update() {}
    
    public void draw(RenderWindow window) {
        for(List<DrawLine> l : line) {
            for(DrawLine dl : l) {
                dl.draw(window);
            }
        }
        if(moveLine != null) {
            moveLine.draw(window);
        }
    }
    
    public void clearLines() {
        line.clear();
        for (Piece piece : existingPieces) {
            piece.clearLines();
        }
    }
    
    private void clearMoveLine() {
        moveLine = null;
    }
    
    /*private void drawMoveLine(Piece[][] allPieces) {
        Piece tempPiece = allPieces[existingPieces.get(classPieceToMove).getY()][existingPieces.get(classPieceToMove).getX()];
        
        //allPieces[currentRow][currentColumn].getLines().get(allPieces[currentRow][currentColumn].getLines().size() - 1).rotateLine(155);
        
        moveLine = allPieces[existingPieces.get(classPieceToMove).getY()][existingPieces.get(classPieceToMove).getX()].getLines().get(classToMove);
        //moveLine = tempPiece.getLines().get(allPieces[existingPieces.get(classPieceToMove).getY()][existingPieces.get(classPieceToMove).getX()].getLines().get(classToMove).getLine());
    }*/
    
    /*private void checkForCheck(Piece[][] allPieces, AI ai) {
        King kingPiece;
        if(existingPieces.stream().filter(p -> p.type() == PieceTypes.KING).findFirst().isPresent()) {
            kingPiece = (King) existingPieces.stream().filter(p -> p.type() == PieceTypes.KING).findFirst().get();
            if (kingPiece.getIsChecked()) {
                    System.out.println("King is checked, checking movements");
                    kingPiece.checkMovement(allPieces, kingPiece.getY(), kingPiece.getX());
                    System.out.println("King movements checked, sending to move King");
                    ifCheckedMove(kingPiece, ai);
                    count = 0;
                } else {
                    System.out.println("King is not checked");
                }
        }
        
        /*if(tempKingPiece.isPresent()) {
            kingPiece = tempKingPiece.get();
        }
        
        
    }*/
    
    /*private void ifCheckedMove(King king, AI ai) {
        boolean canNotMove = false;
        do {
            int whereToMoveRow;
            int whereToMoveColumn;
            List<Pair<Integer>> possibleMovements = king.getPair();
            for(Pair kingPair : possibleMovements) {
                canNotMove = false;
                if(kingPair.getRow() != ai.possibleMovementPair.stream()
                        .flatMap(Collection::stream)
                        .filter(p -> p.getRow() == kingPair.getRow()) &&
                        kingPair.getColumn() != ai.possibleMovementPair.stream()
                        .flatMap(Collection::stream)
                        .filter(p -> p.getColumn() == kingPair.getColumn())) {
                    System.out.println("Moving King to position:\nX: " + kingPair.getColumn() + "\nY: " + kingPair.getRow());
                    
                    
                } else {
                    canNotMove = true;
                }
            }
        } while (king.getIsChecked() || canNotMove);
        
        if(canNotMove) {
            System.out.println(this + "loses");
        }
    }*/
}
