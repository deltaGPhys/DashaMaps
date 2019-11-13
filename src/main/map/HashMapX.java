package map;


public class HashMapX<E extends Comparable<E>,T> {

    private static Hasher HASHER;
    private static int hashPoss;
    private SinglyLinkedList<E>[] lists;


    public HashMapX() {
        if (HASHER == null) {

        }
    }

    public void changeHashingFunction(Hasher<E> hasher) {
        HASHER = hasher;
        hashPoss = hasher.getBinNum();
        lists = new SinglyLinkedList<E>[hashPoss];

    }
}
