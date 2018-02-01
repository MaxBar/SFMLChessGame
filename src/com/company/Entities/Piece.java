package com.company.Entities;

import java.util.ArrayList;

public class Piece {

    public int x;
    public int y;
    public boolean isWhite;


    public ArrayList<Piece> whitePieces; // List for white pieces
    public ArrayList<Piece> blackPieces; // List for black pieces

    public Piece getPiece(int x, int y) {

        for (Piece p : whitePieces) {
            if (p.getX() == x && p.getY() == y) {
                return p;
            }
        }
        for (Piece p : blackPieces) {
            if (p.getX() == x && p.getY() == y) {
                return p;
            }
        }

        return null;
    }

    public Piece() {

    }

    public Piece(int x, int y, boolean isWhite) {

        this.isWhite = isWhite;
        this.x = x;
        this.y = y;

    }

    public boolean isWhite() {
        return isWhite;
    }

    public boolean isBlack() {
        return !isWhite;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean canMove(int destination_x, int destination_y) {
        return false;
    }
}