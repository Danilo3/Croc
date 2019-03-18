package chess;
/*
    run with -ea VM option
 */
public class ChessKnightTest {
    public static void main(String[] args) {
        assert TestFromTask();
        assert TestFromTask2();
    }

    public static boolean TestFromTask(){
        String[] cells = { "e7", "e6"};
        Knight k = new Knight(new ChessCell("g8"));
        try {
            for (String cell : cells) {
                ChessCell c = new ChessCell(cell);
                k.makeMove(c);
            }
        }catch (IllegalKnightMoveException e){
            return e.getMessage().equals("конь так не ходит: e7 -> e6");
        }
        return false;
    }

    public static boolean TestFromTask2(){
        String[] cells = { "e7", "c8"};
        Knight k = new Knight(new ChessCell("g8"));
        try {
            for (String cell : cells) {
                ChessCell c = new ChessCell(cell);
                k.makeMove(c);
            }
        }catch (IllegalKnightMoveException e){
            return false;
        }
        return true;
    }
}
