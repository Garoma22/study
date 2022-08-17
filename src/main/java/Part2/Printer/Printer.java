package Part2.Printer;

import java.io.*;
import java.util.*;

public class Printer {

    private int appendedPagesCount = 0;
    private int printedPagesCount = 0;

    public File appendFile(File onePage) {
        appendedPagesCount++;
        return onePage;
    }
    public void append_And_Print_SubList(List<File> sublist) throws FileNotFoundException {
        for (File f : sublist) {
            appendedPagesCount++;
            print(f);
        }
    }
    public void print(File file) throws FileNotFoundException {
        printedPagesCount++;
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }
        scanner.close();
    }
    public void clear(List<File> sublist) {
        sublist.clear();
    }
    public int getPendingPagesCount() {
        return appendedPagesCount;
    }

    public int getPrintedPagesCount() {
        return printedPagesCount;
    }
}



