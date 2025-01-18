public class Main {
    public int sum = 0;

    public String arrayMethod(String[][] array) throws MyArraySizeException, MyArrayDataException {
        if (array.length != 4) {
            throw new MyArraySizeException("MyArraySizeException: размер массива не соответствует заданию. Количество строк: " + array.length);
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4) {
                throw new MyArraySizeException("MyArraySizeException: размер массива не соответствует заданию. Строка с индексом: " + i + " имеет ширину: " + array[i].length);
            }
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i,j);
                }
            }
        }
        return ("Сумма элементов массива: " + sum);
    }
}