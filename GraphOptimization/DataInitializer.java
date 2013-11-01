package GraphOptimization;

import java.io.*;
import java.util.*;

public final class DataInitializer {

	private class Point
	{
		private int id;
		private double x;
		private double y;
		
		public Point() {
			super();
		}
		
		public Point(final int id, final double x, final double y) {
			this.id = id;
			this.x = x;
			this.y = y;
		}

		public double getX() {
			return x;
		}

		@SuppressWarnings("unused")
		public void setX(final double x) {
			this.x = x;
		}

		public double getY() {
			return y;
		}

		@SuppressWarnings("unused")
		public void setY(final double y) {
			this.y = y;
		}
		
	}
	
	private double [][]distances = null;
	
	public DataInitializer(String path) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(path));		
		List<Point> points = new ArrayList<Point>();
		String line = "";			
		while((line = reader.readLine()) != null) {
			String[] items = line.split(" ");
			Point p = new Point(
					Integer.parseInt(items[0]),
					Double.parseDouble(items[1]), 
					Double.parseDouble(items[2])
					);
			points.add(p);
		}		
		reader.close();
		distances = makeDistanceMatrix(points);
	}
		
	private double[][] makeDistanceMatrix(List<Point> list) {		
		int size = list.size();
		double[][] matrix = new double[size][size];		
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				if (i != j  ) {
					matrix[i][j] = Distance(list.get(i), list.get(j));
				}
			}
		}
		return matrix;
	}
	
	private double Distance(Point p1, Point p2) {
		return Math.sqrt(
				(p1.getX()-p2.getX()) * (p1.getX()-p2.getX()) +
				(p1.getY()-p2.getY()) * (p1.getY()-p2.getY())
				);
	}
	
	double[][] getDistances() {
		return distances;
	}
	
}
