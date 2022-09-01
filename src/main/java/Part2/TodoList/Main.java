package Part2.TodoList;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static final TodoList todoList = new TodoList();

    public static void main(String[] args) {

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите команду: ");

            String line = scanner.nextLine();
            switch (line) {
                case "LIST":
                    if(todoList.getTodos().size() == 0){
                        System.out.println("Список пустой");
                        continue;
                    }
                //    todoList.getTodos();
                    todoList.showList();
                    break;
                case "ADD":
                    System.out.println("Сделайте запись в todoList : ");
                    String appointment1 = scanner.nextLine();
                    todoList.add(appointment1);
                    break;
                case "ADD2":
                    System.out.println("Укажите номер ячейки,куда вставить запись : ");
                    int numForAdd = Integer.parseInt(scanner.nextLine()) - 1 ; // единица нужна чтобы не было нулевого дела в списке
                    System.out.println("Сделайте запись в todoList : ");
                    String appointment3 = scanner.nextLine();
                    todoList.insert(numForAdd,appointment3);
                    break;
                case "EDIT":
                    System.out.println("Укажите номер ячейки на замену : ");
                    int numForEdit = Integer.parseInt(scanner.nextLine()) - 1 ; // единица нужна чтобы не было нулевого дела в списке
                    System.out.println("Сделайте запись в todoList : ");
                    String appointment4 = scanner.nextLine();
                    if (numForEdit>todoList.getSchedule().size()){
                        System.out.println("Такой ячейки пока нет");
                        continue;
                    }
                    todoList.edit(numForEdit,appointment4);
                    break;
                case "DELETE":
                    System.out.println("Укажите номер ячейки на удаление : ");
                        int numForDel = Integer.parseInt(scanner.nextLine()) - 1 ;
                        todoList.delete(numForDel);
                    break;
                default:
                    System.out.println("МИМО");
            }
        }
    }
}



