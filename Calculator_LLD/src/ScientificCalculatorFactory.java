public class ScientificCalculatorFactory implements IFactory {

    @Override
    public CalculatorOperation createCaluclatorObject() {
        return new ScientificCalculationOperators() ;
    }
    
}
