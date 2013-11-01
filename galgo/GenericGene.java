package galgo;

public class GenericGene<T> {

	private T genValue;
	
	public T getGenValue() {
		return genValue;
	}

	public void setGenValue(T genValue) {
		this.genValue = genValue;
	}

	public GenericGene() {
		super();
	}

	public GenericGene(T genValue) {
		this.genValue = genValue;
	}
	
}
