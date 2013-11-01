package Interpritator;

import java.util.Comparator;

public class Operator extends ExpressionItem implements Comparable { 
	
	private Priorities priority;
	private Operations operation;
	private int ArgsCount;
	
	public int getArgsCount() {
		return ArgsCount;
	}

	public void setArgsCount(int argsCount) {
		ArgsCount = argsCount;
	}

	public Priorities getPriority() {
		return priority;
	}

	public void setPriority(Priorities priority) {
		this.priority = priority;
	}

	public Operations getOperation() {
		return operation;
	}

	public void setOperation(Operations operation) {
		this.operation = operation;
	}

	public Operations setOperation() {
		return operation;
	}
	
	public Operator() {
		super();
	}
	
	public Operator(Operations operation) {
		super();
		switch (operation)
		{			
			case POWER: 
				Initializer(Priorities.MIDDLE, operation, 2); 
			break;
			case SUMMATION: 
				Initializer(Priorities.LOW, operation, 2); 
			break;
			case SUBSTRACTION:
				Initializer(Priorities.LOW, operation, 2);
			break;
			case MULTIPLICATION:
				Initializer(Priorities.MIDDLE, operation, 2);
			break;
			case DIVIZION:
				Initializer(Priorities.MIDDLE, operation, 2);
			break;
			case UNARYMINUS:
				Initializer(Priorities.HIGH, operation, 1);
			break;
			case UNARYPLUS:
				Initializer(Priorities.HIGH, operation, 1);
			break;
			case FUNCTION:
				Initializer(Priorities.HIGH, operation, 1);
			break;
			case FACTORIAL:
				Initializer(Priorities.HIGH, operation, 1);
			break;
			case LEFT_BRACKET:
				Initializer(Priorities.LOW, operation, 0);
			break;
			case RIGHT_BRACKET:
				Initializer(Priorities.LOW, operation, 0);
			break;
		}
	}
	
	public Operator(Priorities priority, Operations operation, int ArgsCount) {
		super();
		Initializer(priority, operation, ArgsCount);
	}

	private void Initializer(Priorities priority, Operations operation, int ArgsCount) {
		this.priority = priority;
		this.operation = operation;
		this.ArgsCount = ArgsCount;		
	}
	
	@Override
	public String toString() {
		return operation.toString();
	}

	@Override
	public boolean equals(Object obj) {
		Operations op = (Operations)obj;
		return this.operation.equals(op);
	}

	@Override
	public int compareTo(Object arg) {
		Operator op = (Operator)arg;
		return this.priority.compareTo(op.getPriority());
	}

}
