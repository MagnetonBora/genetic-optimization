package Interpritator;

public enum Operations {
	
	LEFT_BRACKET {
		public String toString() {
			return "(";
		}
	},
	
	RIGHT_BRACKET {
		public String toString() {
			return ")";
		}
	},
	
	UNARYMINUS {
		public String toString() {
			return "-";
		}
	},
	
	UNARYPLUS {
		public String toString() {
			return "+";
		}
	},
	
	FACTORIAL {
		public String toString() {
			return "!";
		}
	},
	
	POWER {
		public String toString() {
			return "^";
		}
	},
	
	SUMMATION {
		public String toString() {
			return "+";
		}
	},
	
	SUBSTRACTION {
		public String toString() {
			return "-";
		}
	},
	
	MULTIPLICATION {
		public String toString() {
			return "*";
		}
	},
	
	DIVIZION {
		public String toString() {
			return "/";
		}
	},
	
	FUNCTION;

	public static Operations parse(String str) {
		if (str.equals("+"))
			return SUMMATION;
		if (str.equals("-"))
			return SUBSTRACTION;
		if (str.equals("*"))
			return MULTIPLICATION;
		if (str.equals("^"))
			return POWER;
		if (str.equals("("))
			return LEFT_BRACKET;
		if (str.equals(")"))
			return RIGHT_BRACKET;
		else
			return DIVIZION;
	}

	public static boolean IsOperation(char ch) {
		if (ch == '+' || ch == '-' ||
			ch == '/' || ch == '*' ||
			ch == '^')
			return true;
		else
			return false;
	}
}
