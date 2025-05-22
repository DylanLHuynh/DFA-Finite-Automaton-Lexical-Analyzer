// import java.util.Collections;
// import java.util.List;
import java.util.ArrayList;

public class LexicalAnalyser {

	private static final String number = "123456789";
	// String zero = "0";
	private static final String operations = "+-/*";
	// String decimal = ".";

	private enum State {START, ZERO, NUMBER, DECIMAL, SPACE, OPERATION};

	public static ArrayList<Token> analyse(String input) throws NumberException, ExpressionException {
		String current = "";
		State state = State.START;
		ArrayList<Token> token = new ArrayList<Token>();

		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == '0') {
				switch (state) {
					case START:
						current += input.charAt(i); 
						state = State.ZERO; 
						break;

					case ZERO:
						current += input.charAt(i); 
						break; 
					
					case DECIMAL: 
						state = State.NUMBER;
						current += input.charAt(i); 
						break;
					
					case NUMBER:
						current += input.charAt(i);	
						break; 
					
					case SPACE:
						// state = State.INVALID;
						throw new ExpressionException(); 

					case OPERATION:
						current += input.charAt(i); 
						state = State.NUMBER;
						break;
					
					// case INVALID:
					// 	throw new 
					// 	break; 
				}
			}

			if (number.contains(String.valueOf(input.charAt(i)))) {
				switch (state) {
					case START:
						current += input.charAt(i); 
						state = State.NUMBER;
						break;

					case ZERO:
						current += input.charAt(i); 
						state = State.NUMBER;
						break; 
					
					case DECIMAL: 
						state = State.NUMBER;
						current += input.charAt(i); 
						break;
					
					case NUMBER:
						current += input.charAt(i);	
						break; 
					
					case SPACE:
						// state = State.SPACE;
						throw new ExpressionException();
						// break; 
					
					case OPERATION:
						state = State.NUMBER;
						current += input.charAt(i);	
						break;
					
					// case INVALID:
					// 	break; 
				}
			}
			if (operations.contains(String.valueOf(input.charAt(i)))) {
				switch (state) {
					case START:
						throw new ExpressionException();

					case ZERO:
						token.add(new Token(Double.valueOf(current)));
						current = ""; 
						token.add(new Token(new Token().typeOf(input.charAt(i))));
						state = State.OPERATION;
						break; 
					
					case DECIMAL: 
						throw new NumberException();
					
					case NUMBER:
						token.add(new Token(Double.valueOf(current)));	
						current = "";
						token.add(new Token(new Token().typeOf(input.charAt(i))));
						state = State.OPERATION;
						break; 
					
					case SPACE:
						token.add(new Token(Double.valueOf(current)));
						current = "";
						token.add(new Token(new Token().typeOf(input.charAt(i))));
						state = State.OPERATION;
						break; 
					
					case OPERATION:
						throw new ExpressionException();
					
					// case INVALID:
					// 	break; 
				}
			}

			if (input.charAt(i) == ' ') {
				switch (state) {
					case START:
						break;

					case ZERO:
						break; 
					
					case DECIMAL: 
						state = State.NUMBER;
						current += input.charAt(i); 
						break;
					
					case NUMBER:
						// current += input.charAt(i);	
						state = State.SPACE;
						break; 
					
					case SPACE:
						// state = State.INVALID;
						throw new ExpressionException();
					
					case OPERATION:
						break;
					
					// case INVALID:
					// 	break; 
				}
			}

			if (input.charAt(i) == '.') {
				switch (state) {
					case START:
						throw new NumberException();

					case ZERO:
						current += input.charAt(i); 
						state = State.DECIMAL;
						break; 
					
					case DECIMAL: 
						throw new NumberException(); 
					
					case NUMBER:
						throw new NumberException();
					
					case SPACE:
						state = State.DECIMAL;
						break; 
					
					case OPERATION:
						throw new ExpressionException();
					
					// case INVALID:
					// 	break; 
				}
			}
		}
		switch (state) {
			case START:
				break;

			case ZERO:
				token.add(new Token(Double.valueOf(current)));	
				// token.add(new Token(new Token().typeOf(input.charAt(i))));
				break; 
					
			case DECIMAL: 
				throw new NumberException(); 
					
			case NUMBER:
				token.add(new Token(Double.valueOf(current)));	
				break;
					
			case SPACE:
				token.add(new Token(Double.valueOf(current)));
				break; 
					
			case OPERATION:
				throw new ExpressionException();
		}
		return token;

	}

}
