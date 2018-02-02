package com.company.Entities;

public class Pawn extends Piece implements IEntity {
    private int startPosX;
    
    public Pawn(int x, int y, boolean isWhite) {
        super(x, y, isWhite);
        startPosX = 300;
        super.setStartPosX(startPosX);
    }
    
    @Override
    public PieceTypes type() {
        return PieceTypes.PAWN;
    }

    @Override
    public void move() {
    
    }
}