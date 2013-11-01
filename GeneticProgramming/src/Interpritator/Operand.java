package Interpritator;

public class Operand<T extends Number> extends ExpressionItem {
	
	private T value;

	public Operand() {
		super();
	}

	public Operand(T value) {
		super();
		this.value = value;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return value.toString();
	}	

}
