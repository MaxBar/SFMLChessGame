package com.company.Entities;

import com.company.Managers.TextureManager;
import org.jsfml.graphics.Sprite;

public class Knight extends Piece implements IEntity {
    //private int startPosX;
    Sprite sprite;
    
    public Knight(int x, int y, boolean isWhite) {
        super(x, y, isWhite);
        super.startPosX = 180;
        super.setStartPosX(startPosX);
        sprite = new Sprite();
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
    
    @Override
    public void move() {
    
    }
}
