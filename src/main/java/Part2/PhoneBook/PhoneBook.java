package Part2.PhoneBook;


import java.util.*;

public class PhoneBook {

    Scanner scanner = new Scanner(System.in);
    private final Map<String, String> map = new HashMap<>(15, 0.75f);

    /*
     В качестве ключа в данном решении выбран номер, а не имя. Но лучше было бы сделать ключём имя,
     а вместо значения не String a List<Sting> numbers. Тогда одному ключу соответствовал бы лист номеров,
     которые можно было бы удобнее доставать в случае необходимости. Хотя, даже в данном варианте доставать тоже можно.
     */

    public void insertCommand() {
        while (true) {
            String inputNum = "\\+?\\d{6,12}";
            String list = "лист";  // руccкими для удобства
            String normalName = "[а-яА-яa-zA-Z]+\\d*\\s*\\d*";// имя может состоять из букв, пробелов и цифр, но не из других символов!
            System.out.println("Введите номер или команду: ");
            String ss = scanner.nextLine();

            if (ss.matches(list)) {    //ЛИСТ
                if (map.isEmpty()) {
                    System.out.println("Справочник пуст");
                } else {
                    showPhoneNumber();
                }
            }

            // ВВОД ПО ИМЕНИ

            if (!ss.matches(list) && !ss.matches(inputNum) && ss.matches(normalName)) {   //ВВОД ИМЕНИ
                System.out.println("Вы ввели имя " + ss);

                if (map.containsValue(ss)) {
                    System.out.println("Абонент " + ss + " уже записан, его номер : " + findKey(map, ss));
                    continue;
                }
                System.out.println("Введите номер для абонента " +  ss );//ВВОД НОМЕРА
                String number = scanner.nextLine();

                if(findEqualNums(number) != null ){
                    System.out.println("Внимание! Это один из номеров абонента " + findEqualNums(number)+
                            ". Перезаписи не будет.");
                    continue;
                }
                if (map.containsKey(number)) {
                    // Если вводится новое имя, а следом номер,
                    // который уже существует (с каким-то другим именем),
                    // тогда старое имя перезаписывается новым

                    System.out.println("Контакт " + map.get(number) + " : " + number +
                            "; изменен на " + ss + " : " + number);
                    map.replace(number, map.get(number), ss);  // метод get возвращает предыдущее V
                }

                if (number.matches(inputNum) && !map.containsKey(number)) {
                    map.put(number, ss);
                    System.out.println(ss + " - " + number + "\nКонтакт сохранен!");
                }
            }

            if( !ss.matches(list) && !ss.matches(inputNum) && !ss.matches(normalName)){
                System.out.println("Некорректное имя или номер");
            }

            if (!ss.matches(list) && ss.matches(inputNum)) {  //ВВОД  НОМЕРА
                System.out.println("Вы ввели номер " + ss);
                if(findEqualNums(ss) == null && !map.containsKey(ss)){
                    System.out.println("Такого номера нет в телефонной книге.");
                }
                if(findEqualNums(ss) != null ){ // если != null, значит совпадение номера в мапе.
                    System.out.println("Внимание! Это один из номеров абонента " + findEqualNums(ss)+
                            ". Перезаписи не будет.");
                    continue;
                }
                if (map.containsKey(ss)) {                    // НОМЕР УЖЕ СУЩЕСТВУЕТ
                    System.out.println("Абонент с номером " + ss + " уже существует, его имя : " + map.get(ss));
                    continue;
                }

                //НОМЕР ОКАЗАЛСЯ НОВЫМ
                System.out.println("Введите имя абонента для номера: " + ss);
                String name = scanner.nextLine();
                // ИМЯ ОКАЗАЛОСЬ НОВЫМ, ПРОВЕРЯЕМ ИМЯ

                // Если вводится новый номер, а следом имя, которое
                // уже существует (с каким-то другим номером), тогда к тому
                // имени новый номер добавляется, а не перезаписывается.

                if (map.containsValue(name) && name.matches(normalName)  ) {
                    String doubleNum = findKey(map, name) + ", " + ss;

                    String previousName = findKey(map, name);
                    map.remove(findKey(map, name));
                    map.put(doubleNum, name);
                    System.out.println("Контакт перезаписан : " + name + " " + doubleNum + " (вместо " + name + " " + previousName + ")");

                    continue;
                }
                map.put(ss, name);
                System.out.println(name + " : " + ss + " - контакт сохранен");
            }
        }
    }

    public Set<String> getAllContacts() {   // множество сет позволяет сортировать автоматически уникальные entry
        Set<String> stringsSet = new TreeSet<>();

        for (Map.Entry<String, String> entry : map.entrySet()) {

            String s = entry.getValue() + " : " + entry.getKey();
            stringsSet.add(s);
        }
        return stringsSet;
    }

    public String findKey(Map<String, String> map, String value) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (value.equals(entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }

    public void showPhoneNumber() {
        System.out.println("___Список сохраненных контактов: ");
        int counter  = 1;
        for (String ss : getAllContacts()) {
            System.out.println( "___" + counter + ". " + ss);
            counter++;
        }
    }

    public String findEqualNums(String number) {   // метод позволяет извлекать из строки, состоящей из нескольких номеров отдельный номер
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String s = entry.getKey();
            String v = entry.getValue();
            String[] arr = s.split(", ");
            for (String p : arr) {
                if (p.equals(number) && arr.length>1) {
                    return v;
                }
            }
        }
        return null;
    }
}

