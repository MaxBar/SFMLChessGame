package com.company.Entities;

import com.company.Enums.PieceTypes;
import com.company.Managers.TextureManager;
import com.company.Utility.Movement;
import com.company.Utility.Pair;
import org.jsfml.graphics.Sprite;

import java.util.ArrayList;

public class Bishop extends Piece implements IEntity {
    //private int startPosX;
    Sprite sprite;
    
    //Movement
    //private ArrayList<Pair<Integer>> pair;
    private Movement movement;
    
    public Bishop(int x, int y, boolean isWhite) {
        super(x, y, isWhite);
        super.startPosX = 240;
        super.setStartPosX(startPosX);
        sprite = new Sprite();
        //pair = new ArrayList<>();
        movement = new Movement();
    }


    @Override
    public PieceTypes type() {
        return PieceTypes.BISHOP;
    }
    
    @Override
    public Sprite getSprite(TextureManager textureManager, String filePath) {
        sprite.setTexture(textureManager.getTexture(filePath));
        //return textureManager.getSprite(getIntRect(), filePath);
        sprite.setTextureRect(getIntRect());
        return sprite;
    }
    
    public void checkMovement(Piece[][] allPieces, Integer currentRow, Integer currentColumn) {
        movement.bishopCheckMovement(allPieces, super.pair, currentRow, currentColumn);

/*        // LEFT UP
        if(currentRow > 0 && currentColumn > 0) {
            for (int row = currentRow, column = currentColumn; row > 0; --row, --column) {
                if(allPieces[row][currentColumn] != null) { break; }
                setPairs(allPieces, currentColumn, row);
            }
        }
        
        // RIGHT UP
        if(currentRow > 0 && currentColumn < 7) {
            for (int row = currentRow, column = currentColumn; row > 0; --row, ++column) {
                if(allPieces[row][currentColumn] != null) { break; }
                setPairs(allPieces, currentColumn, row);
            }
        }
        
        // LEFT DOWN
        if(currentRow < 7 && currentColumn > 0) {
            for (int row = currentRow, column = currentColumn; row > 0; ++row, --column) {
                if(allPieces[row][currentColumn] != null) { break; }
                setPairs(allPieces, currentColumn, row);
            }
        }
        
        // RIGHT DOWN
        if(currentRow < 0 && currentColumn < 7) {
            for (int row = currentRow, column = currentColumn; row > 0; ++row, ++column) {
                if(allPieces[row][currentColumn] != null) { break; }
                setPairs(allPieces, currentColumn, row);
            }
        }
        
        for(int i = 0; i <= pair.size(); ++i) {
            if(pair.size() > 0) {
                System.out.println(pair.get(i).toString());
            }
            System.out.println(pair.size());
        }*/
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
