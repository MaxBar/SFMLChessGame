package com.company.Entities;

import com.company.Enums.PieceTypes;
import com.company.Managers.TextureManager;
import com.company.Utility.Movement;
import com.company.Utility.Pair;
import org.jsfml.graphics.Sprite;

import java.util.ArrayList;

public class Rook extends Piece implements IEntity {
    //private int startPosX;
    Sprite sprite;
    
    //Movement
    private boolean hasMoved;
    //private ArrayList<Pair<Integer>> pair;
    private Movement movement;
    
    public Rook(int x, int y, boolean isWhite) {
        super(x, y, isWhite);
        super.startPosX = 120;
        super.setStartPosX(startPosX);
        super.setPointValue(5);
        sprite = new Sprite();
        //pair = new ArrayList<>();
        movement = new Movement();
    }


    @Override
    public PieceTypes type() {
        return PieceTypes.ROOK;
    }
    
    @Override
    public Sprite getSprite(TextureManager textureManager, String filePath) {
        sprite.setTexture(textureManager.getTexture(filePath));
        //return textureManager.getSprite(getIntRect(), filePath);
        sprite.setTextureRect(getIntRect());
        return sprite;
    }
    
    public void checkMovement(Piece[][] allPieces, Integer currentRow, Integer currentColumn) {
        movement.rookCheckMovement(allPieces, super.pair, currentRow, currentColumn);
//            // UP
//            if(currentRow > 0) {
//                for (int row = currentRow; row > 0; --row) {
//                    if(allPieces[row][currentColumn] != null) { break; }
//                    setPairs(allPieces, currentColumn, row);
//                }
//            }
//
//            // DOWN
//            if(currentRow < 7) {
//                for (int row = currentRow; row < 7; ++row) {
//                    if(allPieces[row][currentColumn] != null) { break; }
//                    setPairs(allPieces, currentColumn, row);
//                }
//            }
//
//            // LEFT
//            if(currentColumn > 0) {
//                for (int column = currentColumn; column > 0; --column) {
//                    if(allPieces[currentRow][column] != null) { break; }
//                    setPairs(allPieces, column, currentRow);
//                }
//            }
//
//            // RIGHT
//            if(currentColumn < 7) {
//                for (int column = currentColumn; column > 7; ++column) {
//                    if(allPieces[currentRow][column] != null) { break; }
//                    setPairs(allPieces, column, currentRow);
//                }
//            }
//
//
//        for(int i = 0; i <= pair.size(); ++i) {
//            if(pair.size() > 0) {
//                System.out.println(pair.get(i).toString());
//            }
//            System.out.println(pair.size());
//        }
    }
    
//    private void setPairs(Piece[][] allPieces, int column, int row) {
//        if(allPieces[row][column] == null) {
//            Pair whereToMove = new Pair(row, column);
//            pair.add(whereToMove);
//            this.setX(column);
//            this.setY(row);
//        }
//    }
    
    @Override
    public void move() {
    
    }
}