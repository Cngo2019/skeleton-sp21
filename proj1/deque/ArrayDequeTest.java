package deque;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayDequeTest {

    /**
     * Test to make sure resizing is working properly.
     */
    @Test
    public void test_addLast() {
        Deque<Integer> list = new ArrayDeque<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.addLast(6);
        list.addLast(7);
        list.addLast(8);

        assertEquals(list.size(), 8);
        assertEquals(list.printArray(), "10,1,2,3,4,5,6,7,8");
    }

    @Test
    public void test_addFirst() {
        Deque<Integer> list = new ArrayDeque<>();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);
        list.addFirst(5);
        list.addFirst(6);
        list.addFirst(7);
        list.addFirst(8);
        assertEquals(list.printArray(), "1,2,3,4,5,6,7,8");
    }

    @Test
    public void test_removeFirst() {
        Deque<Integer> list = new ArrayDeque<>();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);

        assertEquals(list.removeFirst(), (Integer) 4);
        assertEquals(list.size(), 3);
    }

    @Test
    public void test_removeLast() {
        Deque<Integer> list = new ArrayDeque<>();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);

        assertEquals(list.removeLast(), (Integer) 4);
        assertEquals(list.size(), 3);
    }
}
