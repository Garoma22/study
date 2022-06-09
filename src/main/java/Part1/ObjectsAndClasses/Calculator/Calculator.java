package Part1.ObjectsAndClasses.Calculator;

public class Calculator {

    int calculate(){
    return Operation.ADD.n1 + Operation.ADD.n2;
    }

    int calculate2(){
        return Operation.SUBTRACT.n1/ Operation.SUBTRACT.n2;
    }

    int calculate3(){
        return Operation.MULTIPLY.n1* Operation.MULTIPLY.n2;
    }
}



