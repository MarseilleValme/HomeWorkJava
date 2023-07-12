import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
public class PhoneBook {
    Map<String, List<String>> PhoneBook = new HashMap<>();

    void addNote(String name, String number){

        if (PhoneBook.containsKey(name)){
            List<String> list = PhoneBook.get(name);
            list.add(number);
        } else {
            List<String> list = new ArrayList<>();
            list.add(number);
            PhoneBook.put(name, list);
        }
    }
}