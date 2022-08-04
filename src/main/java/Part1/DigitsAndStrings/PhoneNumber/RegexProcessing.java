package Part1.DigitsAndStrings.PhoneNumber;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class RegexProcessing {

    private final String patternString = "^(\\+?[7-9]?[\\s?\\S?]\\(?)?9\\d\\d([\\s?\\S?])?\\s?\\d{3}\\D?\\d{2}\\D?\\d{2}$";
    private final Pattern p = Pattern.compile(patternString);

   private final List<String> valids = new ArrayList<>();
   private final List<String> invalids = new ArrayList<>();

    void putNumsToLists(File scanFile) throws FileNotFoundException {
        Scanner scanner = new Scanner(scanFile);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            Matcher m = p.matcher(line);

            if (m.find()) {
                valids.add(line);
            } else {
                invalids.add(line);
            }
        }
        scanner.close();
    }

    public List<String> getInvalids() {
        return invalids;
    }

    public List<String> getValids() {
        return valids;
    }

    //                       C:\\IdeaProjects\\SergeCourse\\PN3.txt

   public List<String> uniformValidStrings() {
        List<String> validStringsList = new ArrayList<>();

        for (String s : getValids()) {
            if (s.startsWith("8", 0)) {
                String s1 = s.replaceFirst("8", "7");
                validStringsList.add(s1);
            }
            if (s.startsWith("9", 0)) {
                String s1 = "7" + s;
                validStringsList.add(s1);
            }
            if (s.startsWith("+7")) {
                validStringsList.add(s);
            }
        }
        return validStringsList;
    }

   public List<String> clearNondigits(List<String> list) {   // в параметры идет validStringsList;
        List<String> finalList = new ArrayList<>();

        for (String s : getValids()) {
            if (!s.contains(" ") &&
                    !s.contains("+") &&
                    !s.contains(")") &&
                    !s.contains("(") &&
                    !s.contains("-")) {
                finalList.add(s);
            }
        }
        for (String s : list) {
            String s1 = s.replaceAll("\\D", "");
            finalList.add(s1);
        }
        return finalList;
    }
}
