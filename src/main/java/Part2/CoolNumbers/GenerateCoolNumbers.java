package Part2.CoolNumbers;

import java.io.*;
import java.util.*;

public class GenerateCoolNumbers {

    // ЭТИ РЕГУЛЯРКИ ДЛЯ ПОИСКА НОМЕРОВ ПО КРИТЕРИЯМ "КРАСИВОСТИ", ЕСЛИ БЫ БЫЛ СПИСОК РАЗНЫХ НОМЕРОВ.
    // НЕ ИСПОЛЬЗУЮТСЯ В ДАННОЙ ЗАДАЧЕ

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
    static int counter = 0;
    static final int RECORD_NUMBER_FREQUENCY = 12;

    static int a = 0;
    static int b = 1;
    static int c = 0;
    static int d = 0;
    static int e = 0;
    static int f = 0;
    static int g = 0;

    static String[] wordsArr = words.split("");
    static String[] numsArr = numbers.split("");

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
                if (index == RECORD_NUMBER_FREQUENCY) {
                    list2.add(s);  // добавление листа в один общий лист
                    bf.write(s + "\n");
                    index = 0;
                }
            }
            bf.flush();
            bf.close();

        } catch (IOException e) {
            //throw new RuntimeException(e.getMessage());
            System.out.println("Проблема при создании или записи файла");
        }
    }
    public static void clearFile() { //чистим файл чтобы при каждом окончании работы программы
        try {
            FileWriter fstream1 = new FileWriter("CoolNumsFile.txt");// конструктор с одним параметром - для перезаписи
            BufferedWriter out1 = new BufferedWriter(fstream1); //  создаём буферезированный поток
            out1.write(""); // очищаем, перезаписав поверх пустую строку
            out1.close(); // закрываем

        } catch (Exception e) {
            System.err.println("Error in file cleaning: " + e.getMessage());
        }
    }
}
