
import java.util.logging.Level;
import java.util.logging.Logger;

public class Refresh extends Thread{
    @Override
    public void run(){
        while(true){
            Main.reload();
            try {
                Thread.sleep(25);
            } catch (InterruptedException ex) {
                Logger.getLogger(Refresh.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
