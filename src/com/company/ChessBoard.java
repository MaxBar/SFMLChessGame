package com.company;

import com.company.Entities.*;
import org.jsfml.graphics.*;

import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ChessBoard {
    Texture[][] texture;
    Texture[] boardTexture;
    Sprite[] sprite;
    Image[] image;
    String[] fileName;
    
    Image pieceImage;
    Texture pieceTexture;
    
    private List<Piece> blackPieces;
    private List<Piece> whitePieces;
    private int numberOfPieces;
    private int numberOfPawns;
    
    private Piece[][] allPieces;
    private int columns;
    private int rows;
    private int reverseRows;
    
    public ChessBoard() {
        texture = new Texture[8][8];
        boardTexture = new Texture[2];
        sprite = new Sprite[2];
        image = new Image[2];
        pieceImage = new Image();
        pieceTexture = new Texture();
        
        fileName = new String[2];
        fileName[0] = "BlackBackground.png";
        fileName[1] = "WhiteBackground.png";
        
        for(int i = 0; i < boardTexture.length; ++i) {
            boardTexture[i] = new Texture();
            image[i] = new Image();
            sprite[i] = new Sprite();
    
            try {
                image[i].loadFromFile(Paths.get("src/com/company/Images/" + fileName[i]));
                boardTexture[i].loadFromImage(image[i]);
            } catch(IOException |TextureCreationException ex) {
                System.err.println("Something went wrong:");
                ex.printStackTrace();
            }
        }
        
        blackPieces = new ArrayList<>();
        whitePieces = new ArrayList<>();
        numberOfPieces = 16;
        numberOfPawns = 8;
        
        allPieces = new Piece[8][8];
        columns = 8;
        rows = 2;
        reverseRows = 5;
    }
    
    public Sprite[][] createBoard() {
        Sprite[][] spriteArray = new Sprite[8][8];
        for(int i = 0; i < texture.length; ++i) {
            for(int j = 0; j < texture.length; ++j) {
                texture[i][j] = new Texture();
                spriteArray[i][j] = new Sprite();
                if((i % 2 == 0 && j % 2 == 0) ||
                        (i % 2 == 1 && j % 2 == 1)) {
                    try {
                        texture[i][j].loadFromImage(image[0]);
                        spriteArray[i][j].setTexture(texture[i][j]);
                    } catch (TextureCreationException e) {
                        System.err.println("Something went wrong:");
                        e.printStackTrace();
                    }
                } else {
                    try {
                        texture[i][j].loadFromImage(image[1]);
                        spriteArray[i][j].setTexture(texture[i][j]);
                    } catch (TextureCreationException e) {
                        System.err.println("Something went wrong:");
                        e.printStackTrace();
                    }
                }
            }
        }
        return spriteArray;
    }
    
    public void fillLists(boolean isWhite) {
        int count = 0;
        List<Piece> internalList = new ArrayList<>();
        
        internalList.add(new Rook(0, 0, isWhite));
        internalList.add(new Knight(0, 1, isWhite));
        internalList.add(new Bishop(0, 2, isWhite));
        internalList.add(new Queen(0, 3, isWhite));
        internalList.add(new King(0, 4, isWhite));
        internalList.add(new Bishop(0, 5, isWhite));
        internalList.add(new Knight(0, 6, isWhite));
        internalList.add(new Rook(0, 7, isWhite));
            for (int i = 0; i < numberOfPieces; ++i) {
                if (count < numberOfPawns) {
                    internalList.add(new Pawn(1, i, isWhite));
                }
                ++count;
            }
            
        if(isWhite) {
                whitePieces = internalList;
        } else {
                blackPieces = internalList;
        }
    }
    
    public void populateChessboardList() {
        for(int i = 0; i < rows; ++i) {
            for(int j = 0; j < columns; ++j) {
                if(i == 0) {
                    allPieces[i][j] = blackPieces.get(i + j);
                } else {
                    allPieces[i][j] = blackPieces.get(i + j + 7);
                }
            }
        }
        
        for(int i = 0; i < rows; ++i) {
            for(int j = 0; j < columns; ++j) {
                if(i == 0) {
                    allPieces[allPieces[i].length - 1 -i][j] = whitePieces.get(i + j);
                } else {
                    allPieces[allPieces[i].length - 1 -i][j] = whitePieces.get(i + j + 7);
                }
            }
        }
    }
    
    public List<Piece> getBlackPieces() {
        return blackPieces;
    }
    
    public List<Piece> getWhitePieces() {
        return whitePieces;
    }
}
