package chess;

public class ChessCell {

    private char column;

    private int row;

    public ChessCell(String cell) throws IllegalArgumentException{
        if(cell.length() != 2){
            throw new IllegalArgumentException("wrong cell's name size");
        }
        setCell(cell.charAt(0), (int) cell.charAt(1) - 48);
    }


    public void setCell(char column, int row) throws IllegalArgumentException{
        column = Character.toLowerCase(column);
        if(checkCell(column, row)) {
            this.column = column;
            this.row = row;
        }
    }

    public char getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    public int getIntColumn(){
        return (int) column - 96;
    }

    private static boolean checkCell(char column, int row){
        if( column < 'a' || column > 'h'){
            throw new IllegalArgumentException("wrong column");
        }
        if( row < 1 || row > 8){
            throw new IllegalArgumentException("wrong row");
        }
        return true;
    }

    @Override
    public String toString(){
        return column + "" + row;
    }
}
