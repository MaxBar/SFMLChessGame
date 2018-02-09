package com.company.AI;

import com.company.Entities.Piece;
import com.company.Utility.Pair;
import org.jsfml.graphics.Sprite;
import org.jsfml.system.Vector2f;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AI {

    private List<Piece> existingPieces;
    private ArrayList<ArrayList<Pair<Integer>>> possibleMovementPair;
    private Random random;
    private int newPosRow;
    private int newPosColumn;


    public AI(List<Piece> existingPieces) {
        this.existingPieces = existingPieces;
        possibleMovementPair = new ArrayList<>();
        random = new Random();
    }

    public void handleEvents(Piece[][] allPieces, Sprite[][] sprites) {
        while(!possibleMovementPair.isEmpty()) {
            possibleMovementPair.clear();
        }
        for(Piece piece : existingPieces) {
            piece.clearPair();
        }
        for (Piece piece : existingPieces) {
            piece.checkMovement(allPieces, piece.getY(), piece.getX());
            possibleMovementPair.add(piece.getPair());
        }

        /*for (int i = 0; i < possibleMovementPair.size(); i++) {
            System.out.println(possibleMovementPair.get(i));
        }
        System.out.println(possibleMovementPair.size());*/

        move(sprites, allPieces);
    }



    private void move(Sprite[][] sprites, Piece[][] allPieces) {
        int min = 0;
        int max = possibleMovementPair.size() - 1;
        int pieceToMove;
        int toMove;

        do {
            pieceToMove = random.nextInt((max - min) + 1) + min;
            System.out.println(pieceToMove);

        } while (possibleMovementPair.get(pieceToMove).size() <= 0);

        max = possibleMovementPair.get(pieceToMove).size() - 1;
    
    
        System.out.println("max value is " + max);
        System.out.println("pieceToMove's size is " + pieceToMove);
        System.out.println(possibleMovementPair.get(pieceToMove));
        System.out.println("possibleMovementPair's size is " + possibleMovementPair.get(pieceToMove).size());
        
        
        toMove = random.nextInt((max - min) + 1) + min;
        newPosRow = possibleMovementPair.get(pieceToMove).get(toMove).getPairNumber1();
        newPosColumn = possibleMovementPair.get(pieceToMove).get(toMove).getPairNumber2();


        // Sätter en vector till nya positionen på brädet
        Vector2f vector2f = new Vector2f(newPosColumn * 128 + 19, newPosRow * 128 + 19);
        // Flyttar spriten till den nya positionen via vectorns x och y värden
        sprites[existingPieces.get(pieceToMove).getY()][existingPieces.get(pieceToMove).getX()].setPosition(vector2f.x, vector2f.y);
        
        int oldPosRow = existingPieces.get(pieceToMove).getY();
        int oldPosColumn = existingPieces.get(pieceToMove).getX();
        System.out.println(oldPosRow + "--------------------------------------------------");
        System.out.println(oldPosColumn + "--------------------------------------------------");
    
        Piece tempPiece = allPieces[existingPieces.get(pieceToMove).getY()][existingPieces.get(pieceToMove).getX()];
        System.out.println(tempPiece);
        //System.out.println(allPieces[existingPieces.get(pieceToMove).getY()][existingPieces.get(pieceToMove).getX()]);
        // Sätter pjäsen som rörde sig till nytt y-värde via newPosColumn
        existingPieces.get(pieceToMove).setX(newPosColumn);
        System.out.println(existingPieces.get(pieceToMove).getX() + "------------------------------------------------------");
    
        // Sätter pjäsen som rörde sig till nytt y-värde via newPosColumn
        existingPieces.get(pieceToMove).setY(newPosRow);
        //System.out.println(tempPiece);
        allPieces[newPosRow][newPosColumn] = tempPiece;
        //System.out.println(tempPiece);
        System.out.println(allPieces[newPosRow][newPosColumn]);
        allPieces[oldPosRow][oldPosColumn] = null;
        //System.out.println(tempPiece);
        System.out.println("Row position: " + allPieces[newPosRow][newPosColumn].getY() + "\r\nColumn position: " + allPieces[newPosRow][newPosColumn].getX());
        
        //allPieces[existingPieces.get(pieceToMove).getY()][existingPieces.get(pieceToMove).getX()] = allPieces[oldPosRow][oldPosColumn];
        
        // Sätter brädets array med spelpjäser till att den nya positionen innehåller pjäsen som rörde sig
        ////////////////////7allPieces[newPosRow][newPosColumn] = allPieces[existingPieces.get(pieceToMove).getX()][existingPieces.get(pieceToMove).getY()];
        
        
        //sprites[existingPieces.get(pieceToMove).getY()][existingPieces.get(pieceToMove).getX()].move(vector2f);
        
        // Sätter gamla positionen till null för att indikera att den inte innehåller någon pjäs
        //allPieces[existingPieces.get(pieceToMove).getY()][existingPieces.get(pieceToMove).getX()] = null;
        
        for(int i = 0; i < allPieces.length; ++i) {
            for(int j = 0; j < allPieces[i].length; ++j) {
                if(j % 8 == 0) {
                    System.out.println();
                }
                System.out.println(allPieces[i][j]);
            }
        }
        System.out.println("Vector position x: " + vector2f.x + "\r\nVector position y: " + vector2f.y);

        //existingPieces.get(pieceToMove).setX(newPosColumn);
        //existingPieces.get(pieceToMove).setY(newPosRow);
        //existingPieces.get(pieceToMove).setY(newPosRow);
        //existingPieces.get(pieceToMove).setX(newPosColumn);
    }

    public void update() {

    }
}
