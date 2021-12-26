import java.util.List;

public abstract class Bar {
    boolean inHappyHour;
    List<BarObserver> observers;

    public abstract boolean isHappyHour();
    public void startHappyHour() {};
    public void endHappyHour() {};
    public void addObserver(BarObserver observer) {
        observers.add(observer);
    }
    public void removeObserver(BarObserver observer) {
        observers.remove(observer);
    }
    public void notifyObservers() {
        for (BarObserver observer : observers)
            if (isHappyHour()) observer.happyHourStarted(this);
            else observer.happyHourEnded(this);
    }
    public void order(StringDrink drink, StringRecipe recipe){
        recipe.mix(drink);
    }
}
