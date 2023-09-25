import java.util.Stack;

public abstract class CalculatorOperation {
    protected abstract double add(double operand1, double operand2);

    protected abstract double subtract(double operand1, double operand2);
    
    protected abstract double multiplication(double operand1, double operand2);
    
    protected abstract double division(double operand1, double operand2);

    protected abstract double calculate(String exp);

    protected String infixToPostfix(String infix) {

		StringBuilder postfix = new StringBuilder();
		Stack<Character> operatorStack = new Stack<>();

		for (char c : infix.toCharArray()) {
			if (Character.isDigit(c)) {
				postfix.append(c);
			} else if (isOperator(c)) {
				while (!operatorStack.isEmpty() && precedence(operatorStack.peek()) >= precedence(c)) {
					postfix.append(operatorStack.pop());
				}
				operatorStack.push(c);
			} else if (c == '(') {
				operatorStack.push(c);
			} else if (c == ')') {
				while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
					postfix.append(operatorStack.pop());
				}
				operatorStack.pop(); // Pop the '('
			}
		}

		while (!operatorStack.isEmpty()) {
			postfix.append(operatorStack.pop());
		}

		return postfix.toString();
	}

	protected boolean isOperator(char c) {
		return c == '+' || c == '-' || c == '*' || c == '/';
	}

	protected int precedence(char operator) {
		if (operator == '+' || operator == '-') {
			return 1;
		} else if (operator == '*' || operator == '/') {
			return 2;
		}
		return 0;
	}
    
}
