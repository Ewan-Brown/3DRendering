package shapes;

import java.awt.Color;
import java.awt.Polygon;
import java.awt.geom.Point2D;
import java.util.ArrayList;

public class Polygon2D {

	public ArrayList<Point2D> points = new ArrayList<Point2D>();
	
	public Polygon getPoly(int w, int h){
		Polygon p1 = new Polygon();
		for(int j = 0; j < points.size();j++){
			Point2D p = points.get(j);
			double yP = p.getX();
			double x = w / 2;
			x -= yP * (w / 2);
			double zP  = p.getY();
			double y = h / 2;
			y -= zP * (h / 2);
			p1.addPoint((int)(w - x), (int)(h - y));
		}
		return p1;
	}
	
}
