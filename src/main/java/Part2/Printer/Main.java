package Part2.Printer;

import java.io.File;
import java.io.IOException;
import java.net.DatagramSocket;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        Printer printer = new Printer();
        Document document1 = new Document(2);
        Document document2 = new Document(2);

        printer.appendDocument(document1);
        printer.appendDocument(document2);
        printer.print();

        printer.getPrintedPagesCount(); // 4
        printer.getPendingPagesCount(); // 4

        System.out.println();
        System.out.println("____Очищаем очередь на печать __________");
        printer.clear();
        System.out.println();

        printer.getPrintedPagesCount(); // 4
        printer.getPendingPagesCount(); // 0
    }
}
