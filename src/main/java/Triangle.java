public class Triangle implements Lesson_5.Figure {
    private String name;
    private double a; // первая сторона треугольника
    private double b; // вторая сторона треугольника
    private double c; // третья сторона треугольника
    private String color;
    private String colorTwo;

    public void setAll(String name, String color, String colorTwo, double a, double b, double c) {
        this.name = name;
        this.color = color;
        this.colorTwo = colorTwo;
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public String getName(){
        return name+" с "+color+" фоном и "+colorTwo+" границами.";
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

