package Part2;

import java.util.Arrays;
import java.util.Comparator;

class Task1 {
    public String[] createArr(String s) {
        String[] arr = s.split("\\s");
        System.out.println(Arrays.toString(arr));
        return arr;
    }
    public String[] reverseArr(String[] arr) {
        String s;

        for (int i = 0; i < arr.length/2; i++) {
            s = arr[i];
            arr[i] = arr[arr.length -1 -i];
            arr[arr.length -1 -i] = s;
        }
return arr;
    }
}
public class ReverseArray {
    public static void main(String[] args) {
        String s = "каждый охотник желает знать, где сидит фазан";
        Task1 t = new Task1();
        System.out.println(Arrays.toString(t.reverseArr(t.createArr(s))));
    }
}




