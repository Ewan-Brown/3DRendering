package main;

import java.awt.geom.Point2D;
import java.util.ArrayList;

import shapes.Point3D;
import shapes.Polygon2D;
import shapes.Polygon3D;
import shapes.Side;

public class Renderer implements Runnable{

	double povX = 10;
	double povY = 10;
	double povZ = 10;
	double povAngleXY = 0;
	double povAngleZX = 0;
	double FOV = 45;
	static double angle1 = 0;
	static double angle2 = 0;
	static double fovAngle = 0;
//	public double targetX = 15;
//	public double targetY = 15;
//	public double targetZ = 15;
//	double lastRenderXY = 0;
//	double lastRenderXZ = 0;
//	double lastDist = 0;
//	double targetSize = 5;
	public ArrayList<Polygon3D> rawPolygons = new ArrayList<Polygon3D>();
	public ArrayList<Polygon2D> renderedPolygons = new ArrayList<Polygon2D>();
	public Renderer(){
		ArrayList<Side> s = new ArrayList<Side>();
		ArrayList<Point3D> baseSide = new ArrayList<Point3D>();
		baseSide.add(new Point3D(10,10,10));
//		baseSide.add(new Point3D(15,10,10));
//		baseSide.add(new Point3D(15,5,10));
//		baseSide.add(new Point3D(10,5,10));
		ArrayList<Point3D> topSide = new ArrayList<Point3D>(baseSide);
		for(int i = 0; i < topSide.size();i++){
			topSide.get(i).x += 2;
			topSide.get(i).z += 2;
		}
		s.add(new Side(baseSide));
		s.add(new Side(topSide));
		rawPolygons.add(new Polygon3D(s));
	}
	public Point2D renderTarget(Point3D p){
		double targetX = p.x;
		double targetY = p.y;
		double targetZ = p.z;
		double angleXYToTarget1 = Math.toDegrees(Math.atan2(targetY - povY, targetX - povX));
		double s = Math.signum(angleXYToTarget1) * Math.signum(povAngleXY);
		if(s == -1){
			System.out.println("HEY");
		}
		double angleXYToTarget2 = angleXYToTarget1 - povAngleXY;
		double yP = angleXYToTarget2/FOV;
		double angleXZToTarget = Math.toDegrees(Math.atan2(targetZ - povZ, targetX - povX)) - povAngleZX;
		double zP = angleXZToTarget/FOV;
		angle1 = angleXYToTarget1;
		angle2 = angleXYToTarget2;
		fovAngle = povAngleXY;
		return new Point2D.Double(yP,zP);
	}
	public void renderTargets(){
		renderedPolygons.clear();
		for(int i = 0; i < rawPolygons.size();i++){
			Polygon3D poly = rawPolygons.get(i);
			for(int j = 0; j < poly.sides.size();j++){
				Side s = poly.sides.get(j);
				Polygon2D newP = new Polygon2D();
				for(int k = 0; k < s.points.size();k++){
					Point3D point = s.points.get(k);
					newP.points.add(renderTarget(point));
				}
				renderedPolygons.add(newP);
			}
		}
	}
	public static double getDistance( double x1,  double y1,  double x2,  double y2) {
		return Math.sqrt(((x1 - x2) * (x1 - x2)) + ((y1 - y2) * (y1 - y2)));
	}
	@Override
	public void run() {
		while(true){
			renderTargets();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	
}
