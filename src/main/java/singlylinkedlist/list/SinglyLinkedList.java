package singlylinkedlist.list;

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
        linkFirst(e);
        return true;
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

    /*    *//**
     * Links e as last element.
     *//*
    void linkLast(int e) {
        // TODO
    }

    *//**
     * Inserts element e before non-null Node succ.
     *//*
    void linkBefore(int e, Node succ) {
        // TODO
    }

    *//**
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
    }

    *//**
     * Tells if the argument is the index of an existing element.
     *//*
    private boolean isElementIndex(int index) {
        // TODO
        return false;
    }

    *//**
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
     *//*
    private String outOfBoundsMsg(int index) {
        // TODO
        return null;
    }

    private void checkElementIndex(int index) {
        // TODO
    }

    private void checkPositionIndex(int index) {
        // TODO
    }*/

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
