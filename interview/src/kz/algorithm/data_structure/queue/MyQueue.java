package kz.algorithm.data_structure.queue;

import kz.algorithm.data_structure.stack.MyStack;

import javax.swing.*;
import java.util.Stack;

public class MyQueue {
    Stack<Integer> stack ;
    /** Initialize your data structure here. */
    public MyQueue() {
        stack = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(empty()) return Integer.MIN_VALUE;
        Integer first = stack.firstElement();
        stack.remove(first);
        return first;
    }

    /** Get the front element. */
    public int peek() {
        if(empty()){
            return Integer.MIN_VALUE;
        }
        return stack.firstElement();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.size() == 0;
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.pop();
        System.out.println(queue.peek());
    }
}
