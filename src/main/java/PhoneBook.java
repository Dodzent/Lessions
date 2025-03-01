import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PhoneBook {
    private HashMap<String, ArrayList<String>> phoneBook;

    public PhoneBook(){
        phoneBook = new HashMap<>();
    }

    public void add(String name, String phone){
        if(!phoneBook.containsKey(name)){
            phoneBook.put(name,new ArrayList<>());
        }
        phoneBook.get(name).add(phone);
    }

    public List<String> get(String name){
        return phoneBook.getOrDefault(name, new ArrayList<>());
    }

    public void getAll(){
        for (String name : phoneBook.keySet()) {
            System.out.println(name + ": " + phoneBook.get(name));
        }
    }
}
