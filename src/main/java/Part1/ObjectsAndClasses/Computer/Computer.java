package Part1.ObjectsAndClasses.Computer;

class Computer {

    private final String name;
    private final String vendor;
    private Processor processor;
    private RAM ram;
    private Storage storage;
    private Monitor monitor;
    private Keyboard keyboard;

    public Computer(String name, String manufacturer) {
        this.name = name;
        this.vendor = manufacturer;
        this.processor = getProcessor();
        this.ram = getRam();
        this.storage = getStorage();
        this.monitor = getMonitor();
        this.keyboard = getKeyboard();   // подставляем геттеры в качестве ссылок на объект.
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

    public String getName() {
        return name;
    }

    public String getVendor() {
        return vendor;
    }

    public Processor getProcessor() {
        return processor;
    }

    public void setProcessor(Processor processor) {
        this.processor = processor;
    }

    public RAM getRam() {
        return ram;
    }

    public void setRam(RAM ram) {
        this.ram = ram;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public Monitor getMonitor() {
        return monitor;
    }

    public void setMonitor(Monitor monitor) {
        this.monitor = monitor;
    }

    public Keyboard getKeyboard() {
        return keyboard;
    }

    public void setKeyboard(Keyboard keyboard) {
        this.keyboard = keyboard;
    }
}

class Processor {
    final int frequency = 1700;
    final String core = "M1";
    final String manufacturer = "Apple";
    final double weight = 900;
}

class RAM {    //random access memory;
    final String type = "DDR4";
    final int volumeRAM = 16;
    final double weight = 125;
}

class Storage {
    final String type = "SSD";
    final int volumeStorage = 512;
    final double weight = 230;
}

class Monitor {
    final int diagonal = 26;
    final String type = "IPS";  // IPS, TN, VA
    final double weight = 1550;
}

class Keyboard {
    final String type = "Wireless";
    final boolean backlight = true;
    final double weight = 450;

    public double getWeight() {
        return weight;
    }
}









