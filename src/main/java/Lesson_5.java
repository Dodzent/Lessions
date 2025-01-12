public class Lesson_5 {

    public static void main(String[] args) {
        System.out.println("Первое задание:\n");
        Dish dish = new Dish(233);
        Dish dishTwo = new Dish(100);
        Dog dog = new Dog("Бобик");
        Cat cat = new Cat("Барсик",true);
        Cat catTwo = new Cat("Бельчик");
        cat.eat(10, dishTwo);
        catTwo.eat(20,dish);
        Cat[] catArray = new Cat[3];
        catArray[0] = new Cat("Грея");
        catArray[1] = new Cat("Вася");
        catArray[2] = new Cat("Юнька");
        for (int i = 0; i<catArray.length; i++){
            catArray[i].eat(10,dish);
            if (catArray[i].isSatiety()){
                System.out.println("Кот(кошка) "+ catArray[i].name+" сыт(а)");
            } else{
                System.out.println("Кот(кошка) "+ catArray[i].name+" голоден(голодна)");
            }
        }
        dish.infoFood();
        dish.setFood(100);
        dishTwo.setFood(101);
        dish.infoFood();
        dog.run(300);
        cat.run(300);
        dog.swim(5);
        cat.swim(100);
        Animals.infoCount();
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

    public interface Figure {
        String getName();
        double area();
        double perimeter();
        default void infoFigure() {
            System.out.println("Фигура имеет следующие характеристики:");
            System.out.println("Имя и цвет: " + getName());
            System.out.println("Площадь: " + area());
            System.out.println("Периметр: " + perimeter()+"\n");
        }
    }
}