package galgo2;

public class BitGene extends AbstractGene {
	
	private int val;
	
	public BitGene(int val) {
		super();
		this.val = val;
	}

	public BitGene() {
		super();
	}

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		if (val != 0 && val != 1) {
			throw new 
			IllegalArgumentException("The value must be 1 or 0");
		}
		this.val = val;
	}

	@Override
	public boolean equals(Object obj) {
		BitGene gene = (BitGene)obj;
		if (val == gene.getVal())
			return true;
		else
			return false;
	}

	@Override
	public String toString() {
		return Integer.toString(val);
	}

}