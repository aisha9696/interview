package kz.algorithm.letcode.yandex;

import java.util.HashMap;

public class LRUCache {
  Node head = new Node(0, 0);
  Node tail = new Node(0, 0);
  HashMap<Integer, Node> map;
  int size;

  public LRUCache(int capacity) {

    map = new HashMap<>();
    head.next = tail;
    tail.prev = head;
    this.size = capacity;
  }

  public int get(int key) {
    if (map.containsKey(key)) {
      Node temp = map.get(key);
      deleteNode(temp);
      addNode(temp);
      return map.get(key).value;
    }
    return -1;
  }

  public void put(int key, int value) {
    if (map.containsKey(key)) {
      deleteNode(map.get(key));
    }
    if (map.size() == size) {

      deleteNode(tail.prev);
    }
    addNode(new Node(key, value));
  }
  public void addNode(Node node) {
    map.put(node.key, node);
    node.next = head.next;
    head.next.prev = node;
    head.next = node;
    node.prev = head;
  }
  public void deleteNode(Node node) {
    map.remove(node.key);
    node.prev.next = node.next;
    node.next.prev = node.prev;
  }

  public void lru(int key) {

  }





  class Node {
    Node next;
    Node prev;

    int key;
     int value;
    Node(){}
    Node(int val) {
      this.value = val;
    }

    public Node(int key, int value) {
      this.next = null;
      this.prev = null;
      this.key = key;
      this.value = value;
    }
  }

  public static void main(String[] args) {
    LRUCache lruCache = new LRUCache(2);
    lruCache.put(1,1);
    lruCache.put(2,2);
    lruCache.get(1);
  }
}
