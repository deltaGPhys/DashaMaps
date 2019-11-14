package map;

import org.junit.Assert;
import org.junit.Test;

public class MultiHashTest {

    private Hasher<Integer> hasherInteger = IntegerHasherOne.getInstance();
    private Hasher<String> hasherString1 = StringHasherOne.getInstance();
    private Hasher<String> hasherString2 = StringHasherTwo.getInstance();
    private Hasher<String> hasherString3 = StringHasherThree.getInstance();

    @Test(expected = NoHashingFunctionException.class)
    public void noHasherError() throws NoHashingFunctionException {
        new HashMapX<Integer,String>();
    }

    @Test
    public void put() throws NoHashingFunctionException {
        HashMapX.changeHashingFunction(hasherInteger);
        HashMapX<Integer, String> map = new HashMapX<Integer, String>();
        map.put(2,"Beef");
        Assert.assertEquals(1,map.size());

        HashMapX.changeHashingFunction(hasherString1);
        HashMapX<String, String> map2 = new HashMapX<String, String>();
        map2.put("Jim","Beef");
        Assert.assertEquals(1,map2.size());

        HashMapX.changeHashingFunction(hasherString2);
        HashMapX<String, String> map3 = new HashMapX<String, String>();
        map3.put("Jim","Beef");
        Assert.assertEquals(1,map3.size());

        HashMapX.changeHashingFunction(hasherString3);
        HashMapX<String, String> map4 = new HashMapX<String, String>();
        map4.put("Jim","Beef");
        Assert.assertEquals(1,map4.size());

        //now use the old hashers!
        map.put(5,"Beefier");
        Assert.assertEquals(2,map.size());

        map2.put("Jimmy","Beefier");
        Assert.assertEquals(2,map2.size());

        map3.put("Jimmy","Beefier");
        Assert.assertEquals(2,map3.size());

        map4.put("Jimmy","Beefier");
        Assert.assertEquals(2,map4.size());
    }


    @Test
    public void get() throws NoHashingFunctionException {
        HashMapX.changeHashingFunction(hasherString3);
        HashMapX<String, Integer> map4 = new HashMapX<String, Integer>();
        HashMapX.changeHashingFunction(hasherInteger);
        HashMapX<Integer, String> map = new HashMapX<Integer, String>();
        HashMapX.changeHashingFunction(hasherString1);
        HashMapX<String, Integer> map2 = new HashMapX<String, Integer>();
        HashMapX.changeHashingFunction(hasherString2);
        HashMapX<String, Integer> map3 = new HashMapX<String, Integer>();

        // mix 'em up!
        map4.put("Cow", 201);
        map4.put("Zarp", 84);
        map2.put("Beef", 2);
        map2.put("Beefier", 8);
        map3.put("Cat", 1);
        map3.put("Cart", 28);
        map3.put("Show", 3);
        map3.put("Flow", 32);
        map.put(2, "Beef");
        map.put(8, "Beefier");
        map.put(1, "Cat");
        map.put(28, "Cart");
        map2.put("Cat", 1);
        map2.put("Cart", 28);
        map2.put("Show", 3);
        map2.put("Flow", 32);
        map.put(3, "Show");
        map.put(32, "Flow");
        map4.put("Beef", 2);
        map4.put("Beefier", 8);
        map4.put("Cat", 1);
        map4.put("Cart", 28);
        map4.put("Show", 3);
        map4.put("Flow", 32);
        map.put(201, "Cow");
        map.put(84, "Zarp");
        map3.put("Beef", 2);
        map3.put("Beefier", 8);
        map2.put("Cow", 201);
        map2.put("Zarp", 84);
        map3.put("Cow", 201);
        map3.put("Zarp", 84);

        // all still playing by their own rules?
        Assert.assertEquals("Cart",map.get(28));
        Assert.assertEquals(null,map.get(90));
        Assert.assertEquals("Cow",map.get(201));

        Assert.assertEquals((Integer) 28,map2.get("Cart"));
        Assert.assertEquals(null,map2.get("Carts"));
        Assert.assertEquals((Integer) 201,map2.get("Cow"));

        Assert.assertEquals((Integer) 28,map3.get("Cart"));
        Assert.assertEquals(null,map3.get("Carts"));
        Assert.assertEquals((Integer) 201,map3.get("Cow"));

        Assert.assertEquals((Integer) 28,map4.get("Cart"));
        Assert.assertEquals(null,map4.get("Carts"));
        Assert.assertEquals((Integer) 201,map4.get("Cow"));
    }
}
