package Part2.ReverseArray;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        String s = "каждый охотник желает знать, где сидит фазан";
        ReverseArray reverseArray = new ReverseArray();
        System.out.println(Arrays.toString(reverseArray.reverse(reverseArray.createArr(s))));
    }


}
