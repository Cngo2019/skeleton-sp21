package deque;
import org.checkerframework.checker.units.qual.A;
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
        assertEquals(deque.size(), 3);
    }

    @Test
    public void test_addFirst() {
        Deque<String> deque = new ArrayDeque<>();
        deque.addFirst("A");
        deque.addFirst("B");
        deque.addFirst("C");
        assertEquals(deque.toString(), "C B A");
        assertEquals(deque.size(), 3);
    }

    @Test
    public void test_addFirstAndAddLast() {
        Deque<String> deque = sampleDequeEight();
        assertEquals(deque.toString(), "G F C B A D E H");
    }

    @Test
    public void test_removeFirst() {
        Deque<String> deque = sampleDequeEight();
        assertEquals(deque.removeFirst(), "G");
        assertEquals(deque.removeFirst(), "F");
        assertEquals(deque.size(), 6);
    }

    @Test
    public void test_removeLast() {
        Deque<String> deque = sampleDequeEight();
        assertEquals(deque.removeFirst(), "G");
        assertEquals(deque.removeFirst(), "F");
        assertEquals(deque.size(), 6);
        assertEquals(deque.removeLast(), "H");
        assertEquals(deque.removeLast(), "E");
        assertEquals(deque.size(), 4);

    }

    @Test
    public void test_removeFirstAndLast() {
        Deque<String> deque = sampleDequeEight();
        assertEquals(deque.removeFirst(), "G");
        assertEquals(deque.removeFirst(), "F");
        assertEquals(deque.size(), 6);
        assertEquals(deque.removeLast(), "H");
        assertEquals(deque.removeLast(), "E");
        assertEquals(deque.size(), 4);
    }

    /**
     * We now need to test cases where First and Last circle back
     */

    @Test
    public void test_removeFirstWhenSentBack() {
        Deque<String> deque = new ArrayDeque<>();
        deque.addLast("A");
        deque.addLast("B");

        // First should be pointing at index 0 and removal should cause it to circle
        // to the end of the list
        assertEquals(deque.removeFirst(), "A");
        assertEquals(deque.removeFirst(), "B");
    }

    @Test
    public void test_addFirstWhenFirstCirclesBack() {
        Deque<String> deque = new ArrayDeque<>();
        deque.addLast("A");
        deque.addLast("B");
        deque.addLast("C");

        deque.addFirst("A");
        deque.addFirst("B");
        deque.addFirst("C");

        assertEquals(deque.size(), 6);
        assertEquals(deque.toString(), "C B A A B C");
    }

    @Test
    public void test_removeLastCirclesBack() {
        // Given
        Deque<String> deque = new ArrayDeque<>();
        deque.addFirst("A");
        deque.addFirst("B");
        deque.addFirst("C");

        // Removal of last to make sure we circle back to the front
        assertEquals(deque.removeLast(), "A");
        assertEquals(deque.removeLast(), "B");
        assertEquals(deque.size(), 1);
        assertEquals(deque.removeLast(), "C");

    }

    @Test
    public void test_addLastCirclesBack() {
        // Scenario where last pointer has to go to the front of the array
        Deque<String> deque = new ArrayDeque<>();
        deque.addFirst("A");
        deque.addFirst("B");
        deque.addFirst("C");
        deque.removeLast();
        deque.removeLast();


        deque.addLast("A");
        deque.addLast("B");
        deque.addLast("C");
        assertEquals(deque.toString(), "C A B C");

    }

    /**
     * Test resize for 16 elements
     */
    @Test
    public void test_addSixteenElements() {
        // C D B A G F C B A D E H E F Z L
        Deque<String> deque = sampleDequeSixteen();
        assertEquals(deque.toString(), "C D B A G F C B A D E H E F Z L");

    }

    @Test
    public void test_ArraySizeDecreasing() {
        Deque<String> deque = sampleDequeSixteen();
        deque.removeLast();
        deque.removeLast();
        deque.removeLast();
        deque.removeLast();
        deque.removeLast();
        deque.removeLast();
        deque.removeLast();
        deque.removeLast();
        deque.removeFirst();
        deque.removeFirst();
        deque.removeFirst();
        deque.removeFirst();
        deque.removeFirst();

        assertEquals(deque.toString(), "F C B");

        assertEquals(deque.removeFirst(), "F");
        assertEquals(deque.removeFirst(), "C");

        assertEquals(deque.toString(), "B");
        assertEquals(deque.removeFirst(), "B");
        assertTrue(deque.isEmpty());
    }

    @Test
    public void test_ArrayResizeFromSmallToMany() {
        Deque<String> deque = sampleDequeSixteen();
        for (int i = 0; i < 16; i++) {
            deque.removeLast();
        }
        assertTrue(deque.isEmpty());

        deque.addFirst("A");
        deque.addFirst("B");

        assertEquals(deque.size(), 2);

        assertEquals(deque.removeLast(), "A");
        assertEquals(deque.removeFirst(), "B");
    }

    @Test
    public void test_getMethodForArrayDeque() {
        // C D B A G F C B A D E H E F Z L
        Deque<String> deque = sampleDequeSixteen();

        assertEquals(deque.get(0), "C");
        assertEquals(deque.get(1), "D");
        assertEquals(deque.get(2), "B");

        assertEquals(deque.get(15), "L");
        assertEquals(deque.get(14), "Z");
        assertEquals(deque.get(13), "F");
    }

    /**
     * Creates a full deque with sequence G F C B A D E H
     * where G is the first element at the front and H
     * is the last element at the back
     * @return
     */
    private Deque<String> sampleDequeEight() {
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

    /**
     * C D B A G F C B A D E H E F Z L
     * @return
     */
    private Deque<String> sampleDequeSixteen() {
        Deque<String> deque = sampleDequeEight();
        deque.addFirst("A");
        deque.addFirst("B");
        deque.addFirst("D");
        deque.addFirst("C");
        deque.addLast("E");
        deque.addLast("F");
        deque.addLast("Z");
        deque.addLast("L");

        return deque;
    }
}
