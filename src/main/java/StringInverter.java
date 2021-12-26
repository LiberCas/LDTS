import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringInverter implements StringTransformer {
    public void execute(StringDrink drink){
        String text = drink.getText(), inverted = "";
        for(int i=text.length()-1; i>=0; i--){
            inverted+=text.charAt(i);
        }
        drink.setText(inverted);
    }
    public void undo(StringDrink drink){
        this.execute(drink);
    }
}
