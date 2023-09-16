package deque;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaxArrayDequeTest {
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
}
