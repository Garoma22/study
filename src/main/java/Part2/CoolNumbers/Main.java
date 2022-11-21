package Part2.CoolNumbers;
import static Part2.CoolNumbers.CompareSpeedOfSearch.*;
import static Part2.CoolNumbers.GenerateCoolNumbers.*;

public class Main {

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < numbers.length(); j++) {
                for (int k = 1; k < numbers.length(); k++) {
                        int[] arrRegions = {i, j, k};
                        generateCoolNumbers(arrRegions);
                    }
                }
            }
        System.out.println("Длина получившегося листа : " + list2.size());
        System.out.println("Запускаем bruteForceSearchInList, введите номер для поиска: ");
        System.out.println(

                bruteForceSearchInList(list2, insertNum()));

        System.out.println("Запускаем binarySearchInList, введите номер для поиска:");
        System.out.println(

                binarySearchInList(list2, insertNum()));

        System.out.println("Запускаем searchInHashSet, введите номер для поиска:");

        System.out.println(

                searchInHashSet(arrIntoHashSet(list2), insertNum()));

        System.out.println("Запускаем searchInTreeSet, введите номер для поиска");
        System.out.println(

                searchInTreeSet(arrToTreeSet(list2), insertNum()));

        clearFile();
    }
}
