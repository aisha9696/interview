package kz.algorithm;

import java.util.ArrayList;

public class Leetcode {
    public static int getDecimalValue(ListNode head) {
        int out = head.val;
        while (head.next != null) {
            out += head.val << 1;
        }
        return out;
    }
    public static void main(String[] args) {
        System.out.println(getDecimalValue(new ListNode()));
    }
}
class ListNode {
     int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }