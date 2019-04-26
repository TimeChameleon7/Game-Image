import java.awt.*;

class Pixel {
    private Point point;
    private Color color;

    Pixel(Point point, Color color){
        this.point = point;
        this.color = color;
    }
    Pixel(int x, int y, Color color){
        this.point = new Point(x,y);
        this.color = color;
    }
    Pixel(int x, int y){
        this.point = new Point(x,y);
        this.color = Color.BLACK;
    }

    void move(int x, int y){
        point.move(x,y);
    }
    Point getPoint(){
        return point.getLocation();
    }
    void changeColor(Color color){
        this.color = color;
    }
    int getRGB(){
        return color.getRGB();
    }
    int getRed(){
        return color.getRed();
    }
    int getGreen(){
        return color.getGreen();
    }
    int getBlue(){
        return color.getBlue();
    }
}
