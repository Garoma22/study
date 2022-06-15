package Part1.ObjectsAndClasses.Basket;

public class Basket {

    private String items;
    private double totalWeight = 0;   // общая масса товаров, добавленных в корзину
    private int totalPrice = 0; // общая стоимость товаров

    public Basket() {
        items = "Список товаров:";
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

    public void add(String name, int price, int count) {
        boolean error = false;
        if (items.contains(name)) {
            error = true;
        }

        if (error) {
            System.out.println("Error occured :(");
            return;
        }

        items = items + "\n" + name + " - " +
            count + " шт. - " + price;

        totalPrice = totalPrice + price;  //добавил расчет стоимости всего
    }

    // дополнительный метод
    public void add(String name, int price, int count, double weight){

        add(name,price);
        add(name,price,count);

        if (weight>0) {
                totalWeight = totalWeight + weight;
            }
        }

        public double getTotalWeight(){
        return totalWeight;
        }

        public double getTotalPrice(){
        return totalPrice;
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
}
