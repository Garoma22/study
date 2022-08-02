package Part1.DigitsAndStrings.PhoneNumber;

import java.io.File;
import java.util.Scanner;

class FileProcessing {
    File scanFile() {
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();
        return new File(path);
    }
}
