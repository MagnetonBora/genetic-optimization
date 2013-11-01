package GeneticItems;

import java.util.*;

public class Controller {

	private static final double A = 20.0;
	private static final double B = 0.2;
	private static final double C = 2 * Math.PI;
	
	private static double precision = 0.0001;
	private static int dimensions = 2;
	private static List<Double> leftBounds = new ArrayList<Double>();
	private static List<Double> rightBounds = new ArrayList<Double>(); 
	private static int minStall = 30;
	private static int maxStall = 100;
	private static int actualCount = 40;
	
	private static void initParams() throws IllegalArgumentException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("");
		System.out.print("Dimensions: ");
		dimensions = scanner.nextInt();
		if (dimensions <= 0) {
			throw new IllegalArgumentException("Number of dimensions must be positive value");
		}
		for(int i = 0; i < dimensions; i++) {
			System.out.print("Left bound of dimension #" + (i+1) + ": ");
			leftBounds.add(scanner.nextDouble());
			System.out.print("Right bound of dimension #" + (i+1) + ": ");
			rightBounds.add(scanner.nextDouble());
			if (leftBounds.get(i) > rightBounds.get(i)) {
				throw new IllegalArgumentException("Left bound must be less than right");
			}
		}
		System.out.print("Precision: ");
		precision = scanner.nextDouble();
		if (dimensions <= 0) {
			throw new IllegalArgumentException("Precision must be positive value");
		}
		System.out.print("Min stall of population: ");
		minStall = scanner.nextInt();
		System.out.print("Max stall of population: ");
		maxStall = scanner.nextInt();
		if (minStall > maxStall) {
			throw new IllegalArgumentException("minStall must be less than maxStall");
		}
		System.out.print("Actual size of population: ");
		actualCount = scanner.nextInt();
		if (dimensions <= 0) {
			throw new IllegalArgumentException("Size of population must be positive value");
		}
	}
	
	public static void main(String[] args) {				
				
		try
		{
			initParams();
			Population p = new Population(actualCount, leftBounds, rightBounds);								
			Executor exec = new Executor(new AckleyFunction(A, B, C),
					new BoundaryConfigurator(precision, minStall, maxStall, leftBounds, rightBounds));		
			exec.search(p);
		}
		catch(IllegalArgumentException ex) {
			System.out.println("An exception has occured. Details are below.");
			System.out.println(ex.getMessage());
		}
	
	}

}
