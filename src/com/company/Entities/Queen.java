package com.company.Entities;

import com.company.Enums.PieceTypes;
import com.company.Managers.TextureManager;
import com.company.Utility.Movement;
import com.company.Utility.Pair;
import org.jsfml.graphics.Sprite;

import java.util.ArrayList;

public class Queen extends Piece implements IEntity{
    //private int startPosX;
    Sprite sprite;

    //Movement
    private ArrayList<Pair<Integer>> pair;
    private Movement movement;

    public Queen(int x, int y, boolean isWhite) {
        super(x, y, isWhite);
        super.startPosX = 0;
        super.setStartPosX(startPosX);
        sprite = new Sprite();
        movement = new Movement();
        pair = new ArrayList<>();
    }


    
    @Override
    public PieceTypes type() {
        return PieceTypes.QUEEN;
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
        movement.queenCheckMovement(allPieces, pair, currentRow, currentColumn);
    }
    
    @Override
    public void move() {
    
    }
}