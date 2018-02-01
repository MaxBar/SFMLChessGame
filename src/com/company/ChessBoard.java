package com.company;

import org.jsfml.graphics.*;

import java.io.IOException;
import java.nio.file.Paths;

public class ChessBoard {
    Texture[][] texture;
    Texture[] boardTexture;
    Sprite[] sprite;
    Image[] image;
    String[] fileName;
    
    public ChessBoard() {
        texture = new Texture[8][8];
        boardTexture = new Texture[2];
        sprite = new Sprite[2];
        image = new Image[2];
        
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
}
