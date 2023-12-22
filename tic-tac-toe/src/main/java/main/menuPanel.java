 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import inputs.KeyboardInputs;
import java.awt.Dimension;
import java.awt.Graphics;


import javax.swing.JPanel;
import utilz.LoadSave;
import static utilz.LoadSave.TITULO;


public class menuPanel extends JPanel{

    private game Game;
    
    public menuPanel(game Game){
        addKeyListener(new KeyboardInputs(this));
        setPanelSize();
        this.Game = Game;
        setFocusable(true);
    }
    
    private void setPanelSize() {
        Dimension size = new Dimension(600,520);
        setPreferredSize(size);
    }
    
   @Override
   public void paintComponent(Graphics g){
       
       super.paintComponent(g);   
       g.drawImage(LoadSave.GetImage(TITULO), 100, 10,400,300,null);
       Game.render(g);
   }
   
   public game getGame(){
       return Game;
   }
}
