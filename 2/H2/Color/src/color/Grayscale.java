package color;

public class Grayscale extends Color {

    private int value;

    public Grayscale(int value) {
        this.value = value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Rgb toRgb(){
        return new Rgb(value, value, value);
    }
}
