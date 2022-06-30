package Part1.ObjectsAndClasses.Basket;

public class Basket {

    private String items;
    private double totalWeight;   // общая масса товаров, добавленных в 1 корзину
    private double totalPrice; // общая стоимость товаров в одной корзинке
     private static double allWeight; // общий вес товаров, во всех корзинках
     private static double allPrice;  // общая стоимость товаров во всех корзинках
    private static int countPositions; //считаем позиции
    private static int countBaskets; // считаем корзинки

    public Basket() {
        items = "Список товаров:";
        countBaskets++;
    }

    public Basket(String items) {
        this();
        this.items = this.items + items;
    }

    public Basket(String items, double totalWeight, int totalPrice) {
        this();
        this.items = this.items + items;
        this.totalWeight = totalWeight;
        this.totalPrice = totalPrice;
    }

    public void add(String name, int price) {
        add(name, price, 1);

    }

    public void add(String name, double price, int count) {
        boolean error = items.contains(name);

        if (error) {
            System.out.println("Error occured :(");
            return;
        }

        items = items + "\n" + name + " - " +
                count + " шт. - " + price + " руб";

        totalPrice = totalPrice + price;  //добавил расчет стоимости всего
        countPositions = countPositions + count;
        allPrice += price;
    }
    // дополнительный метод
    public void add(String name, int price, int count, double weight) {
        add(name, price, count);
        totalWeight = totalWeight + weight;
        allWeight += weight;
    }
    public double getTotalWeight() {
        return totalWeight;
    }
    public double getTotalPrice() {

        return totalPrice;
    }
    public static double getAllWeight() {
        return allWeight;
    }
    public static double getAllPrice() {
        return allPrice;
    }
    public void clear() {
        items = "";
    }
    public void print(String title) {
        System.out.println(title);
        if (items.isEmpty()) {
            System.out.println("Корзина пуста");
        } else {
            System.out.println(items);
        }
    }
    public static double findAveragePriceGoods() {
        double averagePrice = allPrice / countPositions;
        double scale = Math.pow(10, 2);
        averagePrice = Math.ceil(averagePrice * scale) / scale;

        return averagePrice;
    }
    public static double findAverageBasketPrice() {
        return allPrice / countBaskets;
    }
}


