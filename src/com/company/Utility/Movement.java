package com.company.Utility;


import com.company.Entities.Pawn;
import com.company.Entities.Piece;
import org.jsfml.graphics.Color;
import org.jsfml.graphics.RectangleShape;
import org.jsfml.system.Vector2f;

import java.awt.geom.RectangularShape;
import java.util.ArrayList;

public class Movement {
    
    /*public void lines(int currentColumn, int currentRow, int row) {
        line[0].setPosition(new Vector2f(currentColumn, currentRow));
        line[1].setPosition(new Vector2f(row, currentColumn));
    }
    
    public RectangleShape[] getLine() {
        return line;
    }*/

    public void rookCheckMovement(Piece[][] allPieces, ArrayList<Pair<Integer>> pair, int currentRow, Integer currentColumn) {
        ArrayList<Pair<Integer>> tempPair = pair;
        // UP
        if(currentRow > 0) {
            for (int row = currentRow - 1; row >= 0; --row) {
                if(allPieces[row][currentColumn] != null) { break; }
                setPairs(allPieces, tempPair, row, currentColumn);
                allPieces[currentRow][currentColumn].setLine(5, currentColumn * 128 + 64, currentRow * 128 + 64,  (currentRow - row) * 128, Color.GREEN);
                allPieces[currentRow][currentColumn].getLines().get(allPieces[currentRow][currentColumn].getLines().size() - 1).rotateLine(180);
            }
        }

        // DOWN
        if(currentRow < 7) {
            for (int row = currentRow + 1; row < 7; ++row) {
                if(allPieces[row][currentColumn] != null) { break; }
                setPairs(allPieces, tempPair, row, currentColumn);
                allPieces[currentRow][currentColumn].setLine(5, currentColumn * 128 + 64, currentRow * 128 + 64,  (row - currentRow) * 128, Color.GREEN);
                allPieces[currentRow][currentColumn].getLines().get(allPieces[currentRow][currentColumn].getLines().size() - 1).rotateLine(0);
            }
        }

        // LEFT
        if(currentColumn > 0) {
            for (int column = currentColumn - 1; column > 0; --column) {
                if(allPieces[currentRow][column] != null) { break; }
                setPairs(allPieces, tempPair, currentRow, column);
                allPieces[currentRow][currentColumn].setLine(5, currentColumn * 128 + 64, currentRow * 128 + 64,  (currentColumn - column)  * 128, Color.GREEN);
                allPieces[currentRow][currentColumn].getLines().get(allPieces[currentRow][currentColumn].getLines().size() - 1).rotateLine(90);
            }
        }

        // RIGHT
        if(currentColumn < 7) {
            for (int column = currentColumn + 1; column < 7; ++column) {
                if(allPieces[currentRow][column] != null) { break; }
                setPairs(allPieces, tempPair, currentRow, column);
                allPieces[currentRow][currentColumn].setLine(5, currentColumn * 128 + 64, currentRow * 128 + 64,  (column - currentColumn) * 128, Color.GREEN);
                allPieces[currentRow][currentColumn].getLines().get(allPieces[currentRow][currentColumn].getLines().size() - 1).rotateLine(270);
            }
        }
    
    
        /*for(int i = 0; i < pair.size(); ++i) {
            System.out.println("ROOK MOVEMENT!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            System.out.println(pair.get(i).toString());
        }*/
    }

    public void queenCheckMovement(Piece[][] allPieces, ArrayList<Pair<Integer>> pair, int currentRow, Integer currentColumn) {
        rookCheckMovement(allPieces, pair, currentRow, currentColumn);
        bishopCheckMovement(allPieces, pair, currentRow, currentColumn);
    }

