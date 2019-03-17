package color;

public abstract class Color {

    public abstract Rgb toRgb();

    public double distance(Color color){
        Rgb c1 = this.toRgb();
        Rgb c2 = color.toRgb();

        return Math.sqrt(
                Math.pow(c1.getR()  - c2.getR(), 2) +
                Math.pow(c1.getG()  - c2.getG(), 2) +
                Math.pow(c1.getB()  - c2.getB(), 2));
    }

}
