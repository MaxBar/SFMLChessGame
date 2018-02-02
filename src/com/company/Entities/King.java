package com.company.Entities;

public class King extends Piece implements IEntity {
    private int startPosX;
    
    public King(int x, int y, boolean isWhite) {
        super(x, y, isWhite);
        startPosX = 300;
        super.setStartPosX(startPosX);
    }
    
    @Override
    public PieceTypes type() {
        return PieceTypes.KING;
    }
    
    @Override
    public void move() {
    
    }
}
