import java.util.List;

public class StringTransformerGroup implements StringTransformer{
    List<StringTransformer> transformers;
    StringTransformerGroup(List<StringTransformer> transformers){
        this.transformers = transformers;
    }
    public void execute(StringDrink stringDrink){
        for(StringTransformer transformer : transformers){
            transformer.execute(stringDrink);
        }
    }
}
