package com.company.Entities;

import com.company.Enums.PieceTypes;
import com.company.Managers.TextureManager;
import com.company.Utility.DrawLine;
import com.company.Utility.Movement;
import com.company.Utility.Pair;
import org.jsfml.graphics.Color;
import org.jsfml.graphics.RectangleShape;
import org.jsfml.graphics.Sprite;
import org.jsfml.system.Vector2f;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece implements IEntity {
    //private int startPosX;
    private Sprite sprite;
    
    // Movement
    private boolean hasMoved;
    private int hasMovedMove;
    private int hasNotMovedMove;
    private ArrayList<ArrayList<Integer>> canMoveHere;
   // private ArrayList<Pair<Integer>> pair;
    Movement movement;
    
    private List<DrawLine> line = new ArrayList<>();
    
    /*public void lines(int currentColumn, int currentRow, int row) {
        line[0].setPosition(new Vector2f(currentColumn, currentRow));
        line[1].setPosition(new Vector2f(row, currentColumn));
    }
    
    public RectangleShape[] getLine() {
        return line;
    }*/
    
    public Pawn(int x, int y, boolean isWhite) {
        super(x, y, isWhite);
        super.startPosX = 300;
        super.setStartPosX(startPosX);
        sprite = new Sprite();
        
        // Movement
        hasMoved = false;
        hasMovedMove = 1;
        hasNotMovedMove = 2;
        canMoveHere = new ArrayList<ArrayList<Integer>>();
        movement = new Movement();
        
        //pair = new ArrayList<>();
        
        //testArray = new ArrayList<ArrayList<>>();
        //testArray.add(1, new ArrayList(2));
    }


    
    @Override
    public PieceTypes type() {
        return PieceTypes.PAWN;
    }
    
    @Override
    public Sprite getSprite(TextureManager textureManager, String filePath) {
        sprite.setTexture(textureManager.getTexture(filePath));
        sprite.setTextureRect(getIntRect());
        return sprite;
    }
    
    
    
    public List<DrawLine> getLines() {
        return line;
    }
    
    public void checkMovement(Piece[][] allPieces, Integer currentRow, Integer currentColumn) {

        //movement.pawnCheckMovement(allPieces, super.pair, currentRow, currentColumn);
        
        
        
        
        
        
        ArrayList<Pair<Integer>> tempPair = pair;
        System.out.println("Row: " + currentRow + "\r\nColumn: " + currentColumn + "*********************************************************");
        Pawn pawn = (Pawn)allPieces[currentRow][currentColumn];

        /*if(allPieces[currentRow][currentColumn] instanceof Pawn) {
            pawn = (Pawn)allPieces[currentRow][currentColumn];
        }*/
    
        if(allPieces[currentRow][currentColumn].isWhite()) {
            if(pawn.getHasMoved()) {
                for(int row = currentRow - 1; row >= currentRow - 1; --row) {
                    if(allPieces[row][currentColumn] != null) { break; }
                    setPairs(allPieces, tempPair, row, currentColumn);
                    if(row < currentRow) {
                        line.add(new DrawLine(5, currentColumn * 128 + 64, currentRow * 128 + 64, (row - 1) * 128, Color.GREEN));
                    } else {
                        line.add(new DrawLine(5, currentColumn * 128 + 64, currentRow * 128 + 64, (row - 1) * 128, Color.GREEN));
                    }
                    //pawn.lines(currentColumn, currentRow, row);
                    //line[0].setPosition(new Vector2f(currentColumn, currentRow));
                    //line[1].setPosition(new Vector2f(row, currentColumn));
                }
            } else {
                for(int row = currentRow - 1; row >= currentRow - 2; --row) {
                    if(allPieces[row][currentColumn] != null) { break; }
                    setPairs(allPieces, tempPair, row, currentColumn);
                    if(row < currentRow) {
                        line.add(new DrawLine(5, currentColumn * 128 + 64, currentRow * 128 + 64, (row - 1) * 128, Color.GREEN));
                    } else {
                        line.add(new DrawLine(5, currentColumn * 128 + 64, currentRow * 128 + 64, (row - 1) * 128, Color.GREEN));
                    }
                }
            }
        } else {
            if(pawn.getHasMoved()) {
                for(int row = currentRow + 1; row <= currentRow + 1; ++row) {
                    if(allPieces[row][currentColumn] != null) { break; }
                    setPairs(allPieces, tempPair, row, currentColumn);
                    if(row < currentRow) {
                        line.add(new DrawLine(5, currentColumn * 128 + 64, currentRow * 128 + 64, (row - 1) * 128, Color.GREEN));
                    } else {
                        line.add(new DrawLine(5, currentColumn * 128 + 64, currentRow * 128 + 64, (row - 1) * 128, Color.GREEN));
                    }
                }
            } else {
                for(int row = currentRow + 1; row <= currentRow + 2; ++row) {
                    if(allPieces[row][currentColumn] != null) { break; }
                    setPairs(allPieces, tempPair, row, currentColumn);
                    if(row < currentRow) {
                        line.add(new DrawLine(5, currentColumn * 128 + 64, currentRow * 128 + 64, (row - 1) * 128, Color.GREEN));
                    } else {
                        line.add(new DrawLine(5, currentColumn * 128 + 64, currentRow * 128 + 64, (row - 1) * 128, Color.GREEN));
                    }
                }
            }
        }
        for(int i = 0; i < pair.size(); ++i) {
            System.out.println(pair.get(i).toString());
        }
    }
    
    private void setPairs(Piece[][] allPieces,  ArrayList<Pair<Integer>> pair, int row, int column) {
        if(allPieces[row][column] == null) {
            Pair whereToMove = new Pair(row, column);
            pair.add(whereToMove);
//            this.setX(column);
//            this.setY(row);
        }
    }

    public boolean getHasMoved() {
        return hasMoved;
    }

    @Override
    public void move() {
    }
}