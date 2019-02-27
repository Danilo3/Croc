package triangle;

class Triangle {

    private Point a;
    private Point b;
    private Point c;

    private double ab;
    private double bc;
    private double ac;

    Triangle(Point pa, Point pb, Point pc) {
        a = pa; b = pb; c = pc;
        calculateSides();
        if(!isTriangleExists()){
            throw new IllegalArgumentException("Triangle not exists");
        }
    }

    double getSquare() {
        double p = (ab + bc + ac) / 2;
        return Math.sqrt(p * (p - ab) * (p - ac) * (p - bc));
    }

    private void calculateSides() {
        ab = Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
        bc = Math.sqrt(Math.pow(b.x - c.x, 2) + Math.pow(b.y - c.y, 2));
        ac = Math.sqrt(Math.pow(a.x - c.x, 2) + Math.pow(a.y - c.y, 2));
    }

    private boolean isTriangleExists(){
        boolean isExists = true;
        if(ab >= bc + ac || ac >= bc + ab || bc >= ab + ac){
            isExists = false;
        }
        return isExists;
    }
}
