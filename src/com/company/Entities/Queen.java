package com.company.Entities;

public class Queen extends Piece implements IEntity{
    private int startPosX;
    
    public Queen(int x, int y, boolean isWhite) {
        super(x, y, isWhite);
        startPosX = 300;
        super.setStartPosX(startPosX);
    }
    
    @Override
    public PieceTypes type() {
        return PieceTypes.QUEEN;
    }
    
    @Override
    public void move() {
    
    }
}