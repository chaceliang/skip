package company.facebook;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/**
 * Created by chace on 6/11/14.
 */
public class GroupContacts {

    public static List<List<Contact>> groupContacts(List<Contact> contacts) {
        if (contacts == null) {
            throw new NullPointerException();
        }

        Hashtable<String, List<Contact>> mapping = new Hashtable<String, List<Contact>>();
        for (Contact c : contacts) {
            for (String email : c.emails) {
                List<Contact> cs = null;
                if (mapping.contains(email)) {
                    cs = mapping.get(email);
                } else {
                    cs = new ArrayList<Contact>();
                }
                cs.add(c);
                mapping.put(email, cs);
            }
        }
        List<List<Contact>> results = new ArrayList<List<Contact>>();
        for (Contact c : contacts) {
            for (String email : c.emails) {
                if (mapping.contains(email) && mapping.get(email).size() > 1) {
                    results.add(mapping.get(email));
                }
                mapping.remove(email);
            }
        }
        return results;
    }
}

class Contact {
    String name;
    List<String> emails;

    public Contact(String name, List<String> emails) {
        this.name = name;
        this.emails = emails;
    }
}