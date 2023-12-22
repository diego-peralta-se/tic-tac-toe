
package main;



import javax.swing.*;


public class window {
    
    private final JFrame frame;

    
    
    public window(menuPanel Panel){
        
        frame = new JFrame("Tic-Tac-Toe");
        frame.add(Panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setContentPane(new JLabel(new ImageIcon(img)));
        frame.setResizable(false);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
}
