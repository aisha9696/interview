package kz.algorithm.data_structure.tree;

import java.security.Key;

public class Node {
    private Object key;
    private Object value;
    private Node left, right;

    public Node(Object key, Object value) {
        this.key = key;
        this.value = value;
    }
}
