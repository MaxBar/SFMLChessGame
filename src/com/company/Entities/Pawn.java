package com.company.Entities;

import com.company.Enums.PieceTypes;
import com.company.Managers.TextureManager;
import com.company.Utility.Movement;
import com.company.Utility.Pair;
import org.jsfml.graphics.RectangleShape;
import org.jsfml.graphics.Sprite;
import org.jsfml.system.Vector2f;

import java.util.ArrayList;

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
    
    private RectangleShape[] line = new RectangleShape[2];
    
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
    
    
    
    
    
    public void checkMovement(Piece[][] allPieces, Integer currentRow, Integer currentColumn) {

        movement.pawnCheckMovement(allPieces, super.pair, currentRow, currentColumn);


 /*       if(allPieces[currentRow][currentColumn].isWhite()) {
            if(hasMoved) {
                for(int row = currentRow; row >= currentRow - 1; --row) {
                    if(allPieces[row][currentColumn] != null) { break; }
                    setPairs(allPieces, currentColumn, row);
                }
            } else {
                for(int row = currentRow; row >= currentRow - 2; --row) {
                    if(allPieces[row][currentColumn] != null) { break; }
                    setPairs(allPieces, currentColumn, row);
                }
            }
        } else {
            if(hasMoved) {
                for(int row = currentRow; row <= currentRow + 1; ++row) {
                    if(allPieces[row][currentColumn] != null) { break; }
                    setPairs(allPieces, currentColumn, row);
                }
            } else {
                for(int row = currentRow; row <= currentRow + 2; ++row) {
                    if(allPieces[row][currentColumn] != null) { break; }
                    setPairs(allPieces, currentColumn, row);
                }
            }
        }
        for(int i = 0; i < pair.size(); ++i) {
            System.out.println(pair.get(i).toString());
            System.out.println(pair.size());
        }*/
    }
    
  /*  private void setPairs(Piece[][] allPieces, int currentColumn, int row) {
        if(allPieces[row][currentColumn] == null) {
            Pair whereToMove = new Pair(row, currentColumn);
            pair.add(whereToMove);
            this.setX(currentColumn);
            this.setY(row);
        }
    }*/
    
    
    
    
    
    /*public void checkMovement(Piece[][] allPieces, Integer currentRow, Integer currentColumn) {
        if(allPieces[currentColumn][currentRow].isWhite()) {
            if(hasMoved) {
                for(int column = currentColumn; column > currentColumn - 1; --column) {
                    if(allPieces[column][currentRow] == null) {
                        canMoveHere.add(new Pair<>(column, currentRow));
                    }
                }
            } else {
                for(int column = currentColumn; column > currentColumn - 2; --column) {
                    if(allPieces[column][currentRow] == null) {
                        canMoveHere.add(new Pair<>(column, currentRow));
                    }
                }
            }
        } else {
            if(hasMoved) {
                for(int column = currentColumn; column < currentColumn + 1; ++column) {
                    if(allPieces[column][currentRow] == null) {
                        canMoveHere.add(new Pair<>(column, currentRow));
                    }
                }
            } else {
                for(int column = currentColumn; column < currentColumn + 2; ++column) {
                    if(allPieces[column][currentRow] == null) {
                        canMoveHere.add(new Pair<>(column, currentRow));
                    }
                }
            }
        }
        for(Pair pair : canMoveHere) {
            System.out.printf((String)pair.getKey(), pair.getValue());
        }
        System.out.println(canMoveHere);
    }*/

    public boolean getHasMoved() {
        return hasMoved;
    }

    @Override
    public void move() {
    }
}