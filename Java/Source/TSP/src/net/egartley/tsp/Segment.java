package net.egartley.tsp;

import java.util.ArrayList;

public class Segment {
	
	static ArrayList<Segment> list = new ArrayList<Segment>();
	Point point1, point2;
	double distance;
	String id;
	boolean passed;

	public Segment(Point point1, Point point2) {
		this.point1 = point1;
		this.point2 = point2;
		this.id = point1.id + "_" + point2.id;
		calculateDistance();
		list.add(this);
	}

	private void calculateDistance() {
		double x2 = Math.abs(point1.x - point2.x);
		double y2 = Math.abs(point1.y - point2.y);
		distance = Math.sqrt((x2 * x2) + (y2 * y2));
	}

	boolean contains(Point p) {
		if (this.point1 == p || this.point2 == p)
			return true;
		else
			return false;
	}

	public static ArrayList<Segment> getSegmentsByPoint(Point p) {
		if (list.isEmpty())
			return null;
		ArrayList<Segment> segs = new ArrayList<Segment>();
		for (int i = 0; i < list.size(); i++) {
			Segment s = list.get(i);
			if (s.contains(p))
				segs.add(s);
		}
		if (!segs.isEmpty())
			return segs;
		else
			return null;
	}

	public static Segment getSegmentByPoints(Point p1, Point p2) {
		if (list.isEmpty())
			return null;
		for (int i = 0; i < list.size(); i++) {
			Segment s = list.get(i);
			if (s.contains(p1) && s.contains(p2))
				return s;
		}
		return null;
	}

	public static Segment getSegmentByID(String id) {
		if (list.isEmpty())
			return null;
		for (int i = 0; i < list.size(); i++) {
			Segment s = list.get(i);
			if (s.id == id)
				return s;
		}
		return null;
	}

	public static Segment getShortest(ArrayList<Segment> segs) {
		if (segs.isEmpty())
			return null;
		Segment smallest = segs.get(0);
		for (int i = 0; i < segs.size(); i++) {
			if (segs.get(i).distance < smallest.distance)
				smallest = segs.get(i);
		}
		return getSegmentByID(smallest.id);
	}

	public static Segment getShortestConnectedSegment(Point p) {
		return getShortest(getSegmentsByPoint(p));
	}
}