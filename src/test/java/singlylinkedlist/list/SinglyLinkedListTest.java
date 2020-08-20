package singlylinkedlist.list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SinglyLinkedListTest {

    @Test
    void testAddSingleElement() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.add(10);
        assertEquals(1, list.size());
    }

    @Test
    void testAddMultipleElements() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.add(5);
        list.add(23);
        assertEquals(2, list.size());
    }

}