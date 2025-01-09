public class Lesson_5 {

    public static void main(String[] args) {
        System.out.println("Первое задание:\n");

        Dog dog = new Dog("Бобик");
        Cat cat = new Cat("Барсик");

        Cat[] catArray = new Cat[3];
        catArray[0] = new Cat("Грея");
        catArray[1] = new Cat("Вася");
        catArray[2] = new Cat("Юнька");
        Dish dish = new Dish(23);

        for (int i = 0; i<catArray.length; i++){
            catArray[i].eat();
            if (catArray[i].Satiety == true){
                System.out.println("Кот(кошка) "+ catArray[i].name+" сыт(а)");
            } else{
                System.out.println("Кот(кошка) "+ catArray[i].name+" голоден(голодна)");
            }
        }

        System.out.println("\nВ миске осталось: " +Dish.food);
        dish.setFood(100);
        System.out.println("Теперь в миске: " +Dish.food+"\n");


        dog.run(300);
        cat.run(300);
        dog.swim(5);
        cat.swim(100);

        System.out.println("\nКоличество животных: "+ Animals.count);
        System.out.println("Количество кошек: "+ Animals.countCat);
        System.out.println("Количество собак: "+ Animals.countDog);

        System.out.println("\nВторое задание:\n");

        Rectangle rectangle = new Rectangle();
        Triangle triangle = new Triangle();
        Circle circle = new Circle();
        rectangle.setAll("Прямоугольник первый", "фиолетовым", "жёлтыми", 5, 8);
        triangle.setAll("Треугольник первый", "жёлтым", "красными", 5, 6,7);
        circle.setAll("Круг первый", "cиним", "красными", 7);

        rectangle.infoFigure();
        triangle.infoFigure();
        circle.infoFigure();
    }

    public static class Dish{
        static int food;
        public Dish(int food){
            this.food = food;
        }
        public void setFood(int setFoods){
            food = food +setFoods;
        }
    }

    public static class Animals {
        String name;
        int runDistance;
        int swimDistance;
        static int count;
        static int countCat;
        static int countDog;

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
    }

    public static class Cat extends Animals {
        boolean Satiety=false;
        int foodForSatiety = 10; // необходимое количество еды для сытости
        public Cat(String name) {
            super(name);
            super.count++;
            super.countCat++;
            super.runDistance = 200;
            super.swimDistance = 0;
        }
        public void eat(){
            if(Dish.food>=foodForSatiety && Satiety == false){
                Satiety = true;
                Dish.food = Dish.food - foodForSatiety;
            }
        }
    }


    public static class Dog extends Animals {
        public Dog(String name) {
            super(name);
            super.count++;
            super.countDog++;
            super.runDistance = 500;
            super.swimDistance = 10;
        }
    }

    public interface Figure {

        default void infoFigure() {
            System.out.println("Фигура имеет следующие характеристики:");
            System.out.println("Имя и цвет: " + getName());
            System.out.println("Площадь: " + area());
            System.out.println("Периметр: " + perimeter()+"\n");
        }

        String getName();

        double area();
        double perimeter();
    }

    public static class Rectangle implements Figure {
        String name;
        double length;
        double width;
        String color;
        String color_2;

        public void setAll(String name, String color, String color_2, double length, double width) {
            this.name = name;
            this.color = color;
            this.color_2 = color_2;
            this.length = length;
            this.width = width;
        }

        @Override
        public String getName(){
            return name+" с "+color+" фоном и "+color_2+" границами.";
        }

        @Override
        public double area() {
            return length * width;
        }

        @Override
        public double perimeter() {
            return 2 * (length + width);
        }
    }

    public static class Circle implements Figure {
        String name;
        double radius;
        String color;
        String color_2;

        public void setAll(String name, String color, String color_2, double radius) {
            this.name = name;
            this.color = color;
            this.color_2 = color_2;
            this.radius = radius;
        }

        public String getName(){
            return name+" с "+color+" фоном и "+color_2+" границами.";
        }

        @Override
        public double area() {
            return Math.PI * radius * radius;
        }

        @Override
        public double perimeter() {
            return 2 * Math.PI * radius;
        }
    }

    public static class Triangle implements Figure {
        String name;
        double a; // первая сторона треугольника
        double b; // вторая сторона треугольника
        double c; // третья сторона треугольника
        String color;
        String color_2;

        public void setAll(String name, String color, String color_2, double a, double b, double c) {
            this.name = name;
            this.color = color;
            this.color_2 = color_2;
            this.a = a;
            this.b = b;
            this.c = c;
        }

        @Override
        public String getName(){
            return name+" с "+color+" фоном и "+color_2+" границами.";
        }

        @Override
        public double area() {
            double p = perimeter() / 2;
            return Math.sqrt(p * (p - a) * (p - b) * (p - c));
        }

        @Override
        public double perimeter() {
            return a + b + c;
        }
    }
}