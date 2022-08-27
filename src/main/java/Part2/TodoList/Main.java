package Part2.TodoList;

import java.util.regex.Pattern;

public class Main {
    private static TodoList todoList = new TodoList();

    public static void main(String[] args) {


        // Создать регулярное выражение из строки "LIST,ADD,EDIT,DELETE"

        String s = "LIST,ADD,EDIT,DELETE";

        Pattern p = Pattern.compile(s);




    }
}
