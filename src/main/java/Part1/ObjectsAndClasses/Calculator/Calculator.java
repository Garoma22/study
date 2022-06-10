package Part1.ObjectsAndClasses.Calculator;

public class Calculator {


    int n1;
    int n2;

    public Calculator(int n1, int n2){
        this.n2 = n2;
        this.n1 = n1;
    }

    void calculate(Operation o){
        switch (o){
            case ADD:
                System.out.println(n1+ n2);
                break;
            case SUBTRACT:
                System.out.println(n1/n2);
            break;
            case MULTIPLY:
                System.out.println(n1 * n2);
                break;
        }
    }
}






