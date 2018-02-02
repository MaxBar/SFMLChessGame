package com.company.Entities;

public class Bishop extends Piece implements IEntity {
    private int startPosX;
    
    public Bishop(int x, int y, boolean isWhite) {
        super(x, y, isWhite);
        startPosX = 300;
        super.setStartPosX(startPosX);
    }
    
    @Override
    public PieceTypes type() {
        return PieceTypes.BISHOP;
    }
    
    @Override
    public void move() {
    
    }
}
