package Part2.Printer;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        Printer printer = new Printer();
        Document document = new Document();

        // создаем 3 страницы
        document.newFile();  // на объекте создали пару файлов и положили в лист
        document.newFile();
        document.newFile();

        // добавляем 3 страницы в список на печать + тут же печатаем
        List<File> sublist = document.getQueue().subList(0, 3); // 3 exclusively
        printer.append_And_Print_SubList(sublist); // метод сразу вызывает print внутри себя

        // добавляем 1 страницу в общий список страниц
        document.newFile();
        // выбираем ее (или любую иную) по последнему индексу
        File oneFile1 = printer.appendFile(document.getQueue().get(3));
        printer.print(oneFile1); // печатаем отдельно

        System.out.println("Число добавленных страниц " + printer.getPendingPagesCount());
        System.out.println("Число распечатанных страниц " + printer.getPrintedPagesCount());

        System.out.println("Очищаем лист queue, размером " + document.getQueue().size());
        printer.clear(document.getQueue());

        System.out.println("Размер листа queue " + document.getQueue().size());

    }
}
