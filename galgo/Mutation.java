package GeneticItems;

import java.util.Random;

public class Mutation implements GeneticOperator {
	
	private double probability;
	private double minValue;
	private double maxValue;
		
	public Mutation(double probability, double minValue, double maxValue) {
		super();
		this.probability = probability;
		this.minValue = minValue;
		this.maxValue = maxValue;
	}

	public double getMinValue() {
		return minValue;
	}

	public void setMinValue(double minValue) {
		this.minValue = minValue;
	}

	public Mutation() {
		super();
		probability = 0.5;
		maxValue = Double.MAX_VALUE;
		minValue = Double.MIN_VALUE;
	}

	public double getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(double maxValue) {
		this.maxValue = maxValue;
	}

	private void doMutation(Population p) {
		
		Random rnd = new Random();
		int popSize = p.getSize();
		
		for(int i = 0; i < popSize; i++) {
			RealChromosome chrome = p.getChromosome(i);
			double val = rnd.nextDouble();
			if (val <= probability) {
				int genePosition = rnd.nextInt(chrome.Length());
				val = minValue + (maxValue - minValue) * rnd.nextDouble();
				chrome.setGeneAt(genePosition, new DoubleGene(val));
			}
		}
		
	}
	
	@Override
	public void operate(Population p) {
		doMutation(p);
	}

	public double getProbability() {
		return probability;
	}

	public void setProbability(double probability) {
		this.probability = probability;
	}

}
