package Part2.CoolNumbers;

import java.io.*;
import java.util.*;

public class CoolNumbers {

    // ЭТИ РЕГУЛЯРКИ ДЛЯ ПОИСКА НОМЕРОВ ПО КРИТЕРИЯМ "КРАСИВОСТИ", ЕСЛИ БЫ БЫЛ СПИСОК РАЗНЫХ НОМЕРОВ.

    private final String regex1 = "[ABEKMHOPCTXY]{1}(1{3})*(2{3})*(3{3})*(4{3})*(5{3})*" +
            "(6{3})*(7{3})*(8{3})*(9{3})*[ABEKMHOPCTXY]{2}([0][123456789]{1}\\d{0,1})";

    private final String regex2 = "[ABEKMHOPCTXY]{1}(1{3})*(2{3})*(3{3})*(4{3})*(5{3})*" +
            "(6{3})*(7{3})*(8{3})*(9{3})*[ABEKMHOPCTXY]{2}([1]\\d{1,2})?";

    // БУКВЫ: А, В, Е, К, М, Н, О, Р, С, Т, У, Х
    // создали 2 регулярки для проверки телефонных номеров с окончаниями на 01 и на 100
    // номера должны биться с одной из двух

    static String words = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static String numbers = "0123456789";
    static List<String> list = new ArrayList<>();
    static List<String> list2 = new ArrayList<>();
    static int counter = 0; // переменная счетчик

    static int a = 0;
    static int b = 1;
    static int c = 0;
    static int d = 0;
    static int e = 0;
    static int f = 0;
    static int g = 0;

    static String[] wordsArr = words.split("");
    static String[] numsArr = numbers.split("");

    public static boolean doesFileExist() {
        File file = new File("CoolNumsFile.txt");
        return file.exists();
    }

    public static String ReadLastLine() {
        File file = new File("CoolNumsFile.txt");
        String result;
        try (RandomAccessFile raf = new RandomAccessFile(file, "r")) { //r это read mode
            result = null;
            long startIdx = file.length();
            while (result == null || result.length() == 0) {
                raf.seek(startIdx--);
                raf.readLine();
                result = raf.readLine();
            }
        } catch (IOException ex) {
            return null;
        }
        return result;
    }

    // генерим за один запуск метода все номера для одного региона.
    // Для какого именно региона - передавать в аргументах метода.
    // сам метод generateCoolNumbers() скидывает номера в файл.
    // метод listToFile() принимает в АРГУМЕНТЫ это лист, а не вызывает generateCoolNumbers()\
    // а generateCoolNumbers() у меня запускается методом-нашлепкой, который циклом сидывает в него номера регоинов тоже в аргументы


    public static void generateCoolNumbers(int[] arrRegions) {

        while (d != wordsArr.length) {
            while (c != wordsArr.length) {
                while (a != wordsArr.length) {
                    while (b != 10) {

                        String[] totalArr = {wordsArr[a], numsArr[b], numsArr[b], numsArr[b], wordsArr[c], wordsArr[d],
                                String.valueOf(arrRegions[0]), String.valueOf(arrRegions[1]), String.valueOf(arrRegions[2])};

                        list.add(String.join("", totalArr));
                        b++; // это номер
                        counter++;
                    }
                    b = 1; // то есть 3 первые цифры стали равны 111
                    a++;   // первая буква увеличивается + 1
                }
                a = 0;
                c++;
            }
            c = 0;
            d++;
        }
        d = 0;
        listToFile(list);
        list.clear();
    }

    public static void listToFile(List<String> list) {
        File file = new File("CoolNumsFile.txt");
        try {
            file.createNewFile();

            BufferedWriter bf = new BufferedWriter(new FileWriter(file, true));
            int index = 0;
            for (String s : list) {

                index++;
                if (index == 20) {
                    list2.add(s);
                    bf.write(s + "\n");
                    index = 0;
                }
            }
            bf.flush();
            bf.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void clearFile() {
        try {
            FileWriter fstream1 = new FileWriter("CoolNumsFile.txt");// конструктор с одним параметром - для перезаписи
            BufferedWriter out1 = new BufferedWriter(fstream1); //  создаём буферезированный поток
            out1.write(""); // очищаем, перезаписав поверх пустую строку
            out1.close(); // закрываем

        } catch (Exception e) {
            System.err.println("Error in file cleaning: " + e.getMessage());
        }
    }
    public static String insertNum() {  // СКАНЕР ДЛЯ ВООДА ИСКОМОГО НОМЕРА
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
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
