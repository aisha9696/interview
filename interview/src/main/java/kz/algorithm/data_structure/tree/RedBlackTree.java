package kz.algorithm.data_structure.tree;

public class RedBlackTree <Key extends Comparable<Key>, Value>{

    private static final boolean RED= true;
    private static final boolean BLACK = false;

    public  Node root;
    private class Node {
        private Key key;
        private Value value;
        private Node left, right;
        private int count;
        private boolean color;

        public Node(Key key, Value value,boolean color) {
            this.key = key;
            this.value = value;
            this.color = color;
        }
    }

    public boolean isRed(Node x){
        if(x == null) return false;
        else
            return x.color == RED;
    }

    private Node rotateLeft(Node h){
        assert isRed(h.right);
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }
    private Node rotateRight(Node h){
        h.left.right =h;
        h=h.left;
        return h;
    }

    private void flipColor(Node h){
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    private Node put(Node h, Key key, Value value){
        if(h == null ) return new Node(key, value, RED);
        int cmpp =key.compareTo(h.key);
        if(cmpp <0) h.left = put(h.left, key, value);
        else if(cmpp>0) h.right = put(h.right, key, value);
        else if(cmpp ==0) h.value = value;
        if(isRed(h.right) && !isRed(h.left)) h = rotateLeft(h);
        if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
        if(isRed(h.left) && isRed(h.right)) flipColor(h);
        return h;
    }
}
