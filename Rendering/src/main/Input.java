package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Input implements KeyListener,MouseListener,Runnable{
	boolean[] keys = new boolean[256];
	public void run() {
		while(true){
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
//			double 
			if(keys[KeyEvent.VK_S]){
				Main.renderer.povX -= 0.03;
			}
			if(keys[KeyEvent.VK_W]){
				Main.renderer.povX += 0.03;
			}
			if(keys[KeyEvent.VK_A]){
				Main.renderer.povY -= 0.03;
			}
			if(keys[KeyEvent.VK_D]){
				Main.renderer.povY += 0.03;
			}
			if(keys[KeyEvent.VK_Q]){
				Main.renderer.povZ -= 0.01;
			}
			if(keys[KeyEvent.VK_E]){
				Main.renderer.povZ += 0.01;
			}
			if(keys[KeyEvent.VK_UP]){
				Main.renderer.povAngleZX += 0.8;
			}	
			if(keys[KeyEvent.VK_DOWN]){
				Main.renderer.povAngleZX -= 0.8;
			}		
			if(keys[KeyEvent.VK_LEFT]){
				Main.renderer.povAngleXY -= 0.8;
			}
			if(keys[KeyEvent.VK_RIGHT]){
				Main.renderer.povAngleXY += 0.8;
			}
			if(keys[KeyEvent.VK_Y]){
				Main.renderer.povAngleXY = 0;
			}
			if(keys[KeyEvent.VK_Z]){
				Main.renderer.povAngleZX = 0;
			}		
		}
		
	}

	public void mouseClicked(MouseEvent e) {}

	public void mousePressed(MouseEvent e) {}

	public void mouseReleased(MouseEvent e) {}

	public void mouseEntered(MouseEvent e) {}

	public void mouseExited(MouseEvent e) {}

	public void keyTyped(KeyEvent e) {}

	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}

	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

}
