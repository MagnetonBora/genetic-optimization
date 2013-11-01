package GraphOptimization;

import java.util.Random;

public class Mutation implements GeneticOperator {

	private double probability;
		
	public Mutation(double probability) {
		super();
		this.probability = probability;
	}

	public Mutation() {
		super();
		probability = 0.5;
	}

	private void doMutation(Population p) {
				
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
