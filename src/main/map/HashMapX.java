package map;


import java.util.ArrayList;

public class HashMapX<E extends Comparable<E>,T> {

    private static Hasher currentHasher;
    private Hasher hasher;
    private int hashPoss;
    private Object[] hashVals;
    private ArrayList<SinglyLinkedList<E,T>> lists;


    public HashMapX() throws NoHashingFunctionException {
        if (currentHasher == null) {
            throw new NoHashingFunctionException();
        }
        this.hasher = currentHasher;
        this.hashPoss = this.hasher.getBinNum();
        this.hashVals = this.hasher.getHashVals();

        this.lists = new ArrayList<SinglyLinkedList<E,T>>(hashPoss);
        for (int i = 0; i < hashPoss; i++) { // add a head node to each list with the hash value as the key, null as the value. It'll point nowhere initially
            this.lists.add(new SinglyLinkedList<E,T>());
            this.lists.get(i).add((E)hashVals[i], null);
        }
    }

    public boolean put(E element, T value)  {
        SinglyLinkedList<E,T> targetList;
        targetList = this.lists.get(findListIndex(element));
        targetList.add(element, value);
        return true;
    }

    public int findListIndex(E element) {
        E hashValue = (E) this.hasher.hashFunction(element);
        if (hashValue == null) {
            return this.hashPoss-1;
        }

        for (int i = 0; i < hashPoss; i++) {
            if (hashValue.equals((E)this.hashVals[i])) {
                return i;
            }
        }
        return this.hashPoss-1; //break glass in case of fire - put anything not recognized into null box
    }

    public T get(E element) {
        SinglyLinkedList<E, T> targetList;
        targetList = this.lists.get(findListIndex(element));
        return targetList.get(element);
    }

    public int size() {
        int count = 0;
        for (SinglyLinkedList<E,T> list : this.lists) {
            count += list.size();
        }
        return count - this.hashPoss; //don't count the heads
    }

    public static void changeHashingFunction(Hasher hasher) {
        if (hasher == null) {
            currentHasher = null;
        } else {
            currentHasher = hasher;
        }
    }
}
