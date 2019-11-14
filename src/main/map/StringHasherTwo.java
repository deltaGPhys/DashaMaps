package map;

public class StringHasherTwo implements Hasher<String> {

    private static final StringHasherTwo HASH = new StringHasherTwo();

    private StringHasherTwo() {};

    public static StringHasherTwo getInstance() {
        return HASH;
    }

    public String hashFunction(String input) {
        if (input == null) {
            return null;
        }
        if (input.length() > 1) {
            return String.valueOf(input.charAt(1)).toLowerCase();
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
