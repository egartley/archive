package net.egartley.tsp;

import java.util.ArrayList;

public class Point {
	
	static ArrayList<Point> list = new ArrayList<Point>();
	int x, y;
	String id;
	boolean isOrigin, passed = false;
	
	public static void addPoint(int x, int y, String id, boolean isOrigin) {
		Point p = new Point();
		p.x = x;
		p.y = y;
		p.id = id;
		p.isOrigin = isOrigin;
		list.add(p);
	}

	public static Point getPointByID(String id) {
		if (list.isEmpty())
			return null;
		for (int i = 0; i < list.size(); i++) {
			Point p = list.get(i);
			if (id.equalsIgnoreCase(p.id))
				return p;
		}
		return null;
	}

	public static Point getOriginCity() {
		if (list.isEmpty())
			return null;
		for (int i = 0; i < list.size(); i++) {
			Point p = list.get(i);
			if (p.isOrigin)
				return p;
		}
		return null;
	}

	public static Point getOtherPointOnSegment(Segment s, Point p) {
		if (s.point1 == p)
			return s.point2;
		else if (s.point2 == p)
			return s.point1;
		else
			return null;
	}
}