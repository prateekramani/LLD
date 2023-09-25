import java.util.Stack;

public class BasicCalculationOperation extends CalculatorOperation {

    @Override
    protected double add(double operand1, double operand2) {
        return operand1 + operand2;
    }

    @Override
    protected double subtract(double operand1, double operand2) {
        return operand1 - operand2;
    }

    @Override
    protected double multiplication(double operand1, double operand2) {
        return operand1 * operand2;
    }

    @Override
    protected double division(double operand1, double operand2) {
        return operand1 / operand2;
    }

    private double evaluatePostfixBasic(String postfix) {

        System.out.println("evaluatePostfix of Basic Calculator");

        Stack<Double> operandStack = new Stack<>();

        for (char c : postfix.toCharArray()) {
            System.out.println(operandStack);
            if (Character.isDigit(c)) {
                operandStack.push((double) (c - '0'));
            } else if (super.isOperator(c)) {
                double operand2 = operandStack.pop();
                double operand1 = operandStack.pop();
                double result = 0;
                switch (c) {
                    case '+':
                        result = add(operand1, operand2);
                        break;
                    case '-':
                        result = subtract(operand1, operand2);
                        break;
                    case '*':
                        result = multiplication(operand1, operand2);
                        break;
                    case '/':
                        result = division(operand1, operand2);
                        break;
                    default:
                        break;
                }
                operandStack.push(result);
            }
        }

        return operandStack.pop();
    }

    protected double calculate(String expression) {
        String postfix = super.infixToPostfix(expression);
        System.out.println(postfix);
        return evaluatePostfixBasic(postfix);
        
    }
}