    public void kingCheckMovement(Piece[][] allPieces, ArrayList<Pair<Integer>> pair, int currentRow, Integer currentColumn) {
        int column = currentColumn;
        int row = currentRow;
        ArrayList<Pair<Integer>> tempPair = pair;

        // UP
        if (currentRow > 0 && allPieces[currentRow - 1][currentColumn] == null) {
            --row;
            setPairs(allPieces, tempPair, row, column);
            row = currentRow;
            allPieces[currentRow][currentColumn].setLine(5, currentColumn * 128 + 64, currentRow * 128 + 64, 128, Color.GREEN);
            allPieces[currentRow][currentColumn].getLines().get(allPieces[currentRow][currentColumn].getLines().size() - 1).rotateLine(180);
        }

        // UP LEFT
        if(currentRow > 0 && currentColumn > 0 && allPieces[currentRow - 1][currentColumn - 1] == null) {
            --column;
            --row;
            setPairs(allPieces, tempPair, row, column);
            column = currentColumn;
            row = currentRow;
            allPieces[currentRow][currentColumn].setLine(5, currentColumn * 128 + 64, currentRow * 128 + 64, 128, Color.GREEN);
            allPieces[currentRow][currentColumn].getLines().get(allPieces[currentRow][currentColumn].getLines().size() - 1).rotateLine(135);
        }

        // UP RIGHT
        if(currentRow > 0 && currentColumn < 7 && allPieces[currentRow - 1][currentColumn + 1] == null) {
            ++column;
            --row;
            setPairs(allPieces, tempPair, row, column);
            column = currentColumn;
            row = currentRow;
            allPieces[currentRow][currentColumn].setLine(5, currentColumn * 128 + 64, currentRow * 128 + 64, 128, Color.GREEN);
            allPieces[currentRow][currentColumn].getLines().get(allPieces[currentRow][currentColumn].getLines().size() - 1).rotateLine(225);
        }

        //DOWN
        if (currentRow < 7 && allPieces[currentRow + 1][currentColumn] == null) {
            ++row;
            setPairs(allPieces, tempPair, row, column);
            row = currentRow;
            allPieces[currentRow][currentColumn].setLine(5, currentColumn * 128 + 64, currentRow * 128 + 64, 128, Color.GREEN);
            allPieces[currentRow][currentColumn].getLines().get(allPieces[currentRow][currentColumn].getLines().size() - 1).rotateLine(0);
        }

        // DOWN RIGHT
        if(currentRow < 7 && currentColumn < 7 && allPieces[currentRow + 1][currentColumn + 1] == null) {
            ++column;
            ++row;
            setPairs(allPieces, tempPair, row, column);
            column = currentColumn;
            row = currentRow;
            allPieces[currentRow][currentColumn].setLine(5, currentColumn * 128 + 64, currentRow * 128 + 64, 128, Color.GREEN);
            allPieces[currentRow][currentColumn].getLines().get(allPieces[currentRow][currentColumn].getLines().size() - 1).rotateLine(315);
        }

        // DOWN LEFT
        if(currentRow < 7 && currentColumn > 0 && allPieces[currentRow + 1][currentColumn - 1] == null) {
            --column;
            ++row;
            setPairs(allPieces, tempPair, row, column);
            column = currentColumn;
            row = currentRow;
            allPieces[currentRow][currentColumn].setLine(5, currentColumn * 128 + 64, currentRow * 128 + 64, 128, Color.GREEN);
            allPieces[currentRow][currentColumn].getLines().get(allPieces[currentRow][currentColumn].getLines().size() - 1).rotateLine(45);
        }

        // LEFT
        if (currentColumn > 0 && allPieces[currentRow][currentColumn - 1] == null) {
            --column;
            setPairs(allPieces, tempPair, row, column);
            column = currentColumn;
            allPieces[currentRow][currentColumn].setLine(5, currentColumn * 128 + 64, currentRow * 128 + 64, 128, Color.GREEN);
            allPieces[currentRow][currentColumn].getLines().get(allPieces[currentRow][currentColumn].getLines().size() - 1).rotateLine(90);
        }

        // RIGHT
        if (currentColumn < 7 && allPieces[currentRow][currentColumn + 1] == null) {
            ++column;
            setPairs(allPieces, tempPair, row, column);
            allPieces[currentRow][currentColumn].setLine(5, currentColumn * 128 + 64, currentRow * 128 + 64, 128, Color.GREEN);
            allPieces[currentRow][currentColumn].getLines().get(allPieces[currentRow][currentColumn].getLines().size() - 1).rotateLine(270);
        }

        /*for(int i = 0; i < pair.size(); ++i) {
            if(pair.size() > 0) {
                System.out.println(pair.get(i).toString());
            }
            System.out.println(pair.size());
        }*/
    }

