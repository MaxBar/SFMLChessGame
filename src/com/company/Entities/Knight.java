package com.company.Entities;

import com.company.Enums.PieceTypes;
import com.company.Managers.TextureManager;
import com.company.Utility.Movement;
import com.company.Utility.Pair;
import org.jsfml.graphics.Sprite;

import java.util.ArrayList;
import java.util.Collections;

public class Knight extends Piece implements IEntity {
    //private int startPosX;
    Sprite sprite;
    
    //Movement
    //private ArrayList<Pair<Integer>> pair;
    private Movement movement;



    public Knight(int x, int y, boolean isWhite) {
        super(x, y, isWhite);
        super.startPosX = 180;
        super.setStartPosX(startPosX);
        super.setPointValue(3);
        sprite = new Sprite();
       // pair = new ArrayList<>();
        movement = new Movement();
    }
    
    @Override
    public PieceTypes type() {
        return PieceTypes.KNIGHT;
    }
    
    @Override
    public Sprite getSprite(TextureManager textureManager, String filePath) {
        sprite.setTexture(textureManager.getTexture(filePath));
        //return textureManager.getSprite(getIntRect(), filePath);
        sprite.setTextureRect(getIntRect());
        return sprite;
    }
    
    public void checkMovement(Piece[][] allPieces, Integer currentRow, Integer currentColumn) {

        movement.knightCheckMovement(allPieces, super.pair, currentRow, currentColumn);

       /* int column = currentColumn;
        int row = currentRow;
        
        // UP LEFT
        if(currentRow > 1 && currentColumn > 0) {
            --column;
            row -= 2;
            setPairs(allPieces, column, row);
            column = currentColumn;
            row = currentRow;
        }
        
        // UP RIGHT
        if(currentRow > 1 && currentColumn < 7) {
            ++column;
            row -= 2;
            setPairs(allPieces, column, row);
            column = currentColumn;
            row = currentRow;
        }
        
        // RIGHT UP
        if(currentColumn < 6 && currentRow > 0) {
            column += 2;
            --row;
            setPairs(allPieces, column, row);
            column = currentColumn;
            row = currentRow;
        }
        
        // RIGHT DOWN
        if(currentColumn < 6 && currentRow < 7) {
            column += 2;
            ++row;
            setPairs(allPieces, column, row);
            column = currentColumn;
            row = currentRow;
        }
        
        // DOWN RIGHT
        if(currentRow < 6 && currentColumn < 7) {
            ++column;
            row += 2;
            setPairs(allPieces, column, row);
            column = currentColumn;
            row = currentRow;
        }
        
        // DOWN LEFT
        if(currentRow < 6 && currentColumn > 0) {
            --column;
            row += 2;
            setPairs(allPieces, column, row);
            column = currentColumn;
            row = currentRow;
        }
        
        // LEFT DOWN
        if(currentColumn > 1 && currentRow < 7) {
            column -= 2;
            ++row;
            setPairs(allPieces, column, row);
            column = currentColumn;
            row = currentRow;
        }
        
        // LEFT UP
        if(currentColumn > 1 && currentRow > 0) {
            column -= 2;
            ++row;
            setPairs(allPieces, column, row);
        }
        
        for(int i = 0; i < pair.size(); ++i) {
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
