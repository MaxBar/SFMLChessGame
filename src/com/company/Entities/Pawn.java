package com.company.Entities;

import com.company.Enums.PieceTypes;
import com.company.Managers.TextureManager;
import javafx.util.Pair;
import org.jsfml.graphics.Sprite;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece implements IEntity {
    //private int startPosX;
    private Sprite sprite;
    
    // Movement
    private boolean hasMoved;
    private final int hasMovedMove;
    private final int hasNotMovedMove;
    private List<Pair<Integer, Integer>> canMoveHere;
    //private List<List<Integer>> canMoveHere;
    
    public Pawn(int x, int y, boolean isWhite) {
        super(x, y, isWhite);
        super.startPosX = 300;
        super.setStartPosX(startPosX);
        sprite = new Sprite();
        
        // Movement
        hasMoved = false;
        hasMovedMove = 1;
        hasNotMovedMove = 2;
        canMoveHere = new ArrayList<>();
    }
    
    @Override
    public PieceTypes type() {
        return PieceTypes.PAWN;
    }
    
    @Override
    public Sprite getSprite(TextureManager textureManager, String filePath) {
        sprite.setTexture(textureManager.getTexture(filePath));
        sprite.setTextureRect(getIntRect());
        return sprite;
    }
    
    
    public void checkMovement(Piece[][] allPieces, Integer currentRow, Integer currentColumn) {
        if(allPieces[currentColumn][currentRow].isWhite()) {
            if(hasMoved) {
                for(int column = currentColumn; column > currentColumn - 1; --column) {
                    if(allPieces[column][currentRow] == null) {
                        canMoveHere.add(new Pair<>(column, currentRow));
                    }
                }
            } else {
                for(int column = currentColumn; column > currentColumn - 2; --column) {
                    if(allPieces[column][currentRow] == null) {
                        canMoveHere.add(new Pair<>(column, currentRow));
                    }
                }
            }
        } else {
            if(hasMoved) {
                for(int column = currentColumn; column < currentColumn + 1; ++column) {
                    if(allPieces[column][currentRow] == null) {
                        canMoveHere.add(new Pair<>(column, currentRow));
                    }
                }
            } else {
                for(int column = currentColumn; column < currentColumn + 2; ++column) {
                    if(allPieces[column][currentRow] == null) {
                        canMoveHere.add(new Pair<>(column, currentRow));
                    }
                }
            }
        }
        for(Pair pair : canMoveHere) {
            System.out.printf((String)pair.getKey(), pair.getValue());
        }
        System.out.println(canMoveHere);
    }
    
    @Override
    public void move() {
        if(!hasMoved) {
            
            hasMoved = false;
        } else {
        
        }
    }
}