package GeneticItems;

import java.util.*;

public class ArithmeticalCrossover implements GeneticOperator {

	private double probability;
	private double weight;
	
	public ArithmeticalCrossover() {
		super();
		probability = 0.5;
		weight = 0.5;
	}

	public ArithmeticalCrossover(double probability, double weight) {
		super();
		this.probability = probability;
		this.weight = weight;
	}

	public double getProbability() {
		return probability;
	}

	public void setProbability(double probability) {
		this.probability = probability;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	private void doArithmeticalCrossover(Population p) {
		
		Random rnd = new Random();
		
		int populationSize = p.getSize();		
		int chromeLentgh = p.getChromosomeLength();		
		double val = 0.0;
		List<RealChromosome> list = new ArrayList<RealChromosome>();
		
		for(int i = 0; i < p.getSize(); i++) {
			
			RealChromosome parent1 = p.getChromosome(rnd.nextInt(populationSize));
			RealChromosome parent2 = null;		
					
			do {
				parent2 = p.getChromosome(rnd.nextInt(populationSize));
			} while(parent1.equals(parent2));
			
			RealChromosome child1 = new RealChromosome();
			RealChromosome child2 = new RealChromosome();
			
			for(int j = 0; j < chromeLentgh; j++) {
				val = weight * parent1.getGeneAt(j).getGenValue() +
						(1 - weight) * parent2.getGeneAt(j).getGenValue();
				child1.addGene(new DoubleGene(val));
				val = weight * parent2.getGeneAt(j).getGenValue() +
						(1 - weight) * parent2.getGeneAt(j).getGenValue(); 
				child2.addGene(new DoubleGene(val));
			}
			
			list.add(child1);
			list.add(child2);

		}
		
		p.addChromosome(list);
		
	}
	
	@Override
	public void operate(Population p) {
		doArithmeticalCrossover(p);		
	}

}
