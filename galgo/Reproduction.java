package GeneticItems;

public class Reproduction implements GeneticOperator {

	private FitnessFunction func = null;
	private int minStall = 20;
	private int maxStall = 50;
	
	public int getMinStall() {
		return minStall;
	}

	public void setMinStall(int minStall) {
		this.minStall = minStall;
	}

	public int getMaxStall() {
		return maxStall;
	}

	public void setMaxStall(int maxStall) {
		this.maxStall = maxStall;
	}

	public Reproduction() {}
	
	public Reproduction(FitnessFunction func, int minStall, int maxStall) {
		super();
		this.func = func;
		this.minStall = minStall;
		this.maxStall = maxStall;
	}
	
	private void doReproduction(Population p) {
		
		if (p.getSize() < minStall)
			return;
		
		double avg = p.avgValue(func);			
		
		for(int i = 0; i < p.getSize(); i++) {
			RealChromosome chrome = p.getChromosome(i);			
			if (func.function(chrome) > avg) {
				p.remove(i);
			}
		}
		
		while (p.getSize() > maxStall) {
			int imax = p.maxIndex(func);
			p.remove(imax);
		}
		
	}
	
	@Override
	public void operate(Population p) {
		doReproduction(p);		
	}
	
}
