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
        checkAddPointers();
    }

    /**
     * Invariant we need to consider:
     * There is a case where first and last will be out of bounds.
     * i.e, first ends up being > max index and last < 0.
     * This happens only after we add since first always increments.
     */
    private void checkAddPointers() {
        if (first > items.length - 1) {
            first = 0;
        }
        if (last < 0) {
            last = items.length - 1;
        }
    }


    @Override
    public void addLast(T item) {
        items[last] = item;
        last--;
        size++;
        checkAddPointers();
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        // Calls the toString method
        System.out.println(this);
    }

    @Override
    public T removeFirst() {
        checkRemovePointers();
        first--;
        T item = items[first];
        size--;
        return item;
    }

    @Override
    public T removeLast() {
        checkRemovePointers();
        last++;
        T item = items[last];
        size--;
        return item;
    }

    /**
     * When we call remove first there is a case where we have to end up
     * going to the back of the list. Since remove first subtracts we need
     * to maintain first and last in bounds.
     * At the end of the remove routine we should be pointing at the next available position.
     *
     * Remove methods will end up incrementing/decrementing so need to point these to be 'one-off' the next
     * position to be removed.
     */
    private void checkRemovePointers() {
        if (first == 0) {
            first = items.length;
        }
        if (last == items.length - 1) {
            last = -1;
        }
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
