package Part1.ObjectsAndClasses.Basket;

public class Main {

    public static void main(String[] args) {
        Basket basket = new Basket();
        Basket basket1 = new Basket();


        basket.add("BigMac", 760, 3, 400);
        basket.add("Zewa", 220, 12, 275);
        basket.add("Netflix", 550);
        basket.add("Лотерейные билеты", 1100, 11);


        basket.print("__КОРЗИНА 1__");
        basket.getTotalPrice();
        basket.getTotalWeight();
        System.out.println();

        basket1.add("Macflury", 260, 3, 200);
        basket1.add("Coca-cola", 200, 1, 1505);
        basket1.add("Билеты на Бетмена", 900, 2);
        basket1.add("Качан капусты", 40, 1, 420);

        basket1.print("__КОРЗИНА 2__");
        basket1.getTotalPrice();
        basket1.getTotalWeight();
        System.out.println();

        System.out.println("РАСЧИТЫВАЕМ ЦЕНУ И ВЕС В 2-Х КОРЗИНКАХ : ");
        System.out.println();

        // ОБЩАЯ ЦЕНА И ВЕС ВСЕХ ОБОИХ КОРЗИН
        Basket.findAllPrice(basket, basket1);
        Basket.findAllWeight(basket, basket1);


        // СРЕДНЯЯ ЦЕНА ВСЕХ ПОЗИЦИЙ В ОБОИХ КОРЗИНАХ
        Basket.findAveragePriceGoods();
        System.out.println();

        Basket.findAverageBasketPrice();
        System.out.println();


        System.out.println("ДОБАВИЛИ 3-Ю КОРЗИНКУ");


        // ДОБАВИЛИ ТРЕТЬЮ КОРЗИНКУ И ПЕРЕГУЗИЛИ МЕТОДЫ
        Basket basket2 = new Basket();

        System.out.println();


        basket2.add("Водка ПУТИНКА", 333, 1, 532);
        basket2.add("Шоколадка MARS", 80, 1, 80);

        basket2.print("__КОРЗИНКА 3__");
        System.out.println();

        System.out.println("ОБЩАЯ ЦЕНА И ВЕС 3-Х КОРЗИНОК : ");
        System.out.println();

        Basket.findAllPrice(basket2);
        Basket.findAllWeight( basket2);


        System.out.println();

        //ИЩЕМ СРЕДНЮЮ ЦЕНУ В ПОЗИЦИИИ СРЕДИ ТРЕХ КОРЗИНОК

        Basket.findAveragePriceGoods();
        System.out.println();

        //РАСЧЕТ СРЕДНЕЙ ЦЕНЫ 1-Й КОРЗИНКИ (ВЫБРОКА СРЕДИ 3 КОРЗИНОК)
        Basket.findAverageBasketPrice();

    }

}
