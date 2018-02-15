package com.company.AI;

import com.company.Entities.Pawn;
import com.company.Entities.Piece;
import com.company.Utility.DrawLine;
import com.company.Utility.Pair;
import org.jsfml.graphics.Color;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.Sprite;
import org.jsfml.system.Vector2f;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

public class AI {

    private List<Piece> existingPieces;
    private ArrayList<List<Pair<Integer>>> possibleMovementPair;
    private Random random;
    private int newPosRow;
    private int newPosColumn;
    private int oldPosRow;
    private int oldPosColumn;
    
    private List<List<DrawLine>> line;


    public AI(List<Piece> existingPieces) {
        this.existingPieces = existingPieces;
        possibleMovementPair = new ArrayList<>();
        random = new Random();
        line = new ArrayList<>();
    }

    public void handleEvents(Piece[][] allPieces, Sprite[][] sprites, AI ai) {
        while(!possibleMovementPair.isEmpty()) {
            possibleMovementPair.clear();
        }
        while(!line.isEmpty()) {
            line.clear();
        }
        existingPieces.forEach(Piece::clearPair);
        /*for(Piece piece : existingPieces) {
            piece.clearPair();
        }*/
        for (Piece piece : existingPieces) {
            piece.checkMovement(allPieces, piece.getY(), piece.getX());
            possibleMovementPair.add(piece.getPair());
            line.add(piece.getLines());
        }

        /*for (int i = 0; i < possibleMovementPair.size(); i++) {
            System.out.println(possibleMovementPair.get(i));
        }
        System.out.println(possibleMovementPair.size());*/
        //System.out.println(line);
        move(sprites, allPieces, ai);
    }



    private void move(Sprite[][] sprites, Piece[][] allPieces, AI ai) {
        int min = 0;
        int max = possibleMovementPair.size() - 1;
        int pieceToMove;
        int toMove;

        do {
            pieceToMove = random.nextInt((max - min) + 1) + min;

        } while (possibleMovementPair.get(pieceToMove).size() <= 0);

        max = possibleMovementPair.get(pieceToMove).size() - 1;
        
        toMove = random.nextInt((max - min) + 1) + min;
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
    
        //System.out.println(ai.existingPieces);
        //Predicate<Piece> pieceToDelete = piece -> ai.
        //ai.existingPieces.stream().anyMatch()
        sprites[newPosRow][newPosColumn] = tempSprite;
        sprites[oldPosRow][oldPosColumn] = emptySprite;
        allPieces[oldPosRow][oldPosColumn] = null;
    }

    public void update() {}
    
    public void draw(RenderWindow window) {
        for(List<DrawLine> l : line) {
            for(DrawLine dl : l) {
                dl.draw(window);
            }
        }
    }
    
    public void clearLines() {
        line.clear();
        for (Piece piece : existingPieces) {
            piece.clearLines();
        }
    }
}
