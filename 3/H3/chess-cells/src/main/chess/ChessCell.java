package chess;

public class ChessCell {

    private int x;

    private int y;

    public ChessCell(int x, int y) throws IllegalArgumentException {
        setCell(x, y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    private static boolean CheckCell(int x, int y) throws IllegalArgumentException {
        if( x > 7 || x < 0 ){
            throw new IllegalArgumentException("wrong x");
        }
        if( y < 0 || y > 7){
            throw new IllegalArgumentException("wrong y");
        }
        return true;
    }

    public void setCell(int x, int y) throws IllegalArgumentException {
        CheckCell(x, y);
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString(){
        return (char) (97 + this.y) + "" + (this.x + 1);
    }
}
