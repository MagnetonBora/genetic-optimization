package GeneticItems;

import java.util.*;

public class BoundaryConfigurator extends SuperConfigurator {

	private List<Double> leftBounds = new ArrayList<Double>();
	private List<Double> rightBounds = new ArrayList<Double>();
	
	public void addToLesftBounds(double val) {
		leftBounds.add(val);
	}
	
	public double getLeftBound(int i) {
		return leftBounds.get(i);
	}
	
	public void addToRightBounds(double val) {
		rightBounds.add(val);
	}

	public double getRightBound(int i) {
		return rightBounds.get(i);
	}
	
	public BoundaryConfigurator() {
		super();
	}

	public BoundaryConfigurator(double precision, int lowRange, int upRange,
			List<Double> leftBounds, List<Double> rightBounds) {
		super(precision, lowRange, upRange);
		this.leftBounds = leftBounds;
		this.rightBounds = rightBounds;
	}

}
