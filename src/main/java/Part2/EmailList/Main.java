package Part2.EmailList;

public class Main {
    public static void main(String[] args) {
        EmailList emailList = new EmailList();
        ToScan toScan = new ToScan();
        toScan.scanCommands(emailList);

    }
}



