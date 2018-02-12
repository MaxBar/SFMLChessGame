package com.company.Entities;

import com.company.Enums.PieceTypes;
import com.company.Managers.TextureManager;
import com.company.Utility.Movement;
import com.company.Utility.Pair;
import org.jsfml.graphics.Sprite;

import java.util.ArrayList;

public class King extends Piece implements IEntity {
    //private int startPosX;
    Sprite sprite;

    //Movement
   // private ArrayList<Pair<Integer>> pair;
    private Movement movement;
    
    public King(int x, int y, boolean isWhite) {
        super(x, y, isWhite);
        super.startPosX = 60;
        super.setStartPosX(startPosX);
        super.setPointValue(100);
        sprite = new Sprite();
        //pair = new ArrayList<>();
        movement = new Movement();
    }

    
    @Override
    public PieceTypes type() {
        return PieceTypes.KING;
    }
    
    @Override
    public Sprite getSprite(TextureManager textureManager, String filePath) {
        sprite.setTexture(textureManager.getTexture(filePath));
        //return textureManager.getSprite(getIntRect(), filePath);
        sprite.setTextureRect(getIntRect());
        return sprite;
    }

    public void checkMovement(Piece[][] allPieces, Integer currentRow, Integer currentColumn) {
        movement.kingCheckMovement(allPieces, super.pair, currentRow, currentColumn);
//        int column = currentColumn;
//        int row = currentRow;
//
//        // UP
//        if (currentRow > 0) {
//            --row;
//            setPairs(allPieces, column, row);
//            row = currentRow;
//        }
//
//        // UP LEFT
//        if(currentRow > 0 && currentColumn > 0) {
//            --column;
//            --row;
//            setPairs(allPieces, column, row);
//            column = currentColumn;
//            row = currentRow;
//        }
//
//        // UP RIGHT
//        if(currentRow > 0 && currentColumn < 7) {
//            ++column;
//            --row;
//            setPairs(allPieces, column, row);
//            column = currentColumn;
//            row = currentRow;
//        }
//
//        //DOWN
//        if (currentRow < 7) {
//            ++row;
//            setPairs(allPieces, column, row);
//            row = currentRow;
//        }
//
//        // DOWN RIGHT
//        if(currentRow < 7 && currentColumn < 7) {
//            ++column;
//            ++row;
//            setPairs(allPieces, column, row);
//            column = currentColumn;
//            row = currentRow;
//        }
//
//        // DOWN LEFT
//        if(currentRow < 7 && currentColumn > 0) {
//            --column;
//            ++row;
//            setPairs(allPieces, column, row);
//            column = currentColumn;
//            row = currentRow;
//        }
//
//        // LEFT
//        if (currentColumn > 0) {
//            --column;
//            setPairs(allPieces, column, row);
//            column = currentColumn;
//        }
//
//        // RIGHT
//        if (currentColumn < 7) {
//            ++column;
//            setPairs(allPieces, column, row);
//        }
//
//        for(int i = 0; i < pair.size(); ++i) {
//            if(pair.size() > 0) {
//                System.out.println(pair.get(i).toString());
//            }
//            System.out.println(pair.size());
//        }
    }

/*    private void setPairs(Piece[][] allPieces, int column, int row) {
        if(allPieces[row][column] == null) {
            Pair whereToMove = new Pair(row, column);
            pair.add(whereToMove);
            this.setX(column);
            this.setY(row);
        }
    }*/
    
    @Override
    public void move() {
    
    }
}
