import java.util.HashMap;
import java.util.Map;

public class Lesson_8 {

    public static void main(String[] args){
        System.out.println("Первое задание: \n");
        String[] word = {
                "яблоко", "банан", "апельсин", "яблоко", "груша",
                "банан", "арбуз", "апельсин", "груша", "груша",
                "вишня", "яблоко", "апельсин", "вишня", "банан",
                "груша", "яблоко", "апельсин", "банан", "арбуз"
        };
        HashMap<String, Integer> wordMapOne = new HashMap<>();
        for (String string : word) {
            if (wordMapOne.containsKey(string)) {
                wordMapOne.put(string, wordMapOne.get(string) + 1);
            } else {
                wordMapOne.put(string, 1);
            }
        }
        System.out.println("Первый способ реализации: ");
        for (Map.Entry<String, Integer> entry : wordMapOne.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        HashMap<String, Integer> wordMapTwo = new HashMap<>();
        int count = 0;
        for(int i=0; i< word.length;i++){
            for(int j=0; j< word.length;j++){
                if(word[i] == word[j]){
                    count= count+1;
                    wordMapTwo.put(word[i],count);
                }
            }
            count = 0;
        }
        System.out.println("\nВторой способ реализации: ");
        for (Map.Entry<String, Integer> entry : wordMapTwo.entrySet()){
            System.out.println(entry.getKey()+": "+ entry.getValue());
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


