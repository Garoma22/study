package Part2.CoolNumbers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;

import static Part2.CoolNumbers.CoolNumbers.*;


public class Main {

    public static void main(String[] args) throws IOException {


        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < numbers.length(); j++) {
                for (int k = 1; k < numbers.length(); k++) {
                        int[] arrRegions = {i, j, k};
                        generateCoolNumbers(arrRegions);
                    }
                }
            }

        System.out.println("Длина получившегося листа : " + list2.size());
        System.out.println("Запускаем bruteForceSearchInList: ");
        System.out.println(

                bruteForceSearchInList(list2, insertNum()));

        System.out.println("Запускаем binarySearchInList, введите номер для поиска:");
        System.out.println(

                binarySearchInList(list2, insertNum()));

        System.out.println("Запускаем searchInHashSet, введите номер для поиска:");

        searchInHashSet(arrIntoHashSet(list2), insertNum());

        System.out.println("Запускаем searchInTreeSet, введите номер для поиска");
        System.out.println(

                searchInTreeSet(arrToTreeSet(list2), insertNum()));

        clearFile();


    }
}
