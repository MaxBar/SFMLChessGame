package com.company.Entities;


import org.jsfml.graphics.IntRect;

public class Pawn extends Piece implements IEntity {

    private int startPosX;

    public PieceTypes type() {

        return PieceTypes.PAWN;

    }


    public Pawn() {

    }

    public Pawn(int x, int y, boolean isWhite) {

        super(x, y, isWhite);
        startPosX = 300;
        super.setStartPosX(startPosX);

    }

    public void move() {


    }


}

