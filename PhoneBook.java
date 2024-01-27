import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.ArrayList;


public class PhoneBook {

    private Map<String, Set<String>> handbook = new HashMap<>();

    public void add(String name, String phone) {
        Set<String> phones = handbook.get(name);
        if (phones == null) {
            phones = new HashSet<>();
        }
        phones.add(phone);
        handbook.put(name, phones);
    }

    public void print() {
        List<Map.Entry<String, Set<String>>> entries = new ArrayList<>(handbook.entrySet());

        entries.sort((e1, e2) -> e2.getValue().size() - e1.getValue().size());

        for (Map.Entry<String, Set<String>> entry : entries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        PhoneBook handbook = new PhoneBook();

        handbook.add("Олегов Олег Олегович", "8-777-777-77-78");
        handbook.add("Олегов Олег Олегович", "8-777-777-77-79");
        handbook.add("Петров Петр Петрович", "8-123-456-78-90");

        handbook.print();
    }
}