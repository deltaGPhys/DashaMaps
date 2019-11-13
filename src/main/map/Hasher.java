package map;

public interface Hasher<E> {

    E hashFunction (E input);

    E[] getHashVals ();

    int getBinNum();
}
