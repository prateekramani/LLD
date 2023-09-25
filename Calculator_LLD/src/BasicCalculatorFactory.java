public class BasicCalculatorFactory implements IFactory {

    @Override
    public CalculatorOperation createCaluclatorObject() {
        return new BasicCalculationOperation();
    }

}
