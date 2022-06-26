package Part1.ObjectsAndClasses.Computer;


import static Part1.ObjectsAndClasses.Computer.Computer.*;

public class Main {
    public static void main(String[] args) {

        Computer computer1 = new Computer("My computer", "Apple");

        Processor processor = new Processor();
        computer1.setProcessor(processor);

        Storage storage = new Storage();
        computer1.setStorage(storage);

        RAM ram = new RAM();
        computer1.setRam(ram);

        Monitor monitor = new Monitor();
        computer1.setMonitor(monitor);

        Keyboard keyboard = new Keyboard();
        computer1.setKeyboard(keyboard);

        System.out.println();
        System.out.println(computer1);

        computer1.countWeight();
    }
}
