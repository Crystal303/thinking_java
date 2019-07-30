package chap11.queue;

import java.util.*;

public class QueueDemo {
    public static void printQ(Queue queue) {
        while (queue.peek() !=  null) {
            System.out.print(queue.remove() + " ");
        }
    }

    public static void main(String[] args) {
        Queue<Integer>   queue  = // new LinkedList<>();
                new PriorityQueue<>();
        Queue<Character> queue1 = // new LinkedList<>();
                new PriorityQueue<>();
        Random           rand   = new Random(47);
        for (int i = 0; i < 10; i++) {
            queue.offer(rand.nextInt(i + 10));
        }
        for (Character c : "peace & love".toCharArray()) {
            queue1.offer(c);
        }
        printQ(queue);
        System.out.println();
        printQ(queue1);
    }

}
