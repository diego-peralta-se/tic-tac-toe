
package menuBtn;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;


public class btn {

    private boolean state;
    private int aniTick,  aniSpeed = 60;
    private int aniIndex = 1;
    BufferedImage[] aniBtn;
    
    public btn(){
        loadButton();
        state = false;
    }
       
    private void loadButton(){
        InputStream is = getClass().getResourceAsStream("/menuBtn (1).png");
        
        try {
            BufferedImage img = ImageIO.read(is);
            aniBtn = new BufferedImage[3];
            for (int i=0;i<aniBtn.length;i++){
                aniBtn[i] = img.getSubimage(0,i*300, 300 , 250);
            }
        
        }catch (IOException e){
            e.printStackTrace();
        } finally{
            try{
                is.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        } 
    }
   
    public void selectedAni(){
            aniTick++;
            if(aniTick >= aniSpeed){
                aniTick = 0;
                aniIndex++;
                if(aniIndex >= 3){
                    aniIndex = 1;
                }
            }
   
    }

    public void setAniIndex(int aniIndex) {
        this.aniIndex = aniIndex;
    }
    
    public int getAniIndex() {
        return aniIndex;
    }
     
    public void setState(boolean state){
        this.state = state;
    }

    public boolean getState(){
        return state;
    }
}
