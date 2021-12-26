public class SmartStrategy implements OrderingStrategy{
    StringDrink drink;
    StringRecipe recipe;
    public void wants(StringDrink drink, StringRecipe recipe, StringBar bar){
        if(!bar.isHappyHour()) {
            this.drink = drink;
            this.recipe = recipe;
        }
        else
            bar.order(drink, recipe);
    };
    public void happyHourStarted(Bar bar){
        bar.order(drink, recipe);
    };
    public void happyHourEnded(Bar bar){

    };
}
