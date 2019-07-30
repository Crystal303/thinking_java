package chap10;

import java.util.ArrayList;
import java.util.List;

/**
 * @author crystal303
 * 内部类用来解决所需的不同的action()
 */
public class Controller {
    private List<Event> eventList = new ArrayList<>();
    public void addEvent(Event event) {
        eventList.add(event);
    }

    public void removeEvent(Event e) {
        eventList.remove(e);
    }

    public void run() {
        while (eventList.size() > 0) {
            for (Event e :
                    new ArrayList<Event>(eventList)) {
                if (e.ready()) {
                    System.out.println(e);
                    e.action();
                    removeEvent(e);
                }
            }
        }
    }
}
