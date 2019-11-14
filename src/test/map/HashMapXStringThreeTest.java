package map;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class HashMapXStringThreeTest {

    private Hasher<String> hasherString;

    @Before
    public void setUp() throws Exception {
        hasherString = StringHasherThree.getInstance();
    }

    @After
    public void tearDown() throws Exception {
        HashMapX.changeHashingFunction(null);
    }

    @Test
    public void lookValues() {
        ArrayList<Integer> values = new ArrayList<Integer>();
        for (char i = 'a'; i <= 'z'; i++) {
            for (char j = 'a'; j <= 'z'; j++) {
                values.add(i+j);
            }
        }
        Collections.sort(values);
        System.out.println(values.size());
        System.out.println(values.get(0));
        System.out.println(values.get(675));
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
        int expected = 43;
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void findListIndex2() throws NoHashingFunctionException, HashValueNotFoundException {
        HashMapX.changeHashingFunction(hasherString);
        HashMapX<String, Integer> map = new HashMapX<String, Integer>();
        int actual = map.findListIndex("Zarp");
        int expected = 650;
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void findListIndex3() throws NoHashingFunctionException, HashValueNotFoundException {
        HashMapX.changeHashingFunction(hasherString);
        HashMapX<String, Integer> map = new HashMapX<String, Integer>();
        int actual = map.findListIndex("");
        int expected = 676;
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void findListIndexException() throws NoHashingFunctionException, HashValueNotFoundException {
        HashMapX.changeHashingFunction(hasherString);
        HashMapX<String, Integer> map = new HashMapX<String, Integer>();
        int actual = map.findListIndex(null);
        int expected = 676;
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void get() throws NoHashingFunctionException {
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
        Assert.assertEquals((Integer) 28,map.get("Cart"));
        Assert.assertEquals(null,map.get("Carts"));
        Assert.assertEquals((Integer) 201,map.get("Cow"));
    }
}