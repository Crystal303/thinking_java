package chap11.queue;

import java.util.Queue;

public class Ex27 {
    public static void commandEaster(Queue<Command> queue) {
        while (queue.peek() != null) {
            queue.poll().operate();
        }
    }

    public static void main(String[] args) {
        Build build = new Build();
        commandEaster(build.makeQ());
    }
}
