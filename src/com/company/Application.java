package com.company;

import com.company.Engine.GameEngine;
import com.company.GameStates.InitState;

import org.jsfml.graphics.RenderWindow;
import org.jsfml.window.VideoMode;

import java.io.IOException;

public class Application {
    public void run() throws IOException {
        //RenderWindow window = new RenderWindow();
        //window.create(new VideoMode(640, 480), "The Ultimate Chess Game!");
        RenderWindow window = new RenderWindow();
    
        window.create(new VideoMode(1600, 1024), "The Ultimate Chess Game!");
    
        window.setFramerateLimit(30);
        GameEngine game = new GameEngine();
        
        game.init();
        
        game.changeState(InitState.getInstance(), window);
    
        while(window.isOpen()) {
            while (game.running()) {
    
                game.handleEvents(window);
                game.update(window);
                game.draw(window);
            }
        }
        System.out.println(game.running());
        //Board.getTerminal().exitPrivateMode();
    }
}
