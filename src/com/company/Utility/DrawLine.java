package com.company.Utility;

import org.jsfml.graphics.Color;
import org.jsfml.graphics.RectangleShape;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.system.Vector2f;

import java.awt.*;

public class DrawLine {
    
    private RectangleShape line;
    
    public DrawLine(float thickness, float startingPosX, float startingPosY, float endPosY, float endPosX, Color color) {
        line = new RectangleShape(new Vector2f(thickness, endPosY));
        line.setFillColor(color);
        line.setPosition(new Vector2f(startingPosX, startingPosY));
    }
    
    public RectangleShape getLine() {
        return line;
    }
    
    public void setLine(Color color, int endPosX, int endPosY) {
        line.setFillColor(color);
        line.setPosition(endPosX, endPosY);
    }
    
    public void rotateLine(float degreesToRotate) {
        line.rotate(degreesToRotate);
    }
    
    public void draw(RenderWindow window) {
        window.draw(line);
    }
    
}
