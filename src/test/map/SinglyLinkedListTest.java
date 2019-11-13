package map;

import org.junit.Assert;
import org.junit.Test;

public class SinglyLinkedListTest {

    private SinglyLinkedList<Integer, String> sll;

    @org.junit.Before
    public void setUp() throws Exception {
        sll = new SinglyLinkedList<Integer, String>();
    }

    @org.junit.Test
    public void add() {
        Assert.assertEquals(0, sll.size());
        sll.add(3, "Bing");
        Assert.assertEquals(1, sll.size());
        sll.add(7, "Bong");
        Assert.assertEquals(2, sll.size());
    }

    @org.junit.Test
    public void contains() {
        Assert.assertFalse(sll.contains("Bing"));
        sll.add(3, "Bing");
        Assert.assertTrue(sll.contains("Bing"));
        Assert.assertFalse(sll.contains("Bong"));
        sll.add(7, "Bong");
        Assert.assertTrue(sll.contains("Bing"));
        Assert.assertTrue(sll.contains("Bong"));
    }

    @Test
    public void find() {
        sll.add(9, "Boom");
        sll.add(7, "Bong");
        sll.add(3, "Bing");
        Assert.assertEquals(-1, sll.find("Zoom"));
        Assert.assertEquals(2, sll.find("Bing"));
        Assert.assertEquals(0, sll.find("Boom"));
    }

    @Test
    public void get() {
        sll.add(9, "Boom");
        sll.add(7, "Bong");
        sll.add(3, "Bing");
        Assert.assertEquals(null, sll.get(5));
        Assert.assertEquals("Boom", sll.get(0));
        Assert.assertEquals("Bing", sll.get(2));

    }

    @org.junit.Test
    public void remove() {
        sll.add(9, "Boom");
        sll.add(7, "Bong");
        sll.add(3, "Bing");
        sll.add(4, "Zarp");
        Assert.assertTrue(sll.contains("Bing"));
        Assert.assertTrue(sll.contains("Bong"));
        sll.remove(2);
        Assert.assertFalse(sll.contains("Bing"));
        Assert.assertTrue(sll.contains("Bong"));
        sll.remove(0);
        Assert.assertFalse(sll.contains("Bing"));
        Assert.assertFalse(sll.contains("Boom"));
        Assert.assertTrue(sll.contains("Bong"));
    }


}