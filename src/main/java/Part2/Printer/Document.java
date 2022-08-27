package Part2.Printer;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Document {
     private final List<File> queue;
     private static int countPage = 0;

    public Document(int countPages) throws IOException {   // сколько страниц в одном документе
        this.queue = new ArrayList<>();
        for (int i = 0; i < countPages; i++) {
            newFile();
        }
    }
    public void newFile() throws IOException {
        countPage++;
        Random random = new Random();
        String fileName = "P_";
        File file = new File(fileName + countPage);
        file.createNewFile();
        PrintWriter pw = new PrintWriter(file);
        pw.println("___ страница " + countPage);
        for (int i = 0; i < 5; i++) {
            pw.println(random.nextInt(10));
        }
        pw.println();
        pw.close();
        queue.add(file);
    }
    public List<File> getQueue() {
        return queue;
    }
}
