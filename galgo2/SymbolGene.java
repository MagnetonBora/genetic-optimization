package galgo2;

public class SymbolGene extends AbstractGene {
	
	private char val;

	public SymbolGene() {
		super();
	}

	public SymbolGene(char val) {
		super();
		this.val = val;
	}

	public char getVal() {
		return val;
	}

	public void setVal(char val) {
		this.val = val;
	}

	@Override
	public boolean equals(Object obj) {
		SymbolGene gene = (SymbolGene)obj;
		if (val == gene.getVal())
			return true;
		else
			return false;
	}

	@Override
	public String toString() {
		return Character.toString(val);
	}

}
