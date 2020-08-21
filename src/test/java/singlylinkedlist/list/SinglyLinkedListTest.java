package singlylinkedlist.list;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
    void addFirst() {
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
    void addLast() {
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
    void getFirst() {
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
    void getLast() {
        SinglyLinkedList list = new SinglyLinkedList();

        assertThrows(NoSuchElementException.class, () -> list.getLast());

        list.addLast(5);
        assertEquals(5, list.getLast());

        list.addLast(10);
        assertEquals(10, list.getLast());

        list.addLast(7);
        assertEquals(7, list.getLast());
    }
}