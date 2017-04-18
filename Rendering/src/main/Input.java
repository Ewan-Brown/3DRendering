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
			if(keys[KeyEvent.VK_A]){
				Main.renderer.povX -= 0.03;
			}
			if(keys[KeyEvent.VK_D]){
				Main.renderer.povX += 0.03;
			}
			if(keys[KeyEvent.VK_W]){
				Main.renderer.povY -= 0.03;
			}
			if(keys[KeyEvent.VK_S]){
				Main.renderer.povY += 0.03;
			}
			if(keys[KeyEvent.VK_Q]){
				Main.renderer.povZ -= 0.03;
			}
			if(keys[KeyEvent.VK_E]){
				Main.renderer.povZ += 0.03;
			}
			if(keys[KeyEvent.VK_UP]){
				Main.renderer.povAngleZX += 0.2;
			}	
			if(keys[KeyEvent.VK_DOWN]){
				Main.renderer.povAngleZX -= 0.2;
			}		
//			if(keys[KeyEvent.VK_LEFT]){
//				Main.renderer.povZ += 0.03;
//			}
//			if(keys[KeyEvent.VK_RIGHT]){
//				Main.renderer.povZ += 0.03;
//			}
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