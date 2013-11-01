package GraphOptimization;

import galgo.IntGene;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Crossover implements GeneticOperator {

	private double probability;

	public Crossover() {
		super();
		probability = 0.5;
	}

	public Crossover(double probability) {
		super();
		this.probability = probability;
	}

	public double getProbability() {
		return probability;
	}

	public void setProbability(double probability) {
		this.probability = probability;
	}	
	
	private void doCrossover(Population p) {
		
		Random rnd = new Random();
		int chromeLentgh = p.getChromosomeLength();
		
		List<IntChromosome> buffer = new ArrayList<IntChromosome>(); 
		
		for(int i = 0; i < p.getSize()/2; i++) {
			
			int crossPoint = rnd.nextInt(chromeLentgh);
			
			IntChromosome parent1 = p.getChromosome(rnd.nextInt(p.getSize()));			
			IntChromosome parent2 = null;
			
			do {
				parent2 = p.getChromosome(rnd.nextInt(p.getSize()));
			} while (parent1.equals(parent2));
			
			IntChromosome child1 = new IntChromosome();
			IntChromosome child2 = new IntChromosome();
						
			for(int j = 0; j < crossPoint; j++) {
				child1.addGene(new IntGene(parent1.getGeneAt(j).getGenValue()));
				child2.addGene(new IntGene(parent2.getGeneAt(j).getGenValue()));
			}
			
			for(int j = crossPoint; j < chromeLentgh; j++) {
				child1.addGene(new IntGene(parent2.getGeneAt(j).getGenValue()));
				child2.addGene(new IntGene(parent1.getGeneAt(j).getGenValue()));
			}
			
			buffer.add(child1);
			buffer.add(child2);
		}		
		
		p.addChromosome(buffer);
	}
	
	@Override
	public void operate(Population p) {
		doCrossover(p);
	}

}
