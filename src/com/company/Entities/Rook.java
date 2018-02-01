package com.company.Entities;

public class Rook extends Piece implements IEntity {


    public Rook(int x, int y, boolean is_white) {

        super(x, y, is_white);

    }


    @Override
    public void move() {

    }

    @Override
    public boolean canMove(int destination_x, int destination_y) {

        // IF THERE IS A PIECE AT THE DESTINATION AND ITS OUR OWN WE CANT MAKE THE MOVE

        Piece possiblePiece = getPiece(destination_x, destination_y);

        if (possiblePiece != null) {

            if (possiblePiece.isWhite() && this.isWhite()) {
                return false;
            }
            if (possiblePiece.isBlack() && this.isBlack()) {
                return false;
            }

        }

        // NOT LETTING ROOK MOVE SOMEWHERE IN A STRAIGHT LINE

        if (this.getX() != destination_x && this.getY() != destination_y) {

            return false;

        }

        // FINDS OUT WHICH DIRECTION ROOK'S TRYING TO MOVE

        String direction = "";
        if (destination_y > this.getY()) {

            direction = "down";

        }

        if (destination_y < this.getY()) {

            direction = "up";

        }

        if (destination_x > this.getX()) {

            direction = "right";

        }

        if (destination_x < this.getX()) {

            direction = "left";

        }

        // MAKING SURE THERE'S NOTHING IN THE WAY, WHATEVER DIRECTION

        if (direction.equals("down")) {
            int spaces_to_move = Math.abs(destination_y - this.getY());
            for (int i = 1; i < spaces_to_move; i++) {

                Piece p = getPiece(this.getX(), this.getY() + i);
                if (p != null) {

                    return false;

                }

            }
        }


        if (direction.equals("up")) {
            int spaces_to_move = Math.abs(destination_y - this.getY());
            for (int i = 1; i < spaces_to_move; i++) {

                Piece p = getPiece(this.getX(), this.getY() - i);
                if (p != null) {

                    return false;

                }

            }
        }

        if (direction.equals("right")) {
            int spaces_to_move = Math.abs(destination_x - this.getX());
            for (int i = 1; i < spaces_to_move; i++) {

                Piece p = getPiece(this.getX() + 1, this.getY());
                if (p != null) {

                    return false;

                }

            }
        }


        if (direction.equals("left")) {
            int spaces_to_move = Math.abs(destination_y - this.getY());
            for (int i = 1; i < spaces_to_move; i++) {

                Piece p = getPiece(this.getX() - i, this.getY());
                if (p != null) {

                    return false;

                }

            }
        }

        return true;


    }

}


