package map;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HashMapXTest {

    private Hasher<String> hasherString;

    @Before
    public void setUp() throws Exception {
        hasherString = HasherOne.getInstance();
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
        HashMapX.changeHashingFunction(hasherString);
        new HashMapX<Integer,String>();
    }

    @Test
    public void put() throws NoHashingFunctionException {
        HashMapX.changeHashingFunction(hasherString);
        HashMapX<String, Integer> map = new HashMapX<String, Integer>();
        map.put("Beef", 2);
        Assert.assertEquals(1,map.size());
    }

    @Test
    public void putSecondInSameHash() throws NoHashingFunctionException {
        HashMapX.changeHashingFunction(hasherString);
        HashMapX<String, Integer> map = new HashMapX<String, Integer>();
        map.put("Beef", 2);
        map.put("Beefier", 8);
        Assert.assertEquals(2,map.size());
    }

    @Test
    public void putLots() throws NoHashingFunctionException {
        HashMapX.changeHashingFunction(hasherString);
        HashMapX<String, Integer> map = new HashMapX<String, Integer>();
        map.put("Beef", 2);
        map.put("Beefier", 8);
        map.put("Cat", 1);
        map.put("Cart", 28);
        map.put("Show", 3);
        map.put("Flow", 32);
        map.put("Cow", 201);
        map.put("Zarp", 84);
        Assert.assertEquals(8,map.size());
    }

    @Test
    public void findListIndex() throws NoHashingFunctionException, HashValueNotFoundException {
        HashMapX.changeHashingFunction(hasherString);
        HashMapX<String, Integer> map = new HashMapX<String, Integer>();
        int actual = map.findListIndex("broke");
        int expected = 1;
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void findListIndex2() throws NoHashingFunctionException, HashValueNotFoundException {
        HashMapX.changeHashingFunction(hasherString);
        HashMapX<String, Integer> map = new HashMapX<String, Integer>();
        int actual = map.findListIndex("Zarp");
        int expected = 25;
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void findListIndex3() throws NoHashingFunctionException, HashValueNotFoundException {
        HashMapX.changeHashingFunction(hasherString);
        HashMapX<String, Integer> map = new HashMapX<String, Integer>();
        int actual = map.findListIndex("");
        int expected = 26;
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void findListIndexException() throws NoHashingFunctionException, HashValueNotFoundException {
        HashMapX.changeHashingFunction(hasherString);
        HashMapX<String, Integer> map = new HashMapX<String, Integer>();
        int actual = map.findListIndex(null);
        int expected = 26;
        Assert.assertEquals(expected,actual);
    }
}