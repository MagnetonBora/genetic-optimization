package GeneticItems;

public class AckleyFunction implements FitnessFunction {

	private double a;
	private double b;
	private double c;
			
	public double getA() {
		return a;
	}

	public void setA(double a) {
		this.a = a;
	}

	public double getB() {
		return b;
	}

	public void setB(double b) {
		this.b = b;
	}

	public double getC() {
		return c;
	}

	public void setC(double c) {
		this.c = c;
	}

	public AckleyFunction(double a, double b, double c) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
	}	
	
	public AckleyFunction() {
		super();
		a = 0;
		b = 0;
		c = 0;
	}

	@Override
	public double function(RealChromosome chrome) throws IllegalArgumentException {
		double u = 0;
		double v = 0;
		int n = chrome.Length();
		for(int i = 0; i < n; i++) {
			u += Math.pow(chrome.getGeneAt(i).getGenValue(), 2.0);
			v += Math.cos(c * chrome.getGeneAt(i).getGenValue());
		}							
		return -a * Math.exp(-b * Math.sqrt(u/n)) 
				- Math.exp(v/n) + a + Math.E;		
	}

}
