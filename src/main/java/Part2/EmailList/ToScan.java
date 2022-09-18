package Part2.EmailList;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ToScan {
   private static final String WRONG_COMMAND = "Некорректная команда или ошибка в формате ввода E-mail";

    public void scanCommands(EmailList emailList) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите команду (ADD test@gmail.com, LIST) :  ");

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
                emailList.add(email);
            } else {
                System.out.println(WRONG_COMMAND);
                // заменил название константы с WRONG_EMAIL_ANSWER на WRONG_COMMAND
                // потому что  String input = scanner.nextLine(); принимает значения и
                // для команды LIST, а не только для ADD email
            }
        }
    }
}
