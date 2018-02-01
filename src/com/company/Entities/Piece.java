package com.company.Entities;

import org.jsfml.graphics.IntRect;

import java.util.ArrayList;

public abstract class Piece {

    private int x;
    private int y;
    private int startPosX;
    private int startPosY;
    private int endPosX;
    private int endPosY;
    private boolean isWhite;

    public IntRect getIntRect() {

        if (isWhite) {

            startPosY = 60;

        }
        IntRect rect = new IntRect(startPosX, startPosY, endPosX, endPosY);
        return rect;

    }

    public Piece() {

    }

    public Piece(int x, int y, boolean isWhite) {

        this.isWhite = isWhite;
        this.x = x;
        this.y = y;
        startPosX = 0;
        startPosY = 0;
        endPosX = 60;
        endPosY = 60;

    }

    public boolean isWhite() {
        return isWhite;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setStartPosX(int startPosX) {
        this.startPosX = startPosX;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


    public PieceTypes type() {

        return type();

    }

}