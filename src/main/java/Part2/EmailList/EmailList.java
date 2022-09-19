package Part2.EmailList;

import java.util.*;

public class EmailList {
    private final Set<String> emails = new TreeSet<>();

    public Set<String> getEmails() {
        return emails;
    }

    public void add(String email) {
        emails.add(email);
    }
    public void showSortedEmails() {
        int counter = 1;
        for (String s : emails) {
            System.out.println(counter + ". " + s.toLowerCase());
            counter++;
        }
    }
}
