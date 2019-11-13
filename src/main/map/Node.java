package map;

public class Node<E, T> {

    public E key;
    public T value;
    public Node next;

    public Node(E key, T value, Node next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }

    public E getKey() {
        return key;
    }

    public T getValue() {
        return value;
    }

    public Node getNext() {
        return next;
    }

    public void setKey(E key) {
        this.key = key;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
