import java.util.List;

public class StringRecipe {
    List<StringTransformer> transformers;
    StringRecipe(List<StringTransformer> transformers){
        this.transformers = transformers;
    }
    void mix(StringDrink stringDrink){
        for(StringTransformer transformer : transformers){
            transformer.execute(stringDrink);
        }
    }
}
