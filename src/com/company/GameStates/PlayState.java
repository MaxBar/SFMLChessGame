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
    /*private int[][] chessBoard;
    private TextGraphics textGraphics;
    private KeyStroke key;
    private int screenHeight;
    private int screenWidth;
    private Screen screen;*/
    //private final Window window = new BasicWindow("Chess game");
    //private Panel panel;
    //private Table<String> table;
    
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
        /*Board.getTerminal().clearScreen();
        ai = new AI[2];
        chessBoard = new int[8][8];
        Board.getScreen().startScreen();
        Board.getScreen().setCursorPosition(null);
    
        screenHeight = Board.getTerminal().getTerminalSize().getRows() / 2;
        screenWidth = Board.getTerminal().getTerminalSize().getColumns() / 2;
        
        textGraphics = Board.getScreen().newTextGraphics();
        
        
        Board.getScreen().newTextGraphics().setBackgroundColor(TextColor.ANSI.BLUE);
        Board.getScreen().newTextGraphics().setForegroundColor(TextColor.ANSI.BLACK);
        Board.getScreen().newTextGraphics().fill(' ');

        Rook r = new Rook(0,5,true);
    
        
        for(int i = 0; i < chessBoard.length; ++i) {
            for(int j = 0; j < chessBoard[i].length; ++j) {
                if((i % 2 == 0 && j % 2 == 0) ||
                   (i % 2 == 1 && j % 2 == 1)) {
                    Board.getScreen().setCharacter(i + screenWidth - 4, j + screenHeight - 4, new TextCharacter(
                            ' ', TextColor.ANSI.DEFAULT, TextColor.ANSI.WHITE));
                            
                            
                            
                            
                    /*Board.getScreen().setCursorPosition(i + screenWidth - 4, j + screenHeight - 4);
                    Board.getScreen().setBackgroundColor(TextColor.ANSI.WHITE);
                    Board.getScreen().putCharacter(' ');
                    System.out.println("i: " + i + "\r\nj: " + j);
                    
                } else {
                    Board.getScreen().setCharacter(i + screenWidth - 4, j + screenHeight - 4, new TextCharacter(
                            ' ', TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK));
                    /*Board.getScreen().setCursorPosition(i + screenWidth - 4, j + screenHeight - 4);
                    Board.getScreen().setBackgroundColor(TextColor.ANSI.BLACK);
                    Board.getScreen().putCharacter(' ');
                    System.out.println("i: " + i + "\r\nj: " + j);
                }
                //Board.getTerminal().newTextGraphics().putString(i, j, Board.getTerminal().);
            }
        }*/
    }
    
    @Override
    public void handleEvents(GameEngine game, RenderWindow window) throws IOException {
        for(Event event : window.pollEvents()) {
            if(event.type == Event.Type.CLOSED) {
                //The user pressed the close button
                window.close();
                game.quit();
            }
        }
        /*key = Board.getTerminal().readInput();
    
        switch(key.getKeyType()) {
            case EOF:
                game.quit();
                break;
            case Escape:
                game.quit();
                break;
            case Character:
                switch (key.getCharacter()) {
                    case ' ':
                        for(int i = 0; i < ai.length; ++i) {
                            ai[i].handleEvents();
                        }
                        break;
                }
                break;
        }*/
    }
    
    @Override
    public void update(GameEngine game, RenderWindow window) throws IOException {
        window.clear(Color.BLACK);
        /*for(int i = 0; i < ai.length; ++i) {
            ai[i].update();
        }*/
    }
    
    @Override
    public void draw(GameEngine game, RenderWindow window) throws IOException {
        for(int i = 0; i < boardSprite.length; ++i) {
            for(int j = 0; j < boardSprite[i].length; ++j) {
                window.draw(boardSprite[i][j]);
            }
        }
        window.display();
        //Board.getTerminal().flush();
        //Board.getScreen().refresh();
    }
}