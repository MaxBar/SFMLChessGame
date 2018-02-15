package com.company.Entities;

import com.company.Enums.PieceTypes;
import com.company.Managers.TextureManager;
import com.company.Utility.Movement;
import com.company.Utility.Pair;
import org.jsfml.graphics.Sprite;

import java.util.ArrayList;

public class King extends Piece implements IEntity {

    Sprite sprite;
    private Movement movement;


    public King(int x, int y, boolean isWhite) {
        super(x, y, isWhite);
        super.startPosX = 60;
        super.setStartPosX(startPosX);
        super.setPointValue(100);
        sprite = new Sprite();
        //pair = new ArrayList<>();
        movement = new Movement();
    }

    @Override
    public PieceTypes type() {
        return PieceTypes.KING;
    }

    @Override
    public Sprite getSprite(TextureManager textureManager, String filePath) {
        sprite.setTexture(textureManager.getTexture(filePath));
        //return textureManager.getSprite(getIntRect(), filePath);
        sprite.setTextureRect(getIntRect());
        return sprite;
    }

    public void checkMovement(Piece[][] allPieces, Integer currentRow, Integer currentColumn) {
        movement.kingCheckMovement(allPieces, super.pair, currentRow, currentColumn);
    }

    @Override
    public void move() {
    }
}
