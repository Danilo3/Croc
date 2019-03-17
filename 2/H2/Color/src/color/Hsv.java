package color;

public class Hsv extends Color {

    public int getHue() {
        return hue;
    }

    public void setHue(int hue) {
        this.hue = hue;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getSaturation() {
        return saturation;
    }

    public void setSaturation(int saturation) {
        this.saturation = saturation;
    }

    private int hue;
    private int value;
    private int saturation;

    public Hsv(int hue, int value, int saturation) {
        this.hue = hue;
        this.value = value;
        this.saturation = saturation;
    }

    private Rgb newRgb(double v1, double v2, double v3){
        double k = 255.0/100;
        return new Rgb(
                (int) (k * v1),
                (int) (k * v2),
                (int) (k * v3)
        );
    }

    public Rgb toRgb(){
        int hi = (hue / 60) % 6;
        double vmin = ((100-saturation)* value ) / 100.0;
        double a = (value - vmin) *(hue % 60)/ 60.0;
        double vinc = vmin + a;
        double vdec = vmin - a;

        switch (hi){
            case 0:
                return newRgb(value, vinc, vmin);
            case 1:
                return newRgb(value, vinc, vmin);
            case 2:
                return newRgb(value, vinc, vmin);
            case 3:
                return newRgb(value, vinc, vmin);
            case 4:
                return newRgb(value, vinc, vmin);
            case 5:
                return newRgb(value, vinc, vmin);
            default:
                return new Rgb(0, 0, 0);
        }

    }

}
