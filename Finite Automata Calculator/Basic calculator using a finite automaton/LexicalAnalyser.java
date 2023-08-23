import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class LexicalAnalyser {

	private enum State {
		NONE, ZERO, ZERODOT, NUMBER, OPERATION, SPACE
	}

	public static List<Token> analyse(String input) throws NumberException, ExpressionException {
		Token tkn = new Token();		
		State state = State.NONE;
		for (int i = 0; i < input.length(); i++) {

			if (input.charAt(i) == '0') {
				switch (state) {
				case NONE:
					state = State.ZERO;
					break;
				}
			}

			if (input.charAt(i) == ' ') {
				switch (state) {
				case NUMBER:
					state = State.SPACE;
				}
			}

			else if (input.charAt(i) == '.') {
				switch (state) {
				case NONE:
					throw new NumberException();
				case ZERO:
				if (tkn.typeOf(input.charAt(input.length()-1)) == tkn.typeOf('2')) {
					state = State.ZERODOT;
					break;
					}
				else {
					throw new NumberException();
					}
				case ZERODOT:
					throw new NumberException();
				case NUMBER:
					throw new NumberException();
				}
			}

			else if (input.charAt(i) != '0' && tkn.typeOf(input.charAt(i)) == tkn.typeOf('1')){
				switch (state) {
				case NONE:
					state = State.NUMBER;
					break;
				case OPERATION:
					state = State.NUMBER;
					break;
				case ZERODOT:
					state = State.NUMBER;
					break;
				case SPACE:
					throw new ExpressionException();
				}
			}

			else if (input.charAt(input.length()-1) == '.') {
				switch (state) {
				case NUMBER:
					throw new NumberException();
				}
			}
			
			else if (tkn.typeOf(input.charAt(i)) == tkn.typeOf('+'))
				switch (state) {
				case NONE:
					throw new ExpressionException();
				case NUMBER:
					state = State.OPERATION;
					break;
				case OPERATION:
					throw new ExpressionException();
				case SPACE:
					state = State.OPERATION;
					break;
				
				}
			else if (tkn.typeOf(input.charAt(i)) == tkn.typeOf('-'))
				switch (state) {
				case NONE:
					throw new ExpressionException();
				case NUMBER:
					state = State.OPERATION;
					break;
				case OPERATION:
					throw new ExpressionException();
				case SPACE:
					state = State.OPERATION;
					break;
				}
			else if (tkn.typeOf(input.charAt(i)) == tkn.typeOf('/'))
				switch (state) {
				case NONE:
					throw new ExpressionException();
				case NUMBER:
					state = State.OPERATION;
					break;
				case OPERATION:
					throw new ExpressionException();
				case SPACE:
					state = State.OPERATION;
					break;
				}
			else if (tkn.typeOf(input.charAt(i)) == tkn.typeOf('*'))
				switch (state) {
				case NONE:
					throw new ExpressionException();
				case NUMBER:
					state = State.OPERATION;
					break;
				case OPERATION:
					throw new ExpressionException();
				case SPACE:
					state = State.OPERATION;
					break;
				}
			if (input.charAt(input.length()-1) != '.' && tkn.typeOf(input.charAt(input.length()-1)) != tkn.typeOf('1')) {
				switch (state) {
				case NUMBER:
					throw new ExpressionException();
				}
			}
		}
		ArrayList<Token.TokenType> listTokentype = new ArrayList<Token.TokenType>();
		char[] charA = input.toCharArray();
		int j = 0;
		ArrayList<Token> list = new ArrayList<Token>();
		for(char c : charA) {
			if(c == '.') {
				listTokentype.add(Token.TokenType.NUMBER);
			} 
			else {
            	Token tkn2 = new Token(Token.typeOf(c));
            	listTokentype.add(tkn2.getType());
			}
        }
		while(j < listTokentype.size()) {
			String s = "";
			while(listTokentype.size() > j && charA[j] == ' ') {
				j++;
			}
			
			while(listTokentype.size() > j && (listTokentype.get(j) == Token.TokenType.NUMBER || charA[j] == ' ')) {
				if (charA[j] != ' ') {
        			s += charA[j];
				}
        		j++;
    		}
			if (!s.equals("")) {
				Token tkn2 = new Token(Double.parseDouble(s));
				list.add(tkn2);
			}
			if (j < listTokentype.size() && charA[j] != ' ') {
				Token tkn3 = new Token(listTokentype.get(j));
				list.add(tkn3);
			}
			j++;
	}
		return list;
	}
}
