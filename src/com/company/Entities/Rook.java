package com.company.Entities;

public class Rook extends Piece implements IEntity {
    private int startPosX;
    
    public Rook(int x, int y, boolean isWhite) {
        super(x, y, isWhite);
        startPosX = 300;
        super.setStartPosX(startPosX);
    }
    
    @Override
    public PieceTypes type() {
        return PieceTypes.ROOK;
    }
    
    @Override
    public void move() {
    
    }
}