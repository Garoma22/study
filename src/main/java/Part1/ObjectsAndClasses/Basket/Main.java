package Part1.ObjectsAndClasses.Basket;

public class Main {

    public static void main(String[] args) {
        Basket basket = new Basket();
        Basket basket1 = new Basket();
        Basket basket2 = new Basket();

        basket.add("BigMac", 760, 3, 400);
        basket.add("Zewa", 220, 12, 275);
        basket.add("Netflix", 550);
        basket.add("Лотерейные билеты", 1100, 11);

        basket.print("__КОРЗИНА 1__");
        System.out.println("Общая цена товаров в корзине : " + basket.getTotalPrice() + " руб.");
        System.out.println("Общий вес товаров в корзине : " + basket.getTotalWeight() + " грамм");
        System.out.println();

        basket1.add("Macflury", 260, 3, 200);
        basket1.add("Coca-cola", 200, 1, 1505);
        basket1.add("Билеты на Бетмена", 900, 2);
        basket1.add("Качан капусты", 40, 1, 420);

        basket1.print("__КОРЗИНА 2__");
        System.out.println("Общая цена товаров в корзине : " + basket1.getTotalPrice() + " руб.");
        System.out.println("Общий вес товаров в корзине : " + basket1.getTotalWeight() + " грамм");
        System.out.println();

        basket2.add("Водка ПУТИНКА", 333, 1, 532);
        basket2.add("Шоколадка MARS", 80, 1, 80);

        basket2.print("__КОРЗИНКА 3__");
        System.out.println("Общая цена товаров в корзине : " + basket2.getTotalPrice() + " руб.");
        System.out.println("Общий вес товаров в корзине : " + basket2.getTotalWeight() + " грамм");
        System.out.println();

        // ОБЩАЯ ЦЕНА И ВЕС ВСЕХ  КОРЗИН

        System.out.println("__СКОЛЬКО СТОЯТ И ВЕСЯТ ВСЕ ТОВАРЫ ВО ВСЕХ КОРЗИНАХ : ");
        System.out.println("Все товары в корзинах стоят : " + Basket.getAllPrice());
        System.out.println("Все товары в корзинах весят : " + Basket.getAllWeight());

        // СРЕДНЯЯ ЦЕНА ВСЕХ ПОЗИЦИЙ В КОРЗИНАХ
        System.out.println("Средняя цена товара в корзинах : " + Basket.findAveragePriceGoods() + " руб.");
        System.out.println();

        // СРЕДНЯЯ ЦЕНА КОРЗИНКИ
        System.out.println("__СРЕДНЯЯ ЦЕНА КОРЗИНКИ  : " + Basket.findAverageBasketPrice() + " руб.");
    }
}
