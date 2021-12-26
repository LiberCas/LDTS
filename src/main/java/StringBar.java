import java.util.ArrayList;
import java.util.List;

public class StringBar extends Bar{
    StringBar() {
        inHappyHour = false;
        observers = new ArrayList<BarObserver>();
    }
    public boolean isHappyHour() {
        return inHappyHour;
    };
    public void startHappyHour() {
        inHappyHour=true;
        notifyObservers();
    };
    public void endHappyHour() {
        inHappyHour=false;
        notifyObservers();
    };

}
