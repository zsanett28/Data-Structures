package singlylinkedlist.list;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class SinglyLinkedListTest {

    @Test
    void testCreate() {
        SinglyLinkedList list = new SinglyLinkedList();

        assertEquals(0, list.size());
    }

    @Test
    void testAddSingleElement() {
        SinglyLinkedList list = new SinglyLinkedList();

        list.add(10);

        assertEquals(1, list.size());
        assertEquals(10, list.get(0));
    }

    @Test
    void testAddMultipleElements() {
        SinglyLinkedList list = new SinglyLinkedList();

        list.add(5);
        list.add(23);
        list.add(2);

        assertEquals(3, list.size());
        assertEquals(5, list.get(0));
        assertEquals(23, list.get(1));
        assertEquals(2, list.get(2));
    }

    @Test
    void testIndexOutOfBound() {
        SinglyLinkedList list = new SinglyLinkedList();

        assertThrows(IndexOutOfBoundsException.class, () -> list.get(13));

        list.add(3);
        list.get(0);

        assertThrows(IndexOutOfBoundsException.class, () -> list.get(1));

        list.add(5);
        list.add(11);
        list.get(1);
    }

    @Test
    void testAddFirst() {
        SinglyLinkedList list = new SinglyLinkedList();

        list.addFirst(5);
        assertEquals(5, list.get(0));

        list.addFirst(10);
        assertEquals(10, list.get(0));
        assertEquals(5, list.get(1));

        list.addFirst(7);
        assertEquals(7, list.get(0));
        assertEquals(10, list.get(1));
        assertEquals(5, list.get(2));
    }

    @Test
    void testAddLast() {
        SinglyLinkedList list = new SinglyLinkedList();

        list.addLast(5);
        assertEquals(5, list.get(0));

        list.addLast(10);
        assertEquals(10, list.get(1));
        assertEquals(5, list.get(0));

        list.addLast(7);
        assertEquals(7, list.get(2));
        assertEquals(10, list.get(1));
        assertEquals(5, list.get(0));
    }

    @Test
    void testGetFirst() {
        SinglyLinkedList list = new SinglyLinkedList();

        assertThrows(NoSuchElementException.class, () -> list.getFirst());

        list.addFirst(5);
        assertEquals(5, list.getFirst());

        list.addFirst(10);
        assertEquals(10, list.getFirst());

        list.addFirst(7);
        assertEquals(7, list.getFirst());
    }

    @Test
    void testGetLast() {
        SinglyLinkedList list = new SinglyLinkedList();

        assertThrows(NoSuchElementException.class, () -> list.getLast());

        list.addLast(5);
        assertEquals(5, list.getLast());

        list.addLast(10);
        assertEquals(10, list.getLast());

        list.addLast(7);
        assertEquals(7, list.getLast());
    }

    @Test
    void testAddAtIndex() {
        SinglyLinkedList list = new SinglyLinkedList();

        list.add(0,5);
        assertEquals(5, list.get(0));

        list.add(1,10);
        assertEquals(10, list.get(1));

        list.add(1,15);
        assertEquals(15, list.get(1));

        list.add(0,11);
        assertEquals(11, list.get(0));
    }

    @Test
    void testAddIndexOutOfBound() {
        SinglyLinkedList list = new SinglyLinkedList();

        assertThrows(IndexOutOfBoundsException.class, () -> list.add(1,13));
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(-1,13));

        list.add(5);
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(2,13));
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(-1,13));

        list.add(1,10);
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(3,13));
    }

    @Test
    void testSet() {
        SinglyLinkedList list = new SinglyLinkedList();

        assertThrows(IndexOutOfBoundsException.class, () -> list.set(0,10));

        list.add(2);
        assertEquals(2, list.set(0,10));
        assertEquals(10, list.get(0));
        assertEquals(1, list.size());
    }

    @Test
    void testIndexOf() {
        SinglyLinkedList list = new SinglyLinkedList();

        assertEquals(-1, list.indexOf(3));

        list.add(10);
        list.add(15);
        assertEquals(1, list.indexOf(15));

        list.add(2,20);
        assertEquals(2, list.indexOf(20));
        assertEquals(0, list.indexOf(10));

        list.set(0,30);
        assertEquals(-1, list.indexOf(10));

        list.add(2,6);
        list.add(4,6);
        assertEquals(2, list.indexOf(6));
    }

    @Test
    void testContains() {
        SinglyLinkedList list = new SinglyLinkedList();

        assertFalse(list.contains(10));
        list.add(10);
        assertTrue(list.contains(10));

        list.set(0,15);
        assertTrue(list.contains(15));
        assertFalse(list.contains(10));
    }

    @Test
    void testIsEmpty() {
        SinglyLinkedList list = new SinglyLinkedList();

        assertTrue(list.isEmpty());

        list.add(10);
        assertFalse(list.isEmpty());
    }

    @Test
    void testLastIndexOf() {
        SinglyLinkedList list = new SinglyLinkedList();

        assertEquals(-1, list.lastIndexOf(3));

        list.add(10);
        list.add(15);
        assertEquals(1, list.lastIndexOf(15));

        list.add(2,20);
        assertEquals(2, list.lastIndexOf(20));
        assertEquals(0, list.lastIndexOf(10));

        list.set(0,30);
        assertEquals(-1, list.lastIndexOf(10));

        list.add(2,6);
        list.add(4,6);
        assertEquals(4, list.lastIndexOf(6));

        list.add(6);
        assertEquals(5, list.lastIndexOf(6));
    }
}