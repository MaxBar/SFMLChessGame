package com.company.GameStates;

import com.company.ChessBoard;
import com.company.Engine.GameEngine;
import com.company.Engine.GameState;
import com.company.Entities.AI;
import com.company.Entities.Piece;
import com.company.Managers.TextureManager;
import org.jsfml.graphics.*;
import org.jsfml.system.Vector2f;
import org.jsfml.window.event.Event;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlayState extends GameState {
    private static PlayState playState = null;
    private AI[] ai;
    private ChessBoard chessBoard;
    private Sprite[][] boardSprite;
    private Sprite[][] pieceSprite;
    private TextureManager textureManager;
    
    String chessFilePath;
    private Piece[][] allpieces;
    
    float movementSpeed;
    boolean pressedButton;
    float newPosY;
    
    private PlayState() throws IOException {
    
    }
    
    public static PlayState getInstance() throws IOException {
        if (playState == null) {
            playState = new PlayState();
        }
        return playState;
    }
    
    @Override
    public void init(RenderWindow window) throws IOException {
        window.clear();
        
        movementSpeed = 0.2f;
        pressedButton = false;
        newPosY = 19 + 128;
        
        System.out.println("Inside PlayState");
        chessBoard = new ChessBoard();
        boardSprite = chessBoard.createBoard();
        
        for(int i = 0; i < boardSprite.length; ++i) {
            for(int j = 0; j < boardSprite.length; ++j) {
                boardSprite[i][j].setPosition(new Vector2f(i * 128, j * 128));
            }
        }
        
        chessBoard.fillLists(false);
        chessBoard.fillLists(true);
        
        chessBoard.populateChessboardList();
    
        textureManager = new TextureManager();
        chessFilePath = "src/com/company/Images/ChessPiecesArray.png";
        allpieces = chessBoard.getAllPieces();
        
        
        pieceSprite = new Sprite[8][8];
        
        for(int i = 0; i < allpieces.length; ++i ) {
            for(int j = 0; j < allpieces.length; ++j) {
                pieceSprite[i][j] = new Sprite();
                
                if(chessBoard.getAllPieces()[i][j] != null) {
                    pieceSprite[i][j] = allpieces[i][j].getSprite(textureManager, chessFilePath);
                    pieceSprite[i][j].setPosition(new Vector2f(j * 128 + 19, i * 128 + 19));
                    pieceSprite[i][j].setScale(new Vector2f(1.5f, 1.5f));
                }
            }
        }
    }
    
    @Override
    public void handleEvents(GameEngine game, RenderWindow window, float deltaTime) throws IOException {
        for(Event event : window.pollEvents()) {
            switch(event.type) {
                case CLOSED:
                    window.close();
                    game.quit();
                    break;
                case KEY_RELEASED:
                    switch (event.asKeyEvent().key) {
                        case SPACE:
                            pressedButton = true;
                            newPosY += 128;
                            System.out.println(newPosY);
                            break;
                    }
                case MOUSE_ENTERED:
                    break;
            }
        }
    }
    
    @Override
    public void update(GameEngine game, RenderWindow window, float deltaTime) throws IOException {
        window.clear(Color.BLACK);
        System.out.println(pieceSprite[1][0].getPosition().y);
        if(pressedButton) {
            if (pieceSprite[1][0].getPosition().y <= newPosY) {
                pieceSprite[1][0].move(0, movementSpeed * deltaTime);
            } else if (pieceSprite[1][0].getPosition().y >= (19 + 128 * 8)) {
                pieceSprite[1][0].setPosition(pieceSprite[1][0].getPosition().x, 1024);
                pressedButton = false;
            }
        }
    }
    
    @Override
    public void draw(GameEngine game, RenderWindow window) throws IOException {
        
        
        for (Sprite[] boardSpriteI : boardSprite) {
            for (Sprite boardSpriteJ : boardSpriteI) {
                window.draw(boardSpriteJ);
            }
        }
    
        for (Sprite[] PieceSpriteI : pieceSprite) {
            for (Sprite PieceSpriteJ : PieceSpriteI) {
                if(PieceSpriteJ != null) {
                    window.draw(PieceSpriteJ);
                }
            }
        }
        window.display();
    }
}