package GeneticItems;

public class GenerictGene {

	private double genValue;
	
	public double getGenValue() {
		return genValue;
	}

	public void setGenValue(double genValue) {
		this.genValue = genValue;
	}

	public GenerictGene() {
		super();
	}

	public GenerictGene(double genValue) {
		this.genValue = genValue;
	}

	@Override
	public String toString() {		
		return "[" + String.format("%1$+1.7f", genValue)
				+ "]";
	}
	
}
