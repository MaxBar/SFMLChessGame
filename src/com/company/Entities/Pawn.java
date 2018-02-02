package com.company.Entities;

import com.company.Managers.TextureManager;
import org.jsfml.graphics.Sprite;

public class Pawn extends Piece implements IEntity {
    //private int startPosX;
    
    public Pawn(int x, int y, boolean isWhite) {
        super(x, y, isWhite);
        super.startPosX = 300;
        super.setStartPosX(startPosX);
    }
    
    @Override
    public PieceTypes type() {
        return PieceTypes.PAWN;
    }
    
    @Override
    public Sprite getSprite(TextureManager textureManager, String filePath) {
        return textureManager.getSprite(getIntRect(), filePath);
    }
    
    @Override
    public void move() {
    
    }
}