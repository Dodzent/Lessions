import java.util.Scanner;
public class Lesson_3 {
    public static void main(String args[]){
        printThreeWords(); // 1
        checkSumSign(); // 2
        printColor(); // 3
        compareNumbers(); // 4
        System.out.println(defineExprssion(10,10)); // 5
        positiveNumbers(); // 6
        System.out.println(negativeNumbers()); // 7
        printQuantity(); // 8
        System.out.println(leapYear()); // 9
        System.out.print("Массив-задание 10: ");
        int[] numbers = new int[]{1,1,0,0,1,0,1,1,0,0}; // 10
        for (int i = 0; i<numbers.length; i++){
            if (numbers[i] == 1){
                numbers[i] = 0;
            } else {
                numbers[i] = 1;
            }
            System.out.print(numbers[i]+" ");
        } // end 10
        System.out.println();
        int[] numbersPositive = new int[100]; // 11
        numbersPositive[0] = 1;
        System.out.print("Массив-задание 11: "+ numbersPositive[0]+" ");
        for (int i = 1; i<numbersPositive.length;i++){
            numbersPositive[i] = i+1;
            System.out.print(numbersPositive[i]+ " ");
        } // end 11
        System.out.print("\nМассив-задание 12: ");
        int[] numbersSmall = new int[]{1,5,3,2,11,4,5,2,4,8,9,1}; // 12
        for(int i = 0;i<numbersSmall.length;i++){
            if(numbersSmall[i]<6){
                numbersSmall[i] = numbersSmall[i]*2;
            }
            System.out.print(numbersSmall[i]+" ");
        } // end 12
        System.out.println("\nМассив-задание 13: ");
        int[][] arrays = new int[5][5]; // 13
        for(int i=0;i<arrays.length;i++){
            for(int j=0;j<arrays[i].length;j++){
                if(i==j){
                    arrays[i][j] = 1;
                }
            }
        }
        int j=0;
        for(int leng=arrays.length-1; leng>=0; leng = leng-1){
            arrays[leng][j] = 1;
            j=j+1;
        }
        for(int i1=0;i1<arrays.length;i1++){
            for(int j1=0;j1<arrays[i1].length;j1++){
                System.out.print(arrays[i1][j1]+" ");
                }
            System.out.println();
            }
        int[] arr = Lesson_3.arrayMethod(5,5);
        System.out.print("\nМассив из возвращаемого метода 14: ");
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static void printThreeWords(){
        System.out.println("Orange"+"\nBanana"+"\nApple");
    }
    public static void checkSumSign(){
        int variable1 = 7;
        int variable2 = 8;
        if(variable1+variable2>=0){
            System.out.println("Сумма положительная");
        }
        else {
            System.out.println("Сумма отрицательная");
        }
    }
    public static void printColor(){
        int value = 101;
        if(value<=0){
            System.out.println("Красный");
        } else if (value>100) {
            System.out.println("Зеленый");
        } else {
            System.out.println("Желтый");
        }
    }
    public static void compareNumbers(){
        int a = 10;
        int b = 7;
        if(a>=b){
            System.out.println("a>=b");
        } else {
            System.out.println("a<b");
        }
    }
    public static boolean defineExprssion(int variable1, int variable2){
        if (variable1+variable2>10 && variable1+variable2<=20){
            return true;
        }else {
            return false;
        }
    }
    public static void positiveNumbers(){
        Scanner scan = new Scanner(System.in);
        int variable1 = scan.nextInt();
        if(variable1>=0){
            System.out.println("Вы передали положительное число");
        } else {
            System.out.println("Вы передали отрицательное число");
        }
    }
    public static boolean negativeNumbers(){
        Scanner scan = new Scanner(System.in);
        int variable1 = scan.nextInt();
        if(variable1>=0){
            return false;
        } else {
            return true;
        }
    }
    public static void printQuantity(){
        Scanner scan = new Scanner(System.in);
        String line1 = scan.nextLine();
        int variable1 = scan.nextInt();
        for (int i = 0; i<variable1; i++){
            System.out.println(line1);
        }
    }
    public static boolean leapYear(){
        Scanner scan = new Scanner(System.in);
        int variable1 = scan.nextInt();
        if(variable1 % 400 == 0){
            return true;
        } else if (variable1 % 100 == 0) {
            return false;
        } else if (variable1 % 4 == 0){
            return true;
        } else {
            return false;
        }
    }
    public static int[] arrayMethod(int len, int initialValue){ // 14
        int[] arrayMain = new int[len];
        for(int i=0;i<arrayMain.length;i++){
            arrayMain[i] = initialValue;
        }
        return arrayMain;
    }
}
