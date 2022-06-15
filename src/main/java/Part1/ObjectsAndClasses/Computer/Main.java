package Part1.ObjectsAndClasses.Computer;



public class Main {
    public static void main(String[] args) {

        Computer computer1 = new Computer("My computer", "Apple");

        System.out.println();
        System.out.println(computer1);

        computer1.countWeight();
    }
}
