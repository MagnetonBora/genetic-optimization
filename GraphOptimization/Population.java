package GraphOptimization;

import java.util.ArrayList;
import java.util.List;

public class Population {
	
	private List<IntChromosome> population = new ArrayList<IntChromosome>();
	
	public void remove(int pos) {
		population.remove(pos);
	}
	
	public int getChromosomeLength() {
		return population.get(0).Length();
	}
	
	public double avgValue(FitnessFunction func) {
		double sum = 0;		
		for(int i = 0; i < population.size(); i++) {
			IntChromosome chrome = population.get(i);
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
	
	public void addChromosome(List<IntChromosome> chromosomes) {
		
		for(int i = 0; i < chromosomes.size(); i++) {
			population.add(chromosomes.get(i));
		}
			
	}
	
	public void addChromosome(IntChromosome chrome) {
		population.add(chrome);
	}
	
	public IntChromosome getChromosome(int pos) {
		return population.get(pos);
	}
	
	public int getSize() {
		return population.size();
	}
	
	public Population(int size) {
		super();
		initPopulation(size);
	}
	
	public Population() {
		super();
				
	}
	
	public Population(List<IntChromosome> population) {
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
	
	private void initPopulation(int size) {

		// TO DO
	}

}
