package com.company.Entities;

import com.company.Enums.PieceTypes;
import com.company.Managers.TextureManager;
import org.jsfml.graphics.Sprite;

public class Pawn extends Piece implements IEntity {
    //private int startPosX;
    Sprite sprite;
    
    public Pawn(int x, int y, boolean isWhite) {
        super(x, y, isWhite);
        super.startPosX = 300;
        super.setStartPosX(startPosX);
        sprite = new Sprite();
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
    
    @Override
    public void move() {
    
    }
}