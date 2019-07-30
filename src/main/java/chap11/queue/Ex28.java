package chap11.queue;

import java.util.PriorityQueue;
import java.util.Random;

public class Ex28 {
    public static void main(String[] args) {
        Random rand = new Random(47);
        PriorityQueue<Double> queuePD = new PriorityQueue<>(10);
        for (int i = 0; i < 10; i++) {
            queuePD.offer(rand.nextDouble() * i);
        }
        while (queuePD.peek() != null) {
            System.out.println(queuePD.poll());
        }
    }
}
