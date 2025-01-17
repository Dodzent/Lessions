public class Animals {
    protected String name;
    protected int runDistance;
    protected int swimDistance;
    protected static int count;
    protected static int countCat;
    protected static int countDog;

    public Animals(String name) {
        this.name = name;
    }

    public void run(int distance) {
        if (runDistance > distance) {
            System.out.println(name + " пробежал " + distance + " м.");
        } else {
            System.out.println(name + " не может пробежать " + distance + " м.");
        }
    }

    public void swim(int distance) {
        if (swimDistance > distance) {
            System.out.println(name + " проплыл " + distance + " м.");
        }
        if (swimDistance == 0) {
            System.out.println(name + " не умеет плавать ");
        }
        if (swimDistance < distance && swimDistance != 0) {
            System.out.println(name + " не может проплыть " + distance + " м.");
        }
    }

    public static void infoCount(){
        System.out.println("\nКоличество животных: "+ Animals.count);
        System.out.println("Количество кошек: "+ Animals.countCat);
        System.out.println("Количество собак: "+ Animals.countDog);
    }
}
