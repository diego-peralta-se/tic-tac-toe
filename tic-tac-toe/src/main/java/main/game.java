
package main;

import java.awt.Graphics;
import menuBtn.btn;
import menuBtn.menu;



public class game implements Runnable {
    private window window;
    private menuPanel panel;
    private Thread gameThread;
    private final int FPS_SET = 120;
    private final int UPS_SET = 200;

    private menu Menu;
    public game(){
        
        initClasses();
        panel = new menuPanel(this);
        window = new window(panel);
        panel.requestFocus();
        startGameLoop();
        
    }
    
    private void startGameLoop() {
	gameThread = new Thread(this);
	gameThread.start();
    }
    
    private void initClasses(){

            Menu = new menu();
    }
    
    public void render(Graphics g){

            Menu.renderMenu(g);
    }
    
    public void update() {
        Menu.update();
    }
    
    public menu getMenu(){
        return Menu;
    }
        @Override
	public void run() {

		double timePerFrame = 1000000000.0 / FPS_SET;
		double timePerUpdate = 1000000000.0 / UPS_SET;

		long previousTime = System.nanoTime();

		int frames = 0;
		int updates = 0;
		long lastCheck = System.currentTimeMillis();

		double deltaU = 0;
		double deltaF = 0;

		while (true) {
			long currentTime = System.nanoTime();

			deltaU += (currentTime - previousTime) / timePerUpdate;
			deltaF += (currentTime - previousTime) / timePerFrame;
			previousTime = currentTime;

			if (deltaU >= 1) {
				update();
				updates++;
				deltaU--;
			}

			if (deltaF >= 1) {
				panel.repaint();
				frames++;
				deltaF--;
			}

			if (System.currentTimeMillis() - lastCheck >= 1000) {
				lastCheck = System.currentTimeMillis();
				System.out.println("FPS: " + frames + " | UPS: " + updates);
				frames = 0;
				updates = 0;

			}
		}

	}
}
