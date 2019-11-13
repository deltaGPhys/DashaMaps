package map;

import org.junit.Assert;
import org.junit.Test;

public class SinglyLinkedListTest {

    private SinglyLinkedList<Integer> sll;

    @org.junit.Before
    public void setUp() throws Exception {
        sll = new SinglyLinkedList<Integer>();
    }

    @org.junit.Test
    public void add() {
        Assert.assertEquals(0, sll.size());
        sll.add(3);
        Assert.assertEquals(1, sll.size());
        sll.add(7);
        Assert.assertEquals(2, sll.size());
    }

    @org.junit.Test
    public void contains() {
        Assert.assertFalse(sll.contains(3));
        sll.add(3);
        Assert.assertTrue(sll.contains(3));
        Assert.assertFalse(sll.contains(7));
        sll.add(7);
        Assert.assertTrue(sll.contains(3));
        Assert.assertTrue(sll.contains(7));
    }

    @Test
    public void find() {
        sll.add(9);
        sll.add(7);
        sll.add(3);
        Assert.assertEquals(-1, sll.find(5));
        Assert.assertEquals(2, sll.find(3));
        Assert.assertEquals(0, sll.find(9));
    }

    @Test
    public void get() {
        sll.add(9);
        sll.add(7);
        sll.add(3);
        Assert.assertEquals(null, sll.get(5));
        Assert.assertEquals((Integer) 9, sll.get(0));
        Assert.assertEquals((Integer) 3, sll.get(2));

    }

    @org.junit.Test
    public void remove() {
        sll.add(9);
        sll.add(7);
        sll.add(3);
        sll.add(4);
        Assert.assertTrue(sll.contains(3));
        Assert.assertTrue(sll.contains(7));
        sll.remove(2);
        Assert.assertFalse(sll.contains(3));
        Assert.assertTrue(sll.contains(7));
        sll.remove(0);
        Assert.assertFalse(sll.contains(3));
        Assert.assertFalse(sll.contains(9));
        Assert.assertTrue(sll.contains(7));
    }

    @org.junit.Test
    public void copy() {
        Integer integerObj = 3;
        sll.add(9);
        sll.add(7);
        sll.add(integerObj);
        sll.add(4);
        SinglyLinkedList<Integer> copy = sll.copy();
        Assert.assertEquals(9,copy.get(0),.01);
        Assert.assertEquals(2,copy.find(3),.01);
        Assert.assertNotEquals(integerObj,copy.get(3),.01);
        Assert.assertEquals(3,copy.find(4),.01);
    }

    @org.junit.Test
    public void sort() {
        sll.add(9);
        sll.add(7);
        sll.add(3);
        sll.add(4);
        sll.sort();
        Assert.assertEquals(3, sll.get(0),.01);
        Assert.assertEquals(4, sll.get(1),.01);
        Assert.assertEquals(7, sll.get(2),.01);
        Assert.assertEquals(9, sll.get(3),.01);
    }

    @org.junit.Test
    public void reverse() {
        sll.add(9);
        sll.add(7);
        sll.add(3);
        sll.add(4);
        sll.reverse();
        Assert.assertEquals(9, sll.get(0),.01);
        Assert.assertEquals(7, sll.get(1),.01);
        Assert.assertEquals(4, sll.get(2),.01);
        Assert.assertEquals(3, sll.get(3),.01);
    }

}