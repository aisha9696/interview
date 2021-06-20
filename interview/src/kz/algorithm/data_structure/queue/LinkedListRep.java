package kz.algorithm.data_structure.queue;

public class LinkedListRep {
    private Node first = null;
    private Node last =null;

    public class Node{
        private Object value;
        private Node next;

        public Node(Object value) {
            this.value = value;
            this.next = null;
        }
    }

    public boolean isEmpty(){
        return first == null;
    }

    public Object dequeue(){
        Object item = first.value;
        first = first.next;
        if(isEmpty()){
            last = null;
        }
        return item;
    }

    public void enqueue(Object new_val){
        Node last = new Node(new_val);
        Node old_last = last;

        last.next = null;
        if(isEmpty()){
            first = last;
        } else {
            old_last.next = last;
        }
    }

    public void toIterate(){

        Node nodes = this.first;
        while (nodes!=null){
            System.out.println(nodes.value +"\t");
            nodes =nodes.next;
        }

    }
    public static void main(String[] args) {
        LinkedListRep queue = new LinkedListRep();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.dequeue();
        queue.toIterate();


    }
}
