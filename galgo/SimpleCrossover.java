package GeneticItems;

import java.util.*;

public class SimpleCrossover implements GeneticOperator {

	private double probability;

	public SimpleCrossover() {
		super();
		probability = 0.5;
	}

	public SimpleCrossover(double probability) {
		super();
		this.probability = probability;
	}

	public double getProbability() {
		return probability;
	}

	public void setProbability(double probability) {
		this.probability = probability;
	}

	private void doSimpleCrossover(Population p) {
		
		Random rnd = new Random();
		int chromeLentgh = p.getChromosomeLength();
		
		List<RealChromosome> buffer = new ArrayList<RealChromosome>(); 
		
		for(int i = 0; i < p.getSize()/2; i++) {
			
			int crossPoint = rnd.nextInt(chromeLentgh);
			
			RealChromosome parent1 = p.getChromosome(rnd.nextInt(p.getSize()));			
			RealChromosome parent2 = null;
			
			do {
				parent2 = p.getChromosome(rnd.nextInt(p.getSize()));
			} while (parent1.equals(parent2));
			
			RealChromosome child1 = new RealChromosome();
			RealChromosome child2 = new RealChromosome();
						
			for(int j = 0; j < crossPoint; j++) {
				child1.addGene(new DoubleGene(parent1.getGeneAt(j).getGenValue()));
				child2.addGene(new DoubleGene(parent2.getGeneAt(j).getGenValue()));
			}
			
			for(int j = crossPoint; j < chromeLentgh; j++) {
				child1.addGene(new DoubleGene(parent2.getGeneAt(j).getGenValue()));
				child2.addGene(new DoubleGene(parent1.getGeneAt(j).getGenValue()));
			}
			
			buffer.add(child1);
			buffer.add(child2);
		}		
		
		p.addChromosome(buffer);
	}
	
	@Override
	public void operate(Population p) {
		doSimpleCrossover(p);		
	}
	
}
