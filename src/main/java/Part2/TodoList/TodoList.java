package Part2.TodoList;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class TodoList {

    private final List<String> schedule = new ArrayList<>();

    public List<String> getSchedule() {
        return schedule;
    }

    public void add(String todo) {
        schedule.add(todo);
    }

    public void insert(int index, String todo) {
        if (schedule.size() + 1 >= index) {
            schedule.add(index, todo);
        } else {
            System.out.println("Вставка невозможна, лист короткий");
        }
    }
    public void edit(int index, String todo) {
        schedule.remove(index);
        schedule.add(index, todo);
    }

    public void delete(int index) {
        if (index <= schedule.size() + 1) {
            schedule.remove(index);}
        else {
            System.out.println("Такого индекса нет");
        }
    }
    public List<String> getTodos() {
        System.out.println(schedule);
        return schedule;
    }
    public void showList() {
        int counter = 0;
        System.out.println("TodoList :");
        for (String s : schedule) {
            counter++;
            System.out.println(counter + ". " + s);
        }
    }
}



