package com.company.Utility;


import com.company.Entities.Pawn;
import com.company.Entities.Piece;

import java.util.ArrayList;

public class Movement {

    public void rookCheckMovement(Piece[][] allPieces, ArrayList<Pair<Integer>> pair, int currentRow, Integer currentColumn) {
        ArrayList<Pair<Integer>> tempPair = pair;
        // UP
        if(currentRow > 0) {
            for (int row = currentRow - 1; row > 0; --row) {
                if(allPieces[row][currentColumn] != null) { break; }
                setPairs(allPieces, tempPair, row, currentColumn);
            }
        }

        // DOWN
        if(currentRow < 7) {
            for (int row = currentRow + 1; row < 7; ++row) {
                if(allPieces[row][currentColumn] != null) { break; }
                setPairs(allPieces, tempPair, row, currentColumn);
            }
        }

        // LEFT
        if(currentColumn > 0) {
            for (int column = currentColumn - 1; column > 0; --column) {
                if(allPieces[currentRow][column] != null) { break; }
                setPairs(allPieces, tempPair, column, currentRow);
            }
        }

        // RIGHT
        if(currentColumn < 7) {
            for (int column = currentColumn + 1; column > 7; ++column) {
                if(allPieces[currentRow][column] != null) { break; }
                setPairs(allPieces, tempPair, column, currentRow);
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
        }

        // UP LEFT
        if(currentRow > 0 && currentColumn > 0 && allPieces[currentRow - 1][currentColumn - 1] == null) {
            --column;
            --row;
            setPairs(allPieces, tempPair, row, column);
            column = currentColumn;
            row = currentRow;
        }

        // UP RIGHT
        if(currentRow > 0 && currentColumn < 7 && allPieces[currentRow - 1][currentColumn + 1] == null) {
            ++column;
            --row;
            setPairs(allPieces, tempPair, row, column);
            column = currentColumn;
            row = currentRow;
        }

        //DOWN
        if (currentRow < 7 && allPieces[currentRow + 1][currentColumn] == null) {
            ++row;
            setPairs(allPieces, tempPair, row, column);
            row = currentRow;
        }

        // DOWN RIGHT
        if(currentRow < 7 && currentColumn < 7 && allPieces[currentRow + 1][currentColumn + 1] == null) {
            ++column;
            ++row;
            setPairs(allPieces, tempPair, row, column);
            column = currentColumn;
            row = currentRow;
        }

        // DOWN LEFT
        if(currentRow < 7 && currentColumn > 0 && allPieces[currentRow + 1][currentColumn - 1] == null) {
            --column;
            ++row;
            setPairs(allPieces, tempPair, row, column);
            column = currentColumn;
            row = currentRow;
        }

        // LEFT
        if (currentColumn > 0 && allPieces[currentRow][currentColumn - 1] == null) {
            --column;
            setPairs(allPieces, tempPair, row, column);
            column = currentColumn;
        }

        // RIGHT
        if (currentColumn < 7 && allPieces[currentRow][currentColumn + 1] == null) {
            ++column;
            setPairs(allPieces, tempPair, row, column);
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
            }
        }

        // RIGHT UP
        if(currentRow > 0 && currentColumn < 7) {
            for (int row = currentRow - 1, column = currentColumn + 1; row >= 0 && column <= 7; --row, ++column) {
                if(allPieces[row][column] != null) { break; }
                setPairs(allPieces, tempPair, row, column);
            }
        }

        // LEFT DOWN
        if(currentRow < 7 && currentColumn > 0) {
            for (int row = currentRow + 1, column = currentColumn - 1; row <= 7 && column >= 0; ++row, --column) {
                if(allPieces[row][column] != null) { break; }
                setPairs(allPieces, tempPair, row, column);
            }
        }

        // RIGHT DOWN
        if(currentRow < 7  && currentColumn < 7) {
            for (int row = currentRow + 1, column = currentColumn + 1; row <= 7 && column <= 7; ++row, ++column) {
                if(allPieces[row][column] != null) { break; }
                setPairs(allPieces, tempPair, row, column);
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
            setPairs(allPieces, tempPair, column, row);
            column = currentColumn;
            row = currentRow;
        }

        // UP RIGHT
        if(currentRow > 1 && currentColumn < 7 && allPieces[currentRow - 2][currentColumn + 1] == null) {
            ++column;
            row -= 2;
            setPairs(allPieces, tempPair, column, row);
            column = currentColumn;
            row = currentRow;
        }

        // RIGHT UP
        if(currentColumn < 6 && currentRow > 0 && allPieces[currentRow - 1][ currentColumn + 2] == null) {
            column += 2;
            --row;
            setPairs(allPieces, tempPair, column, row);
            column = currentColumn;
            row = currentRow;
        }

        // RIGHT DOWN
        if(currentColumn < 6 && currentRow < 7 && allPieces[currentRow + 1][currentColumn + 2] == null) {
            column += 2;
            ++row;
            setPairs(allPieces, tempPair, column, row);
            column = currentColumn;
            row = currentRow;
        }

        // DOWN RIGHT
        if(currentRow < 6 && currentColumn < 7 && allPieces[currentRow + 2][currentColumn + 1] == null) {
            ++column;
            row += 2;
            setPairs(allPieces, tempPair, column, row);
            column = currentColumn;
            row = currentRow;
        }

        // DOWN LEFT
        if(currentRow < 6 && currentColumn > 0 && allPieces[currentRow + 2][currentColumn - 1] == null) {
            --column;
            row += 2;
            setPairs(allPieces, tempPair, column, row);
            column = currentColumn;
            row = currentRow;
        }

        // LEFT DOWN
        if(currentColumn > 1 && currentRow < 7 && allPieces[currentRow + 1][currentColumn - 2] == null) {
            column -= 2;
            ++row;
            setPairs(allPieces, tempPair, column, row);
            column = currentColumn;
            row = currentRow;
        }

        // LEFT UP
        if(currentColumn > 1 && currentRow > 0 && allPieces[currentRow - 1][ currentColumn - 2] == null) {
            column -= 2;
            --row;
            setPairs(allPieces, tempPair, column, row);
        }

        /*for(int i = 0; i < pair.size(); ++i) {
            if (pair.size() > 0) {
                System.out.println(pair.get(i).toString());
            }
        }*/
    }

    public void pawnCheckMovement(Piece[][] allPieces, ArrayList<Pair<Integer>> pair, int currentRow, int currentColumn) {

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
}
