package net.egartley.tsp;

import java.util.ArrayList;

public class Main {
	
	// private static String path;
	private static double totalDistance = 0;
	private static Point currentPoint;
	private static ArrayList<Integer> used = new ArrayList<Integer>();
	private static int n = 512;
	private static int g = n * 2;

	public static void out(String s) {
		System.out.println(s);
	}

	private static int rand(int max) {
		int r = 1 + (int) ((max) * java.lang.Math.random());
		if (used.contains(r))
			return rand(max);
		else
			used.add(r);
		return r;
	}

	private static void appendPointToPath(Point p) {
		// path += p.id + ", ";
	}

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		out("Generating " + n + " random points on " + g + "x" + g + " graph");
		for (int i = 0; i < n; i++) {
			Point.addPoint(rand(g), rand(g), "P" + i, false);
		}
		for (int i = 0; i < n; i++) {
			Point p = Point.list.get(i);
			ArrayList<Point> otherPoints = new ArrayList<Point>();
			for (int ii = 0; ii < n - 1; ii++) {
				if (ii != i)
					otherPoints.add(Point.list.get(ii));
			}
			for (int iii = 0; iii < otherPoints.size(); iii++) {
				Segment.list.add(new Segment(p, otherPoints.get(iii)));
			}
		}
		out("Generated " + n + " points and " + Segment.list.size() + " segments");
		used.clear();
		out("\nWorking...");
		Point.list.get(rand(n - 1)).isOrigin = true;
		Point originCity = Point.getOriginCity();
		if (originCity == null) {
			out("\"Origin\" city is null! Cannot continue!");
			return;
		}
		appendPointToPath(originCity);
		currentPoint = originCity;
		Segment shortestSegment = Segment.getShortestConnectedSegment(originCity);
		totalDistance += shortestSegment.distance;
		Point otherPoint = Point.getOtherPointOnSegment(shortestSegment, originCity);
		Segment.getSegmentByPoints(currentPoint, otherPoint).passed = true;
		checkPoint(otherPoint);
		
		// path += originCity.id;
		double finish = System.currentTimeMillis() - start;
		done(finish);
	}

	private static void done(double time) {
		out("\nTotal distance: " + totalDistance + " km");
		double c = time * 1000000000;
		out("Total time taken: " + c + " seconds");
		// out("Path taken: " + path);
	}

	/*@SuppressWarnings("unused")
	private static String passover(Segment s, Point p) {
		return "Passed over point " + p.id + "\nPassed over segment " + s.id;
	}*/

	private static void distanceAdd(Segment s) {
		totalDistance += s.distance;
		// out("Added distance of segment " + s.id + " (" + s.distance + ") to the total distance (" + totalDistance + ")");
	}

	private static void travel(Segment s, Point p) {
		distanceAdd(s);
		appendPointToPath(p);
		// out(passover(s, p));
		Point.getPointByID(p.id).passed = true;
		Segment.getSegmentByID(s.id).passed = true;
	}

	private static void checkPoint(Point p) {
		currentPoint = p;
		// out("\nCurrent point is now " + current.id);
		if (currentPoint.passed || currentPoint.isOrigin) {
			out("Point " + currentPoint.id + " is passed or the origin city! Fatal!");
			return;
		}
		ArrayList<Segment> connectedSegments = Segment.getSegmentsByPoint(currentPoint);
		ArrayList<Segment> passedSegments = new ArrayList<Segment>();
		ArrayList<Segment> notPassedSegments = new ArrayList<Segment>();
		for (int i = 0; i < connectedSegments.size(); i++) {
			Segment s = connectedSegments.get(i);
			if (s.passed) {
				passedSegments.add(s);
			} else if (Point.getOtherPointOnSegment(s, currentPoint).passed
					|| Point.getOtherPointOnSegment(s, currentPoint).isOrigin) {
				passedSegments.add(s);
			} else {
				notPassedSegments.add(s);
			}
		}
		if (passedSegments.size() == connectedSegments.size()) {
			travel(Segment.getSegmentByPoints(Point.getOriginCity(), currentPoint), currentPoint);
			return;
		}
		Segment shortest = Segment.getShortest(notPassedSegments);
		travel(shortest, currentPoint);
		checkPoint(Point.getOtherPointOnSegment(shortest, currentPoint));
	}
}