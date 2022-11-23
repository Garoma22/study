package Part2.CoolNumbers;
import java.util.*;
public class CompareSpeedOfSearch {

    // СКАНЕР ДЛЯ ВООДА ИСКОМОГО НОМЕРА
    public static String insertNum() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    //ПРОСТОЙ ПОИСК ПО ЛИСТУ
    public static boolean bruteForceSearchInList(List<String> list2, String number) {
        System.out.println("Введите номер для поиска");
        long startTime = System.nanoTime();
        for (String s : list2) {
            if (s.equals(number)) {
                long nano_endTime = System.nanoTime();
                System.out.println("Скорость работы метода bruteForceSearchInList : " +
                        (nano_endTime - startTime) + " mls.");
                return true;
            }
        }
        return false;
    }
    //БИНАРНЫЙ ПОИСК
    public static boolean binarySearchInList(List<String> sortedList, String number) {
        Collections.sort(sortedList);
        long startTime = System.nanoTime();

        int pos = Collections.binarySearch(sortedList, number);

        if (pos != 0) {
            long nano_endTime = System.nanoTime();
            System.out.println("Позиция номера в листе:  " + pos + "\nСкорость поиска  binarySearchInList : " +
                    (nano_endTime - startTime) + " mls.");
            return true;
        }
        return false;
    }

    // ПЕРЕВОДИМ ЛИСТ В HASHSET
    public static HashSet<String> arrIntoHashSet(List<String> list) {
        return new HashSet<>(list);
    }
    //ИЩЕМ ПО HASHSET
    public static boolean searchInHashSet(HashSet<String> hashSet, String number) {
        long startTime = System.nanoTime();
        boolean b = hashSet.contains(number);
        if (b) {
            long nano_endTime = System.nanoTime();
            System.out.println("Элемент " + number + " содержится в HashSet" +
                    "\nСкорость поиска  binarySearchInHashSet : " +
                    (nano_endTime - startTime) + " mls.");
            return true;
        }
        return false;
    }

    // ПЕРЕВОДИМ ЛИСТ В ТРИСЕТ
    public static TreeSet<String> arrToTreeSet(List<String> list) {
        return new TreeSet<>(list);
    }
    // ИЩЕМ ПО ТРИСЕТ
    public static boolean searchInTreeSet(TreeSet<String> treeSet, String number) {
        long startTime = System.nanoTime();
        if (treeSet.contains(number)) {
            long nano_endTime = System.nanoTime();
            System.out.println("Элемент " + number + " содержится в TreeSet" +
                    "\nСкорость поиска  searchInTreeSet : " +
                    (nano_endTime - startTime) + " mls.");
            return true;
        }
        return false;
    }
}
