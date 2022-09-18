package Part2.EmailList;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailList {
    final Set<String> emails = new TreeSet<>();

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
