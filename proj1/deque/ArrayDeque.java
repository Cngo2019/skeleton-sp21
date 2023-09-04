package deque;
public class ArrayDeque<T> implements Deque<T> {

    /**
     *  Invariant:
     *  - F and L always point at the next position in line.
     *  - In order to get the current sequence, it is always just start at L and keep increasing
     *    the index. If we go out of bounds then jump to the front of the array (index 0).
     *
     *    I use F and L here for first and last.
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

        if (first > items.length - 1) {
            first = 0;
        }

        if (size == items.length) {
            resize(2 * items.length);
        }
    }

    @Override
    public void addLast(T item) {
        items[last] = item;
        last--;
        size++;

        if (size == items.length) {
            resize(2 * items.length);
        }
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

    }

    @Override
    public T removeFirst() {
        if (size == 0) {
            return null;
        }

        T item;
        if (first - 1 < 0) {
            item = items[items.length - 1];
            first = items.length - 1;
        } else {
            item = items[first - 1];
            first = first - 1;
        }

        items[first] = null;
        return item;

    }

    @Override
    public T removeLast() {
        return null;
    }

    @Override
    public T get(int index) {
        return null;
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
