package Part1.ObjectsAndClasses.Basket;

public class Basket {

    private String items;

    public Basket() {
        items = "Список товаров:";
    }

    public Basket(String items) {
        this();
        this.items = this.items + items;
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
