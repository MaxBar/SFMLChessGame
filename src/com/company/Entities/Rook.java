package com.company.Entities;

import com.company.Enums.PieceTypes;
import com.company.Managers.TextureManager;
import org.jsfml.graphics.Sprite;

public class Rook extends Piece implements IEntity {
    //private int startPosX;
    Sprite sprite;
    
    public Rook(int x, int y, boolean isWhite) {
        super(x, y, isWhite);
        super.startPosX = 120;
        super.setStartPosX(startPosX);
        sprite = new Sprite();
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
    
    @Override
    public void checkMovement(Piece[][] allPieces, Integer currentRow, Integer currentColumn) {
    
    }
    
    @Override
    public void move() {
    
    }
}