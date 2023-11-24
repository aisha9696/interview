package kz.algorithm.letcode.yandex;

import java.util.ArrayList;

import kz.algorithm.data_structure.linked_list.MyLinkedList.IntNode;

public class MergeKSortedList {

  static class ListNode {

    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }

  public ListNode mergeKLists(ListNode[] lists) {


    if (lists.length == 0) {
      return new ListNode();
    }
    ListNode node = lists[0];
    if (lists.length == 1) {
      return lists[0];
    }
    int i = 1;
    while (i < lists.length) {

      node = mergeTwoSortedList(node, lists[i++]);
    }

    return node;
  }

  public ListNode mergeTwoSortedList(ListNode l1, ListNode l2) {
    ListNode node = new ListNode(0);
    ListNode temp = node;
    while (l1 != null && l2 != null) {

      if (l1.val < l2.val) {
        temp.next = l1;
        l1 = l1.next;
        temp = temp.next;
      } else if(l1.val > l2.val) {
        temp.next = l2;
        l2 = l2.next;
        temp = temp.next;
      }else{
        temp.next = l1;
        temp = temp.next;
        temp.next = l2;
        l1 = l1.next;
        l2 = l2.next;
        temp = temp.next;
      }


    }

    if (l1 != null) {
      temp.next = l1;
    }
    if (l2 != null) {
      temp.next = l2;
    }
    return node.next;
  }



  public static void main(String[] args) {
    MergeKSortedList m = new MergeKSortedList();

    ListNode f = new ListNode(1);
    f.next = new ListNode(4);
    f.next.next = new ListNode(5);
    ListNode s = new ListNode(1);
    s.next = new ListNode(3);
    s.next.next = new ListNode(4);
    ListNode t = new ListNode(2);
    t .next = new ListNode(3);
    t .next.next = new ListNode(6);

    ListNode [] node = new ListNode[]{f,s,t};
    m.mergeKLists(node);
  }
}
