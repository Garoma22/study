package Part1.ObjectsAndClasses.Calculator;

public class Main {
    public static void main(String[] args) {

        Calculator c = new Calculator(4, 4);

        c.calculate(Operation.ADD);
        c.calculate(Operation.SUBTRACT);
        c.calculate(Operation.MULTIPLY);

    }
}
