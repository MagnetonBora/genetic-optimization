package Interpritator;

public class Function<T extends Number> extends Operator implements Computable {
	
	private MathFunctions FunctionType;
	
	private T argument = null;
	
	public Function() {
		super();
	}

	public Function(String func) {
		super(Operations.FUNCTION);
		String src = func.toLowerCase();
	}

	
	public Function(MathFunctions FunctionType) {
		this.FunctionType = FunctionType;
	}
	
	public void setArgument(T arg) {
		argument = arg;
	}
	
	public T getArgument() {
		return argument;
	}
	
	public String toString() {
		return FunctionType.toString();
	}

	public double compute(double... args) {
		return Math.cos(args[0]);
	}

}
