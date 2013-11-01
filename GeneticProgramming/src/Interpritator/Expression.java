package Interpritator;

import java.util.*;

public class Expression {

	private List<ExpressionItem> expr = new ArrayList<ExpressionItem>(); 
	
	public ArrayList<ExpressionItem> getTokens() {
		return (ArrayList<ExpressionItem>)expr;
	}
	
	public Expression() {}
	
	public Expression(String str) {
		ToSuffix(str);
	}
		
	private void ToSuffix(String str) {		
		Stack<Operator> stack = new Stack<Operator>();		
		ArrayList<ExpressionItem> src = Utility.Tokenize(str);
		ExpressionItem ptoken = null;
		for(int i = 0; i < src.size(); i++) {
			ExpressionItem item = src.get(i);
			if (item instanceof Operator == false) {
				expr.add(item);
			}
			else if (item instanceof Function) {
				stack.push((Operator)item);
			}
			else {
				Operator op2 = (Operator)item;
				switch (op2.getOperation())
				{
				case LEFT_BRACKET:
					stack.push(op2);
				break;
				case RIGHT_BRACKET:
					while (!stack.empty() && stack.peek().equals(Operations.LEFT_BRACKET) == false) {
						expr.add(stack.pop());
					}
					stack.pop();
				break;
				default:
					Operator op = op2;
					if (ptoken == null || ptoken instanceof Operator &&
						!ptoken.equals(Operations.RIGHT_BRACKET)) {
						if (op2.getOperation() == Operations.SUBSTRACTION) {
							op = new Operator(Operations.UNARYMINUS);
						}
						if (op2.getOperation() == Operations.SUMMATION) {
							op = new Operator(Operations.UNARYPLUS);
						}
					}
					while (!stack.empty() && stack.peek().compareTo(op) < 0 &&
							stack.peek().equals(Operations.LEFT_BRACKET) == false) {
						expr.add(stack.pop());
					}
					stack.push(op);
				break;
				}
			}
			ptoken = item;
		}
		while (!stack.empty()) {	
			expr.add(stack.pop());
		}

	};
			
	public String toString() {
		String str = "[ ";
		for(ExpressionItem item : expr) {
			str += item.toString() + " ";
		}
		return str + "]";
	}
}