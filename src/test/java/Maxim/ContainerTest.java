package Maxim;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class ContainerTest {

    @Test
    void add() {
        Container container = new Container();
        container.add(5);
        container.add(10);
        assertEquals("5 10 ", container.toString());
    }

    @Test
    void remove() {
        Container container = new Container();
        container.add(5);
        container.add(10);
        container.remove(0);
        assertEquals("10 ", container.toString());
    }

    @Test
    void set() {
        Container container = new Container();
        container.add(5);
        container.add(10);
        container.set(1, 15);
        assertEquals("5 15 ", container.toString());
    }

    @Test
    void getSize() {
        Container container = new Container();
        container.add(5);
        container.add(10);
        assertEquals(2, container.getSize());
    }
    @Test
    void addByIndex() {
        Container container = new Container();
        container.add(5);
        container.add(10);
        container.add(1, 7);
        assertEquals("5 7 10 ", container.toString());
    }

    @Test
    void pop() {
        Container container = new Container();
        container.add(5);
        container.add(10);
        int poppedValue = container.pop();
        assertEquals(10, poppedValue);
        assertEquals("5 ", container.toString());
    }

    @Test
    void clear() {
        Container container = new Container();
        container.add(5);
        container.add(10);
        container.clear();
        assertEquals("", container.toString());
        assertEquals(0, container.getSize());
    }

    @Test
    void contains() {
        Container container = new Container();
        container.add(5);
        container.add(10);
        assertTrue(container.contains(5));
        assertFalse(container.contains(7));
    }

    @Test
    void tclone() {
        Container container = new Container();
        container.add(5);
        container.add(10);
        Container clonedContainer = container.clone();
        assertEquals(container.toString(), clonedContainer.toString());
    }

    @Test
    void equals() {
        Container container1 = new Container();
        container1.add(5);
        container1.add(10);

        Container container2 = new Container();
        container2.add(5);
        container2.add(10);

        assertTrue(container1.equals(container2));

        Container container3 = new Container();
        container3.add(5);
        container3.add(15);

        assertFalse(container1.equals(container3));
    }

    @Test
    void indexOf() {
        Container container = new Container();
        container.add(5);
        container.add(10);
        container.add(5);
        assertEquals(0, container.indexOf(5));
        assertEquals(1, container.indexOf(10));
        assertEquals(-1, container.indexOf(15));
    }

    @Test
    void lastIndexOf() {
        Container container = new Container();
        container.add(5);
        container.add(10);
        container.add(5);
        assertEquals(2, container.lastIndexOf(5));
        assertEquals(1, container.lastIndexOf(10));
        assertEquals(-1, container.lastIndexOf(15));
    }

    @Test
    void isEmpty() {
        Container container = new Container();
        Container empty_container = new Container();
        container.add(5);
        assertFalse(container.isEmpty());
        assertTrue(empty_container.isEmpty());
    }
}
