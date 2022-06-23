package Part1.ObjectsAndClasses.Basket;

public class Main {

    public static void main(String[] args) {
        Basket basket = new Basket();


        basket.add("BigMac",760,3,400);
        basket.add("Zewa", 220,12, 270);
        basket.add("Netflix", 550);
        basket.add("Лотерейные билеты", 1100,11);

        basket.getTotalPrice();
        basket.getTotalWeight();
        basket.print("Zewa");





//        basket.add("Milk", 40);
//        basket.print("Milk");





    }
}
