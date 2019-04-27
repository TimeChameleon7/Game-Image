import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

class Grid {
    private int width, height;
    private Object[] objects;//objects[0] is the player, all others are obstacles on the grid.
    private Color background;
    private BufferedImage grid;

    Grid(int width, int height, Object[] objects, Color background){
        this.width = width;
        this.height = height;
        this.objects = objects;
        this.background = background;
    }
    int getWidth(){
        return width;
    }
    int getHeight(){
        return  height;
    }
    void setObjects(Object[] objects){
        this.objects = objects;
    }
    Object[] getObjects(){
        return objects;
    }
    void setBackground(Color background){
        this.background = background;
    }
    Color getBackground(){
        return background;
    }
    BufferedImage getGrid(){
        return grid;
    }

    synchronized void draw(){
        BufferedImage grid = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        for(int y = 0;y<height;y++){
            for(int x = 0;x<width;x++){
                grid.setRGB(x,y,background.getRGB());
            }
        }
        for(Object object : objects){
            for(Pixel pixel : object.getPixels()){
                grid.setRGB(
                        object.getCenter().x + pixel.getPoint().x,
                        object.getCenter().y + pixel.getPoint().y,
                        pixel.getRGB()
                );
            }
        }
        this.grid = grid;
    }
    Point[] getObjectsPoints(){
        ArrayList<Point> points = new ArrayList<>();
        for(int i = 1;i<objects.length;i++){
            for(Pixel pixel : objects[i].getPixels()){
                points.add(new Point(
                        objects[i].getCenter().x+pixel.getPoint().x,
                        objects[i].getCenter().y+pixel.getPoint().y
                ));
            }
        }
        Point[] ret = new Point[points.size()];
        ret = points.toArray(ret);
        return ret;
    }
    Point[] getPlayerPoints(){
        ArrayList<Point> points = new ArrayList<>();
        for(Pixel pixel : objects[0].getPixels()){
            points.add(new Point(
                    objects[0].getCenter().x+pixel.getPoint().x,
                    objects[0].getCenter().y+pixel.getPoint().y
            ));
        }
        Point[] ret = new Point[points.size()];
        ret = points.toArray(ret);
        return ret;
    }
}
