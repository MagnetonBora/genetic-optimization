package Interpritator;

import java.util.*;

public class Interpritator {

	private Expression expr;
	
	public Interpritator() {
		super();
	}
	
	public Interpritator(Expression expr) {
		this.expr = expr;
	}
	
	public static boolean compile(Expression exp) {		
		return false;
	}
	
	public String toString() {
		return expr.toString();
	}
	
	private static double calc(Operator operator, Operand<Double> ...operands) {
		double val = 0;
		Operations op = operator.getOperation();
		switch (op) {
		case POWER:
			val = Math.pow(operands[1].getValue(), operands[0].getValue());
		break;
		case SUMMATION: 
			val = operands[0].getValue().doubleValue() +
			operands[1].getValue().doubleValue();
		break;
		case SUBSTRACTION:
			val = operands[1].getValue().doubleValue() -
			operands[0].getValue().doubleValue();
		break;
		case MULTIPLICATION:
			val = operands[1].getValue().doubleValue() * 
			operands[0].getValue().doubleValue();
		break;
		case DIVIZION:
			val = operands[1].getValue().doubleValue() / 
			operands[0].getValue().doubleValue();
		break;
		case UNARYPLUS:
			val = operands[0].getValue();
		break;
		case UNARYMINUS:
			val = -operands[0].getValue();
		break;
		}
		return val;
	}
	
	public static double value(Expression expr) throws IllegalArgumentException {
		Interpritator interpritator = new Interpritator(expr);
		return interpritator.value(); 
	}	
	
	public double value() throws IllegalArgumentException {
		double val = 0;
		Stack<ExpressionItem> stack = new Stack<ExpressionItem>();
		ArrayList<ExpressionItem> tokens = expr.getTokens();
		for(ExpressionItem item : tokens) {
			if (item instanceof Operator == false) {
				stack.push(item);
			}
			else {
					Operator operator = (Operator)item;
					Operand<Double> op1 = (Operand<Double>)stack.pop();
					if (operator.getOperation() == Operations.UNARYMINUS ||
						operator.getOperation() == Operations.UNARYPLUS) {
						val = calc(operator, op1);
						}
					else if (operator instanceof Function) {
						val = ((Function)operator).compute(op1.getValue());
					}
					else {
						Operand<Double> op2 = (Operand<Double>)stack.pop();					
						val = calc(operator, op1, op2);						
					}
					stack.push(new Operand<Double>(val));
			}
		}		
		return ((Operand<Double>)stack.pop()).getValue();
	}	
	
	public static void main(String[] args) {		
		Scanner scanner = new Scanner(System.in);
		String src = "";		
		while (true) {
			src = scanner.nextLine();
			if (src.equals("quit")) {
				System.out.println("Terminated");
				break;
			}
			Interpritator inter = new Interpritator(new Expression(src));
			System.out.println(inter.value());
			//System.out.println(inter);
		}		
	}
}