    public void bishopCheckMovement(Piece[][] allPieces, ArrayList<Pair<Integer>> pair, int currentRow, Integer currentColumn) {
        ArrayList<Pair<Integer>> tempPair = pair;

        // LEFT UP
        if(currentRow > 0 && currentColumn > 0) {
            for (int row = currentRow - 1, column = currentColumn - 1; row >= 0 && column >= 0; --row, --column) {
                if(allPieces[row][column] != null) { break; }
                setPairs(allPieces, tempPair, row, column);
                allPieces[currentRow][currentColumn].setLine(5, currentColumn * 128 + 64, currentRow * 128 + 64,  (currentRow - row) * 181, Color.GREEN);
                allPieces[currentRow][currentColumn].getLines().get(allPieces[currentRow][currentColumn].getLines().size() - 1).rotateLine(135);
            }
        }

        // RIGHT UP
        if(currentRow > 0 && currentColumn < 7) {
            for (int row = currentRow - 1, column = currentColumn + 1; row >= 0 && column <= 7; --row, ++column) {
                if(allPieces[row][column] != null) { break; }
                setPairs(allPieces, tempPair, row, column);
                allPieces[currentRow][currentColumn].setLine(5, currentColumn * 128 + 64, currentRow * 128 + 64,  (currentRow - row) * 181, Color.GREEN);
                allPieces[currentRow][currentColumn].getLines().get(allPieces[currentRow][currentColumn].getLines().size() - 1).rotateLine(225);
            }
        }

        // LEFT DOWN
        if(currentRow < 7 && currentColumn > 0) {
            for (int row = currentRow + 1, column = currentColumn - 1; row <= 7 && column >= 0; ++row, --column) {
                if(allPieces[row][column] != null) { break; }
                setPairs(allPieces, tempPair, row, column);allPieces[currentRow][currentColumn].setLine(5, currentColumn * 128 + 64, currentRow * 128 + 64,  (row - currentRow) * 181, Color.GREEN);
                allPieces[currentRow][currentColumn].getLines().get(allPieces[currentRow][currentColumn].getLines().size() - 1).rotateLine(45);
            }
        }

        // RIGHT DOWN
        if(currentRow < 7  && currentColumn < 7) {
            for (int row = currentRow + 1, column = currentColumn + 1; row <= 7 && column <= 7; ++row, ++column) {
                if(allPieces[row][column] != null) { break; }
                setPairs(allPieces, tempPair, row, column);
                setPairs(allPieces, tempPair, row, column);allPieces[currentRow][currentColumn].setLine(5, currentColumn * 128 + 64, currentRow * 128 + 64,  (row - currentRow) * 181, Color.GREEN);
                allPieces[currentRow][currentColumn].getLines().get(allPieces[currentRow][currentColumn].getLines().size() - 1).rotateLine(315);
            }
        }

        /*for(int i = 0; i <= pair.size(); ++i) {
            if(pair.size() > 0) {
                System.out.println(pair.get(i).toString());
            }
            System.out.println(pair.size());
        }*/
    }

