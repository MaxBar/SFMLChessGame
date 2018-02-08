package com.company.Utility;


import com.company.Entities.Pawn;
import com.company.Entities.Piece;

import java.util.ArrayList;

public class Movement {

    public void rookCheckMovement(Piece[][] allPieces, ArrayList<Pair<Integer>> pair, int currentRow, Integer currentColumn) {
        ArrayList<Pair<Integer>> tempPair = pair;
        // UP
        if(currentRow > 0) {
            for (int row = currentRow; row > 0; --row) {
                if(allPieces[row][currentColumn] != null) { break; }
                setPairs(allPieces, tempPair, currentColumn, row);
            }
        }

        // DOWN
        if(currentRow < 7) {
            for (int row = currentRow; row < 7; ++row) {
                if(allPieces[row][currentColumn] != null) { break; }
                setPairs(allPieces, tempPair, currentColumn, row);
            }
        }

        // LEFT
        if(currentColumn > 0) {
            for (int column = currentColumn; column > 0; --column) {
                if(allPieces[currentRow][column] != null) { break; }
                setPairs(allPieces, tempPair, column, currentRow);
            }
        }

        // RIGHT
        if(currentColumn < 7) {
            for (int column = currentColumn; column > 7; ++column) {
                if(allPieces[currentRow][column] != null) { break; }
                setPairs(allPieces, tempPair, column, currentRow);
            }
        }


        for(int i = 0; i <= tempPair.size(); ++i) {
            if(tempPair.size() > 0) {
                System.out.println(tempPair.get(i).toString());
            }
            System.out.println(tempPair.size());
        }
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
        if (currentRow > 0) {
            --row;
            setPairs(allPieces, tempPair, column, row);
            row = currentRow;
        }

        // UP LEFT
        if(currentRow > 0 && currentColumn > 0) {
            --column;
            --row;
            setPairs(allPieces, tempPair, column, row);
            column = currentColumn;
            row = currentRow;
        }

        // UP RIGHT
        if(currentRow > 0 && currentColumn < 7) {
            ++column;
            --row;
            setPairs(allPieces, tempPair, column, row);
            column = currentColumn;
            row = currentRow;
        }

        //DOWN
        if (currentRow < 7) {
            ++row;
            setPairs(allPieces, tempPair, column, row);
            row = currentRow;
        }

        // DOWN RIGHT
        if(currentRow < 7 && currentColumn < 7) {
            ++column;
            ++row;
            setPairs(allPieces, tempPair, column, row);
            column = currentColumn;
            row = currentRow;
        }

        // DOWN LEFT
        if(currentRow < 7 && currentColumn > 0) {
            --column;
            ++row;
            setPairs(allPieces, tempPair, column, row);
            column = currentColumn;
            row = currentRow;
        }

        // LEFT
        if (currentColumn > 0) {
            --column;
            setPairs(allPieces, tempPair, column, row);
            column = currentColumn;
        }

        // RIGHT
        if (currentColumn < 7) {
            ++column;
            setPairs(allPieces, tempPair, column, row);
        }

        for(int i = 0; i < pair.size(); ++i) {
            if(pair.size() > 0) {
                System.out.println(pair.get(i).toString());
            }
            System.out.println(pair.size());
        }
    }

    public void bishopCheckMovement(Piece[][] allPieces, ArrayList<Pair<Integer>> pair, int currentRow, Integer currentColumn) {
        ArrayList<Pair<Integer>> tempPair = pair;

        // LEFT UP
        if(currentRow > 0 && currentColumn > 0) {
            for (int row = currentRow, column = currentColumn; row > 0; --row, --column) {
                if(allPieces[row][currentColumn] != null) { break; }
                setPairs(allPieces, tempPair, currentColumn, row);
            }
        }

        // RIGHT UP
        if(currentRow > 0 && currentColumn < 7) {
            for (int row = currentRow, column = currentColumn; row > 0; --row, ++column) {
                if(allPieces[row][currentColumn] != null) { break; }
                setPairs(allPieces, tempPair, currentColumn, row);
            }
        }

        // LEFT DOWN
        if(currentRow < 7 && currentColumn > 0) {
            for (int row = currentRow, column = currentColumn; row > 0; ++row, --column) {
                if(allPieces[row][currentColumn] != null) { break; }
                setPairs(allPieces, tempPair, currentColumn, row);
            }
        }

        // RIGHT DOWN
        if(currentRow < 0 && currentColumn < 7) {
            for (int row = currentRow, column = currentColumn; row > 0; ++row, ++column) {
                if(allPieces[row][currentColumn] != null) { break; }
                setPairs(allPieces, tempPair, currentColumn, row);
            }
        }

        for(int i = 0; i <= pair.size(); ++i) {
            if(pair.size() > 0) {
                System.out.println(pair.get(i).toString());
            }
            System.out.println(pair.size());
        }
    }

