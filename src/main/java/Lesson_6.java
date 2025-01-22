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
        try { // прогон 1-ого массива
            try {
                System.out.println(main.arrayMethod(arrayOne));
            }catch (MyArraySizeException e){
                System.err.println(e.getMessage());
            }
        } catch (MyArrayDataException e) {
            System.err.println("MyArrayDataException: неверные данные в ячейке ["+e.i+"]["+e.j+"]");
        }
        try { // прогон 2-ого массива
            try {
                System.out.println(main.arrayMethod(arrayTwo));
            }catch (MyArraySizeException e){
                System.err.println(e.getMessage());
            }
        } catch (MyArrayDataException e){
            System.err.println("MyArrayDataException: неверные данные в ячейке ["+e.i+"]["+e.j+"]");
        }
        try { // прогон 3-его массива
            try {
                System.out.println(main.arrayMethod(arrayThree));
            }catch (MyArraySizeException e){
                System.err.println(e.getMessage());
            }
        } catch (MyArrayDataException e) {
            System.err.println("MyArrayDataException: неверные данные в ячейке [" + e.i + "][" + e.j + "]");
        }
    }
}
