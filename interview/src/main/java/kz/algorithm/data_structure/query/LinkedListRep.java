package kz.algorithm.data_structure.query;

public class LinkedListRep {
    private Node first = null;
    private Node last = null;

    private class Node{
        private Object value;
        private Node next;

        public Node(Object value) {
            this.value = value;
            this.next =null;
        }
    }

    public Object pop(){
        Object item = first.value;
        first = first.next;
        return item;
    }

    public void push(Object value){
        Node old_obj = last;
        Node last = new Node(value);
        last.next = null;
        old_obj.next = last;

    }

    public static void main(String[] args) {

    }
}
