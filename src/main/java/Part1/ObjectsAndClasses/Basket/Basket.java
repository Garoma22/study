package Part1.ObjectsAndClasses.Basket;

public class Basket {

    private String items;
    private double totalWeight;   // общая масса товаров, добавленных в корзину
    private double totalPrice; // общая стоимость товаров
    private static double allWeight;
    private static double allPrice;
    private static int countPositions;
    private static int countBaskets;

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
        boolean error = false;
        if (items.contains(name)) {
            error = true;
        }

        if (error) {
            System.out.println("Error occured :(");
            return;
        }

        items = items + "\n" + name + " - " +
                count + " шт. - " + price + " руб";

        totalPrice = totalPrice + price;  //добавил расчет стоимости всего
        countPositions = countPositions + count;
    }

    // дополнительный метод
    public void add(String name, int price, int count, double weight) {

        add(name, price, count);

        totalWeight = totalWeight + weight;

    }

    public void getTotalWeight() {
        System.out.println("Общий вес продуктов в корзинке : " +  totalWeight);
    }

    public void getTotalPrice() {

        System.out.println("Общая цена продуктов в корзине : " + totalPrice);
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

    // ПЕРЕГРУЗКА МЕТОДА ДЯЛ ТРЕХ КОЗИНОК
    public static void findAllPrice(Basket b2) {
        allPrice = allPrice + b2.totalPrice;
        System.out.println("TOTAL Price в " + countBaskets + " корзинках : " + allPrice + " руб ");
    }
    public static void findAllPrice(Basket basket, Basket basket1) {
        allPrice = allPrice + basket.totalPrice + basket1.totalPrice;
        System.out.println("TOTAL Price в " + countBaskets + " корзинках : " + allPrice + " руб ");
    }


    // ПЕРЕГРУЗКА МЕТОДА ДЛЯ ТРЕХ КОРЗИНОК
    public static void findAllWeight(Basket b2) {
        allWeight = allWeight + b2.totalWeight;
        System.out.println("TOTAL weight в " + countBaskets + " корзинках : " + allWeight + " грамм ");

    }
    public static void findAllWeight(Basket basket, Basket basket1) {
        allWeight = allWeight + basket1.totalWeight + basket.totalWeight;
        System.out.println("TOTAL weight в " + countBaskets + " корзинках : " + allWeight + " грамм ");
    }

    public static void findAveragePriceGoods() {
        System.out.println();
        double averagePrice = allPrice / countPositions;
        System.out.print("РАСЧЕТ СРЕДНЕЙ ЦЕНЫ ТОВАРА В " + countBaskets + " КОРЗИНАХ : \n" +
                "Общая цена позиций : " + allPrice + "\nЧисло позиций : " + countPositions + "\n" + "ИТОГО средняя " +
                "цена одной позиции : ");

        double scale = Math.pow(10, 3);
        averagePrice = Math.ceil(averagePrice * scale) / scale;
        System.out.print(averagePrice);

    }
    public static void findAverageBasketPrice() {
        System.out.println();
        System.out.println();
        System.out.println("РАСЧЕТ СРЕДЕНЙ ЦЕНЫ 1-й КОРЗИНКИ (ВЫБОРКА СРЕДИ " + countBaskets + "-X КОРЗИНОК)");

        double averageBasketPrice = allPrice / countBaskets;
        System.out.println("Средняя цена корзинки : " + averageBasketPrice);
    }
}

