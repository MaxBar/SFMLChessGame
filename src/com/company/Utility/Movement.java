package com.company.Utility;

import com.company.Entities.Piece;
import org.jsfml.graphics.Color;
import java.util.ArrayList;

public class Movement {

    public void rookCheckMovement(Piece[][] allPieces, ArrayList<Pair<Integer>> pair, int currentRow, Integer currentColumn) {
        ArrayList<Pair<Integer>> tempPair = pair;
        // UP
        if(currentRow > 0) {
            for (int row = currentRow - 1; row >= 0; --row) {
                if(allPieces[row][currentColumn] != null && allPieces[row][currentColumn].isWhite() == allPieces[currentRow][currentColumn].isWhite()) {
                    break;
                } else if(allPieces[row][currentColumn] != null && allPieces[row][currentColumn].isWhite() != allPieces[currentRow][currentColumn].isWhite()) {
                    setPairs(allPieces, tempPair, row, currentColumn);
                    allPieces[currentRow][currentColumn].setLine(5, currentColumn * 128 + 64, currentRow * 128 + 64,  (currentRow - row) * 128, Color.RED);
                    allPieces[currentRow][currentColumn].getLines().get(allPieces[currentRow][currentColumn].getLines().size() - 1).rotateLine(180);
                    break;
                } else {
                    setPairs(allPieces, tempPair, row, currentColumn);
                    allPieces[currentRow][currentColumn].setLine(5, currentColumn * 128 + 64, currentRow * 128 + 64, (currentRow - row) * 128, Color.GREEN);
                    allPieces[currentRow][currentColumn].getLines().get(allPieces[currentRow][currentColumn].getLines().size() - 1).rotateLine(180);
                }
            }
        }

        // DOWN
        if(currentRow < 7) {
            for (int row = currentRow + 1; row < 7; ++row) {
                if(allPieces[row][currentColumn] != null && allPieces[row][currentColumn].isWhite() == allPieces[currentRow][currentColumn].isWhite()) {
                    break;
                } else if(allPieces[row][currentColumn] != null && allPieces[row][currentColumn].isWhite() != allPieces[currentRow][currentColumn].isWhite()) {
                    setPairs(allPieces, tempPair, row, currentColumn);
                    allPieces[currentRow][currentColumn].setLine(5, currentColumn * 128 + 64, currentRow * 128 + 64,  (row - currentRow) * 128, Color.RED);
                    allPieces[currentRow][currentColumn].getLines().get(allPieces[currentRow][currentColumn].getLines().size() - 1).rotateLine(0);
                    break;
                } else {
                    setPairs(allPieces, tempPair, row, currentColumn);
                    allPieces[currentRow][currentColumn].setLine(5, currentColumn * 128 + 64, currentRow * 128 + 64, (row - currentRow) * 128, Color.GREEN);
                    allPieces[currentRow][currentColumn].getLines().get(allPieces[currentRow][currentColumn].getLines().size() - 1).rotateLine(0);
                }
            }
        }

        // LEFT
        if(currentColumn > 0) {
            for (int column = currentColumn - 1; column > 0; --column) {
                if(allPieces[currentRow][column] != null && allPieces[currentRow][column].isWhite() == allPieces[currentRow][currentColumn].isWhite()) {
                    break;
                } else if(allPieces[currentRow][column] != null && allPieces[currentRow][column].isWhite() != allPieces[currentRow][currentColumn].isWhite()) {
                    setPairs(allPieces, tempPair, currentRow, column);
                    allPieces[currentRow][currentColumn].setLine(5, currentColumn * 128 + 64, currentRow * 128 + 64,  (currentColumn - column)  * 128, Color.RED);
                    allPieces[currentRow][currentColumn].getLines().get(allPieces[currentRow][currentColumn].getLines().size() - 1).rotateLine(90);
                    break;
                } else {
                    setPairs(allPieces, tempPair, currentRow, column);
                    allPieces[currentRow][currentColumn].setLine(5, currentColumn * 128 + 64, currentRow * 128 + 64, (currentColumn - column) * 128, Color.GREEN);
                    allPieces[currentRow][currentColumn].getLines().get(allPieces[currentRow][currentColumn].getLines().size() - 1).rotateLine(90);
                }
            }
        }

        // RIGHT
        if(currentColumn < 7) {
            for (int column = currentColumn + 1; column < 7; ++column) {
                if(allPieces[currentRow][column] != null && allPieces[currentRow][column].isWhite() == allPieces[currentRow][currentColumn].isWhite()) {
                    break;
                } else if(allPieces[currentRow][column] != null && allPieces[currentRow][column].isWhite() != allPieces[currentRow][currentColumn].isWhite()) {
                    setPairs(allPieces, tempPair, currentRow, column);
                    allPieces[currentRow][currentColumn].setLine(5, currentColumn * 128 + 64, currentRow * 128 + 64, (column - currentColumn) * 128, Color.RED);
                    allPieces[currentRow][currentColumn].getLines().get(allPieces[currentRow][currentColumn].getLines().size() - 1).rotateLine(270);
                    break;
                } else {
                    setPairs(allPieces, tempPair, currentRow, column);
                    allPieces[currentRow][currentColumn].setLine(5, currentColumn * 128 + 64, currentRow * 128 + 64, (column - currentColumn) * 128, Color.GREEN);
                    allPieces[currentRow][currentColumn].getLines().get(allPieces[currentRow][currentColumn].getLines().size() - 1).rotateLine(270);
                }
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
        if(currentRow > 0 && allPieces[currentRow - 1][currentColumn] != null && allPieces[currentRow - 1][currentColumn].isWhite() != allPieces[currentRow][currentColumn].isWhite()) {
            --row;
            setPairs(allPieces, tempPair, row, column);
            row = currentRow;
            allPieces[currentRow][currentColumn].setLine(5, currentColumn * 128 + 64, currentRow * 128 + 64, 128, Color.RED);
            allPieces[currentRow][currentColumn].getLines().get(allPieces[currentRow][currentColumn].getLines().size() - 1).rotateLine(180);
        } else if(currentRow > 0 && allPieces[currentRow - 1][currentColumn] == null){
            --row;
            setPairs(allPieces, tempPair, row, column);
            row = currentRow;
            allPieces[currentRow][currentColumn].setLine(5, currentColumn * 128 + 64, currentRow * 128 + 64, 128, Color.GREEN);
            allPieces[currentRow][currentColumn].getLines().get(allPieces[currentRow][currentColumn].getLines().size() - 1).rotateLine(180);
        }

        // UP LEFT
        if(currentRow > 0 && currentColumn > 0 && allPieces[currentRow - 1][currentColumn - 1] != null && allPieces[currentRow - 1][currentColumn - 1].isWhite() != allPieces[currentRow][currentColumn].isWhite()) {
            --column;
            --row;
            setPairs(allPieces, tempPair, row, column);
            column = currentColumn;
            row = currentRow;
            allPieces[currentRow][currentColumn].setLine(5, currentColumn * 128 + 64, currentRow * 128 + 64, 128, Color.RED);
            allPieces[currentRow][currentColumn].getLines().get(allPieces[currentRow][currentColumn].getLines().size() - 1).rotateLine(135);
        } else if(currentRow > 0 && currentColumn > 0 && allPieces[currentRow - 1][currentColumn - 1] == null) {
            --column;
            --row;
            setPairs(allPieces, tempPair, row, column);
            column = currentColumn;
            row = currentRow;
            allPieces[currentRow][currentColumn].setLine(5, currentColumn * 128 + 64, currentRow * 128 + 64, 128, Color.GREEN);
            allPieces[currentRow][currentColumn].getLines().get(allPieces[currentRow][currentColumn].getLines().size() - 1).rotateLine(135);
        }

        // UP RIGHT
        if(currentRow > 0 && currentColumn < 7 && allPieces[currentRow - 1][currentColumn + 1] != null && allPieces[currentRow - 1][currentColumn + 1].isWhite() != allPieces[currentRow][currentColumn].isWhite()) {
            ++column;
            --row;
            setPairs(allPieces, tempPair, row, column);
            column = currentColumn;
            row = currentRow;
            allPieces[currentRow][currentColumn].setLine(5, currentColumn * 128 + 64, currentRow * 128 + 64, 128, Color.RED);
            allPieces[currentRow][currentColumn].getLines().get(allPieces[currentRow][currentColumn].getLines().size() - 1).rotateLine(225);
        } else if(currentRow > 0 && currentColumn < 7 && allPieces[currentRow - 1][currentColumn + 1] == null) {
            ++column;
            --row;
            setPairs(allPieces, tempPair, row, column);
            column = currentColumn;
            row = currentRow;
            allPieces[currentRow][currentColumn].setLine(5, currentColumn * 128 + 64, currentRow * 128 + 64, 128, Color.GREEN);
            allPieces[currentRow][currentColumn].getLines().get(allPieces[currentRow][currentColumn].getLines().size() - 1).rotateLine(225);
        }

        //DOWN
        if(currentRow < 7 && allPieces[currentRow + 1][currentColumn] != null && allPieces[currentRow + 1][currentColumn].isWhite() != allPieces[currentRow][currentColumn].isWhite()) {
            ++row;
            setPairs(allPieces, tempPair, row, column);
            row = currentRow;
            allPieces[currentRow][currentColumn].setLine(5, currentColumn * 128 + 64, currentRow * 128 + 64, 128, Color.RED);
            allPieces[currentRow][currentColumn].getLines().get(allPieces[currentRow][currentColumn].getLines().size() - 1).rotateLine(0);
        }
        else if (currentRow < 7 && allPieces[currentRow + 1][currentColumn] == null) {
            ++row;
            setPairs(allPieces, tempPair, row, column);
            row = currentRow;
            allPieces[currentRow][currentColumn].setLine(5, currentColumn * 128 + 64, currentRow * 128 + 64, 128, Color.GREEN);
            allPieces[currentRow][currentColumn].getLines().get(allPieces[currentRow][currentColumn].getLines().size() - 1).rotateLine(0);
        }

        // DOWN RIGHT
        if(currentRow < 7 && currentColumn < 7 && allPieces[currentRow + 1][currentColumn + 1] != null && allPieces[currentRow + 1][currentColumn + 1].isWhite() != allPieces[currentRow][currentColumn].isWhite()) {
            ++column;
            ++row;
            setPairs(allPieces, tempPair, row, column);
            column = currentColumn;
            row = currentRow;
            allPieces[currentRow][currentColumn].setLine(5, currentColumn * 128 + 64, currentRow * 128 + 64, 128, Color.RED);
            allPieces[currentRow][currentColumn].getLines().get(allPieces[currentRow][currentColumn].getLines().size() - 1).rotateLine(315);
        }
        else if(currentRow < 7 && currentColumn < 7 && allPieces[currentRow + 1][currentColumn + 1] == null) {
            ++column;
            ++row;
            setPairs(allPieces, tempPair, row, column);
            column = currentColumn;
            row = currentRow;
            allPieces[currentRow][currentColumn].setLine(5, currentColumn * 128 + 64, currentRow * 128 + 64, 128, Color.GREEN);
            allPieces[currentRow][currentColumn].getLines().get(allPieces[currentRow][currentColumn].getLines().size() - 1).rotateLine(315);
        }

        // DOWN LEFT
        if(currentRow < 7 && currentColumn > 0 && allPieces[currentRow + 1][currentColumn - 1] != null && allPieces[currentRow + 1][currentColumn - 1].isWhite() != allPieces[currentRow][currentColumn].isWhite()) {
            --column;
            ++row;
            setPairs(allPieces, tempPair, row, column);
            column = currentColumn;
            row = currentRow;
            allPieces[currentRow][currentColumn].setLine(5, currentColumn * 128 + 64, currentRow * 128 + 64, 128, Color.RED);
            allPieces[currentRow][currentColumn].getLines().get(allPieces[currentRow][currentColumn].getLines().size() - 1).rotateLine(45);
        }
        else if(currentRow < 7 && currentColumn > 0 && allPieces[currentRow + 1][currentColumn - 1] == null) {
            --column;
            ++row;
            setPairs(allPieces, tempPair, row, column);
            column = currentColumn;
            row = currentRow;
            allPieces[currentRow][currentColumn].setLine(5, currentColumn * 128 + 64, currentRow * 128 + 64, 128, Color.GREEN);
            allPieces[currentRow][currentColumn].getLines().get(allPieces[currentRow][currentColumn].getLines().size() - 1).rotateLine(45);
        }

        // LEFT
        if (currentColumn > 0 && allPieces[currentRow][currentColumn - 1] != null && allPieces[currentRow][currentColumn - 1].isWhite() != allPieces[currentRow][currentColumn].isWhite()) {
            --column;
            setPairs(allPieces, tempPair, row, column);
            column = currentColumn;
            allPieces[currentRow][currentColumn].setLine(5, currentColumn * 128 + 64, currentRow * 128 + 64, 128, Color.RED);
            allPieces[currentRow][currentColumn].getLines().get(allPieces[currentRow][currentColumn].getLines().size() - 1).rotateLine(90);
        } else if (currentColumn > 0 && allPieces[currentRow][currentColumn - 1] == null) {
            --column;
            setPairs(allPieces, tempPair, row, column);
            column = currentColumn;
            allPieces[currentRow][currentColumn].setLine(5, currentColumn * 128 + 64, currentRow * 128 + 64, 128, Color.GREEN);
            allPieces[currentRow][currentColumn].getLines().get(allPieces[currentRow][currentColumn].getLines().size() - 1).rotateLine(90);
        }

        // RIGHT
        if(currentColumn < 7 && allPieces[currentRow][currentColumn + 1] != null && currentColumn < 7 && allPieces[currentRow][currentColumn + 1].isWhite() != allPieces[currentRow][currentColumn].isWhite()) {
            ++column;
            setPairs(allPieces, tempPair, row, column);
            allPieces[currentRow][currentColumn].setLine(5, currentColumn * 128 + 64, currentRow * 128 + 64, 128, Color.RED);
            allPieces[currentRow][currentColumn].getLines().get(allPieces[currentRow][currentColumn].getLines().size() - 1).rotateLine(270);
        }
        else if (currentColumn < 7 && allPieces[currentRow][currentColumn + 1] == null) {
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
                if(allPieces[row][column] != null && allPieces[row][column].isWhite() == allPieces[currentRow][currentColumn].isWhite()) {
                    break;
                } else if(allPieces[row][column] != null && allPieces[row][column].isWhite() != allPieces[currentRow][currentColumn].isWhite()) {
                    setPairs(allPieces, tempPair, row, column);
                    allPieces[currentRow][currentColumn].setLine(5, currentColumn * 128 + 64, currentRow * 128 + 64,  (currentRow - row) * 181, Color.RED);
                    allPieces[currentRow][currentColumn].getLines().get(allPieces[currentRow][currentColumn].getLines().size() - 1).rotateLine(135);
                    break;
                } else {
                    setPairs(allPieces, tempPair, row, column);
                    allPieces[currentRow][currentColumn].setLine(5, currentColumn * 128 + 64, currentRow * 128 + 64, (currentRow - row) * 181, Color.GREEN);
                    allPieces[currentRow][currentColumn].getLines().get(allPieces[currentRow][currentColumn].getLines().size() - 1).rotateLine(135);
                }
            }
        }

        // RIGHT UP
        if(currentRow > 0 && currentColumn < 7) {
            for (int row = currentRow - 1, column = currentColumn + 1; row >= 0 && column <= 7; --row, ++column) {
                if(allPieces[row][column] != null && allPieces[row][column].isWhite() == allPieces[currentRow][currentColumn].isWhite()) {
                    break;
                } else if(allPieces[row][column] != null && allPieces[row][column].isWhite() != allPieces[currentRow][currentColumn].isWhite()) {
                    setPairs(allPieces, tempPair, row, column);
                    allPieces[currentRow][currentColumn].setLine(5, currentColumn * 128 + 64, currentRow * 128 + 64,  (currentRow - row) * 181, Color.RED);
                    allPieces[currentRow][currentColumn].getLines().get(allPieces[currentRow][currentColumn].getLines().size() - 1).rotateLine(225);
                    break;
                } else {
                    setPairs(allPieces, tempPair, row, column);
                    allPieces[currentRow][currentColumn].setLine(5, currentColumn * 128 + 64, currentRow * 128 + 64, (currentRow - row) * 181, Color.GREEN);
                    allPieces[currentRow][currentColumn].getLines().get(allPieces[currentRow][currentColumn].getLines().size() - 1).rotateLine(225);
                }
            }
        }

        // LEFT DOWN
        if(currentRow < 7 && currentColumn > 0) {
            for (int row = currentRow + 1, column = currentColumn - 1; row <= 7 && column >= 0; ++row, --column) {
                if(allPieces[row][column] != null && allPieces[row][column].isWhite() == allPieces[currentRow][currentColumn].isWhite()) {
                    break;
                } else if(allPieces[row][column] != null && allPieces[row][column].isWhite() != allPieces[currentRow][currentColumn].isWhite()) {
                    setPairs(allPieces, tempPair, row, column);
                    allPieces[currentRow][currentColumn].setLine(5, currentColumn * 128 + 64, currentRow * 128 + 64, (row - currentRow) * 181, Color.RED);
                    allPieces[currentRow][currentColumn].getLines().get(allPieces[currentRow][currentColumn].getLines().size() - 1).rotateLine(45);
                    break;
                } else {
                    setPairs(allPieces, tempPair, row, column);
                    allPieces[currentRow][currentColumn].setLine(5, currentColumn * 128 + 64, currentRow * 128 + 64, (row - currentRow) * 181, Color.GREEN);
                    allPieces[currentRow][currentColumn].getLines().get(allPieces[currentRow][currentColumn].getLines().size() - 1).rotateLine(45);
                }
            }
        }

        // RIGHT DOWN
        if(currentRow < 7  && currentColumn < 7) {
            for (int row = currentRow + 1, column = currentColumn + 1; row <= 7 && column <= 7; ++row, ++column) {
                if(allPieces[row][column] != null && allPieces[row][column].isWhite() == allPieces[currentRow][currentColumn].isWhite()) {
                    break;
                } else if(allPieces[row][column] != null && allPieces[row][column].isWhite() != allPieces[currentRow][currentColumn].isWhite()) {
                    setPairs(allPieces, tempPair, row, column);
                    allPieces[currentRow][currentColumn].setLine(5, currentColumn * 128 + 64, currentRow * 128 + 64,  (row - currentRow) * 181, Color.RED);
                    allPieces[currentRow][currentColumn].getLines().get(allPieces[currentRow][currentColumn].getLines().size() - 1).rotateLine(315);
                    break;
                } else {
                    setPairs(allPieces, tempPair, row, column);
                    allPieces[currentRow][currentColumn].setLine(5, currentColumn * 128 + 64, currentRow * 128 + 64, (row - currentRow) * 181, Color.GREEN);
                    allPieces[currentRow][currentColumn].getLines().get(allPieces[currentRow][currentColumn].getLines().size() - 1).rotateLine(315);
                }
            }
        }
    }

    public void knightCheckMovement(Piece[][] allPieces, ArrayList<Pair<Integer>> pair, int currentRow, int currentColumn) {
        ArrayList<Pair<Integer>> tempPair = pair;

        int column = currentColumn;
        int row = currentRow;

        // UP LEFT
        if(currentRow > 1 && currentColumn > 0 && allPieces[currentRow - 2][currentColumn - 1] != null && allPieces[currentRow - 2][currentColumn - 1].isWhite() != allPieces[currentRow][currentColumn].isWhite()) {
            --column;
            row -= 2;
            setPairs(allPieces, tempPair, row, column);
            column = currentColumn;
            row = currentRow;
            allPieces[currentRow][currentColumn].setLine(5, currentColumn * 128 + 64, currentRow * 128 + 64, 2 * 152, Color.RED);
            allPieces[currentRow][currentColumn].getLines().get(allPieces[currentRow][currentColumn].getLines().size() - 1).rotateLine(155);
        }
        else if(currentRow > 1 && currentColumn > 0 && allPieces[currentRow - 2][currentColumn - 1] == null) {
            --column;
            row -= 2;
            setPairs(allPieces, tempPair, row, column);
            column = currentColumn;
            row = currentRow;
            allPieces[currentRow][currentColumn].setLine(5, currentColumn * 128 + 64, currentRow * 128 + 64, 2 * 152, Color.GREEN);
            allPieces[currentRow][currentColumn].getLines().get(allPieces[currentRow][currentColumn].getLines().size() - 1).rotateLine(155);
        }

        // UP RIGHT
        if(currentRow > 1 && currentColumn < 7 && allPieces[currentRow - 2][currentColumn + 1] != null && allPieces[currentRow - 2][currentColumn + 1].isWhite() != allPieces[currentRow][currentColumn].isWhite()) {
            ++column;
            row -= 2;
            setPairs(allPieces, tempPair, row, column);
            column = currentColumn;
            row = currentRow;
            allPieces[currentRow][currentColumn].setLine(5, currentColumn * 128 + 64, currentRow * 128 + 64, 2 * 152, Color.RED);
            allPieces[currentRow][currentColumn].getLines().get(allPieces[currentRow][currentColumn].getLines().size() - 1).rotateLine(205);
        }
        else if(currentRow > 1 && currentColumn < 7 && allPieces[currentRow - 2][currentColumn + 1] == null) {
            ++column;
            row -= 2;
            setPairs(allPieces, tempPair, row, column);
            column = currentColumn;
            row = currentRow;
            allPieces[currentRow][currentColumn].setLine(5, currentColumn * 128 + 64, currentRow * 128 + 64, 2 * 152, Color.GREEN);
            allPieces[currentRow][currentColumn].getLines().get(allPieces[currentRow][currentColumn].getLines().size() - 1).rotateLine(205);
        }

        // RIGHT UP
        if(currentColumn < 6 && currentRow > 0 && allPieces[currentRow - 1][ currentColumn + 2] != null && allPieces[currentRow - 1][currentColumn + 2].isWhite() != allPieces[currentRow][currentColumn].isWhite()) {
            column += 2;
            --row;
            setPairs(allPieces, tempPair, row, column);
            column = currentColumn;
            row = currentRow;
            allPieces[currentRow][currentColumn].setLine(5, currentColumn * 128 + 64, currentRow * 128 + 64, 2 * 152, Color.RED);
            allPieces[currentRow][currentColumn].getLines().get(allPieces[currentRow][currentColumn].getLines().size() - 1).rotateLine(245);
        }
        else if(currentColumn < 6 && currentRow > 0 && allPieces[currentRow - 1][ currentColumn + 2] == null) {
            column += 2;
            --row;
            setPairs(allPieces, tempPair, row, column);
            column = currentColumn;
            row = currentRow;
            allPieces[currentRow][currentColumn].setLine(5, currentColumn * 128 + 64, currentRow * 128 + 64, 2 * 152, Color.GREEN);
            allPieces[currentRow][currentColumn].getLines().get(allPieces[currentRow][currentColumn].getLines().size() - 1).rotateLine(245);
        }

        // RIGHT DOWN
        if (currentColumn < 6 && currentRow < 7 && allPieces[currentRow + 1][currentColumn + 2] != null && allPieces[currentRow + 1][currentColumn + 2].isWhite() != allPieces[currentRow][currentColumn].isWhite()) {
            column += 2;
            ++row;
            setPairs(allPieces, tempPair, row, column);
            column = currentColumn;
            row = currentRow;
            allPieces[currentRow][currentColumn].setLine(5, currentColumn * 128 + 64, currentRow * 128 + 64, 2 * 152, Color.RED);
            allPieces[currentRow][currentColumn].getLines().get(allPieces[currentRow][currentColumn].getLines().size() - 1).rotateLine(295);
        } else if (currentColumn < 6 && currentRow < 7 && allPieces[currentRow + 1][currentColumn + 2] == null) {
            column += 2;
            ++row;
            setPairs(allPieces, tempPair, row, column);
            column = currentColumn;
            row = currentRow;
            allPieces[currentRow][currentColumn].setLine(5, currentColumn * 128 + 64, currentRow * 128 + 64, 2 * 152, Color.GREEN);
            allPieces[currentRow][currentColumn].getLines().get(allPieces[currentRow][currentColumn].getLines().size() - 1).rotateLine(295);
        }

        // DOWN RIGHT
        if (currentRow < 6 && currentColumn < 7 && allPieces[currentRow + 2][currentColumn + 1] != null && allPieces[currentRow + 2][currentColumn + 1].isWhite() != allPieces[currentRow][currentColumn].isWhite()) {
            ++column;
            row += 2;
            setPairs(allPieces, tempPair, row, column);
            column = currentColumn;
            row = currentRow;
            allPieces[currentRow][currentColumn].setLine(5, currentColumn * 128 + 64, currentRow * 128 + 64, 2 * 152, Color.RED);
            allPieces[currentRow][currentColumn].getLines().get(allPieces[currentRow][currentColumn].getLines().size() - 1).rotateLine(335);
        } else if (currentRow < 6 && currentColumn < 7 && allPieces[currentRow + 2][currentColumn + 1] == null) {
            ++column;
            row += 2;
            setPairs(allPieces, tempPair, row, column);
            column = currentColumn;
            row = currentRow;
            allPieces[currentRow][currentColumn].setLine(5, currentColumn * 128 + 64, currentRow * 128 + 64, 2 * 152, Color.GREEN);
            allPieces[currentRow][currentColumn].getLines().get(allPieces[currentRow][currentColumn].getLines().size() - 1).rotateLine(335);
        }

        // DOWN LEFT
        if(currentRow < 6 && currentColumn > 0 && allPieces[currentRow + 2][currentColumn - 1] != null && allPieces[currentRow + 2][currentColumn - 1].isWhite() != allPieces[currentRow][currentColumn].isWhite()) {
            --column;
            row += 2;
            setPairs(allPieces, tempPair, row, column);
            column = currentColumn;
            row = currentRow;
            allPieces[currentRow][currentColumn].setLine(5, currentColumn * 128 + 64, currentRow * 128 + 64, 2 * 152, Color.RED);
            allPieces[currentRow][currentColumn].getLines().get(allPieces[currentRow][currentColumn].getLines().size() - 1).rotateLine(25);
        }
        else if(currentRow < 6 && currentColumn > 0 && allPieces[currentRow + 2][currentColumn - 1] == null) {
            --column;
            row += 2;
            setPairs(allPieces, tempPair, row, column);
            column = currentColumn;
            row = currentRow;
            allPieces[currentRow][currentColumn].setLine(5, currentColumn * 128 + 64, currentRow * 128 + 64, 2 * 152, Color.GREEN);
            allPieces[currentRow][currentColumn].getLines().get(allPieces[currentRow][currentColumn].getLines().size() - 1).rotateLine(25);
        }

        // LEFT DOWN
        if(currentColumn > 1 && currentRow < 7 && allPieces[currentRow + 1][currentColumn - 2] != null && allPieces[currentRow + 1][currentColumn - 2].isWhite() != allPieces[currentRow][currentColumn].isWhite()) {
            column -= 2;
            ++row;
            setPairs(allPieces, tempPair, row, column);
            column = currentColumn;
            row = currentRow;
            allPieces[currentRow][currentColumn].setLine(5, currentColumn * 128 + 64, currentRow * 128 + 64, 2 * 152, Color.RED);
            allPieces[currentRow][currentColumn].getLines().get(allPieces[currentRow][currentColumn].getLines().size() - 1).rotateLine(65);
        }
        else if(currentColumn > 1 && currentRow < 7 && allPieces[currentRow + 1][currentColumn - 2] == null) {
            column -= 2;
            ++row;
            setPairs(allPieces, tempPair, row, column);
            column = currentColumn;
            row = currentRow;
            allPieces[currentRow][currentColumn].setLine(5, currentColumn * 128 + 64, currentRow * 128 + 64, 2 * 152, Color.GREEN);
            allPieces[currentRow][currentColumn].getLines().get(allPieces[currentRow][currentColumn].getLines().size() - 1).rotateLine(65);
        }

        // LEFT UP
        if(currentColumn > 1 && currentRow > 0 && allPieces[currentRow - 1][ currentColumn - 2] != null && allPieces[currentRow - 1][currentColumn - 2].isWhite() != allPieces[currentRow][currentColumn].isWhite()) {
            column -= 2;
            --row;
            setPairs(allPieces, tempPair, row, column);
            allPieces[currentRow][currentColumn].setLine(5, currentColumn * 128 + 64, currentRow * 128 + 64, 2 * 152, Color.GREEN);
            allPieces[currentRow][currentColumn].getLines().get(allPieces[currentRow][currentColumn].getLines().size() - 1).rotateLine(115);
        }
        else if(currentColumn > 1 && currentRow > 0 && allPieces[currentRow - 1][ currentColumn - 2] == null) {
            column -= 2;
            --row;
            setPairs(allPieces, tempPair, row, column);
            allPieces[currentRow][currentColumn].setLine(5, currentColumn * 128 + 64, currentRow * 128 + 64, 2 * 152, Color.GREEN);
            allPieces[currentRow][currentColumn].getLines().get(allPieces[currentRow][currentColumn].getLines().size() - 1).rotateLine(115);
        }
    }

    public void pawnCheckMovement(Piece[][] allPieces, ArrayList<Pair<Integer>> pair, int currentRow, int currentColumn) {
        while (!allPieces[currentRow][currentColumn].getLines().isEmpty()) {
            allPieces[currentRow][currentColumn].clearLines();
        }
        
        ArrayList<Pair<Integer>> tempPair = pair;
        System.out.println("Row: " + currentRow + "\r\nColumn: " + currentColumn + "*********************************************************");
        // White Pawn
        if (allPieces[currentRow][currentColumn].isWhite()) {
            // If White Pawn has moved we can only move one step
            if (allPieces[currentRow][currentColumn].getHasMoved()) {
                for (int row = currentRow - 1; row >= currentRow - 1; --row) {
                    // Piece can't move right if it is furthest to the right on the board
                    whiteMoveLeftRight(allPieces, currentRow, currentColumn, tempPair, row);
                    
                    // If there is a piece in front of the Pawn it can't move so we break the for-loop
                    if (allPieces[row][currentColumn] != null) {
                        break;
                    } else {
                        setPairs(allPieces, tempPair, row, currentColumn);
                        allPieces[currentRow][currentColumn].setLine(5, currentColumn * 128 + 64, currentRow * 128 + 64, 128, Color.GREEN);
                        allPieces[currentRow][currentColumn].getLines().get(allPieces[currentRow][currentColumn].getLines().size() - 1).rotateLine(180);
                    }
                }
            } else {
                for (int row = currentRow - 1; row >= currentRow - 2; --row) {
                    // Piece can't move right if it is furthest to the right on the board
                    if(row == currentRow - 1) {
                        whiteMoveLeftRight(allPieces, currentRow, currentColumn, tempPair, row);
                    }
                    // If there is a piece in front of the Pawn it can't move so we break the for-loop
                    if (allPieces[row][currentColumn] != null) {
                        break;
                    } else {
                        setPairs(allPieces, tempPair, row, currentColumn);
                        allPieces[currentRow][currentColumn].setLine(5, currentColumn * 128 + 64, currentRow * 128 + 64, (currentRow - row) * 128, Color.GREEN);
                        allPieces[currentRow][currentColumn].getLines().get(allPieces[currentRow][currentColumn].getLines().size() - 1).rotateLine(180);
                    }
                }
            }
        }
        
        
        // Black Pawn
        else {
            // If Black Pawn has moved we can only move one step
            if (allPieces[currentRow][currentColumn].getHasMoved()) {
                for (int row = currentRow + 1; row <= currentRow + 1; ++row) {
                    MoveBlackRightLeft(allPieces, currentRow, currentColumn, tempPair, row, 315, 45);
                    // If there is a piece in front of the Pawn it can't move so we break the for-loop
                    if (allPieces[row][currentColumn] != null) {
                        break;
                    } else {
                        setPairs(allPieces, tempPair, row, currentColumn);
                        allPieces[currentRow][currentColumn].setLine(5, currentColumn * 128 + 64, currentRow * 128 + 64, 128, Color.GREEN);
                    }
                }
            } else {
                for (int row = currentRow + 1; row <= currentRow + 2; ++row) {
                    if(row == currentRow + 1) {
                        MoveBlackRightLeft(allPieces, currentRow, currentColumn, tempPair, row, 225, 135);
                    }
                    // If there is a piece in front of the Pawn it can't move so we break the for-loop
                    if (allPieces[row][currentColumn] != null) {
                        break;
                    } else {
                        setPairs(allPieces, tempPair, row, currentColumn);
                        allPieces[currentRow][currentColumn].setLine(5, currentColumn * 128 + 64, currentRow * 128 + 64, (row - currentRow) * 128, Color.GREEN);
                    }
                }
            }
        }
    }
    
    private void whiteMoveLeftRight(Piece[][] allPieces, int currentRow, int currentColumn, ArrayList<Pair<Integer>> tempPair, int row) {
        if (currentColumn != 7) {
            // Check if there is a enemy piece UP RIGHT
            if (allPieces[row][currentColumn + 1] != null && allPieces[row + 1][currentColumn].isWhite() != allPieces[row][currentColumn + 1].isWhite()) {
                setPairs(allPieces, tempPair, row, currentColumn + 1);
                allPieces[currentRow][currentColumn].setLine(5, currentColumn * 128 + 64, currentRow * 128 + 64, 181, Color.RED);
                allPieces[currentRow][currentColumn].getLines().get(allPieces[currentRow][currentColumn].getLines().size() - 1).rotateLine(225);
            }
        }
        
        // Piece can't move left if it is furthest to the left on the board
        if (currentColumn != 0) {
            // Check if there is a enemy piece UP LEFT
            if (allPieces[row][currentColumn - 1] != null && allPieces[row + 1][currentColumn].isWhite() != allPieces[row][currentColumn - 1].isWhite()) {
                setPairs(allPieces, tempPair, row, currentColumn - 1);
                allPieces[currentRow][currentColumn].setLine(5, currentColumn * 128 + 64, currentRow * 128 + 64, 181, Color.RED);
                allPieces[currentRow][currentColumn].getLines().get(allPieces[currentRow][currentColumn].getLines().size() - 1).rotateLine(135);
            }
        }
    }
    
    private void MoveBlackRightLeft(Piece[][] allPieces, int currentRow, int currentColumn, ArrayList<Pair<Integer>> tempPair, int row, int degreesToRotate, int degreesToRotate2) {
        if (currentColumn != 7) {
            // Check if there is a enemy piece DOWN RIGHT
            if (allPieces[row][currentColumn + 1] != null && allPieces[row - 1][currentColumn].isWhite() != allPieces[row][currentColumn + 1].isWhite()) {
                setPairs(allPieces, tempPair, row, currentColumn + 1);
                allPieces[currentRow][currentColumn].setLine(5, currentColumn * 128 + 64, currentRow * 128 + 64, 181, Color.RED);
                allPieces[currentRow][currentColumn].getLines().get(allPieces[currentRow][currentColumn].getLines().size() - 1).rotateLine(degreesToRotate);
            }
        }
        // Piece can't move left if it is furthest to the left on the board
        if (currentColumn != 0) {
            // Check if there is a enemy piece DOWN LEFT
            if (allPieces[row][currentColumn - 1] != null && allPieces[row - 1][currentColumn].isWhite() != allPieces[row][currentColumn - 1].isWhite()) {
                setPairs(allPieces, tempPair, row, currentColumn - 1);
                allPieces[currentRow][currentColumn].setLine(5, currentColumn * 128 + 64, currentRow * 128 + 64, 181, Color.RED);
                allPieces[currentRow][currentColumn].getLines().get(allPieces[currentRow][currentColumn].getLines().size() - 1).rotateLine(degreesToRotate2);
            }
        }
    }
    
    private void setPairs(Piece[][] allPieces,  ArrayList<Pair<Integer>> pair, int row, int column/*, int currentRow, int currentColumn*/) {
        if(allPieces[row][column] == null) {
            Pair whereToMove = new Pair(row, column);
            pair.add(whereToMove);
        } /*else if(allPieces[row][column].isWhite() != allPieces[currentRow][currentColumn].isWhite()) {
            Pair whereToMove = new Pair(row, column);
            pair.add(whereToMove);
        }*/
    }
}
