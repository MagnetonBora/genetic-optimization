package GeneticItems;

public class DoubleGene {

	private double genValue;
	
	public double getGenValue() {
		return genValue;
	}

	public void setGenValue(double genValue) {
		this.genValue = genValue;
	}

	public DoubleGene() {
		super();
	}

	public DoubleGene(double genValue) {
		this.genValue = genValue;
	}

	@Override
	public String toString() {		
		return "[" + String.format("%1$+1.7f", genValue)
				+ "]";
	}

}
