package map;

import java.util.Arrays;

public class SinglyLinkedList<E,T> {

    private Node[] nodes;
    private Node head;

    public SinglyLinkedList() {
        this.nodes = new Node[0];
        this.head = null;
    }

    public void add(E key, T value) {
        if (this.nodes.length == 0) {
            this.nodes = new Node[] {new Node(key, value,null)};
            this.head = this.nodes[0];
        } else {
            Node[] newNodes = Arrays.copyOf(this.nodes,this.nodes.length + 1);

            Node newNode = new Node(key, value, null);
            newNodes[this.nodes.length-1].next = newNode;
            newNodes[this.nodes.length] = newNode;
            this.nodes = newNodes;
        }
    }

    public void remove(int index) {
        Node[] newNodes = new Node[nodes.length-1];
        if (index != 0 && index < this.nodes.length - 1) {
            this.nodes[index-1].next = this.nodes[index + 1];
        } else if (index == this.nodes.length - 1){
            this.nodes[index-1].next = null;
        }
        for (int i = 0, k = 0; i < this.nodes.length; i++) {
            if (i != index) {
                newNodes[k++] = this.nodes[i];
            }
        }
        this.nodes = newNodes;
        this.head = this.nodes[0];

    }

    public int size() {
        return nodes.length;
    }

    public boolean contains(T value) {
        if (this.nodes.length == 0 ){
            return false;
        }
        for (Node node : this.nodes) {
            if (node.value.equals(value)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsKey(E key) {
        if (this.nodes.length == 0 ){
            return false;
        }
        for (Node node : this.nodes) {
            if (node.key.equals(key)) {
                return true;
            }
        }
        return false;
    }

    public int find(T value) {
        if (this.nodes.length == 0 ){
            return -1;
        }
        for (int i = 0; i < this.nodes.length; i++) {
            if (this.nodes[i].value.equals(value)) {
                return i;
            }
        }
        return -1;
    }

    public T get(int index) {
        if (index > this.nodes.length -1 || index < 0){
            return null;
        }
        return (T) this.nodes[index].value;
    }

    public T get(E key) {
        if (!containsKey(key)){
            return null;
        }
        for (int i = 0; i < this.nodes.length; i++) {
            if (this.nodes[i].key.equals(key)) {
                return (T) this.nodes[i].value;
            }
        }
        return null;
    }

}
