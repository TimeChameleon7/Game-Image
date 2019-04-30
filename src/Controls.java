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
        if(e.getKeyCode()==27){
            Main.frame.dispose();
        }
        try{
            for (int distance = Main.grid.getObjects()[0].getSpeed(); distance > 0; distance--) {
                switch (e.getKeyCode()) {
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
            }
        } catch (ObjectCollisionException ex) {
            System.out.println("Object collision at "+ex.getObject());
        } catch (WallCollisionException ignored) {

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}