package Interpritator;

public enum MathFunctions {
		
	cos {
		public String toString() {
			return "cos";
		}
	},
		
	sin {
		public String toString() {
			return "sin";
		}
	},
		
	tg {
		public String toString() {
			return "tg";
			}
	},
		
	ctg {
		public String toString() {
			return "ctg";
		}
	},
		
	sh {
		public String toString() {
			return "sh";
		}
	},
		
	ch {
		public String toString() {
			return "ch";
		}
	};
	
	public static MathFunctions getFunctionType(String src) {
		if (src.equals("cos")) {
			return cos;
		}
		if (src.equals("sin")) {
			return sin;
		}
		if (src.equals("tg")) {
			return tg;
		}
		if (src.equals("ctg")) {
			return ctg;
		}
		if (src.equals("sh")) {
			return sh;
		}
		else
			return ch;					
	}
}
