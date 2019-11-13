package map;

public final class HasherOne implements Hasher<String> {

    private static final HasherOne HASH = new HasherOne();

    private HasherOne() {};

    public static HasherOne getInstance() {
        return HASH;
    }

    public String hashFunction(String input) {
        if (input.length() > 0) {
            return String.valueOf(input.charAt(0)).toLowerCase();
        }
        return null;
    }

    public String[] getHashVals() {
        String[] vals = new String[27];
        int k = 0;
        for (char i = 'a'; i <= 'z'; i++) {
            vals[k++] = String.valueOf(i);
        }
        vals[26] = null;
        return vals;
    }

    public int getBinNum() {
        return getHashVals().length;
    }
}
