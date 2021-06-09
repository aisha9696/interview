package kz.algorithm.data_structure.stack;

public class LinkedListRep {

    /**
     * Every operation get O(n) time in worst case
     * **/
    private Node first = null;

    private class Node{
        private Object value;
        private Node next;

        public Node(Object value) {
            this.value = value;
            this.next =null;
        }
    }

    public boolean isEmpty(){
        return first == null;
    }

    public void push(Object val){
        Node oldfirst = first;
        first = new Node(val);
        first.next = oldfirst;
    }

    public Object pop(){
        Object item = first.value;
        first = first.next;
        return item;
    }


}
