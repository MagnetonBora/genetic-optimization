package GeneticItems;

public abstract class SuperConfigurator {

	private double precision;	
	private double mutationProbability;
	private double crossoverProbability;
	
	public double getPrecision() {
		return precision;
	}

	public void setPrecision(double precision) {
		this.precision = precision;
	}

	public double getMutationProbability() {
		return mutationProbability;
	}

	public void setMutationProbability(double mutationProbability) {
		this.mutationProbability = mutationProbability;
	}

	public double getCrossoverProbability() {
		return crossoverProbability;
	}

	public void setCrossoverProbability(double crossoverProbability) {
		this.crossoverProbability = crossoverProbability;
	}

	public int getUpRange() {
		return upRange;
	}

	public void setUpRange(int upRange) {
		this.upRange = upRange;
	}

	public int getLowRange() {
		return lowRange;
	}

	public void setLowRange(int lowRange) {
		this.lowRange = lowRange;
	}

	private int upRange;
	private int lowRange;
	
	public SuperConfigurator() {}

	public SuperConfigurator(double precision, int lowRange, int upRange) {
		super();
		this.precision = precision;
		this.lowRange = lowRange;
		this.upRange = upRange;
	}
		
}
