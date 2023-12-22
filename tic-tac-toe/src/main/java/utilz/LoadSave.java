
package utilz;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;

/**
 *
 * @author aburr
 */
public class LoadSave {
    
    
    public static final String TITULO = "/titulo.png";
    
    
    public static BufferedImage GetImage(String fileName){
        BufferedImage img = null;
        InputStream is = LoadSave.class.getResourceAsStream(fileName);
        try {
          img = ImageIO.read(is);
        } catch(IOException e){
            e.printStackTrace();
        } finally{
            try{
                is.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        return img;
    }
}
