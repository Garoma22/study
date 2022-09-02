package Part2.TodoList;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static final TodoList todoList = new TodoList();
    public static void main(String[] args) {
        while (true) {
            System.out.println("Введите команду: ");
            Scanner scanner = new Scanner(System.in);
            String ss = String.valueOf(scanner.nextLine());

            String listing = "L?l?I?i?S?s?T?t?";
            String adding = "[a-dA-D]{3}";
            String addOnIndex = "[a-dA-D]{3}\\s+\\d+";
            String editing = "E?e?D?d?I?i?T?t?\\s+\\d+";
            String deleting = "D?d?E?e?L?l?E?e?T?t?E?e?\\s+\\d+";

            if (ss.matches(listing)) {
                todoList.showList();
            }
            if (ss.matches(adding)) {
                System.out.println("Сделайте запись : ");
                todoList.add(scanner.nextLine());
            }
            if (ss.matches(addOnIndex)) {      // выковыриваем цифру индекса из строки
                int num = todoList.findNum(ss);
                System.out.println("Сделайте запись (индекс уже определен) : ");
                todoList.insert(num, scanner.nextLine());
            }
            if (ss.matches(editing)){
                if (todoList.getSchedule().size()==0){
                    System.out.println("Лист пустой");
                    continue;
                }
                int num2 = todoList.findNum(ss);
                System.out.println("Замените пункт (индекс уже определен) : ");
                todoList.edit(num2,scanner.nextLine());
            }
            if(ss.matches(deleting)){
                int num3 = todoList.findNum(ss);
                System.out.println("Удаляем пункт (индекс уже определен) :");
                todoList.delete(num3);
            }
        }
    }
}