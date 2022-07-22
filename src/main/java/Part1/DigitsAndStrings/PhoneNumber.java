package Part1.DigitsAndStrings;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumber {
    public static void main(String[] args) throws IOException {
        System.out.println("База телефонных номеров подгружена в PN3.txt");
        clearStrings(scanFile(getNewFile()));
    }
    static File getNewFile() {
        String path = "C:\\IdeaProjects\\SergeCourse\\PN3.txt";
        return new File(path);
    }
    public static List scanFile(File newFile) throws FileNotFoundException {
        Scanner scanner = new Scanner(getNewFile());
        String patternString = "^(\\+?[7-9]?[\\s?\\S?]\\(?)?9\\d\\d[\\s?\\S?]\\s?\\d{3}\\D?\\d{2}\\D?\\d{2}$";
        Pattern p = Pattern.compile(patternString);

        List<String> validNumbers = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            Matcher m = p.matcher(line);
            if (m.find()) {
                validNumbers.add(line);
            }
        }
        scanner.close();
        return validNumbers;
    }

    static void clearStrings(List<String> validNumbers) {
        int normalLength = 11;
        ArrayList<String> cleanString = new ArrayList<>();
        List<List> finalList = new ArrayList<>();

        for (String oneString : validNumbers) {
            String[] sStingArr = oneString.split("\\D*");
            if (sStingArr[0].equals("8")) {
                sStingArr[0] = "7";
            }
            for (String i : sStingArr) {
                if (!i.equals("")) {
                    cleanString.add(i);
                }
            }
            finalList.add((List) cleanString.clone());
            cleanString.clear();
        }
        for (List s : finalList) {
            if (s.size() == normalLength - 1) {
                if (s.get(0).equals("9")) {
                    s.add(0, "7");
                }
            }
        }
        for (List s : finalList) {
            String[] utillsArr =new String[normalLength];
            for (int i = 0; i < s.size(); i++) {
                utillsArr[i] = (String) s.get(i);
            }
            String arrToString = String.join("",utillsArr);
            System.out.println(arrToString);
        }
    }
}



