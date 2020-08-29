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
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean add(int e) {
        linkLast(e);
        return true;
    }

    @Override
    public void add(int index, int element) {
        checkPositionIndex(index);
        if (count == index) {
            linkLast(element);
        } else {
            Node succ = node(index);
            linkBefore(element, succ);
        }
    }

    @Override
    public int remove(int index) {
        checkElementIndex(index);
        return unlink(node(index));
    }

    @Override
    public int set(int index, int element) {
        checkElementIndex(index);
        Node node = node(index);

        int oldElement = node.value;
        node.value = element;
        return oldElement;
    }

    @Override
    public int get(int index) {
        checkElementIndex(index);
        return node(index).value;
    }

    @Override
    public int indexOf(int e) {
        Node trav = head;
        int index = 0;

        while (trav != null) {
            if (trav.value == e) {
                return index;
            }
            trav = trav.next;
            index++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(int e) {
        Node trav = head;
        int index = 0;
        int lastIndex = -1;

        while (trav != null) {
            if (trav.value == e) {
                lastIndex = index;
            }
            trav = trav.next;
            index++;
        }
        return lastIndex;
    }

    @Override
    public boolean contains(int e) {
        return indexOf(e) != -1;
    }

    @Override
    public void clear() {
        Node trav = head;
        Node next;

        while (trav != null) {
            next = trav.next;

            trav.next = null;
            trav.value = 0;

            trav = next;
        }

        head = null;
        count = 0;
    }

    @Override
    public int[] toArray() {
        int[] array = new int[count];
        int i = 0;
        Node trav = head;

        while (trav != null) {
            array[i] = trav.value;
            trav = trav.next;
            i++;
        }

        return array;
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
     * Inserts the specified element before the first occurrence of another element.
     *
     * @param insertValue the element to add
     * @param searchValue the element searched for. insertValue is added before its first occurrence.
     */
    public void addBefore(int insertValue, int searchValue) {
        int index = indexOf(searchValue);
        add(index, insertValue);
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

    /**
     * Removes and returns the first element from this list.
     *
     * @return the first element from this list
     * @throws NoSuchElementException if this list is empty
     */
    public int removeFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }

        return unlinkFirst(head);
    }

    /**
     * Removes and returns the last element from this list.
     *
     * @return the last element from this list
     * @throws NoSuchElementException if this list is empty
     */
    public int removeLast() {
        if (head == null) {
            throw new NoSuchElementException();
        }

        Node last = node(count - 1);
        return unlinkLast(last);
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
        Node current = new Node(e);
        Node pred = getPredecessor(succ);

        if (pred == null) {
            linkFirst(e);
        } else {
            current.next = succ;
            pred.next = current;
            count++;
        }
    }

    private Node getPredecessor(Node node) {
        if (head == node) {
            return null;
        }
        Node trav = head;
        while (trav.next != node && trav.next != null) {
            trav = trav.next;
        }
        return trav;
    }

    /**
     * Unlinks non-null first node f.
     */
    private int unlinkFirst(Node f) {
        int oldElement = f.value;
        head = f.next;
        count--;
        return oldElement;
    }

    /**
     * Unlinks non-null last node l.
     */
    private int unlinkLast(Node l) {
        int oldElement = l.value;

        if (count == 1) {
            head = null;
        } else {
            Node secondLast = node(count - 2);
            secondLast.next = null;
        }

        count--;
        return oldElement;
    }

    /**
     * Unlinks non-null node.
     */
    int unlink(Node node) {
        int oldElement = node.value;
        Node pred = getPredecessor(node);
        Node next = node.next;

        if (pred == null) {
            head = next;
        } else {
            pred.next = next;
        }

        count--;
        return oldElement;
    }

    /**
     * Tells if the argument is the index of an existing element.
     */
    private boolean isElementIndex(int index) {
        return 0 <= index && index < count;
    }

    /**
     * Tells if the argument is the index of a valid position for an
     * iterator or an add operation.
     */
    private boolean isPositionIndex(int index) {
        return 0 <= index && index <= count;
    }

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

    private void checkPositionIndex(int index) {
        if (!isPositionIndex(index)) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

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
