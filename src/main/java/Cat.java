public class Cat extends Animals {
    private boolean satiety = false;

    public Cat(String name, boolean satiety) {
        super(name);
        count++;
        countCat++;
        runDistance = 200;
        swimDistance = 0;
        this.satiety = satiety;
    }

    public Cat(String name){
        super(name);
        count++;
        countCat++;
        runDistance = 200;
        swimDistance = 0;
    }

    public void eat(int foodForSatiety, Dish dish){
        if(dish.getFood() >= foodForSatiety && !satiety){
            satiety = true;
            dish.setFood(-foodForSatiety);
        }
    }

    public boolean isSatiety() {
        return satiety;
    }
}

