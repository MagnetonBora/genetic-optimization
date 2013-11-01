package galgo2;

public class RealGene extends AbstractGene {

	private double val;
	
	public double getVal() {
		return val;
	}

	public void setVal(double val) {
		this.val = val;
	}

	public RealGene(double val) {
		super();
		this.val = val;
	}

	public RealGene() {
		super();
	}

	@Override
	public boolean equals(Object obj) {
		RealGene gene = (RealGene)obj;
		if (val == gene.getVal())
			return true;
		else
			return false;
	}

	@Override
	public String toString() {
		return Double.toString(val);
	}
	
}
