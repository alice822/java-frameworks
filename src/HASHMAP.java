//Create a HashMap to store key-value pairs.Add, retrieve, and remove entries using keys.
import java.util.HashMap;

public class HASHMAP {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();

        map.put("101", "John");
        map.put("102", "Alice");
        map.put("103", "Bob");

        String name = map.get("101");
        System.out.println("Name with ID 101: " + name);

        map.remove("102");

        System.out.println("Updated HashMap: " + map);
    }
}

