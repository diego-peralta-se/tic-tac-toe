/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menuBtn;

import java.awt.Graphics;
import java.util.HashSet;

/**
 *
 * @author aburr
 */
public class menu {
    private short currentIndex = 0;
    private short previousIndex = 1;
    private final btn btnPlay;
    private final btn btnOpt;
    private final btn[] arrayBotones;
    
    public menu(){
        btnPlay = new btn();
        btnOpt = new btn();
        arrayBotones = new btn[2];
        arrayBotones[0] = btnPlay;
        arrayBotones[1] = btnOpt;
    }
    
    public void update(){
        selectIndex();     
    }
    
    public void renderMenu(Graphics g){
        
        for(int i=0;i<arrayBotones.length;i++){
            if(arrayBotones[i].getState()){
                g.drawImage(arrayBotones[i].aniBtn[arrayBotones[i].getAniIndex()],180,(i*125+125),200,150,null);
            } else{
                g.drawImage(arrayBotones[i].aniBtn[0],180,(i*125+125),200,150,null);
            }
            
        }
        
        
    }
    
    public void selectIndex(){
        arrayBotones[previousIndex].setState(false);
        arrayBotones[currentIndex].setState(true);
        arrayBotones[currentIndex].selectedAni();
        
    }
    
    public void setIndex(short newIndex){
        this.currentIndex = newIndex;
    }
    
    public void setPIndex(short pindex){
        this.previousIndex = pindex;
    }
}
