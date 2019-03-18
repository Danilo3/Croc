package chess;

public class IllegalKnightMoveException extends RuntimeException {

    public IllegalKnightMoveException(ChessCell fromCell, ChessCell toCell){
        super("конь так не ходит: " + fromCell + " -> " + toCell);
    }
}
