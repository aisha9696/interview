package kz.algorithm.data_structure.stack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MyStack {

    Queue<Integer> queue = null;

    public MyStack() {
        queue = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if(empty()) return Integer.MIN_VALUE;
        Queue<Integer> current = new LinkedList<>();
        while (queue.size() != 1){
            current.add(queue.poll());
        }
        int last = queue.poll();
        queue = current;
        return last;
    }

    /** Get the top element. */
    public int top() {
        if(empty()) return Integer.MIN_VALUE;
        Queue<Integer> current = new LinkedList<>();
        int last = 0;
        while (queue.size() != 0){
            last = queue.poll();
            current.add(last);
        }
        queue = current;
        return last;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.size() == 0;
    }




    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        stack.pop();
        stack.push(4);
        stack.push(5);
        stack.push(7);
        stack.pop();
        stack.pop();
        System.out.println(stack.top());


    }

}
