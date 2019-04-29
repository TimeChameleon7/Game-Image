import java.awt.*;
import java.util.ArrayList;

class Object {
    private Point center;
    private Pixel[] pixels;
    private int speed;

    Object(Point center, Pixel[] pixels, int speed){
        this.center = center;
        this.pixels = pixels;
        this.speed = speed;
    }
    Object(Point center, Pixel[] pixels){
        this.center = center;
        this.pixels = pixels;
        this.speed = 1;
    }

    void move(int x, int y){
        center.move(x,y);
    }
    //todo add WallCollsionException and ObjectCollisionException
    void translate(int dx, int dy){
        center.translate(dx,dy);
    }
    void setCenter(Point center){
        this.center = center;
    }
    Point getCenter(){
        return center.getLocation();
    }
    void setPixels(Pixel[] pixels){
        this.pixels = pixels;
    }
    Pixel[] getPixels(){
        return pixels;
    }
    Point[] getAbsolutePoints(){
        ArrayList<Point> points = new ArrayList<>();
        for(Pixel pixel : pixels){
            points.add(new Point(
                    center.x+pixel.getPoint().x,
                    center.y+pixel.getPoint().y
            ));
        }
        Point[] ret = new Point[points.size()];
        ret = points.toArray(ret);
        return ret;
    }
    void setSpeed(int speed){
        this.speed = speed;
    }
    int getSpeed(){
        return this.speed;
    }
}
