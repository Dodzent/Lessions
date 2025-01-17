public class Circle implements Lesson_5.Figure {
    private String name;
    private double radius;
    private String color;
    private String colorTwo;

    public void setAll(String name, String color, String colorTwo, double radius) {
        this.name = name;
        this.color = color;
        this.colorTwo = colorTwo;
        this.radius = radius;
    }

    public String getName(){
        return name+" с "+color+" фоном и "+colorTwo+" границами.";
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

