package Part1.ObjectsAndClasses.Elevator;

public class Elevator {

    private int currentFloor = 1;
    private final int minFloor;
    private final int maxFloor;

    public Elevator(int minFloor, int maxFloor) {
        this.minFloor = minFloor;
        this.maxFloor = maxFloor;
    }
    public void moveDown() {
        currentFloor--;
    }
    public void moveUp() {
        currentFloor++;
    }
    public void move(int floor) {
        if (floor >= minFloor && floor <= maxFloor && currentFloor < floor) {
            while (floor != currentFloor) {
                moveUp();
                System.out.println("Этаж " + currentFloor);
            }
            System.out.println("Мы поднялись на нужный этаж " + currentFloor);
            return;
        }
        if (floor >= minFloor && floor <= maxFloor && currentFloor > floor) {
            while (floor != currentFloor) {
                moveDown();
                System.out.println("Этаж " + currentFloor);
            }
            System.out.println("Мы опустились на нужный этаж " + currentFloor);
            return;
        }
        if (floor < minFloor || floor > maxFloor) {
            System.out.println("Некорректный ввод этажа");
        } else {
            System.out.println("Мы находимся на " + currentFloor + " этаже");
        }
    }
}

