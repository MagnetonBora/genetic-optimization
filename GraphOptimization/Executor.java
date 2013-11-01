package GraphOptimization;

import galgo.GeometryCrossover;
import galgo.Reproduction;
import galgo.SuperConfigurator;

public class Executor {

	private FitnessFunction func = null;
	private SuperConfigurator conf = null;
	
	public Executor() {
		super();
	}

	public FitnessFunction getFunc() {
		return func;
	}

	public void setFunc(FitnessFunction func) {
		this.func = func;
	}

	public SuperConfigurator getConf() {
		return conf;
	}

	public void setConf(SuperConfigurator conf) {
		this.conf = conf;
	}

	public Executor(FitnessFunction func, SuperConfigurator conf) {
		super();
		this.func = func;
		this.conf = conf;
	}

	public void search(Population population) {		
		Population p = population;

		//Reproduction reproduction = new Reproduction(func, conf.getLowRange(), conf.getUpRange());
		
		Mutation mutation = new Mutation(conf.getMutationProbability());
		GeneticOperator crossover = new Crossover(conf.getCrossoverProbability()); 		
		
		//GeneticInfoFormatter formatter = new GeneticInfoFormatter(population, func);
		
		System.out.println("\nStart population");
		
		//System.out.println(formatter.toString());		
		
		int i = 0;
		double curMin = population.minValue(func);
		double prevMin = Double.MIN_VALUE;
		double precision = conf.getPrecision();		
		while ( Math.abs(prevMin - curMin) >= precision )  {
			System.out.println("Step #" + (i+1));
			crossover.operate(p);
			mutation.operate(p);
			//reproduction.operate(p);
			//System.out.print(formatter.toString());
			System.out.println("End of step #" + (i+1) + "\n");
			prevMin = curMin;
			curMin = population.minValue(func);
			i++;
		}
		System.out.println("The best fitness function value: " + curMin + "\r\n");		
	}
	
}
