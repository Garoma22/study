package Part2;

import java.util.Arrays;
import java.util.Comparator;

public class Task1 {

    public String[] createArr(String s) {
        String[] array = s.split("\\s");
        return array;
    }
    public String[] clearArr(String[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].endsWith(",")) {
                array[i] = array[i].replace(",", "");
            }
            if (array[i].endsWith(".")) {
                array[i] = array[i].replace(".", "");
            }
        }
        return array;
    }
    public String[] reflectArray(String[] array) {
        Arrays.sort(array, Comparator.reverseOrder());
        return array;
    }
    public static void main(String[] args) {
        String s = "Каждый охотник желает знать, где сидит фазан.";
        Task1 arr = new Task1();

        System.out.println(Arrays.toString(arr.reflectArray(arr.clearArr(arr.createArr(s)))));
    }
}

