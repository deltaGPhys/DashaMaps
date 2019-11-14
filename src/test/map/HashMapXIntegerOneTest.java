package map;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HashMapXIntegerOneTest {

    private Hasher<Integer> hasherInteger;

    @Before
    public void setUp() throws Exception {
        hasherInteger = IntegerHasherOne.getInstance();
    }

    @After
    public void tearDown() throws Exception {
        HashMapX.changeHashingFunction(null);
    }

    @Test(expected = NoHashingFunctionException.class)
    public void noHasherError() throws NoHashingFunctionException {
        new HashMapX<Integer,String>();
    }

    @Test
    public void noHasherErrorFree() throws NoHashingFunctionException {
        HashMapX.changeHashingFunction(hasherInteger);
        new HashMapX<Integer,String>();
    }

    @Test
    public void put() throws NoHashingFunctionException {
        HashMapX.changeHashingFunction(hasherInteger);
        HashMapX<Integer, String> map = new HashMapX<Integer, String>();
        map.put(2,"Beef");
        Assert.assertEquals(1,map.size());
    }

    @Test
    public void putSecondInSameHash() throws NoHashingFunctionException {
        HashMapX.changeHashingFunction(hasherInteger);
        HashMapX<Integer, String> map = new HashMapX<Integer, String>();
        map.put(2, "Beef");
        map.put(8, "Beefier");
        Assert.assertEquals(2,map.size());
    }

    @Test
    public void putLots() throws NoHashingFunctionException {
        HashMapX.changeHashingFunction(hasherInteger);
        HashMapX<Integer, String> map = new HashMapX<Integer, String>();
        map.put(2, "Beef");
        map.put(8, "Beefier");
        map.put(1, "Cat");
        map.put(28, "Cart");
        map.put(3, "Show");
        map.put(32, "Flow");
        map.put(201, "Cow");
        map.put(84, "Zarp");
        Assert.assertEquals(8,map.size());
    }

    @Test
    public void findListIndex() throws NoHashingFunctionException, HashValueNotFoundException {
        HashMapX.changeHashingFunction(hasherInteger);
        HashMapX<Integer, String> map = new HashMapX<Integer, String>();
        int actual = map.findListIndex(982301);
        int expected = 1;
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void findListIndex2() throws NoHashingFunctionException, HashValueNotFoundException {
        HashMapX.changeHashingFunction(hasherInteger);
        HashMapX<Integer, String> map = new HashMapX<Integer, String>();
        int actual = map.findListIndex(2034);
        int expected = 4;
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void findListIndex3() throws NoHashingFunctionException, HashValueNotFoundException {
        HashMapX.changeHashingFunction(hasherInteger);
        HashMapX<Integer, String> map = new HashMapX<Integer, String>();
        int actual = map.findListIndex(0);
        int expected = 0;
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void findListIndexException() throws NoHashingFunctionException, HashValueNotFoundException {
        HashMapX.changeHashingFunction(hasherInteger);
        HashMapX<Integer, String> map = new HashMapX<Integer, String>();
        int actual = map.findListIndex(null);
        int expected = 10;
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void get() throws NoHashingFunctionException {
        HashMapX.changeHashingFunction(hasherInteger);
        HashMapX<Integer, String> map = new HashMapX<Integer, String>();
        map.put(2, "Beef");
        map.put(8, "Beefier");
        map.put(1, "Cat");
        map.put(28, "Cart");
        map.put(3, "Show");
        map.put(32, "Flow");
        map.put(201, "Cow");
        map.put(84, "Zarp");
        Assert.assertEquals("Cart",map.get(28));
        Assert.assertEquals(null,map.get(90));
        Assert.assertEquals("Cow",map.get(201));
    }
}