    public void knightCheckMovement(Piece[][] allPieces, ArrayList<Pair<Integer>> pair, int currentRow, Integer currentColumn) {
        ArrayList<Pair<Integer>> tempPair = pair;

        int column = currentColumn;
        int row = currentRow;

        // UP LEFT
        if(currentRow > 1 && currentColumn > 0 && allPieces[currentRow - 2][currentColumn - 1] == null) {
            --column;
            row -= 2;
            setPairs(allPieces, tempPair, row, column);
            column = currentColumn;
            row = currentRow;
            //181 = hypotenusan
            allPieces[currentRow][currentColumn].setLine(5, currentColumn * 128 + 64, currentRow * 128 + 64, 2 * 152, Color.GREEN);
            allPieces[currentRow][currentColumn].getLines().get(allPieces[currentRow][currentColumn].getLines().size() - 1).rotateLine(155);
        }

        // UP RIGHT
        if(currentRow > 1 && currentColumn < 7 && allPieces[currentRow - 2][currentColumn + 1] == null) {
            ++column;
            row -= 2;
            setPairs(allPieces, tempPair, row, column);
            column = currentColumn;
            row = currentRow;
            allPieces[currentRow][currentColumn].setLine(5, currentColumn * 128 + 64, currentRow * 128 + 64, 2 * 152, Color.GREEN);
            allPieces[currentRow][currentColumn].getLines().get(allPieces[currentRow][currentColumn].getLines().size() - 1).rotateLine(205);
        }

        // RIGHT UP
        if(currentColumn < 6 && currentRow > 0 && allPieces[currentRow - 1][ currentColumn + 2] == null) {
            column += 2;
            --row;
            setPairs(allPieces, tempPair, row, column);
            column = currentColumn;
            row = currentRow;
            allPieces[currentRow][currentColumn].setLine(5, currentColumn * 128 + 64, currentRow * 128 + 64, 2 * 152, Color.GREEN);
            allPieces[currentRow][currentColumn].getLines().get(allPieces[currentRow][currentColumn].getLines().size() - 1).rotateLine(245);
        }

        // RIGHT DOWN
        if(currentColumn < 6 && currentRow < 7 && allPieces[currentRow + 1][currentColumn + 2] == null) {
            column += 2;
            ++row;
            setPairs(allPieces, tempPair, row, column);
            column = currentColumn;
            row = currentRow;
            allPieces[currentRow][currentColumn].setLine(5, currentColumn * 128 + 64, currentRow * 128 + 64, 2 * 152, Color.GREEN);
            allPieces[currentRow][currentColumn].getLines().get(allPieces[currentRow][currentColumn].getLines().size() - 1).rotateLine(295);
        }

        // DOWN RIGHT
        if(currentRow < 6 && currentColumn < 7 && allPieces[currentRow + 2][currentColumn + 1] == null) {
            ++column;
            row += 2;
            setPairs(allPieces, tempPair, row, column);
            column = currentColumn;
            row = currentRow;
            allPieces[currentRow][currentColumn].setLine(5, currentColumn * 128 + 64, currentRow * 128 + 64, 2 * 152, Color.GREEN);
            allPieces[currentRow][currentColumn].getLines().get(allPieces[currentRow][currentColumn].getLines().size() - 1).rotateLine(335);
        }

        // DOWN LEFT
        if(currentRow < 6 && currentColumn > 0 && allPieces[currentRow + 2][currentColumn - 1] == null) {
            --column;
            row += 2;
            setPairs(allPieces, tempPair, row, column);
            column = currentColumn;
            row = currentRow;
            allPieces[currentRow][currentColumn].setLine(5, currentColumn * 128 + 64, currentRow * 128 + 64, 2 * 152, Color.GREEN);
            allPieces[currentRow][currentColumn].getLines().get(allPieces[currentRow][currentColumn].getLines().size() - 1).rotateLine(25);
        }

        // LEFT DOWN
        if(currentColumn > 1 && currentRow < 7 && allPieces[currentRow + 1][currentColumn - 2] == null) {
            column -= 2;
            ++row;
            setPairs(allPieces, tempPair, row, column);
            column = currentColumn;
            row = currentRow;
            allPieces[currentRow][currentColumn].setLine(5, currentColumn * 128 + 64, currentRow * 128 + 64, 2 * 152, Color.GREEN);
            allPieces[currentRow][currentColumn].getLines().get(allPieces[currentRow][currentColumn].getLines().size() - 1).rotateLine(65);
        }

        // LEFT UP
        if(currentColumn > 1 && currentRow > 0 && allPieces[currentRow - 1][ currentColumn - 2] == null) {
            column -= 2;
            --row;
            setPairs(allPieces, tempPair, row, column);
            allPieces[currentRow][currentColumn].setLine(5, currentColumn * 128 + 64, currentRow * 128 + 64, 2 * 152, Color.GREEN);
            allPieces[currentRow][currentColumn].getLines().get(allPieces[currentRow][currentColumn].getLines().size() - 1).rotateLine(115);
        }
    }

