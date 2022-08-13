package Part2.PhoneBook;

import java.util.Set;
import java.util.TreeSet;

public class PhoneBook {

    public void addContact(String phone, String name) {
        // проверьте корректность формата имени и телефона
        // (рекомедуется написать отдельные методы для проверки является строка именем/телефоном)
        // если такой номер уже есть в списке, то перезаписать имя абонента
        // если такое имя уже есть в списке, то добавить еще один номер (новый) и хранить несколько номеров
    }

    public String getContactByPhone(String phone) {
        // формат одного контакта "Имя - Телефон" или "Имя - Телефон, Телефон, Телефон ..."
        // если контакт не найден - вернуть пустую строку
        return "";
    }

    public String getContactByName(String name) {
        // формат одного контакта "Имя - Телефон" или "Имя - Телефон, Телефон, Телефон ..."
        // если контакт не найден - вернуть пустую строку
        return "";
    }

    public Set<String> getAllContacts() {
        // формат одного контакта "Имя - Телефон" или "Имя - Телефон, Телефон, Телефон ..."
        // если контактов нет в телефонной книге - вернуть пустой TreeSet
        return new TreeSet<>();
    }

    // для обхода Map используйте получение пары ключ->значение Map.Entry<String,String>
    // это поможет вам найти все ключи (key) по значению (value)
    /*
        for (Map.Entry<String, String> entry : map.entrySet()){
            String key = entry.getKey(); // получения ключа
            String value = entry.getValue(); // получения ключа
        }
    */
}