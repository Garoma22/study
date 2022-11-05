package Part2.CoolNumbers;

import java.util.Collections;
import java.util.HashSet;

import static Part2.CoolNumbers.CoolNumbers.*;


public class Main {

    public static void main(String[] args) {
        CoolNumbers.generateCoolNumbers();
        showNumbers();

        System.out.println("Запускаем bruteForceSearchInList: ");
        System.out.println(bruteForceSearchInList(list, insertNum()));


        System.out.println("Запускаем binarySearchInList, введите номер для поиска:");
        System.out.println(binarySearchInList(list, insertNum()));


        System.out.println("Запускаем searchInHashSet, введите номер для поиска:");
        searchInHashSet(arrIntoHashSet(list), insertNum());


        System.out.println("Запускаем searchInTreeSet, введите номер для поиска");
        System.out.println(searchInTreeSet(arrToTreeSet(list), insertNum()));


    }
}
