package Part2.TodoList;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static Part2.TodoList.Main.todoList;

public class TodoList {
    private final List<String> schedule = new ArrayList<>();

    public void add(String todo) {
        schedule.add(todo);
    }

    public void insert(int index, String todo) {
        if (index >= 1 && index <= schedule.size()) {
            schedule.add(index -1, todo);
        } else {
            schedule.add(todo);
        }
    }
    public void edit(int index, String todo) {
        if (index >= 1 && index <= schedule.size()) {
            schedule.remove(index - 1);
            schedule.add(index-1, todo);
        } else {
            System.out.println("Редактировать нечего или такого индекса нет");
        }
    }
    public void delete(int index) {
        if (index >= 1 && index <= schedule.size()) {
            schedule.remove(index - 1);
        } else {
            System.out.println("Такого индекса нет");
        }
    }
    public void showList() {
        int counter = 0;
        System.out.println("TodoList :");
        for (String s : schedule) {
            counter++;
            System.out.println(counter + ". " + s);
        }
    }
    public List<String> getSchedule() {
        return schedule;
    }
    public void checkRegex() {
        while (true) {
            System.out.println("Введите команду: ");
            Scanner scanner = new Scanner(System.in);
            String ss = String.valueOf(scanner.nextLine());

            String listing = "LIST";
            String adding = "ADD";
            String addOnIndex = "ADD\\s+\\d+";
            String editing = "EDIT\\s+\\d+";
            String deleting = "DELETE\\s+\\d+";

            if (ss.matches(listing)) {
                todoList.showList();
            }
            if (ss.matches(adding)) {
                System.out.println("Сделайте запись : ");
                todoList.add(scanner.nextLine());
            }
            if (ss.matches(addOnIndex)) {      // выковыриваем цифру индекса из строки
                String[] arr = ss.split(" ");
                int num = Integer.parseInt(arr[1]);

                System.out.println("Сделайте запись (индекс уже определен) : ");
                todoList.insert(num, scanner.nextLine());
            }
            if (ss.matches(editing)) {
                if (todoList.getSchedule().size() == 0) {
                    System.out.println("Лист пустой");
                }
                String[] arr = ss.split(" ");
                int num = Integer.parseInt(arr[1]);
                System.out.println("Замените пункт (индекс уже определен) : ");
                todoList.edit(num, scanner.nextLine());
            }
            if (ss.matches(deleting)) {
                String[] arr = ss.split(" ");
                int num = Integer.parseInt(arr[1]);
                if (num < 1) {
                    num = 0;
                }
                System.out.println("Удаляем пункт (индекс уже определен) :");
                todoList.delete(num);
            }
        }
    }
}