    public void pawnCheckMovement(Piece[][] allPieces, ArrayList<Pair<Integer>> pair, int currentRow, int currentColumn) {
        while(!allPieces[currentRow][currentColumn].getLines().isEmpty()) {
            allPieces[currentRow][currentColumn].clearLines();
        }
        ArrayList<Pair<Integer>> tempPair = pair;
        System.out.println("Row: " + currentRow + "\r\nColumn: " + currentColumn + "*********************************************************");
        
            if(allPieces[currentRow][currentColumn].isWhite()) {
                if(allPieces[currentRow][currentColumn].getHasMoved()) {
                for(int row = currentRow - 1; row >= currentRow - 1; --row) {
                    if(allPieces[row][currentColumn] != null) { break; }
                    setPairs(allPieces, tempPair, row, currentColumn);
                    if(row < currentRow) {
                        allPieces[currentRow][currentColumn].setLine(5, currentColumn * 128 + 64, currentRow * 128 + 64, 128, Color.GREEN);
                        allPieces[currentRow][currentColumn].getLines().get(allPieces[currentRow][currentColumn].getLines().size() - 1).rotateLine(180);
                    } else {
                        allPieces[currentRow][currentColumn].setLine(5, currentColumn * 128 + 64, currentRow * 128 + 64, 128, Color.GREEN);
                    }
                }
            } else {
                for(int row = currentRow - 1; row >= currentRow - 2; --row) {
                    if(allPieces[row][currentColumn] != null) { break; }
                    setPairs(allPieces, tempPair, row, currentColumn);
                    if(row < currentRow) {
                        allPieces[currentRow][currentColumn].setLine(5, currentColumn * 128 + 64, currentRow * 128 + 64, 2 * 128, Color.GREEN);
                        allPieces[currentRow][currentColumn].getLines().get(allPieces[currentRow][currentColumn].getLines().size() - 1).rotateLine(180);
                    } else {
                        allPieces[currentRow][currentColumn].setLine(5, currentColumn * 128 + 64, currentRow * 128 + 64, 2 * 128, Color.GREEN);
                    }
                }
            }
        } else {
                if(allPieces[currentRow][currentColumn].getHasMoved()) {
                for (int row = currentRow + 1; row <= currentRow + 1; ++row) {
                    if (allPieces[row][currentColumn] != null) {
                        break;
                    }
                    setPairs(allPieces, tempPair, row, currentColumn);
                        allPieces[currentRow][currentColumn].setLine(5, currentColumn * 128 + 64, currentRow * 128 + 64, 128, Color.GREEN);
                }
            } else {
                for(int row = currentRow + 1; row <= currentRow + 2; ++row) {
                    if(allPieces[row][currentColumn] != null) { break; }
                    setPairs(allPieces, tempPair, row, currentColumn);
                    if(row == currentRow + 2) {
                        allPieces[currentRow][currentColumn].setLine(5, currentColumn * 128 + 64, currentRow * 128 + 64, 2 * 128, Color.GREEN);
                    } else {
                        allPieces[currentRow][currentColumn].setLine(5, currentColumn * 128 + 64, currentRow * 128 + 64, 128, Color.GREEN);
                    }
                }
            }
        }
        
        
        
        
        
        
        
        

        /*ArrayList<Pair<Integer>> tempPair = pair;
        System.out.println("Row: " + currentRow + "\r\nColumn: " + currentColumn + "*********************************************************");
        Pawn pawn = (Pawn)allPieces[currentRow][currentColumn];
        
        if(allPieces[currentRow][currentColumn].isWhite()) {
            if(pawn.getHasMoved()) {
                for(int row = currentRow - 1; row >= currentRow - 1; --row) {
                   if(allPieces[row][currentColumn] != null) { break; }
                    setPairs(allPieces, tempPair, row, currentColumn);
                   //line[0].setPosition(new Vector2f(currentColumn, currentRow));
                   //line[1].setPosition(new Vector2f(row, currentColumn));
                }
            } else {
                for(int row = currentRow - 1; row >= currentRow - 2; --row) {
                  if(allPieces[row][currentColumn] != null) { break; }
                    setPairs(allPieces, tempPair, row, currentColumn);
                }
            }
        } else {
            if(pawn.getHasMoved()) {
                for(int row = currentRow + 1; row <= currentRow + 1; ++row) {
                  if(allPieces[row][currentColumn] != null) { break; }
                    setPairs(allPieces, tempPair, row, currentColumn);
                }
            } else {
                for(int row = currentRow + 1; row <= currentRow + 2; ++row) {
                  if(allPieces[row][currentColumn] != null) { break; }
                    setPairs(allPieces, tempPair, row, currentColumn);
                }
            }
        }
        for(int i = 0; i < pair.size(); ++i) {
            System.out.println(pair.get(i).toString());
        }*/
    }

    private void setPairs(Piece[][] allPieces,  ArrayList<Pair<Integer>> pair, int row, int column) {
        if(allPieces[row][column] == null) {
            Pair whereToMove = new Pair(row, column);
            pair.add(whereToMove);
//            this.setX(column);
//            this.setY(row);
        }
    }
}
