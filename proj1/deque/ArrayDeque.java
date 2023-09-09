package deque;
public class ArrayDeque<T> implements Deque<T> {
    /**
     * Invariants:
     *
     * -Adding first ALWAYS requires us to increase the index by 1 for the next position
     *
     * -Adding last always requires us to decrease the index by 1 for the next position
     *
     * -first points to the next position to insert at the front of the list
     *
     * -last points to the next position to insert at the end of the list
     *
     * -When looking at the 'proper' ordering of the list, we start at F - 1 and decrement.
     * If we are out of bounds go to end of array.
     */
    private T[] items;
    private Integer first;
    private Integer last;

    private Integer size;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        first = 0;
        last = 7;
        size = 0;
    }

    @Override
    public void addFirst(T item) {
        items[first] = item;
        first++;
        size++;
    }

    @Override
    public void addLast(T item) {
        items[last] = item;
        last--;
        size++;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void printDeque() {
        // Calls the toString method
        System.out.println(this);
    }

    @Override
    public T removeFirst() {
        return null;
    }

    @Override
    public T removeLast() {
        return null;
    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public String toString() {
        // pos represents the element to print out before the loop.
        int pos = first - 1;
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < size; i++) {
            if (pos < 0) {
                pos = items.length - 1;
            }
            out.append(" ").append(items[pos]);
            pos--;
        }

        return out.toString().trim();
    }

    private void resize(int newSize) {
        T[] newArr = (T[]) new Object[newSize];

        // Start at last and keep incrementing.
        for (int i = 0; i < size; i++) {
            newArr[i] = items[last];
            last++;
            if (last > items.length) {
                last = 0;
            }
        }

        first = size;
        last = items.length;
        items = newArr;
    }
    
}
