package kz.algorithm.letcode.stack;

import kz.algorithm.data_structure.linked_list.MyNode;

import java.util.LinkedList;

public class MinStack {
   /* private static final int size = 10000;
    private int N = 0;
    private int min = Integer.MAX_VALUE;*/

    /*private Integer[] array;
    /** initialize your data structure here. */
   /* public MinStack() {
        this.array = new Integer[size];
    }

    public void push(int val) {
        if(N == 0) {array[0] = val; min = val;  N++; return;}
        if(val < min) {
            min = val;
            shift(N);
            array[0] = val;

            N ++;
        }else{
            int index = 0;
            for(int i = 0; i<size &&  array[i] <= val; i++){
                index ++;
            }
            array[index] =val;
            shift(index++);
            N++;
        }

    }

    public void pop() {
        array[N] = 0;
        N--;
    }

    public int top() {
        return array[N];
    }

    public int getMin() {
        return min;
    }

    public void shift(int index){
        Integer[] copy = new Integer[size];
        for(int i = index; i<size; i++){
            copy[i+1] = array[i];
        }
        array = copy;
    }
*/

    public class Node{
        private Integer value;
        private Node next;

        public Node(Integer value) {
            this.value = value;
            this.next = null;
        }
    }

    private int minVal ;
    private Node head ;
    public MinStack() {
        this.head = null;
        this.minVal = Integer.MAX_VALUE;
    }

    public void push(int val) {
        if(head == null) { this.head = new Node(val); minVal = val; return;}

        if(val < minVal){
            minVal = val;

        }
        Node new_node = new Node(val);
        new_node.next = this.head;
        head = new_node;
    }

    public void pop() {
        if(head == null) { this.head =null; return;}
        Node node = this.head;
        int secndMin = Integer.MIN_VALUE;
        if(node.value == minVal){

        }
        node.next = null;
    }

    public int top() {
        if(head == null) { return Integer.MIN_VALUE; }
        Node node = this.head;

        while (node.next != null){
            node = node.next;
        }
        return node.value;
    }

    public int getMin() {
       if(head == null) return Integer.MIN_VALUE;
       return minVal;
    }


    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);

        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());

    }
}
