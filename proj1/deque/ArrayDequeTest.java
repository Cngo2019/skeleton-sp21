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
        assertEquals(deque.toString(), "G F C B A D E H");
    }

    @Test
    public void test_removeFirst() {
        Deque<String> deque = new ArrayDeque<>();
        assertEquals(deque.removeFirst(), "G");
        assertEquals(deque.removeFirst(), "F");
        assertEquals(deque.size(), 6);
    }

    @Test
    public void test_removeLast() {
        Deque<String> deque = dummyDeque();
        assertEquals(deque.removeFirst(), "G");
        assertEquals(deque.removeFirst(), "F");
        assertEquals(deque.size(), 6);
        assertEquals(deque.removeLast(), "H");
        assertEquals(deque.removeLast(), "E");
    }

    @Test
    public void test_removeFirstAndLast() {
        Deque<String> deque = dummyDeque();
        assertEquals(deque.removeFirst(), "G");
        assertEquals(deque.removeFirst(), "F");
        assertEquals(deque.size(), 6);
        assertEquals(deque.removeLast(), "H");
        assertEquals(deque.removeLast(), "E");
        assertEquals(deque.size(), 4);
    }


    /**
     * Creates a full deque with sequence G F H B A D E H
     * where G is the first element at the front and H
     * is the last element at the back
     * @return
     */
    @Test
    public Deque<String> dummyDeque() {
        Deque<String> deque = new ArrayDeque<>();
        deque.addFirst("A");
        deque.addFirst("B");
        deque.addFirst("C");
        deque.addLast("D");
        deque.addLast("E");
        deque.addFirst("F");
        deque.addFirst("G");
        deque.addLast("H");
        return deque;
    }
}
