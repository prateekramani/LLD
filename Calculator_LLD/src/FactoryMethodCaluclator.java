/**
 * FactoryMethodCaluclator
 */
public class FactoryMethodCaluclator {

    public static void main(String[] args) {

        // expresion : 3+2*10/5
        IFactory basicFactory = new BasicCalculatorFactory();
        CalculatorOperation calculatorOperation  = basicFactory.createCaluclatorObject();
        double result = calculatorOperation.calculate("3+2*5/5");

        System.out.println(result); // 5.0
        
    }

}