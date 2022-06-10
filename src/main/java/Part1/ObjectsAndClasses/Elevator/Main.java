package Part1.ObjectsAndClasses.Elevator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {



        /*
        Раскомментировать после "заполнения" класса Elevator
         */

        Elevator elevator = new Elevator(-3, 26);

        while(true) {
            System.out.print("Введите номер этажа: ");
            int floor = new Scanner(System.in).nextInt();
            elevator.move(floor);
        }
    }
}


