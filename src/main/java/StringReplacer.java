import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringReplacer implements StringTransformer{
    char replaced;
    char replacement;
    StringReplacer(char replaced, char replacement){
        this.replaced = replaced;
        this.replacement = replacement;
    }
    public void execute(StringDrink drink) {
        String text = drink.getText();
        text = text.replace(replaced, replacement);
        drink.setText(text);
    }
    public void undo(StringDrink drink){
        String text = drink.getText();
        text = text.replace(replacement, replaced);
        drink.setText(text);
    }
}
