/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import java.util.Queue;
import main.menuPanel;

/**ww
 *
 * @author aburr
 */
public class KeyboardInputs implements KeyListener {
    
    private final menuPanel menuPanel;
    private short actualIndex = 0;
    private Queue<Short> q;
    
    public KeyboardInputs(menuPanel menuPanel){
        this.menuPanel = menuPanel;
        q = new LinkedList<>();
    }

    

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        q.offer(actualIndex);
        switch (e.getKeyCode()){
            case KeyEvent.VK_W:
                if(actualIndex == 0){
                    actualIndex = 1;
                }
                else{
                    actualIndex--;
                }
                System.out.println(actualIndex);
                break;
                
            case KeyEvent.VK_S:
                
                if(actualIndex == 1){
                    actualIndex = 0;
                }
                else{
                    actualIndex++;
                }
                System.out.println(actualIndex);                
                break;
                
        }
        
        
        if(!q.isEmpty()){
            menuPanel.getGame().getMenu().setPIndex(q.remove());
            
        }
        menuPanel.getGame().getMenu().setIndex(actualIndex);
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        

    }

    public short getActualIndex() {
        return actualIndex;
    }
    
}
