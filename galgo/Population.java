package GeneticItems;

import java.util.*;

public class Population {

	private List<RealChromosome> population = new ArrayList<RealChromosome>();
	
	public void remove(int pos) {
		population.remove(pos);
	}
	
	public int getChromosomeLength() {
		return population.get(0).Length();
	}
	
	public double avgValue(FitnessFunction func) {
		double sum = 0;		
		for(int i = 0; i < population.size(); i++) {
			RealChromosome chrome = population.get(i);
			sum += func.function(chrome);
		}		
		return sum;
	}

	public double maxValue(FitnessFunction func) {		
		double max = func.function(population.get(0));		
		for(int i = 0; i < population.size(); i++) {			
			double val = func.function(population.get(i));
			if (val >= max) {
				max = val;
			}			
		}		
		return max;		
	}	
	
	public double minValue(FitnessFunction func) {		
		double min = func.function(population.get(0));		
		for(int i = 0; i < population.size(); i++) {			
			double val = func.function(population.get(i));
			if (val <= min) {
				min = val;
			}			
		}		
		return min;		
	}

	public int maxIndex(FitnessFunction func) {
		int imax = 0;
		double max = func.function(population.get(imax));		
		for(int i = 0; i < population.size(); i++) {			
			double val = func.function(population.get(i));
			if (val >= max) {
				max = val;
				imax = i;
			}			
		}		
		return imax;
	}

	public int minIndex(FitnessFunction func) {
		int imin = 0;
		double min = func.function(population.get(imin));		
		for(int i = 0; i < population.size(); i++) {			
			double val = func.function(population.get(i));
			if (val <= min) {
				min = val;
				imin = i;
			}			
		}		
		return imin;
	}	
	
	public void addChromosome(List<RealChromosome> chromosomes) {
		
		for(int i = 0; i < chromosomes.size(); i++) {
			population.add(chromosomes.get(i));
		}
			
	}
	
	public void addChromosome(RealChromosome chrome) {
		population.add(chrome);
	}
	
	public RealChromosome getChromosome(int pos) {
		return population.get(pos);
	}
	
	public int getSize() {
		return population.size();
	}
	
	public Population(int size, List<Double> leftBounds, List<Double> rightBounds) 
			throws IllegalArgumentException {
		super();
		initPopulation(size, leftBounds, rightBounds);
	}
	
	public Population() {
		super();
				
	}
	
	public Population(List<RealChromosome> population) {
		this.population = population;
	}
	
	@Override
	public String toString() {
		String str = "";
		for(int i = 0; i < population.size(); i++) {
			str += population.get(i) + "\r\n";
		}
		return str;
	}
	
	private void initPopulation(int size, List<Double> leftBounds,
			List<Double> rightBounds) throws IllegalArgumentException {
			
		if (leftBounds.size() != rightBounds.size())
			throw new IllegalArgumentException("Illegal size of bounds");

		Random rnd = new Random();
		double val = 0;		
		
		for(int i = 0; i < size; i++) {
			RealChromosome chrome = new RealChromosome();
			for(int j = 0; j < leftBounds.size(); j++) {
				val = leftBounds.get(j) + 
						(rightBounds.get(j) - leftBounds.get(j)) * rnd.nextDouble();
				chrome.addGene(new DoubleGene(val));
			}
			population.add(chrome);
		}
		
	}
	
}
