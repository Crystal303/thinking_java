package chap11.queue;

import java.util.*;

public class PriorityQueueDemo {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue =
                new PriorityQueue<>();
        Random rand                          = new Random(47);
        for (int i = 0; i < 10; i++) {
            priorityQueue.offer(rand.nextInt(i + 10));
        }
        QueueDemo.printQ(priorityQueue);
        System.out.println();

        List<Integer> ints = Arrays.asList(32, 2, 34, 45, 6567, 32, 66, 43, 22);
        priorityQueue      = new PriorityQueue<Integer>(ints);
        QueueDemo.printQ(priorityQueue);
        System.out.println();

        priorityQueue      = new PriorityQueue<>(ints.size(), Collections.reverseOrder());
        priorityQueue.addAll(ints);
        QueueDemo.printQ(priorityQueue);
        System.out.println();

        String fact = "LET NO FEELING OF DISCOURAGEMENT PREY";
        List<String> strings = Arrays.asList(fact.split(" "));
        PriorityQueue<String> stringsPQ =
                new PriorityQueue<>(strings);
        QueueDemo.printQ(stringsPQ);
        System.out.println();

        stringsPQ = new PriorityQueue<>(strings.size(), Collections.reverseOrder());
        stringsPQ.addAll(strings);
        QueueDemo.printQ(stringsPQ);
        System.out.println();

        Set<Character> charSet = new HashSet<>();
        for (char c : fact.toCharArray()) {
            charSet.add(c);
        }
        PriorityQueue<Character> characterPQ =
                new PriorityQueue<>(charSet);
        QueueDemo.printQ(characterPQ);
        System.out.println();
    }
}
