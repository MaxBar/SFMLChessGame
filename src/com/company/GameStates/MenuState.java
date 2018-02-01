package com.company.GameStates;

import com.company.Engine.GameEngine;
import com.company.Engine.GameState;
import org.jsfml.graphics.*;
import org.jsfml.system.Vector2f;
import org.jsfml.window.event.Event;

import java.io.IOException;
import java.nio.file.Paths;

public class MenuState extends GameState {
    private static MenuState menuState = null;
    private Texture[] texture;
    private Sprite[] sprite;
    private Image[] image;
    /*private int screenHeight;
    private int screenWidth;
    private int heightOffsetMenu;
    private int heightOffsetPlay;
    private int widthOffsetPlay;
    private KeyStroke key;*/
    
    
    private MenuState() throws IOException {
        /*screenHeight = Board.getTerminal().getTerminalSize().getRows() / 2;
        screenWidth = Board.getTerminal().getTerminalSize().getColumns() / 2;
        heightOffsetMenu = -4;
        heightOffsetPlay = -11;
        widthOffsetPlay = 2;*/
        this.texture = new Texture[2];
        this.sprite = new Sprite[2];
        this.image = new Image[2];
    }
    
    public static MenuState getInstance() throws IOException {
        if (menuState == null) {
            menuState = new MenuState();
        }
        return menuState;
    }
    
    @Override
    public void init(RenderWindow window) throws IOException {
        try {
            image[0] = new Image();
            texture[0] = new Texture();
            image[0].loadFromFile(Paths.get("src/com/company/Images/StartButton_NotClicked.png"));
            texture[0].loadFromImage(image[0]);
        } catch(IOException|TextureCreationException ex) {
            System.err.println("Something went wrong:");
            ex.printStackTrace();
        }
    
        float startButtonx = window.getView().getSize().x / 2 - (image[0].getSize().x / 2);
        float startButtony = window.getView().getSize().y / 2 - (image[0].getSize().y / 2);
        Vector2f startButtonPos = new Vector2f(startButtonx, startButtony);
        
        sprite[0] = new Sprite();
        sprite[1] = new Sprite();
        sprite[0].setTexture(texture[0]);
        sprite[0].setPosition(startButtonPos);
    
        try {
            image[1] = new Image();
            texture[1] = new Texture();
            image[1].loadFromFile(Paths.get("src/com/company/Images/ChessPiecesArray.png"));
            texture[1].loadFromImage(image[1]);
        } catch(IOException|TextureCreationException ex) {
            System.err.println("Something went wrong:");
            ex.printStackTrace();
        }
        
        IntRect rect = new IntRect(180,0,60,60);
        sprite[1].setTexture(texture[1]);//new IntRect(0,0,60,60));
        sprite[1].setTextureRect(rect);
        /*Board.getTerminal().clearScreen();
        Board.getTerminal().enterPrivateMode();
        Board.getTerminal().newTextGraphics().putString(screenWidth + heightOffsetMenu,
                                                        screenHeight,
                                                        "Menu");
        Board.getTerminal().newTextGraphics().putString(screenWidth + heightOffsetPlay,
                                                        screenHeight + widthOffsetPlay,
                                                        "Press space to play");*/
    }
    
    @Override
    public void handleEvents(GameEngine game, RenderWindow window) throws IOException {
        for(Event event : window.pollEvents()) {
            switch(event.type) {
                case CLOSED:
                    window.close();
                    game.quit();
                    break;
                case KEY_RELEASED:
                    switch (event.asKeyEvent().key) {
                        case SPACE:
                            changeState(game, PlayState.getInstance(), window);
                            System.out.println("Changing states to PlayState");
                            break;
                    }
                case MOUSE_ENTERED:
                
            }
            /*if(event.type == Event.Type.CLOSED) {
            //The user pressed the close button
            window.close();
            game.quit();
            }
            else if(event.type == Event.Type.KEY_RELEASED) {
                if(event.asKeyEvent().key == )
                changeState(game, PlayState.getInstance(), window);
            }*/
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
                        changeState(game, PlayState.getInstance());
                        break;
                }
                break;
        }*/
    }
    
    @Override
    public void update(GameEngine game, RenderWindow window) throws IOException {
        window.clear(Color.BLUE);
        //changeState(game, PlayState.getInstance(), window);
    }
    
    @Override
    public void draw(GameEngine game, RenderWindow window) throws IOException {
        window.draw(sprite[0]);
        window.draw(sprite[1]);
        window.display();
    }
}
