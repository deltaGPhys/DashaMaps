package map;

public class Node<E extends Comparable<E>> {

    public E data;
    public Node next;

    public Node(E data, Node next) {
        this.data = data;
        this.next = next;
    }

    public E getData() {
        return data;
    }

    public Node getNext() {
        return next;
    }

    public void setData(E data) {
        this.data = data;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public int compareTo(Node node2) {
        return (this.data.compareTo((E) node2.getData()));
    }
}
