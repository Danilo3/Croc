package color;

public class Palette {

    private Color [] colors;

    public Palette(int n){
        colors = new Color[n];
    }

    public void setColor(int index, Color color){
        colors[index] = color;
    }

    public Color getColor(int index) {
        return colors[index];
    }

    public Color matchColor(Color color){
        double min = Double.MAX_VALUE;
        Color result = color;
        for(Color paletteColor : colors){
            if(paletteColor != null) {
                double d = color.distance(paletteColor);
                if (d < min) {
                    min = d;
                    result = paletteColor;
                }
            }
        }
        return result;
    }
}
