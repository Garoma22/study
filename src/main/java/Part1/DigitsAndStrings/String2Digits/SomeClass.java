package Part1.DigitsAndStrings.String2Digits;

public class SomeClass {
    public static void main(String[] args) {

        System.out.println(sumDigits("891"));
        System.out.println(sumDigits("12345"));
        System.out.println(sumDigits("10"));
        System.out.println(sumDigits("25059191"));

    }
    static int sumDigits(String str){
        int sum = 0;
        String [] ss = str.split("");
        for(String s : ss){
            sum += Integer.parseInt(s);
        }
        return sum;
    }
}
