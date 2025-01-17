public class Lesson_6 {

    public static void main (String[] args) {
        Main main = new Main();
        String[][] arrayOne = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}};
        String[][] arrayTwo = {
                {"1", "2"},
                {"3", "4"},
                {"5","6"}};
        String[][] arrayThree = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "Branch", "11", "12"},
                {"13", "14", "15", "16"}};
        try {
            System.out.println(main.arrayMethod(arrayOne));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.err.println(e.getMessage());
        }
        try {
            System.out.println(main.arrayMethod(arrayTwo));
        } catch (MyArraySizeException | MyArrayDataException e){
            System.err.println(e.getMessage());
        }
        try {
            System.out.println(main.arrayMethod(arrayThree));
        } catch (MyArraySizeException | MyArrayDataException e){
            System.err.println(e.getMessage());
        }
    }
}
