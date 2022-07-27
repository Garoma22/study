package Part1.DigitsAndStrings.StringExperiments;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        while (true) {
            Card card = new Card();
            System.out.println("Введите номер карты в указанном формате : \n" +
                    "«Номер кредитной карты <1111 1111 1111> 1111»");
            // String text = "«Номер кредитной карты <4008 1234 5678> 8912»";
            System.out.println(card.hideNumbers(card.parseNumber()));
        }
    }
}
class Card {
    String parseNumber() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
    String hideNumbers(String text) {
        int start = text.indexOf("<");
        int finish = text.indexOf(">");
        String toHide = text.substring(start , finish+1);
        return text.replace(toHide, "***");
    }
}
