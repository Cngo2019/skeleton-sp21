package deque;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class MaxArrayDequeTest {

    private static final Random r = new Random();

    @Test
    public void test_findMaxEmpty() {
        MaxArrayDeque<String> maxDeque = new MaxArrayDeque(new StringComparator());
        assertNull(maxDeque.max());
    }
    @Test
    public void test_findMaxString() {
        MaxArrayDeque<String> maxDeque = new MaxArrayDeque(new StringComparator());
        maxDeque.addFirst("A");
        maxDeque.addFirst("Z");
        maxDeque.addLast("D");
        maxDeque.addLast("B");
        assertEquals(maxDeque.max(), "Z");
    }

    @Test
    public void test_findMaxStringAfterUpSizing() {
        MaxArrayDeque<String> maxDeque = new MaxArrayDeque(new StringComparator());
        maxDeque.addFirst("A");
        maxDeque.addFirst("A");
        maxDeque.addLast("D");
        maxDeque.addLast("B");
        maxDeque.addFirst("A");
        maxDeque.addFirst("A");
        maxDeque.addLast("D");
        maxDeque.addLast("B");
        maxDeque.addFirst("A");
        maxDeque.addFirst("Z");
        maxDeque.addLast("D");
        maxDeque.addLast("B");
        maxDeque.addFirst("F");
        assertEquals(maxDeque.max(), "Z");
    }

    @Test
    public void test_findMaxStringAfterDesizing() {
        MaxArrayDeque<String> maxDeque = new MaxArrayDeque(new StringComparator());
        maxDeque.addFirst("A");
        maxDeque.addFirst("A");
        maxDeque.addLast("D");
        maxDeque.addLast("B");
        maxDeque.addFirst("A");
        maxDeque.addFirst("A");
        maxDeque.addLast("D");
        maxDeque.addLast("B");
        maxDeque.addFirst("A");
        maxDeque.addFirst("Z");
        maxDeque.addLast("D");
        maxDeque.addLast("B");
        maxDeque.addFirst("F");
        for (int i = 0; i < 11; i++) {
            maxDeque.removeLast();
        }
        maxDeque.addLast("Z");
        assertEquals(maxDeque.max(), "Z");
    }

    @Test
    public void test_randomGenerationDeque() {
        String max = "a";
        MaxArrayDeque<String> maxDeque = new MaxArrayDeque(new StringComparator());
        for(int i = 0; i < 1000000; i++) {
            String rndStr = String.valueOf((char)(r.nextInt(26) + 'a'));
            if (max.compareTo(rndStr) < 0) {
                max = rndStr;
            }

            if (Math.random() < .5) {
                maxDeque.addFirst(rndStr);
            } else {
                maxDeque.addLast(rndStr);
            }
        }
        assertEquals(max, maxDeque.max());
    }

}
