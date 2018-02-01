package com.company;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.window.VideoMode;
import org.jsfml.window.event.Event;

import java.io.IOException;


public class Main {

    public static void main(String[] args) throws IOException {
        
        Application app = new Application();
        app.run();
        //Create the window
        //RenderWindow window = new RenderWindow();
        //window.create(new VideoMode(640, 480), "Hello JSFML!");

        //Limit the framerate
        //window.setFramerateLimit(30);

        //Main loop
        //while(window.isOpen()) {
            //Fill the window with red
            //window.clear(Color.RED);
        
            //Display what was drawn (... the red color!)
            //window.display();
        
            //Handle events
            //for(Event event : window.pollEvents()) {
                //if(event.type == Event.Type.CLOSED) {
                    //The user pressed the close button
                    //window.close();
                //}
            //}
        //}
    }
}
