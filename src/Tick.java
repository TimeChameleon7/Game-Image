
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
            for(Object object : Main.grid.getObjects()){
                object.setVelocityX(object.getVelocityX()+object.getAccelerationX());
                object.setDistanceX(object.getDistanceX()+object.getVelocityX());
                object.setVelocityY(object.getVelocityY()+object.getAccelerationY());
                object.setDistanceY(object.getDistanceY()+object.getVelocityY());
                while(!(object.getDistanceX()>-1&&object.getDistanceX()<1)){
                    try {
                        if (object.getDistanceX() <= -1) {
                            object.setDistanceX(object.getDistanceX() + 1);
                            object.translate(-1,0);
                        } else {
                            object.setDistanceX(object.getDistanceX() - 1);
                            object.translate(1,0);
                        }
                    }catch (Exception ignored){
                        object.setVelocityX(0);
                        object.setDistanceX(0);
                    }
                }
                while(!(object.getDistanceY()>-1&&object.getDistanceY()<1)){
                    try{
                        if(object.getDistanceY() <= -1){
                            object.setDistanceY(object.getDistanceY() + 1);
                            object.translate(0,1);
                        }else{
                            object.setDistanceY(object.getDistanceY() - 1);
                            object.translate(0,-1);
                        }
                    }catch(Exception ignored){
                        object.setVelocityY(0);
                        object.setDistanceY(0);
                    }
                }
            }
            try {
                Thread.sleep(20);
            } catch (InterruptedException ex) {
                Logger.getLogger(Tick.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
