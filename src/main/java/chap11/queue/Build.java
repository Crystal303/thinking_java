package chap11.queue;

import java.util.LinkedList;
import java.util.Queue;

public class Build {
    Queue<Command> makeQ() {
        Queue<Command> queue = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            queue.offer(new Command(i + " "));
        }
        return queue;
    }
}
