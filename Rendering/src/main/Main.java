package main;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;

public class Main {

	static JFrame frameFOV;
	static JFrame frameDown;
	static JFrame frameSide;
	static PanelFOV panelFOV;
	static PanelDown panelDown;
	static PanelSide panelSide;

	static Renderer renderer;
	static Input input;
	
	public static void main(String[] args){
//		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice(); 
//		int width = gd.getDisplayMode().getWidth(); 
//		int height = gd.getDisplayMode().getHeight();
		renderer = new Renderer();
		input = new Input();

		frameFOV = new JFrame("FOV");
		panelFOV = new PanelFOV();
	
		frameFOV.add(panelFOV);
		frameFOV.setSize(500, 500);
		frameFOV.setVisible(true);
		frameFOV.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameFOV.setFocusable(true);
		frameFOV.addKeyListener(input);
		
		frameDown = new JFrame("Down");
		panelDown = new PanelDown();
	
		frameDown.add(panelDown);
		frameDown.setSize(500, 500);
		frameDown.setLocation(500, 0);
		frameDown.setVisible(true);
		frameDown.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameDown.setFocusable(true);
		frameDown.addKeyListener(input);
		
		frameSide = new JFrame("Side");
		panelSide = new PanelSide();
	
		frameSide.add(panelSide);
		frameSide.setSize(500, 500);
		frameSide.setLocation(300, 500);
		frameSide.setVisible(true);
		frameSide.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameSide.setFocusable(true);
		frameSide.addKeyListener(input);
		
		
		
		Thread rThread = new Thread(renderer);
		rThread.start();
		Thread pFThread = new Thread(panelFOV);
		pFThread.start();
		Thread pTDThread = new Thread(panelDown);
		pTDThread.start();
		Thread PSThread = new Thread(panelSide);
		PSThread.start();
		Thread iThread = new Thread(input);
		iThread.start();
		
		
	}
	
}
