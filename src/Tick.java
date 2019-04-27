
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tick extends Thread{
    Tick(){
        setDaemon(true);
    }
    @Override
    public void run(){
        //noinspection InfiniteLoopStatement
        while(true){
            Main.reload();
            try {
                Thread.sleep(20);
            } catch (InterruptedException ex) {
                Logger.getLogger(Tick.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
