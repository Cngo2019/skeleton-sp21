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
        if (!hasArraySizeIncreased()) {
            checkAddPointers();
        }
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
        if (!hasArraySizeIncreased()) {
            checkAddPointers();
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
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
        checkArraySizeNeedsDecreased();
        return item;
    }

    @Override
    public T removeLast() {
        checkRemovePointers();
        last++;
        T item = items[last];
        size--;
        checkArraySizeNeedsDecreased();
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


    /**
     * TODO: Think about resizing.
     * @return
     */
    private boolean checkArraySizeNeedsDecreased() {

        if (usageLessThan25Percent()) {
            resize(items.length / 2);
            last = items.length - 1;
            first = size;
            return true;
        }

        return false;
    }

    private boolean usageLessThan25Percent() {
        return size / (double) items.length < .25;
    }

    /**
     * Invariants:
     *
     * first and last always point to the next element to be added.
     * To obtain the elements in sequence order, you need to start out at first - 1
     * and keep decrementing.
     *
     * HOWEVER, we need to copy over the array such that this invariant is maintained.
     *
     * We need to be aware of WHEN we should call this.
     *
     * Assume that if array is resized the pointers are already in their neccessary slots
     */
    private boolean hasArraySizeIncreased() {

        if (size == items.length) {
            resize(2 * items.length);
            last = items.length - 1;
            first = size;
            return true;
        }

        return false;
    }

    private void resize(int newLength) {
        T[] tempItems = (T[]) new Object[newLength];
        int tempLast = last + 1;
        for (int i = 0; i < size; i++) {

            if (tempLast > items.length - 1) {
                tempLast = 0;
            }

            tempItems[i] = items[tempLast];
            tempLast++;
        }
        items = tempItems;
    }
}
