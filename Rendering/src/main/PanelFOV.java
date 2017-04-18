package main;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.text.DecimalFormat;

import javax.swing.JPanel;

public class PanelFOV extends JPanel implements Runnable{

	public PanelFOV(){}
	DecimalFormat df  = new DecimalFormat("0.00");
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
		Graphics2D g2 = (Graphics2D) g;
		g.clearRect(0, 0, getWidth(), getHeight());	
		for(int i = 0; i < Main.renderer.renderedPolygons.size();i++){
			Polygon p = Main.renderer.renderedPolygons.get(i).getPoly(getWidth(), getHeight());
			for(int j = 0; j < p.npoints;j++){
				g2.drawRect(p.xpoints[j], p.ypoints[j], 5, 5);
			}
			g2.fillPolygon(Main.renderer.renderedPolygons.get(i).getPoly(getWidth(), getHeight()));
		}
	}
}
