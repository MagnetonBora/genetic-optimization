package GeneticItems;

public class GeneticInfoFormatter {
	
	private Population population;
	private FitnessFunction func;
	
	public GeneticInfoFormatter() {
		super();
	}

	public GeneticInfoFormatter(Population population, FitnessFunction func) {
		super();
		this.population = population;
		this.func = func;
	}

	@Override
	public String toString() {		
		String str = "";
		for(int i = 0; i < population.getSize(); i++) {
			double f = func.function(population.getChromosome(i));
			str += population.getChromosome(i).toString() + " f = " + f + "\r\n";
		}
		return str;
	}		
	
}
