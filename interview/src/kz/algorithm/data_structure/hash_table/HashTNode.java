package kz.algorithm.data_structure.hash_table;


public class HashTNode {
    private Object key;
    private Object value;
    private HashTNode next;

    public Object getKey() {
        return key;
    }

    public void setKey(Object key) {
        this.key = key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public HashTNode getNext() {
        return next;
    }

    public void setNext(HashTNode next) {
        this.next = next;
    }

    public HashTNode(Object key, Object value, HashTNode next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }
}
