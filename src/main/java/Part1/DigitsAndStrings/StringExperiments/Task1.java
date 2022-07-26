package Part1.DigitsAndStrings.StringExperiments;

import java.nio.charset.Charset;
import java.util.Locale;
import java.util.SortedMap;

public class Task1 {
    public static void main(String[] args) {
        String literals = "abcdefghijklmnopqrstuvwxyz";
        literals = literals.toUpperCase(Locale.ROOT);
        abc(literals);
    }
    static void abc(String l) {
        char[] chars = l.toCharArray();
        for (char c : chars){
            System.out.println( c + " : " + Character.getNumericValue(c));
        }
        System.out.println("____________");
        for (char c : chars){
            System.out.println( c + " : " + Character.getName(c));
        }
    }
}