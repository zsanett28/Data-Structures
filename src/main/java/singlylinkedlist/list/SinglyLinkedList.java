package singlylinkedlist.list;

import java.util.NoSuchElementException;

public class SinglyLinkedList implements List {

    // Members

    private Node head;
    private int count;

    // Constructors

    public SinglyLinkedList() {
        this.head = null;
        this.count = 0;
    }

    /*/**
     * Constructs a list containing the elements of the specified
     * collection, in the order they are returned by the collection's
     * iterator.
     *
     * @param c the collection whose elements are to be placed into this list
     * @throws NullPointerException if the specified collection is null
     *//*
    public LinkedList(Collection<Integer> c) {
        // TODO
    }*/

    // Public methods

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean add(int e) {
        linkLast(e);
        return true;
    }

    @Override
    public int get(int index) {
        checkElementIndex(index);
        return node(index).value;
    }

    /**
     * Inserts the specified element at the beginning of this list.
     *
     * @param e the element to add
     */
    public void addFirst(int e) {
        linkFirst(e);
    }

    /**
     * Appends the specified element to the end of this list.
     *
     * <p>This method is equivalent to {@link #add}.
     *
     * @param e the element to add
     */
    public void addLast(int e) {
        linkLast(e);
    }

    /**
     * Returns the first element in this list.
     *
     * @return the first element in this list
     * @throws NoSuchElementException if this list is empty
     */
    public int getFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        return head.value;
    }

    /**
     * Returns the last element in this list.
     *
     * @return the last element in this list
     * @throws NoSuchElementException if this list is empty
     */
    public int getLast() {
        if (count == 0) {
            throw new NoSuchElementException();
        }
        return node(count - 1).value;
    }

    // Private methods

    /**
     * Links e as first element.
     */
    private void linkFirst(int e) {
        Node current = new Node(e);
        current.next = head;
        head = current;
        count++;
    }

    /**
     * Links e as last element.
     */
    private void linkLast(int e) {
        Node current = new Node(e);
        if (count == 0) {
            head = current;
        } else {
            Node last = node(count - 1);
            last.next = current;
        }
        count++;
    }

    /**
     * Inserts element e before non-null Node succ.
     */
    private void linkBefore(int e, Node succ) {
        // TODO
    }

    /**
     * Unlinks non-null first node f.
     *//*
    private int unlinkFirst(Node f) {
        // TODO
        return 0;
    }

    *//**
     * Unlinks non-null last node l.
     *//*
    private int unlinkLast(Node l) {
        // TODO
        return 0;
    }

    *//**
     * Unlinks non-null node x.
     *//*
    int unlink(Node x) {
        // TODO
        return 0;
    }*/

    /**
     * Tells if the argument is the index of an existing element.
     */
    private boolean isElementIndex(int index) {
        return 0 <= index && index < count;
    }

    /*/**
     * Tells if the argument is the index of a valid position for an
     * iterator or an add operation.
     *//*
    private boolean isPositionIndex(int index) {
        // TODO
        return false;
    }

    */

    /**
     * Constructs an IndexOutOfBoundsException detail message.
     * Of the many possible refactorings of the error handling code,
     * this "outlining" performs best with both server and client VMs.
     */
    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + count;
    }

    private void checkElementIndex(int index) {
        if (!isElementIndex(index)) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    /*private void checkPositionIndex(int index) {
        // TODO
    }*/

    /**
     * Returns the (non-null) Node at the specified element index.
     */
    private Node node(int index) {
        Node trav = head;
        for (int i = 0; i < index; i++) {
            trav = trav.next;
        }
        return trav;
    }

    // Node class

    private static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
