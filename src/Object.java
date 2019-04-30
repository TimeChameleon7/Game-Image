import java.awt.*;
import java.util.ArrayList;

class Object{
    private Point center;
    private Pixel[] pixels;
    private int speed;
    private double velocityX, velocityY, accelerationX, accelerationY;

    Object(Point center, Pixel[] pixels, int speed){
        this.center = center;
        this.pixels = pixels;
        this.speed = speed;
        this.velocityX = 0;
        this.velocityY = 0;
        this.accelerationX = 0;
        this.accelerationY = 0;
    }
    Object(Point center, Pixel[] pixels){
        this.center = center;
        this.pixels = pixels;
        this.speed = 1;
        this.velocityX = 0;
        this.velocityY = 0;
        this.accelerationX = 0;
        this.accelerationY = 0;
    }
    Object(Point center, Pixel[] pixels, int speed, double accelerationX, double accelerationY){
        this.center = center;
        this.pixels = pixels;
        this.speed = speed;
        this.velocityX = 0;
        this.velocityY = 0;
        this.accelerationX = accelerationX;
        this.accelerationY = accelerationY;
    }

    void move(int x, int y){
        center.move(x,y);
    }
    void translate(int dx, int dy) throws WallCollisionException, ObjectCollisionException{
        Object object = new Object(new Point(this.center),this.pixels);
        object.center.translate(dx,dy);
        for(Point pixel : object.getAbsolutePoints()) {
            for (Object objectOnGrid : Main.grid.getObjects(this)) {
                for (Point pixelOnGrid : objectOnGrid.getAbsolutePoints()) {
                    if(pixel.equals(pixelOnGrid)){
                        throw new ObjectCollisionException(objectOnGrid);
                    }
                }
            }
            for(int y = 1; y < Main.grid.getHeight(); y++){
                if(
                        pixel.equals(new Point(0,y))||
                                pixel.equals(new Point(Main.grid.getWidth(),y))
                ){
                    throw new WallCollisionException();
                }
            }
            for(int x = 1; x < Main.grid.getWidth(); x++){
                if(
                        pixel.equals(new Point(x,0))||
                                pixel.equals(new Point(x,Main.grid.getWidth()))
                ){
                    throw new WallCollisionException();
                }
            }
        }
        this.center.translate(dx,dy);
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
    public double getVelocityX() {
        return velocityX;
    }
    public void setVelocityX(double velocityX) {
        this.velocityX = velocityX;
    }
    public double getVelocityY() {
        return velocityY;
    }
    public void setVelocityY(double velocityY) {
        this.velocityY = velocityY;
    }
    void setAccelerationY(double accelerationY){
        this.accelerationY = accelerationY;
    }
    double getAccelerationY(){
        return this.accelerationY;
    }
    void setAccelerationX(double accelerationX){
        this.accelerationX = accelerationX;
    }
    double getAccelerationX(){
        return this.accelerationX;
    }
}
