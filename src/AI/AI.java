package AI;

import com.company.Entities.Piece;
import com.company.Entities.Rook;
import com.company.Utility.Pair;
import org.jsfml.graphics.Sprite;
import org.jsfml.system.Vector2f;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AI {

    List<Piece> existingPieces;
    ArrayList<ArrayList<Pair<Integer>>> possibleMovementPair;
    Random random;
    int newPosRow;
    int newPosColumn;


    public AI(List<Piece> existingPieces) {
        this.existingPieces = existingPieces;
        possibleMovementPair = new ArrayList<>();
        random = new Random();
    }

    public void handleEvents(Piece[][] allPieces, Sprite[][] sprites) {
        possibleMovementPair.clear();
        for (Piece piece : existingPieces) {
            piece.checkMovement(allPieces, piece.getY(), piece.getX());
            possibleMovementPair.add(piece.getPair());
        }

        for (int i = 0; i < possibleMovementPair.size(); i++) {
            System.out.println(possibleMovementPair.get(i));
        }
        System.out.println(possibleMovementPair.size());

        move(sprites, allPieces);
    }



    private void move(Sprite[][] sprites, Piece[][] allPieces) {
        int min = 0;
        int max = possibleMovementPair.size() - 1;
        int pieceToMove;
        int toMove;

        do {
            pieceToMove = random.nextInt((max - min) + 1) + min;

        } while (possibleMovementPair.get(pieceToMove) == null);

            max = possibleMovementPair.get(pieceToMove).size() - 1;
            toMove = random.nextInt((max - min) + 1) + min;
            newPosColumn = possibleMovementPair.get(pieceToMove).get(toMove).getPairNumber2();
            newPosRow = possibleMovementPair.get(pieceToMove).get(toMove).getPairNumber1();


            //FELSÖK!!!
            Vector2f vector2f = new Vector2f(newPosColumn * 128 + 19, newPosRow * 128 + 19);
            sprites[existingPieces.get(pieceToMove).getY()][existingPieces.get(pieceToMove).getX()].setPosition(newPosColumn, newPosRow);
            //sprites[existingPieces.get(pieceToMove).getY()][existingPieces.get(pieceToMove).getX()].move(vector2f);
            allPieces[newPosColumn][newPosRow] = allPieces[existingPieces.get(pieceToMove).getY()][existingPieces.get(pieceToMove).getX()];
            allPieces[existingPieces.get(pieceToMove).getY()][existingPieces.get(pieceToMove).getX()] = null;

            //existingPieces.get(pieceToMove).setX(newPosColumn);
            //existingPieces.get(pieceToMove).setY(newPosRow);
            //existingPieces.get(pieceToMove).setY(newPosRow);
            //existingPieces.get(pieceToMove).setX(newPosColumn);
    }

    public void update() {

    }
}
