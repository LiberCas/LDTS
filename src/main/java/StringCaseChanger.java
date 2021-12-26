import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringCaseChanger implements StringTransformer{
    public void execute(StringDrink drink){
        String text = drink.getText(), inverted = "";
        for(int i=0; i<text.length(); i++){
            if(Character.isLowerCase(text.charAt(i)))
                inverted+=Character.toUpperCase(text.charAt(i));
            else
                inverted+=Character.toLowerCase(text.charAt(i));
        }
        drink.setText(inverted);
    }
    public void undo(StringDrink drink){
        execute(drink);
    }
}
