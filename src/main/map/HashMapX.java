package map;


import java.util.ArrayList;

public class HashMapX<E extends Comparable<E>,T> {

    private static Hasher HASHER;
    private static int hashPoss;
    private static Object[] hashVals;
    private ArrayList<SinglyLinkedList<E,T>> lists;


    public HashMapX() throws NoHashingFunctionException {
        if (HASHER == null) {
            throw new NoHashingFunctionException();
        }
        lists = new ArrayList<SinglyLinkedList<E,T>>(hashPoss);
        for (int i = 0; i < hashPoss; i++) { // add a head node to each list with the hash value as the key, null as the value. It'll point nowhere initially
            lists.add(new SinglyLinkedList<E,T>());
            lists.get(i).add((E)hashVals[i], null);
        }
    }

    public boolean put(E element, T value)  {
        SinglyLinkedList<E,T> targetList;
        try {
            targetList = lists.get(findListIndex(element));
            targetList.add(element, value);
            return true;
        } catch (HashValueNotFoundException e) {
            e.printStackTrace();
            return false;
        }

    }

    public int findListIndex(E element) throws HashValueNotFoundException {
        E hashValue = (E) HASHER.hashFunction(element);
        if (hashValue == null) {
            return hashPoss-1;
        }

        for (int i = 0; i < hashPoss; i++) {
            if (hashValue.equals((E)hashVals[i])) {
                return i;
            }
        }
        throw new HashValueNotFoundException();
    }

    public int size() {
        int count = 0;
        for (SinglyLinkedList<E,T> list : lists) {
            count += list.size();
        }
        return count - hashPoss; //don't count the heads
    }

    public static void changeHashingFunction(Hasher hasher) {
        if (hasher == null) {
            HASHER = null;
            hashPoss = 0;
            hashVals = null;
        } else {
            HASHER = hasher;
            hashPoss = hasher.getBinNum();
            hashVals = hasher.getHashVals();
        }
    }
}
