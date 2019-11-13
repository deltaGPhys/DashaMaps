package map;


import java.util.ArrayList;

public class HashMapX<E extends Comparable<E>,T> {

    private static Hasher HASHER;
    private static int hashPoss;
    private static Object[] hashVals;
    private ArrayList<SinglyLinkedList<E>> lists;


    public HashMapX() throws NoHashingFunctionException {
        if (HASHER == null) {
            throw new NoHashingFunctionException();
        }
    }

    public boolean put(E element, T value)  {
        SinglyLinkedList<E> targetList;
        try {
            targetList = lists.get(findListIndex(element));
            targetList.add(element);
            return true;
        } catch (HashValueNotFoundException e) {
            e.printStackTrace();
            return false;
        }

    }

    public int findListIndex(E element) throws HashValueNotFoundException {
        E hashValue = (E) HASHER.hashFunction(element);
        for (int i = 0; i < hashPoss; i++) {
            if (hashValue.equals((E)hashVals[i])) {
                return i;
            }
        }
        throw new HashValueNotFoundException();
    }

    public void changeHashingFunction(Hasher<E> hasher) {
        HASHER = hasher;
        hashPoss = hasher.getBinNum();
        hashVals = hasher.getHashVals();
        lists = new ArrayList<SinglyLinkedList<E>>(hashPoss);
    }
}
