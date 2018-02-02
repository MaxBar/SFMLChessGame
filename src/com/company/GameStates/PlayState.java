package com.company.GameStates;

import com.company.ChessBoard;
import com.company.Engine.GameEngine;
import com.company.Engine.GameState;
import com.company.Entities.AI;
import org.jsfml.graphics.Color;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.Sprite;
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
        System.out.println("Inside PlayState");
        chessBoard = new ChessBoard();
        boardSprite = chessBoard.createBoard();
        
        for(int i = 0; i < boardSprite.length; ++i) {
            for(int j = 0; j < boardSprite.length; ++j) {
                boardSprite[i][j].setPosition(new Vector2f(i * 128, j * 128));
                System.out.println("x: " + i * 128);
                System.out.println("y: " + j * 128);
                
                if(i % 8 == 0) {
                    boardSprite[i][j].setPosition(new Vector2f(i * 128, j * 128));
                    System.out.println("x: " + i * 128);
                    System.out.println("y: " + j * 128);
                }
            }
        }
        
        chessBoard.fillLists(false);
        chessBoard.fillLists(true);
        
        chessBoard.populateChessboardList();
    }
    
    @Override
    public void handleEvents(GameEngine game, RenderWindow window) throws IOException {
        for(Event event : window.pollEvents()) {
            if(event.type == Event.Type.CLOSED) {
                window.close();
                game.quit();
            }
        }
    }
    
    @Override
    public void update(GameEngine game, RenderWindow window) throws IOException {
        window.clear(Color.BLACK);
    }
    
    @Override
    public void draw(GameEngine game, RenderWindow window) throws IOException {
        for (Sprite[] boardSpriteI : boardSprite) {
            for (Sprite boardSpriteJ : boardSpriteI) {
                window.draw(boardSpriteJ);
            }
        }
        window.display();
    }
}