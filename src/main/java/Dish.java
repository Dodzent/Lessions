public class Dish {
    private int food;

    public Dish(int food){
        this.food = food;
    }

    public void setFood(int setFoods){
        this.food += setFoods;
    }

    public int getFood(){
        return food;
    }

    public void infoFood(){
        System.out.println("В миске "+getFood()+" единиц(ы) корма.");
    }
}
