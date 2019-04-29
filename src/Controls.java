import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controls implements KeyListener {

    Controls(){

    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        /*todo move to Object under method translate, create a copy of objects
        * then attempt to move as desired, throwing MovedBeyondGridException
        * if object collides with wall, or ObjectCollisionException if object
        * collides with another collision. These Exceptions are intended to be caught
        * and dealt with accordingly.
        */
        collisionCheck:
        for(int distance = Main.grid.getObjects()[0].getSpeed();distance>0;distance--) {
            Point prevPoint = Main.grid.getObjects()[0].getCenter();
            switch (e.getKeyCode()) {
                case 27:
                    Main.frame.dispose();
                    break;
                case 87:
                    Main.grid.getObjects()[0].translate(0, -1);
                    break;
                case 83:
                    Main.grid.getObjects()[0].translate(0, 1);
                    break;
                case 65:
                    Main.grid.getObjects()[0].translate(-1, 0);
                    break;
                case 68:
                    Main.grid.getObjects()[0].translate(1, 0);
                    break;
            }
            for (Point playerPoint : Main.grid.getObjects()[0].getAbsolutePoints()) {
                for (Point point : Main.grid.getObjectsPoints()) {
                    if (playerPoint.equals(point.getLocation())) {
                        Main.grid.getObjects()[0].setCenter(prevPoint);
                        break collisionCheck;
                    }
                }
                for (int y = 1; y < Main.grid.getHeight(); y++) {
                    if (
                            playerPoint.equals(new Point(0, y)) ||
                                    playerPoint.equals(new Point(Main.grid.getWidth(), y))
                    ) {
                        Main.grid.getObjects()[0].setCenter(prevPoint);
                        break collisionCheck;
                    }
                }
                for (int x = 1; x < Main.grid.getWidth(); x++) {
                    if (
                            playerPoint.equals(new Point(x, 0)) ||
                                    playerPoint.equals(new Point(x, Main.grid.getWidth()))
                    ) {
                        Main.grid.getObjects()[0].setCenter(prevPoint);
                        break collisionCheck;
                    }
                }
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}