package AI;

import com.company.Entities.Piece;
import com.company.Utility.Pair;

import java.util.ArrayList;
import java.util.List;

public class AI {

    List<Piece> existingPieces;
    ArrayList<ArrayList<Pair<Integer>>> possibleMovementPair;


    public AI(List<Piece> existingPieces) {
        this.existingPieces = existingPieces;
        possibleMovementPair = new ArrayList<>();
    }

    public void handleEvents(Piece[][] allPieces) {
        for (Piece piece : existingPieces) {
            piece.checkMovement(allPieces, piece.getY(), piece.getX());
            possibleMovementPair.add(piece.getPair());
        }

        for (int i = 0; i < possibleMovementPair.size(); i++) {
            System.out.println(possibleMovementPair.get(i));
        }
    }

    public void update() {

    }
}
