package Part2.ReverseArray;

import java.util.Arrays;

public class ReverseArray {

    public String[] reverse(String[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            String s = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = s;
        }
        return arr;
    }

    public String[] createArr(String s) {
        String[] arr = s.split("\\s");
        System.out.println(Arrays.toString(arr));
        return arr;
    }

}