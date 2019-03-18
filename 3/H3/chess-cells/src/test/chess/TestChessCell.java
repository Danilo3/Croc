package chess;


/*
  run with -ea VM-option
 */
public class TestChessCell {
    public static void main(String[] args) {
        assert TestGeneral();
        assert TestException();
    }

    public static boolean TestGeneral(){
        ChessCell cell = new ChessCell(1,1);
        return cell.toString().equals("b2");
    }

    public static boolean TestException(){
        try{
            ChessCell cell = new ChessCell(-1, 0);
        } catch (IllegalArgumentException e){
            return true;
        }
        return false;
    }

}
