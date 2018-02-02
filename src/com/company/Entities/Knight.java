package com.company.Entities;

public class Knight extends Piece implements IEntity {
    private int startPosX;
    
    public Knight(int x, int y, boolean isWhite) {
        super(x, y, isWhite);
        startPosX = 300;
        super.setStartPosX(startPosX);
    }
    
    @Override
    public PieceTypes type() {
        return PieceTypes.KNIGHT;
    }
    
    @Override
    public void move() {
    
    }
}
