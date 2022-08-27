package Part2.Printer;

import java.io.*;
import java.util.*;
public class Printer {

    private final List<Document> documents;
    private int appendedPagesCount = 0;
    private int printedPagesCount = 0;

    public Printer() {
        this.documents = new ArrayList<>();
    }
    public void appendDocument(Document d) {
        documents.add(d);
        appendedPagesCount += d.getQueue().size(); // размер листа.
    }
    public void print() throws FileNotFoundException {
        for (Document f : documents) {
            for (File file : f.getQueue()) {
                printedPagesCount++;
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    System.out.println(scanner.nextLine());
                }
                scanner.close();
            }
        }
    }
    public void clear() {
        documents.clear();
        appendedPagesCount = 0;
    }
    public void getPendingPagesCount() {
        System.out.println("В очереди на печать страниц: " + appendedPagesCount);
    }
    public void getPrintedPagesCount() {
        System.out.println("Всего напечатано страниц: " + printedPagesCount);
    }
}








