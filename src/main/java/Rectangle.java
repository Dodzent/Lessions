public class Rectangle implements Lesson_5.Figure {
    private String name;
    private double length;
    private double width;
    private String color;
    private String colorTwo;

    public void setAll(String name, String color, String colorTwo, double length, double width) {
        this.name = name;
        this.color = color;
        this.colorTwo = colorTwo;
        this.length = length;
        this.width = width;
    }

    @Override
    public String getName(){
        return name+" с "+color+" фоном и "+colorTwo+" границами.";
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

