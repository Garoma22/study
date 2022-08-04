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

        // форматируем строки (без удаления нецифровых символов):
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

