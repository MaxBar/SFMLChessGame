package com.company.Managers;

import org.jsfml.graphics.*;

import java.io.IOException;
import java.nio.file.Paths;

public class TextureManager {
    private Texture texture;
    private Image image;
    private Sprite sprite;
    
    public TextureManager() {
        texture = new Texture();
        image = new Image();
        sprite = new Sprite();
    }
    
    private void loadImage(String filePath) {
        try {
            image.loadFromFile(Paths.get(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void loadTexture(String filePath) {
        loadImage(filePath);
        try {
            texture.loadFromImage(image);
        } catch (TextureCreationException e) {
            e.printStackTrace();
        }
    }
    
    private void setTexture(String filePath) {
        loadTexture(filePath);
        sprite.setTexture(texture);
    }
    
    private void spliceTexture(IntRect intRect, String filePath) {
        setTexture(filePath);
        sprite.setTextureRect(intRect);
    }
    
    public Sprite getSprite(IntRect intRect, String filePath) {
        spliceTexture(intRect, filePath);
        return sprite;
    }
}
