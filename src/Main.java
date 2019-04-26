import javax.swing.*;
import java.awt.*;

public class Main {
    static JFrame frame;
    private static JLabel label;
    static Grid grid;
    public static void main(String[] args) {
        frame = new JFrame("Game Image");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        label = new JLabel();
        frame.getContentPane().add(label);

        Pixel[] pixels = {
                new Pixel(-1,1), new Pixel(0,1), new Pixel(1,1),
                new Pixel(-1,0), new Pixel(0,0), new Pixel(1,0),
                new Pixel(-1,-1), new Pixel(0,-1), new Pixel(1,-1)};
        Object player = new Object(new Point(200,200),pixels,10);
        Pixel[] pixels1 = {
                new Pixel(-1,0,Color.RED), new Pixel(0,0,Color.RED), new Pixel(1,0,Color.RED)
        };
        Object wall = new Object(new Point(100,100),pixels1,10);
        Object[] objects = {player,wall};
        grid = new Grid(400,400,objects,Color.GRAY);
        label.setIcon(new ImageIcon(grid.getGrid()));
        frame.addKeyListener(new Controls());

        frame.setVisible(true);
        
        Thread refresher = new Refresh();
        refresher.setDaemon(true);
        refresher.start();
    }
    static void reload(){
        grid.draw();
        label.setIcon(new ImageIcon(grid.getGrid()));
        label.repaint();
    }
}
