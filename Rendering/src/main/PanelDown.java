package main;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import shapes.Point3D;
import shapes.Polygon3D;

public class PanelDown extends JPanel implements Runnable{

	public PanelDown(){}

	public void run() {
		while(true){
			repaint();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public void paint(Graphics g){
		super.paint(g);
		double w = getWidth();
		double h = getHeight();
		g.setColor(Color.RED);
		double x = Main.renderer.povX * 10;
		double y = Main.renderer.povY * 10;
		g.fillRect((int)(x),(int)(y), 5, 5);

		double turnx = Math.cos(Math.toRadians(Main.renderer.povAngleXY)); 
		double turny = Math.sin(Math.toRadians(Main.renderer.povAngleXY));
		int s = 10 *15;
		turnx *= s;
		turny *= s;
		for(int i = 0; i < Main.renderer.rawPolygons.size();i++){
			Polygon3D p3 = Main.renderer.rawPolygons.get(i);
			for(int j = 0 ; j < p3.sides.size();j++){
				for(int k = 0; k < p3.sides.get(j).points.size();k++){
					Point3D p = p3.sides.get(j).points.get(k);
					g.fillRect((int)(p.x * 10),(int)(p.y * 10), 5, 5);
					g.drawLine((int)(x),(int)(y), (int)(turnx+x), (int)(turny+y));

				}
			}
		}	}
}
