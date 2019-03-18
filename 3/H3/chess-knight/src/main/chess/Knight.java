package chess;

public class Knight {

    private ChessCell currentCell;

    public Knight(){
        this.currentCell  =new ChessCell("a1");
    }

    public Knight(ChessCell cell){
        this.currentCell = cell;
    }

    public void makeMove(ChessCell toCell) throws IllegalKnightMoveException {
        if(canMoveTo(toCell)){
            this.currentCell = toCell;
        }else{
            throw new IllegalKnightMoveException(currentCell, toCell);
        }
    }

    private boolean canMoveTo(ChessCell cell) {
        int diffColumn = Math.abs(currentCell.getIntColumn() - cell.getIntColumn());
        int diffRow = Math.abs(currentCell.getRow() - cell.getRow());
        return (diffColumn == 2 && diffRow == 1) || (diffColumn == 1) && (diffRow == 2);
    }

    public void setCurrentCell(ChessCell currentCell) {
        this.currentCell = currentCell;
    }

}
