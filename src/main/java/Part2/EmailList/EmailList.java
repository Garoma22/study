package Part2.EmailList;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailList {
    private final Set<String> emails = new TreeSet<>();
    public static final String WRONG_EMAIL_ANSWER = "Неверный формат email";

    public void add(String email) {
        // TODO: валидный формат email добавляется, email это строка, она быть может любой
        // принять решение добавлять аргумент email или нет должен этот метод
        // РОМА: НЕ ЯСНО ПОЧЕМУ ТЭТОТ МЕТОД ДОЛЖЕН ПРИНИМАТЬ РЕШЕНИЕ

        emails.add(email);
    }

    public List<String> getSortedEmails() {
        // TODO: возвращается сортированный список электронных адресов в алфавитном порядке
        // НЕ ЯСНО ЗАЧЕМ НУЖЕН МЕТОД ЕСЛИ МНОЕЖСТОВ SET внутри себя делает сортировку.

        return new ArrayList<>();
    }
    public void showSortedEmails() {
        int counter = 1;
        for (String s : emails) {
            System.out.println(counter + ". " + s.toLowerCase());
            counter++;
        }
    }
    public void scanCommands(EmailList emailList) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите команду:  ");

            String input = scanner.nextLine();
            String list = "LIST";

            String add = "ADD\\s\\w+([.-]?\\w+)*@\\w+([.-]?\\w+)*\\.\\w{1,3}";
            Pattern p = Pattern.compile(add);
            Matcher m = p.matcher(input);

            if (input.equals(list) && emailList.emails.isEmpty()) {
                System.out.println("Список пока пуст");
                continue;
            }
            if (input.equals(list)) {
                emailList.showSortedEmails();
                continue;
            }
            if (m.find()) {
                String[] arr = input.split(" ");
                String email = arr[1];
                emailList.emails.add(email);
            } else {
                System.out.println(WRONG_EMAIL_ANSWER);
            }
        }
    }
}
