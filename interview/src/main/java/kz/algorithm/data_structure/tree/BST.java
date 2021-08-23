package kz.algorithm.data_structure.tree;

import kz.algorithm.data_structure.queue.MyQueue;

import java.util.*;

public class BST<Key extends Comparable<Key>, Value> {
    private Node root;

    private class Node {
        private Key key;
        private Value value;
        private Node left, right;
        private int count;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
        }
    }

    public void put(Key key, Value val){
        root = put(root, key, val);
    }
    private Node put(Node x, Key key, Value value){
        if(x== null) return new Node(key, value);
        int cmp = key.compareTo(x.key);
        if(cmp<0) x.left= put(x.left, key, value); // assign to left
        else if(cmp >0) x.right = put(x.right, key,value); //assign to rigth val
        else if(cmp == 0) x.value = value;//reset value
        x.count = 1 + size(x.left) + size(x.right);
        return x;
    }

    public int size(){
        return size(root);
        
    }

    private int size(Node x) {
        if(x == null) return 0;
        return x.count;
    }


    public int rank(Key key){
        return rank(key, root) ;
    }

    private int rank(Key key, Node x) {
        if(x == null) return 0;
        int cpm = key.compareTo(x.key);
        if(cpm<0) return rank(key, x.left);
        else if(cpm>0) return 1 + size(x.left) +rank(key, x.right);
        else if(cpm == 0) return size(x.left);
        return 0;
    }



    public Key floor (Key key){
        Node x = floor(root, key);
        if(x == null) return null;
        return x.key;

    }

    private Node floor(Node x, Key key) {
        if(x == null) return null;
        int cmp = key.compareTo(x.key);
        if(cmp == 0) return x;
        if(cmp<0) return floor(x.left, key);
        Node t = floor(x.right, key);
        if(t != null) return t;
        else
            return x;
    }

    public Value get(Key key){

        Node x = root;
        while (x!= null){
            int cmp = key.compareTo(x.key);
            if(cmp<0) x =x.left;
            else if(cmp >0) x =x.right;
            else return x.value;
        }
        return null;
    }

    public Node getMin(Node x){
        if(x.left == null) return x;
        else return getMin(x.left);

    }


    /** delete Min value
     * 1) Go until finding null left link
     * 2) replace with right link
     * 3) update count subtree
     * */
    public void delMin(){
        root = deleteMin(root);
    }

    private Node deleteMin(Node x) {
        if(x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.count = 1+ size(x.left) +size(x.right);
        return x;
    }

    /**
     * Hibbard deletion
     *
     * */
    public void delete(Key key){
        root = delete(root, key);
    }

    private Node delete(Node x, Key key) {
        if(x == null) return null;
        int cmp = key.compareTo(x.key);
        if(cmp < 0) x.left = delete(x.left, key);//search key
        else if(cmp>0) x.right = delete(x.right, key);//search key
        else{
            if(x.right == null) return x.left;//no left child
            if(x.right == null) return x.right;//no right child

            Node t = x;                     //
            x = getMin(root);               // replacing successor
            x.right = deleteMin(t.right);   //
            x.left = t.left;                //
        }
        x.count = size(x.left) + size(x.right) +1; //update subtree
        return x;
    }


    public Iterable<Key> iterator(){
        return null;
    }

    //inorder traversals

    public Iterable<Key> keys() {
        Queue<Key> q = new LinkedList<>();
        inorder(root,q);
        return q;
    }

    private void inorder(Node x, Queue<Key> q) {
        if(x ==null) return;
        inorder(x.left, q);
        q.add(x.key);
        inorder(x.right, q);
    }



}
