import java.awt.*;
import java.util.ArrayList;

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
    Pixel(int x, int y, int color){
        this.point = new Point(x,y);
        this.color = new Color(color);
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
    Color getColor(){
        return color;
    }
    int getRGB(){
        return color.getRGB();
    }

    Pixel[] rectangle(Point point1, Point point2, Color color){
        ArrayList<Pixel> pixels = new ArrayList<>();
        for(int y = point1.y;y<=point2.y;y++){
            for(int x = point1.x;x<=point1.x;x++){
                pixels.add(new Pixel(x,y,color));
            }
        }
        Pixel[] ret = new Pixel[pixels.size()];
        ret = pixels.toArray(ret);
        return ret;
    }
}
