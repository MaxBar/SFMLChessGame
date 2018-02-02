package com.company.Entities;

import com.company.Managers.TextureManager;
import org.jsfml.graphics.Sprite;

public class King extends Piece implements IEntity {
    //private int startPosX;
    
    public King(int x, int y, boolean isWhite) {
        super(x, y, isWhite);
        super.startPosX = 60;
        super.setStartPosX(startPosX);
    }
    
    @Override
    public PieceTypes type() {
        return PieceTypes.KING;
    }
    
    @Override
    public Sprite getSprite(TextureManager textureManager, String filePath) {
        return textureManager.getSprite(getIntRect(), filePath);
    }
    
    @Override
    public void move() {
    
    }
}
