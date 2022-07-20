package Part1.DigitsAndStrings;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.Principal;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumber {

    public static void main(String[] args) throws IOException {

        List<ArrayList> allNumbers = new ArrayList<>();
        findList(allNumbers);
        System.out.println(allNumbers);
    }
    static void findList(List<ArrayList> allNumbers) {

        final int STANDART_NUM_LENGTH = 11;

        while (true) {
            ArrayList<String> stArr = new ArrayList<>();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Insert phone number: ");

            String num = scanner.nextLine();
            Pattern p = Pattern.compile("\\D*");

            Matcher m = p.matcher(num);  // не использую, надо номера в список добавить


            String[] ss = num.split("\\D*");
            System.out.println("Initial Phone number :");
            System.out.println(Arrays.toString(ss));
            for (String i : ss) {
                if (!i.equals("")) {
                    stArr.add(i);
                }
            }
            System.out.println("Get clear array :\n " + stArr);
            if (stArr.size() == STANDART_NUM_LENGTH) {
                if (stArr.get(0).equals("8")) {
                    stArr.set(0, "7");
                    allNumbers.add((ArrayList) stArr.clone());
                    System.out.println("Символов 11 в номере, первый символ 8" +
                            " (код выхода на мобильный номер) заменяем на код страны 7 — номер верный.");
                    System.out.println(allNumbers);
                    continue;
                }
            }
            if (stArr.get(0).equals("7")) {
                System.out.println("Символов 11 в номере, код страны 7 — номер верный.");
                allNumbers.add((ArrayList) stArr.clone());
                System.out.println(allNumbers);
                continue;
            }
            if (stArr.get(0).equals("9")) {
                System.out.println("Неверный формат номера: Символов 11 в номере, " +
                        "первый символ после очистки 9, это не 7 и не 8 — формат номера неверный.");

                System.out.println(allNumbers);
            }

            if (stArr.size() == STANDART_NUM_LENGTH - 1) {
                if (stArr.get(0).equals("9")) {
                    stArr.add(0, "7");
                    allNumbers.add((ArrayList) stArr.clone());
                    System.out.println("Количество символов 10 после очистки — значит, приводим к формату номера с 7.");
                    //stArr.clear();
                    System.out.println(allNumbers);
                    continue;
                }
            }
            if (stArr.size() > STANDART_NUM_LENGTH) {
                System.out.println("Символов в номере больше чем 11 — номер неверный.");
                System.out.println(allNumbers);
                continue;
            }
            if (stArr.size() < 9) {
                System.out.println("В номере " + stArr.size() + " символов — номер неверный.");
                System.out.println(allNumbers);
            }
        }
    }
}




