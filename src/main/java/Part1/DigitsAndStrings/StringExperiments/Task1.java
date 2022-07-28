package Part1.DigitsAndStrings.StringExperiments;

import java.nio.charset.Charset;
import java.util.Locale;
import java.util.SortedMap;

public class Task1 {
    public static void main(String[] args) {
        abc();
    }
    static void abc() {
        for (char i = 'a'; i < 'z'; i++) {
            System.out.println( i + " : " + Character.getNumericValue(i));
        }
        System.out.println("____________");
        for (char i = 'a'; i < 'z'; i++) {
            System.out.println( i + " : " + Character.getName(i));
        }
    }
}