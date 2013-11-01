package Interpritator;

import java.util.*;

public final class Utility {
	
	public static enum TokenType {
		
		LEFT_BRACKET,
		RIGHT_BRACKET,
		OPERATOR,
		NUMBER,
		FUNCTION,
		SEPARATOR
		
	}
	
	private static boolean IsValidSymbol(char ch) {
		if (Character.isLetterOrDigit(ch) || ch == '.') {
			return true;	
		}			
		else {
			return false;
		}
	}
	
	private static boolean IsFunctionSymbol(char ch) {
		if (Character.isLetter(ch)) {
			return true;	
		}
		else {
			return false;
		}
	}
	
	private static boolean IsOperation(char ch) {
		if (ch == '+' || ch == '-' ||
			ch == '*' || ch == '/' ||
			ch == '(' || ch == ')' ||
			ch == '^')
			return true;
		else
			return false;
	}
		
	public static ArrayList<ExpressionItem> Tokenize(String str) {
		ArrayList<ExpressionItem> tokens = new ArrayList<ExpressionItem>();
		String buf = "";
		int i = 0;
		while (i < str.length()) {			
			char ch = str.charAt(i);
			if (!Character.isWhitespace(str.charAt(i))) {
				if (IsOperation(ch)) {
					tokens.add(new Operator(Operations.parse(Character.toString(ch))));
				}
				else if (IsFunctionSymbol(ch)) {
					while (i < str.length() && str.charAt(i) != '(') {
						buf += str.charAt(i++);
					}
					i--;
					tokens.add(new Function(MathFunctions.getFunctionType(buf)));
					buf = "";
				}
				else {
					while (i < str.length() && IsValidSymbol(str.charAt(i))) {
						buf += str.charAt(i++);
					}
					i--;
					tokens.add(new Operand<Double>(Double.parseDouble(buf)));
					buf = "";
				}
			}
			i++;
		}		
		return tokens;		
	}

	private Utility() {}
	
	public static void main(String[] args) {
		String src = "cos(0.2) + cos(0.2)";
		ArrayList<ExpressionItem> tokens = Tokenize(src);		
		for(ExpressionItem item : tokens) {
			System.out.println(item);
		}
	}
	
}
