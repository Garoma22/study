package Part1.DigitsAndStrings;

public class HumanitarianAid {


    public static void main(String[] args) {


        int totalBoxes = Boxes.countBoxes(555);
        int totalContainers = Containers.countContainers();
        int totalTrucks = Truck.countTrucks();
        int empty_truck_exception = 1;   // вспомогательная переменная


        int[] TRUCK_CAPACITY = new int[12];
        int[] CONTAINER_CAPACITY = new int[27];

        int g = 1;  // итератор грузовика, отсчет начинаем с 1
        int k = 1;  // итератор контейнера, отсчет начинаем с 1
        System.out.println("Грузовик: " + g);
        System.out.println("Контейнер: " + k);

        for (int i = 1; i < totalBoxes + 1; i++) {  // тут +1 потому что начинаем считать с 1
            System.out.println("\t Ящик " + i);

            //ЗАПОЛНЯЕМ ЯЩИКАМИ КОНТЕЙНЕРЫ
            if (i % CONTAINER_CAPACITY.length == 0) {   // тут этого хитрого условия как ниеж нет, потому что i сразу 1 а не 0;
                k++;
                if (k <= TRUCK_CAPACITY.length) {
                    System.out.println("Kонтейнер: " + k);
                }
            }
            if (k % TRUCK_CAPACITY.length == 0) {    // ИТЕРИРУЕМ ЦИКЛ 12 -Й РАЗ
                continue;
            }
            if (
                    k > empty_truck_exception && k % TRUCK_CAPACITY.length == 1) {  // смысл условия, чтобы оно выполнялось только когда k==13 или кратному 12+1, но не 1.
                // если делим меньшее число на большее по модулю
                // то остаток от деления равен делимому. В данном случае 1. Получается вывод НЕКОРРЕКТНЫЙ,
                // поэтому для первой итерации цикла добавляем условие k>1. Чтобы k всегда делилось было 13, 25 и
                // так далее, то есть на 1 больше чем полный грузовик.

                g++;
                k = 1;
                System.out.println("Грузовик: " + g);
                System.out.println("Контейнер: " + k);

            }
        }

        System.out.println();
        System.out.println("Всего ящиков : " + totalBoxes);
        System.out.println("Всего требуется контейнеров : " + totalContainers);
        System.out.println("Всего требуется грузовиков : " + totalTrucks);

    }
}

class Truck {
    final static int TRUCK_CAPACITY = 12;
    final static int ONE_TRUCK = 1;

    public static int countTrucks() {
        int loadedTrucks = Containers.countContainers() / TRUCK_CAPACITY;

        if (Containers.countContainers() / TRUCK_CAPACITY < ONE_TRUCK) {
            return ONE_TRUCK;
        }
        if (Containers.countContainers() % TRUCK_CAPACITY == 0) {
            return loadedTrucks;
        }
        if (Containers.countContainers() > TRUCK_CAPACITY) {
            return loadedTrucks + 1;
        }
        return loadedTrucks;
    }
}

class Containers {
    final static int CONTAINER_CAPACITY = 27;
    final static int ONE_CONTAINER = 1;

    static int boxesForContainers = Boxes.cb;

    public static int countContainers() {
        int countFullContainers = boxesForContainers / CONTAINER_CAPACITY;  //число ящиков делим на 27

        if (boxesForContainers / CONTAINER_CAPACITY < ONE_CONTAINER) {

            return ONE_CONTAINER;
        }
        if (boxesForContainers % CONTAINER_CAPACITY == 0) {
            return countFullContainers;
        }
        if (boxesForContainers > CONTAINER_CAPACITY) {
            return countFullContainers + 1;
        }
        return countFullContainers;
    }
}

class Boxes {
    static int cb;

    public static int countBoxes(int countBoxes) {
        cb = countBoxes;
        return cb;
    }
}

