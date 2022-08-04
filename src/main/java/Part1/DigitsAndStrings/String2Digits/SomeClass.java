package Part1.DigitsAndStrings.String2Digits;

public class SomeClass {
    public static int sumDigits(String str){
        int sum = 0;
        int counter;
        for (int i = 0; i < str.length(); i++) {
            counter = Integer.parseInt(String.valueOf(str.charAt(i)));
            sum += counter;
        }
        return sum;
    }
    public static void main(String[] args) {
        System.out.println(sumDigits("891"));
        System.out.println(sumDigits("12345"));
        System.out.println(sumDigits("10"));
        System.out.println(sumDigits("25059191"));
    }
}







