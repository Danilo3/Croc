package triangle;
/*
   run with -ea vm option
 */
public class TestTriangleSquare {

    static double e = 1e-5; //погрешность

    public static void main(String[] args) {
        assert TestImpossibleTriangle();
        assert TestNegativePoints();
        assert TestRightTriangle();
        assert TestObvious();

    }

    static boolean TestNegativePoints(){
        Point p1 = new Point(-1, -1 );
        Point p2 = new Point(-5, -5 );
        Point p3 = new Point(-5, -1  );
        Triangle triangle = new Triangle(p1, p2 ,p3);
        return Math.abs(8.0 - triangle.getSquare())  < e;
    }

    static boolean TestImpossibleTriangle(){
        try{
            Triangle triangle = new Triangle(new Point(1, 1), new Point(2, 2), new Point(3, 3 ));
        } catch (IllegalArgumentException exception){
            return true;
        }
        return false;
    }

    static boolean TestRightTriangle(){
        Point p1 = new Point(-1, 4);
        Point p2 = new Point(-1, -2 );
        Point p3 = new Point(4, -2);
        Triangle triangle = new Triangle(p1, p2, p3);

        return Math.abs(15.0 - triangle.getSquare()) < e;
    }

    static boolean TestObvious(){
        Point p1 = new Point(2, 1);
        Point p2 = new Point(6 , 1 );
        Point p3 = new Point(4, 4);
        Triangle triangle = new Triangle(p1, p2, p3);

        return Math.abs(6.0 - triangle.getSquare()) < e;
    }
}
