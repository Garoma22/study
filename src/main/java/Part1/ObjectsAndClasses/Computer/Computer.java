package Part1.ObjectsAndClasses.Computer;

class Computer {

    private final String name;
    private final String vendor;
    private final Processor processor;
    private final RAM ram;
    private final Storage storage;
    private final Monitor monitor;
    private final Keyboard keyboard;

    public Computer(String name, String manufacturer) {
        this.name = name;
        this.vendor = manufacturer;
        this.processor = new Processor();
        this.ram = new RAM();
        this.storage = new Storage();
        this.monitor = new Monitor();
        this.keyboard = new Keyboard();
    }
    static final class Processor {
        final int frequency = 1700;
        final String core = "M1";
        final String manufacturer = "Apple";
        final double weight = 900;
    }
    static final class RAM {    //random access memory;
        final String type = "DDR4";
        final int volumeRAM = 16;
        final double weight = 125;
    }
    static final class Storage {
        final String type = "SSD";
        final int volumeStorage = 512;
        final double weight = 230;
    }
    static final class Monitor {
        final int diagonal = 26;
        final String type = "IPS";  // IPS, TN, VA
        final double weight = 1550;
    }
    static class Keyboard {
        final String type = "Wireless";
        final boolean backlight = true;
        final double weight = 450;
    }
    @Override
    public String toString() {
        return " COMPUTER NAME : " + name + '\n' +
                " MANUFACTURER :  " + vendor + '\n' + '\n' +
                " PROCESSOR : " + '\n' +
                "____PRODUCER : " + processor.manufacturer + '\n' +
                "____CORE : " + processor.core + '\n' +
                "____FREQUENCY :" + processor.frequency + '\n' + '\n' +
                " RAM : " + '\n'
                + "____TYPE : " + ram.type + '\n'
                + "____VOLUME : " + ram.volumeRAM + '\n'
                + "____WEIGHT : " + ram.weight + '\n' + '\n'
                + " STORAGE : " + '\n'
                + "____TYPE : " + storage.type + '\n'
                + "____WEIGHT : " + storage.weight + '\n'
                + "____VOLUME : " + storage.volumeStorage + '\n' + '\n'
                + " MONITOR : " + '\n'
                + "____DIAGONAL : " + monitor.diagonal + '\n'
                + "____TYPE : " + monitor.type + '\n'
                + "____WEIGHT : " + monitor.weight + '\n' + '\n'
                + " KEYBOARD : " + '\n'
                + "____TYPE : " + keyboard.type + '\n'
                + "____BACKLIGHT : " + keyboard.backlight + '\n'
                + "____WEIGHT : " + keyboard.weight;
    }


    void countWeight() {
        double totalWeight = keyboard.weight + monitor.weight + storage.weight + ram.weight + processor.weight;
        System.out.println();
        System.out.println("Total weight is : " + totalWeight);
    }


}









