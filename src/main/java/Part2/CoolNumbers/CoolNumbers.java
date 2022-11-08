package Part2.CoolNumbers;

import java.util.*;

public class CoolNumbers {


    // ЭТИ РЕГУЛЯРКИ ДЛЯ ПОИСКА НОМЕРОВ ПО КРИТЕРИЯМ "КРАСИВОСТИ", ЕСЛИ БЫ БЫЛ СПИСОК РАЗНЫХ НОМЕРОВ.

    private final String regex1 = "[ABEKMHOPCTXY]{1}(1{3})*(2{3})*(3{3})*(4{3})*(5{3})*" +
            "(6{3})*(7{3})*(8{3})*(9{3})*[ABEKMHOPCTXY]{2}([0][123456789]{1}\\d{0,1})";

    private final  String regex2 = "[ABEKMHOPCTXY]{1}(1{3})*(2{3})*(3{3})*(4{3})*(5{3})*" +
            "(6{3})*(7{3})*(8{3})*(9{3})*[ABEKMHOPCTXY]{2}([1]\\d{1,2})?";

    // БУКВЫ: А, В, Е, К, М, Н, О, Р, С, Т, У, Х
    // создали 2 регулярки для проверки телефонных номеров с окончаниями на 01 и на 100
    // номера должны биться с одной из двух

    static String words = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static String numbers = "1234567890";
    public static final int REGION_FIRST_NUM = 1;
    public static final int REGION_LAST_NUM = 9;
    static List<String> list = new ArrayList<>();

    public static void generateCoolNumbers() {

        char[] arr = CoolNumbers.createArray();  // метод складывает 2 массива
        for (int i = 0; i < 2000005; i++) {

            String[] arrayCools = new String[9]; // массив - один крутой номерной знак

            for (int j = 0; j < arrayCools.length; j++) {  // проходимся по номерному знаку

                int p = (int) Math.floor(Math.random() * arr.length); // выбираем индекс символа из общего массива
                String simbol = String.valueOf(arr[p]); // записываем его значение в строку символ

                if (words.contains(simbol) && (j == 0 || j == 4 || j == 5)) {  // добавляем условие про буквы в номере
                    arrayCools[j] = simbol;
                }
                if (numbers.contains(simbol) && (j == 1) && Integer.parseInt(simbol) != 0) { // прописали одинаковые 3 цифры
                    arrayCools[1] = simbol;
                    arrayCools[2] = simbol;
                    arrayCools[3] = simbol;
                    j = j + 2;
                }

                //ПИШЕМ РЕГИОН

                // поиск первой цифры региона можно вынести в отдельны метод.
                if (j == 6) {

                    int startNumOfReg = (int) Math.round(Math.random());

                    String l = String.valueOf(startNumOfReg);

                    if (startNumOfReg == 0) {  // определяем вторую цифру региона если первая == 0. Например: 09
                        int d = (int) (Math.random() * ((REGION_LAST_NUM - REGION_FIRST_NUM) + 1)) + REGION_FIRST_NUM;
                        String ll = String.valueOf(d);
                        arrayCools[6] = l;
                        arrayCools[7] = ll;
                        arrayCools[8] = "";
                        break;
                    }
                    if (startNumOfReg == 1) {
                        arrayCools[6] = l;

                        arrayCools[7] = String.valueOf((int) Math.floor(Math.random() * 9));  // диапазон от 0 до 9

                        int d = (int) Math.round(Math.random());
                        if (d == 0) {
                            arrayCools[8] = String.valueOf((int) Math.floor(Math.random() * (10 - 1))); // диапазон от 0 до 9

                        } else {
                            arrayCools[8] = "";
                        }
                        break;
                    }
                }
                if (arrayCools[j] == null) {
                    j--;
                }
            }
            list.add(String.join("", arrayCools));
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
        for (String s : list) {
            System.out.println(s);
        }
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
        if(b){
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
