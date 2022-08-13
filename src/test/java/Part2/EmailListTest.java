package Part2;

import Part2.EmailList.EmailList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test for homework Emails collector app
 */

@DisplayName("Программа для хранения адресов электронной почты")
class EmailListTest {
    private EmailList emailList;

    @BeforeEach
    public void setUp() {
        emailList = new EmailList();
    }

    @Test
    @DisplayName("Добавление валидного email [hello@yandex.ru]")
    void testAddValidEmail() {
        String validEmail = "hello@yandex.ru";
        emailList.add(validEmail);
        assertEquals(List.of(validEmail), emailList.getSortedEmails());
    }

    @Test
    @DisplayName("Добавление НЕвалидного email [hello_yandex.ru]")
    void testAddNotValidEmailWithoutAt() {
        String notValidEmail = "hello_yandex.ru";
        emailList.add(notValidEmail);
        assertEquals(List.of(), emailList.getSortedEmails());
    }

    @Test
    @DisplayName("Добавление НЕвалидного email [hello@yandexru]")
    void testAddNotValidEmailWithoutDomainDot() {
        String notValidEmail = "hello@yandexru";
        emailList.add(notValidEmail);
        assertEquals(List.of(), emailList.getSortedEmails());
    }

    @Test
    @DisplayName("Добавление дубликата валидного email [hello@yandex.ru]")
    void testAddDuplicateValidEmail() {
        String validEmail = "hello@yandex.ru";
        String validDuplicateEmail = "HELLO@yandex.ru";

        emailList.add(validEmail);
        emailList.add(validDuplicateEmail);

        assertEquals(List.of(validEmail), emailList.getSortedEmails());
    }


    @Test
    @DisplayName("Проверка возврата списка адресов в алфавитном порядке")
    void testSortedEmails() {
        String firstEmail = "hello@yandex.ru";
        String secondEmail = "asgard@yggdrasil.com";
        String thirdEmail = "hello@mail.ru";

        emailList.add(firstEmail);
        emailList.add(secondEmail);
        emailList.add(thirdEmail);

        assertEquals(List.of(secondEmail, thirdEmail, firstEmail), emailList.getSortedEmails());
    }


}
