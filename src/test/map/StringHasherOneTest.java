package map;

import org.junit.Assert;
import org.junit.Test;

public class StringHasherOneTest {

    @Test
    public void hashValsTest() {
        StringHasherOne hasher = StringHasherOne.getInstance();

        String[] vals = hasher.getHashVals();

        Assert.assertEquals("a",vals[0]);
        Assert.assertEquals("z",vals[25]);
        Assert.assertEquals(null,vals[26]);
        Assert.assertEquals(27,vals.length);
    }

    @Test
    public void hasherTest1() {
        StringHasherOne hasher = StringHasherOne.getInstance();

        String input = "a";
        String expected = "a";

        Assert.assertEquals(expected, hasher.hashFunction(input));
    }

    @Test
    public void hasherTest2() {
        StringHasherOne hasher = StringHasherOne.getInstance();

        String input = "arrow";
        String expected = "a";

        Assert.assertEquals(expected, hasher.hashFunction(input));
    }

    @Test
    public void hasherTest3() {
        StringHasherOne hasher = StringHasherOne.getInstance();

        String input = "cat";
        String expected = "c";

        Assert.assertEquals(expected, hasher.hashFunction(input));
    }

    @Test
    public void hasherTest4() {
        StringHasherOne hasher = StringHasherOne.getInstance();

        String input = "Frog";
        String expected = "f";

        Assert.assertEquals(expected, hasher.hashFunction(input));
    }

    @Test
    public void hasherTest5() {
        StringHasherOne hasher = StringHasherOne.getInstance();

        String input = "";
        String expected = null;

        Assert.assertEquals(expected, hasher.hashFunction(input));
    }
}
