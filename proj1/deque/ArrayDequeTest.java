package deque;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayDequeTest {

    /**
     * Test to make sure resizing is working properly.
     */
    @Test
    public void test_addLast() {
        Deque<String> deque = new ArrayDeque<>();
        deque.addLast("A");
        deque.addLast("B");
        deque.addLast("C");
        assertEquals(deque.toString(), "A B C");
    }

    @Test
    public void test_addFirst() {
        Deque<String> deque = new ArrayDeque<>();
        deque.addFirst("A");
        deque.addFirst("B");
        deque.addFirst("C");
        assertEquals(deque.toString(), "C B A");
    }

    @Test
    public void test_addFirstAndAddLast() {
        Deque<String> deque = new ArrayDeque<>();
        deque.addFirst("A");
        deque.addFirst("B");
        deque.addFirst("C");
        deque.addLast("D");
        deque.addLast("E");
        deque.addFirst("F");
        deque.addFirst("G");
        deque.addLast("H");
        assertEquals(deque.toString(), "G F C B A D E H");
    }

    @Test
    public void test_removeFirst() {

    }

    @Test
    public void test_removeLast() {

    }
}