    public void knightCheckMovement(Piece[][] allPieces, ArrayList<Pair<Integer>> pair, int currentRow, Integer currentColumn) {
        ArrayList<Pair<Integer>> tempPair = pair;

        int column = currentColumn;
        int row = currentRow;

        // UP LEFT
        if(currentRow > 1 && currentColumn > 0) {
            --column;
            row -= 2;
            setPairs(allPieces, tempPair, column, row);
            column = currentColumn;
            row = currentRow;
        }

        // UP RIGHT
        if(currentRow > 1 && currentColumn < 7) {
            ++column;
            row -= 2;
            setPairs(allPieces, tempPair, column, row);
            column = currentColumn;
            row = currentRow;
        }

        // RIGHT UP
        if(currentColumn < 6 && currentRow > 0) {
            column += 2;
            --row;
            setPairs(allPieces, tempPair, column, row);
            column = currentColumn;
            row = currentRow;
        }

        // RIGHT DOWN
        if(currentColumn < 6 && currentRow < 7) {
            column += 2;
            ++row;
            setPairs(allPieces, tempPair, column, row);
            column = currentColumn;
            row = currentRow;
        }

        // DOWN RIGHT
        if(currentRow < 6 && currentColumn < 7) {
            ++column;
            row += 2;
            setPairs(allPieces, tempPair, column, row);
            column = currentColumn;
            row = currentRow;
        }

        // DOWN LEFT
        if(currentRow < 6 && currentColumn > 0) {
            --column;
            row += 2;
            setPairs(allPieces, tempPair, column, row);
            column = currentColumn;
            row = currentRow;
        }

        // LEFT DOWN
        if(currentColumn > 1 && currentRow < 7) {
            column -= 2;
            ++row;
            setPairs(allPieces, tempPair, column, row);
            column = currentColumn;
            row = currentRow;
        }

        // LEFT UP
        if(currentColumn > 1 && currentRow > 0) {
            column -= 2;
            --row;
            setPairs(allPieces, tempPair, column, row);
        }

        for(int i = 0; i < pair.size(); ++i) {
            if (pair.size() > 0) {
                System.out.println(pair.get(i).toString());
            }
        }
    }

    public void pawnCheckMovement(Piece[][] allPieces, ArrayList<Pair<Integer>> pair, int currentRow, Integer currentColumn) {

        ArrayList<Pair<Integer>> tempPair = pair;
        Pawn pawn = null;

        if(allPieces[currentRow][currentColumn] instanceof Pawn) {
            pawn = (Pawn)allPieces[currentRow][currentColumn];
        }

        if(allPieces[currentRow][currentColumn].isWhite()) {
            if(pawn.getHasMoved()) {
                for(int row = currentRow; row >= currentRow - 1; --row) {
                   // if(allPieces[row][currentColumn] != null) { break; }
                    setPairs(allPieces, tempPair, currentColumn, row);
                }
            } else {
                for(int row = currentRow; row >= currentRow - 2; --row) {
                  //  if(allPieces[row][currentColumn] != null) { break; }
                    setPairs(allPieces, tempPair, currentColumn, row);
                }
            }
        } else {
            if(pawn.getHasMoved()) {
                for(int row = currentRow; row <= currentRow + 1; ++row) {
                  //  if(allPieces[row][currentColumn] != null) { break; }
                    setPairs(allPieces, tempPair, currentColumn, row);
                }
            } else {
                for(int row = currentRow; row <= currentRow + 2; ++row) {
                  //  if(allPieces[row][currentColumn] != null) { break; }
                    setPairs(allPieces, tempPair, currentColumn, row);
                }
            }
        }
        for(int i = 0; i < pair.size(); ++i) {
            System.out.println(pair.get(i).toString());
            System.out.println(pair.size());
        }
    }

    private void setPairs(Piece[][] allPieces,  ArrayList<Pair<Integer>> pair, int column, int row) {
        if(allPieces[row][column] == null) {
            Pair whereToMove = new Pair(row, column);
            pair.add(whereToMove);
//            this.setX(column);
//            this.setY(row);
        }
    }
}
