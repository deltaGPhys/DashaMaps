package map;

public class IntegerHasherOne implements Hasher<Integer> {

    private static final IntegerHasherOne HASH = new IntegerHasherOne();

    private IntegerHasherOne() {};

    public static IntegerHasherOne getInstance() {
        return HASH;
    }

    public Integer hashFunction(Integer input) {
        if (input == null) {
            return null;
        }
        if (input != Integer.MAX_VALUE && input != Integer.MIN_VALUE) {
            return input % 10;
        }
        return null;
    }

    public Integer[] getHashVals() {
        Integer[] vals = new Integer[11];

        for (int i = 0; i<= 9; i++) {
            vals[i] = i;
        }
        vals[10] = null;
        return vals;
    }

    public int getBinNum() {
        return getHashVals().length;
    }
}
