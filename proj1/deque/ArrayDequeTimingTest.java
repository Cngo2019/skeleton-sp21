package deque;

import edu.princeton.cs.algs4.Stopwatch;

public class ArrayDequeTimingTest {
    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();
        testListTime(deque);

        deque = new LinkedListDeque<>();
        testListTime(deque);
    }

    private static void testListTime(Deque<Integer> deque) {
        Stopwatch stopwatch = new Stopwatch();
        for (int i = 0; i < 9999999; i++) {
            deque.addLast(i);
        }
        System.out.println(stopwatch.elapsedTime());
    }
}
