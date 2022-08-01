package Part1.DigitsAndStrings.PhoneNumber;

import java.io.*;
import java.util.*;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumber {
    public static void main(String[] args) throws FileNotFoundException {

        //СТРОКА -ССЫЛКА :        C:\\IdeaProjects\\SergeCourse\\PN3.txt

        System.out.println("Введите ссылку на файл в формате: " +
                "C: / IdeaProjects / SergeCourse / PN3.txt");

        //Создаем объекты:
        FileProcessing fileProcessing1 = new FileProcessing();
        RegexProcessing regexProcessing1 = new RegexProcessing();
        TotalMap map1 = new TotalMap();

        // Сканируем файл:
        regexProcessing1.putNumsToLists(fileProcessing1.scanFile());

        // Отдельно кладем в HashMap списки валидных и невалидных номеров:
        System.out.println("Hashmap с валидными и невалидными номерами : ");
        System.out.println(map1.fillMap(regexProcessing1.getValids(), regexProcessing1.getInvalids()));

        System.out.println();
        System.out.println("Невалидные номера: ");
        System.out.println(regexProcessing1.getInvalids());

        System.out.println();
        System.out.println("Валидные номера: ");
        System.out.println(regexProcessing1.getValids());

        // форматируем строки (без удаления непечатных символов):
        List<String> validSTR = regexProcessing1.uniformValidStrings();

        // убираем пробелы и другие нецифровые символы:
        regexProcessing1.clearNondigits(validSTR);
        List<String> finalList = regexProcessing1.clearNondigits(regexProcessing1.uniformValidStrings());

        // печатаем список корректных номеров:
        for (String s : finalList) {
            System.out.println(s);
        }
        //строка - ссылка       C:\\IdeaProjects\\SergeCourse\\PN3.txt
    }
}
class FileProcessing {
    File scanFile() {
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();
        return new File(path);
    }
}
class RegexProcessing {

    String patternString = "^(\\+?[7-9]?[\\s?\\S?]\\(?)?9\\d\\d([\\s?\\S?])?\\s?\\d{3}\\D?\\d{2}\\D?\\d{2}$";
    Pattern p = Pattern.compile(patternString);

    public List<String> valids = new ArrayList<>();
    public List<String> invalids = new ArrayList<>();

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
    List<String> getInvalids() {
        return invalids;
    }

    List<String> getValids() {
        return valids;
    }

    //                       C:\\IdeaProjects\\SergeCourse\\PN3.txt

    List<String> uniformValidStrings() {
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
    List<String> clearNondigits(List<String> list) {   // в параметры идет validStringsList;
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
class TotalMap {
    Map<String, List<String>> commonMap = new HashMap<>();
    Map<String, List<String>> fillMap(List<String> valids, List<String> invalids) {
        commonMap.put("Невалидные номера", invalids);
        commonMap.put("Валидные номера", valids);
        return commonMap;
    }
}
