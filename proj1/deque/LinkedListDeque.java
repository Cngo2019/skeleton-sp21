package deque;

public class LinkedListDeque<T> implements Deque<T> {

    private class Node<T> {
        private T item;
        private Node next;
        private Node prev;
    }

    /**
     * Invariant:
     * sentinel.next always points to the first node in the list
     * sentinel.last always points toe last node in the list.
     * The last node's next points to sentinel
     * The first node's previous always points to sentinel.
     */

    private Node<T> sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel = new Node<T>();
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }

    public void addFirst(T item) {
        Node temp = sentinel.next;
        Node newNode = new Node<T>();
        newNode.item = item;
        newNode.prev = sentinel; // Maintain invariant

        sentinel.next = newNode;
        temp.prev = newNode;
        newNode.next = temp;

        size++;
    }

    public void addLast(T item) {
        Node temp = sentinel.prev;
        Node newNode = new Node<T>();
        newNode.item = item;
        newNode.next = sentinel; // Maintain invariant

        sentinel.prev = newNode;
        temp.next = newNode;
        newNode.prev = temp;

        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {

    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }

        Node<T> temp = sentinel.next; // Keep reference to the first
        sentinel.next = temp.next; // Set the first to be the next element after temp
        sentinel.next.prev = sentinel; // Let sentinel next point back to previous

        size--;
        return temp.item;

    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }

        Node<T> temp = sentinel.prev;
        sentinel.prev = temp.prev;
        sentinel.prev.next = sentinel;
        size--;

        return temp.item;
    }

    public T get(int index) {
        
        if (size == 0 || index >= size) {
            return null;
        }

        Node<T> start = sentinel.next;
        while (index > 0) {
            start = sentinel.next;
            index--;
        }

        return start.item;
    }
}
