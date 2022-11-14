package Part2.CoolNumbers;

import java.io.*;
import java.util.*;
import java.util.function.ToDoubleBiFunction;

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
    public static final int REGION_FIRST_NUM = 1;
    public static final int REGION_LAST_NUM = 9;
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
//    static String[] totalArr = {wordsArr[a], numsArr[b], numsArr[b], numsArr[b], wordsArr[c], wordsArr[d],
//            numsArr[e], numsArr[f], numsArr[g]};

    public static boolean doesFileExist() {
        File file = new File("CoolNumsFile.txt");
        if (file.exists()) {
            return true;
        }
        return false;
    }

    public static String ReadLastLine() throws IOException {
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

    public static void generateCoolNumbers() throws IOException {

        while (e != 2) {
            while (f != numsArr.length) {
                while (g != numsArr.length) {
                    while (d != wordsArr.length) {
                        while (c != wordsArr.length) {
                            while (a != wordsArr.length) {
                                while (b != 10) {

                                  String[] totalArr = {wordsArr[a], numsArr[b], numsArr[b], numsArr[b], wordsArr[c], wordsArr[d],
                                            numsArr[e], numsArr[f], numsArr[g]};

                                    if (counter < 20000000) {
                                        list.add(String.join("", totalArr));
                                        b++; // это номер
                                        counter++;
                                    }
                                    if (counter == 20000000) {
                                        listToFile();
                                        list.clear();
                                        counter = 555;
                                        System.out.println(counter);
                                        System.out.println(ReadLastLine());
                                        System.out.println(Arrays.toString(totalArr));
                                    }
                                    if (counter == 40000000) {
                                        System.out.println(list.size() + " Длина листа");
                                        System.out.println(list2.size() + " Длина листа 2");
                                    }
                                }
                                b = 0; // то есть 3 первые цифры стали равны 111
                                a++;   // первая буква увеличивается + 1
                            }
                            a = 0;
                            c++;
                        }
                        c = 0;
                        d++;
                    }
                    d = 0;             // e\f\g меняем на   \\ g\f\e
                    // это делается для того, чтобы отсчет шел с конца региона
                    g++;
                }
                g = 0;
                f++;
            }
            f = 0;
            e++;
        }
    }


    public static char[] createArray() {  // создали массив общий

        char[] charsWords = words.toCharArray();
        char[] charsNums = numbers.toCharArray();
        char[] result = new char[charsNums.length + charsWords.length];

        System.arraycopy(charsWords, 0, result, 0, charsWords.length);
        int j = 0;
        for (int i = charsWords.length; i < result.length; i++) {
            result[i] = charsNums[j];
            j++;
        }
        return result;
    }

    public static void showNumbers() {
        int counter = 0;
        for (String s : list) {
            counter++;
            if (counter == 333333) {
                System.out.println(s);
                counter = 0;
            }
        }
    }


    // TODO : тут перезаписывается файл и поэтому не получается его дописать. Надо это пофиксить

    public static void listToFile() {
        File file = new File("CoolNumsFile.txt");
        try {
            BufferedWriter bf = new BufferedWriter(new FileWriter(file, true));
            int index = 0;
            for (String s : list) {
                index++;
                if (index == 333333) {
                    bf.write(s + "\n");
                    index = 0;
                }
            }
            // counter = 2000001;  // условие, которое дает возможность вернуться в метод generateCoolNumbers() в нужную часть ветвления
            bf.flush();
            bf.close();
            generateCoolNumbers();

            //
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void listToFile2() throws IOException {
        FileWriter writer = new FileWriter("CoolNumsFile.txt", true);

        int index = 0;
        if (counter > 20000000) {
            for (String s : list2) {
                index++;
                if (index == 333333) {
                    writer.write(s + "\n");
                    System.out.println();
                    index = 0;
                }
            }
        }
        writer.close();
    }

    public static String insertNum() {  // СКАНЕР ДЛЯ ВООДА ИСКОМОГО НОМЕРА
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static boolean bruteForceSearchInList(List<String> list, String number) {
        System.out.println("Введите номер для поиска");
        long startTime = System.nanoTime();
        for (String s : list) {
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
