public class HumanClient implements Client{
    OrderingStrategy strategy;
    HumanClient(OrderingStrategy strategy){
        this.strategy=strategy;
    }
    public void happyHourStarted(Bar bar) {
        strategy.happyHourStarted(bar);
    }
    public void happyHourEnded(Bar bar) {
        strategy.happyHourEnded(bar);
    }

    @Override
    public void wants(StringDrink drink, StringRecipe recipe, StringBar bar) {
        strategy.wants(drink, recipe, bar);
    }
}
