package galgo;

public class IntGene extends GenericGene<Integer> {

	public IntGene() {
		super();
	}
	
	public IntGene(int val) {
		super(val);
	}
	
	@Override
	public String toString() {
		return this.getGenValue().toString();
	}

}
