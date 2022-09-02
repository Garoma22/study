package Part2.TodoList;

import java.util.ArrayList;
import java.util.List;

public class TodoList {
    private final List<String> schedule = new ArrayList<>();
    public void add(String todo) {
        schedule.add(todo);
        showList();
    }

    public void insert(int index, String todo) {
        if (schedule.size() + 1 >= index) {
            schedule.add(index, todo);
            showList();
        } else {
            schedule.add(todo);
            showList();
        }
    }
    public void edit(int index, String todo) {

        if (schedule.size() + 1 >= index && schedule.size()!= 0) {
            schedule.remove(index);
            schedule.add(index, todo);
        }else{
            System.out.println("Редактировать нечего или такого индекса нет");
        }
        showList();
    }
    public void delete(int index) {
        if (index <= schedule.size() + 1) {
            schedule.remove(index);
            showList();
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
    public int findNum(String ss) {  //EDIT 3
        char[] arr1 = ss.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : arr1) {
            if (c == '0' ||
                    c == '1' ||
                    c == '2' ||
                    c == '3' ||
                    c == '4' ||
                    c == '5' ||
                    c == '6' ||
                    c == '7' ||
                    c == '8' ||
                    c == '9') {
                sb.append(c);
            }
        }
        int num = Integer.parseInt(String.valueOf(sb)) - 1;
        if (num < 0) {
            num = 0;
        }
        return num;
    }
    public List<String> getSchedule() {
        return schedule;
    }
}



