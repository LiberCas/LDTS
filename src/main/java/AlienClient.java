public abstract class AlienClient implements Client {
    private OrderingStrategy strategy;
    public AlienClient() {
        this.strategy = createOrderingStrategy();
        //When creating a ChildClass object, I am unable to call on an ParentClass() constructor with a certain parameter
        //to tell ParentClass() constructor which type of child I am trying to create.
        //Therefore, in the ParentClass() constructor, I can say whatever attributes are dependent on the type of child are
        //equal to creatorFunctions() defined in each ChildClass -> Factory Method
    }
    @Override
    public void happyHourStarted(Bar bar) {
        strategy.happyHourStarted((StringBar) bar);
    }
    @Override
    public void happyHourEnded(Bar bar) {
        strategy.happyHourEnded((StringBar) bar);
    }
    @Override
    public void wants(StringDrink drink, StringRecipe recipe,
                      StringBar bar) {
        strategy.wants(drink, recipe, bar);
    }
    protected abstract OrderingStrategy createOrderingStrategy();
}
