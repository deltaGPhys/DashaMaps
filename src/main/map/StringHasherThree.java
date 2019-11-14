package map;

public class StringHasherThree implements Hasher<String> {
   private static final map.StringHasherThree HASH = new map.StringHasherThree();

    private StringHasherThree() {};

    public static map.StringHasherThree getInstance() {
        return HASH;
    }

    public String hashFunction(String input) {
        if (input == null) {
            return null;
        }
        if (input.length() > 0) {
            return String.valueOf(input.toLowerCase().charAt(0))+String.valueOf(input.toLowerCase().charAt(1));
        }
        return null;
    }

    public String[] getHashVals() {
        String[] vals = new String[677];
        int k = 0;
        for (char i = 'a'; i <= 'z'; i++) {
            for (char j ='a'; j <= 'z'; j++) {
                vals[k++] = String.valueOf(i) + String.valueOf(j);
            }
        }
        vals[676] = null;
        return vals;
    }

    public int getBinNum() {
        return getHashVals().length;
    }
}

