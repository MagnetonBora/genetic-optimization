package GeneticItems;

import java.util.Random;

public class FlatCrossover implements GeneticOperator {

	private double probability;
	private double minValue;
	private double maxValue;

	public FlatCrossover() {
		super();
		probability = 0.5;
		minValue = Double.MIN_VALUE;
		maxValue = Double.MAX_VALUE;
	}

	public FlatCrossover(double probability, double minValue, double maxValue) {
		super();
		this.probability = probability;
		this.minValue = minValue;
		this.maxValue = maxValue;
	}

	public double getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(double maxValue) {
		this.maxValue = maxValue;
	}

	public double getMinValue() {
		return minValue;
	}

	public void setMinValue(double minValue) {
		this.minValue = minValue;
	}	
	
	public double getProbability() {
		return probability;
	}

	public void setProbability(double probability) {
		this.probability = probability;
	}

	private void doFlatCrossover(Population p) {		
		Random rnd = new Random();
		int size = p.getChromosomeLength(); 		
		RealChromosome chrome = new RealChromosome();		
		for(int i = 0; i < size; i++) {
			double val = minValue + (maxValue - minValue) * rnd.nextDouble();
			chrome.addGene(new DoubleGene(val));
		}		
		p.addChromosome(chrome);		
	}
	
	@Override
	public void operate(Population p) {
		doFlatCrossover(p);
	}	
	
}
