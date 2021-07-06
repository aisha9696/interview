package kz.algorithm.data_structure.linked_list;

public class MyLinkedListClass {
    private MyNode head;
    private int size;

    /** Initialize your data structure here. */
    public MyLinkedListClass() {
        this.head = null;
        size = 0;
    }

    public static class MyNode{
        private int val;
        private MyNode next;

        public MyNode (int val){
            this.val = val;
            this.next = null;
        }

    }

    public int get(int index) {
        MyNode node = this.head;

        for(int i = 0; i < index && node != null; i++){
            node = node.next;
        }
        if(node != null){
            return node.val;
        }else{
            return -1;
        }

    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        MyNode node = this.head;
        while (node.next != null){
            node = node.next;
        }
        MyNode new_node = new MyNode(val);
        node.next = new_node;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index < 0 || index > size){
            return;
        }
        MyNode new_node = new MyNode(val);
        if(this.head == null && index == 0){
            this.head = new_node;
            size ++;
            return;
        }
        if(index == 0){
            new_node.next = this.head;
            this.head = new_node;
            size ++;
            return;
        }


        MyNode node = this.head;
        for(int i = 0 ; i < index -1 && node != null; i++){
            node = node.next;
        }
        new_node.next = node.next;
        node.next = new_node;
        size ++;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index < 0 || index >= size){
            return;
        }
        MyNode node = this.head;
        if(index == 0){
            this.head = node.next;
            size ++;
            return;
        }

        for(int i = 0 ; i < index-1 && node != null; i++){
            node = node.next;
        }
        if(node == null && node.next == null){
            return;
        }

        node.next = node.next.next;

    }


    public static void main(String[] args) {
        MyLinkedListClass myLinkedListClass = new MyLinkedListClass();
        myLinkedListClass.addAtHead(2);
        myLinkedListClass.deleteAtIndex(1);
        myLinkedListClass.addAtHead(7);
        myLinkedListClass.addAtHead(2);
        myLinkedListClass.addAtHead(1);
        myLinkedListClass.addAtHead(2);
        myLinkedListClass.addAtHead(5);
        myLinkedListClass.addAtTail(5);

        myLinkedListClass.addAtIndex(3,0);
        myLinkedListClass.deleteAtIndex(2);
        myLinkedListClass.addAtHead(6);
        myLinkedListClass.addAtTail(4);
        System.out.println(myLinkedListClass.get(4));
        myLinkedListClass.addAtHead(4);
        myLinkedListClass.addAtIndex(5,0);
        myLinkedListClass.addAtHead(6);

        MyNode myNode = myLinkedListClass.head ;
        while( myNode!= null){
            System.out.print(myNode.val+"-");
            myNode = myNode.next;
        }

    }

}
