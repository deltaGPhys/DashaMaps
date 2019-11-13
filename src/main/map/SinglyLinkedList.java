package map;

import java.util.Arrays;

public class SinglyLinkedList<E extends Comparable<E>> {

    private Node[] nodes;
    private Node head;

    public SinglyLinkedList() {
        this.nodes = new Node[0];
        this.head = null;
    }

    public void add(E data) {
        if (this.nodes.length == 0) {
            this.nodes = new Node[] {new Node(data,null)};
            this.head = this.nodes[0];
        } else {
            Node[] newNodes = Arrays.copyOf(this.nodes,this.nodes.length + 1);

            Node newNode = new Node(data,null);
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

    public boolean contains(E data) {
        if (this.nodes.length == 0 ){
            return false;
        }
        for (Node node : this.nodes) {
            if (node.data.equals(data)) {
                return true;
            }
        }
        return false;
    }

    public int find(E data) {
        if (this.nodes.length == 0 ){
            return -1;
        }
        for (int i = 0; i < this.nodes.length; i++) {
            if (this.nodes[i].data.equals(data)) {
                return i;
            }
        }
        return -1;
    }

    public E get(int index) {
        if (index > this.nodes.length -1 || index < 0){
            return null;
        }
        return (E) this.nodes[index].data;
    }

    public SinglyLinkedList<E> copy() {
        SinglyLinkedList<E> copy = new SinglyLinkedList<E>();
        for (Node node : this.nodes) {
            copy.add((E) node.data);
        }
        return copy;
    }

    public void sort() {
        if (this.nodes.length == 0) {
            return;
        }
        E temp;
        for (int i = 0; i < this.nodes.length -1; i++) {
            for (int j = 0; j < this.nodes.length - i - 1; j++) {
                if (this.nodes[j].compareTo(this.nodes[j+1]) > 0){
                    temp = (E) this.nodes[j].data;
                    this.nodes[j].data = this.nodes[j+1].data;
                    this.nodes[j+1].data = temp;
                }
            }
        }
    }

    public void reverse() {
        if (this.nodes.length == 0) {
            return;
        }
        E temp;
        this.sort();
        int len = this.nodes.length;
        for (int i = 0; i < len >> 1; i++) {
            temp = (E) this.nodes[len-i-1].data;
            this.nodes[len-i-1].data = this.nodes[i].data;
            this.nodes[i].data = temp;
        }

    }
}
