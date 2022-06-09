package Part1.ObjectsAndClasses.Calculator;

public enum Operation {

ADD(1,2), SUBTRACT(22,2), MULTIPLY(3,30);


    final int n1;
    final int n2;

    Operation(int n1, int n2) {
        this.n1 = n1;
        this.n2 = n2;
    }

}

