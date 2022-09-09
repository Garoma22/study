package Part2.TodoList;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static final TodoList todoList = new TodoList(scanner);

    public static void main(String[] args) {
        todoList.checkRegex();
    }
}









