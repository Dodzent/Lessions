import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Lesson_8 {

    public static void main(String[] args){
        System.out.println("Первое задание: \n");
        String[] word = {"яблоко", "банан", "апельсин", "груша", "груша", "банан", "вишня", "апельсин", "груша", "груша", "вишня", "груша", "апельсин", "вишня", "банан", "груша", "груша", "апельсин", "банан", "арбуз"};
        ArrayList<String> arrayList = new ArrayList<>();
        int count = 0;
        for (int i=0;i< word.length;i++){
            for (int j=0; j< word.length;j++){
             if(word[i]==word[j]){
                 count = count+1;
             }
            }
            if(count == 1){
                arrayList.add(word[i]);
            }
            count = 0;
        }
        System.out.println("Уникальные слова: "+ arrayList);
        HashMap<String, Integer> wordMapOne = new HashMap<>();
        for (String string : word) {
            if (wordMapOne.containsKey(string)) {
                wordMapOne.put(string, wordMapOne.get(string) + 1);
            } else {
                wordMapOne.put(string, 1);
            }
        }
        for (Map.Entry<String, Integer> entry : wordMapOne.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println("\nВторое задание: \n");
        PhoneBook phoneBookOne = new PhoneBook();
        phoneBookOne.add("Иванов", "123-456");
        phoneBookOne.add("Иванов", "789-101");
        phoneBookOne.add("Петров", "234-567");
        phoneBookOne.add("Петров", "890-123");
        System.out.println("Телефоны для Иванов: " + phoneBookOne.get("Иванов"));
        System.out.println("Телефоны для Петров: " + phoneBookOne.get("Петров"));
        System.out.println("Телефоны для Сидоров: " + phoneBookOne.get("Сидоров"));
        phoneBookOne.getAll();
        PhoneBook phoneBookTwo = new PhoneBook();
        phoneBookTwo.add("Иван", "123-456");
        phoneBookTwo.add("Ива", "789-101");
        phoneBookTwo.getAll();
    }
}


