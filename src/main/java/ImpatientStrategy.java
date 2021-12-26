public class ImpatientStrategy implements OrderingStrategy{
    public void wants(StringDrink drink, StringRecipe recipe, StringBar bar){
        bar.order(drink, recipe);
    };
    public void happyHourStarted(Bar bar){

    };
    public void happyHourEnded(Bar bar){

    };
}
