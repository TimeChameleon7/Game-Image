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
        Object player = new Object(new Point(200,200),Pixel.rectangle(new Point(-1,-1),new Point(1,1),Color.BLACK),10);
        Pixel[] pixels1 = {
                new Pixel(-1,0,Color.RED), new Pixel(0,0,Color.RED), new Pixel(1,0,Color.RED)
        };
        Object wall = new Object(new Point(100,100),pixels1,10);
        Object[] objects = {player,wall};
        grid = new Grid(400,400,objects,Color.WHITE);
        label.setIcon(new ImageIcon(grid.getGrid()));
        frame.addKeyListener(new Controls());

        frame.setVisible(true);
        
        Thread tick = new Tick();
    }
    static void reload(){
        grid.draw();
        label.setIcon(new ImageIcon(grid.getGrid()));
    }
}
