package kz.algorithm.data_structure.linked_list;

import java.util.HashSet;
import java.util.Stack;

public class MyLinkedList {
    public MyNode head;
    //tarverse by list- проход по циклу
    private void printList(){
        MyNode node = head;
        while(node!=null){
            System.out.print(node.getValue()+",");
            node = node.getNext();
        }

    }
    /**
     * метод добавление подразумевает:
     * 1) довавить в начало
     * 2) добавить в середину
     * 3) добавить в конец
     * */

    //1 Добавить в начало
    public void push(Object new_data){
        MyNode new_head = new MyNode(new_data);
        new_head.setNext(head);
        head = new_head;
    }
    //2 добавить в середину
    public void pushAfter(MyNode prev, Object new_data){
        if(prev == null){
            System.err.println("Node не может быть пустым");
        }
        MyNode new_node = new MyNode(new_data);
        new_node.setNext(prev.getNext());
        prev.setNext(new_node);
    }
    //3 добавить в конец
    public void append( Object new_data){
        if(head == null){
            System.err.println("Node не может быть пустым");
        }
        MyNode new_node = new MyNode(new_data);
        MyNode last = head;
        while(last.getNext()!=null){
            last = last.getNext();
        }
        last.setNext(new_node);
    }

    /**
     * метод удаления node из Linked List
     * 1) Найти предедущий node удаляемого node
     * 2) поменять ссылку из след на предедущий
     * 3) пустая должна удалиться
     * */

    public void delete(Object value){
        MyNode node = head, prev = null;
        if(node != null && node.getValue() == value){
            head = node.getNext();
            return;
        }
        while(node!=null && node.getValue() !=value){
            prev = node;
            node = node.getNext();
        }

        if(node == null){
            return;
        }
        prev.setNext(node.getNext());
    }


    /**
     * Delete node given position
     *
     * Ex 1,2,3,4,5,6,7
     * delete 3 position ->>>> its 4 node ->>>> 1,2,3,5,6,7
     * 1) если позиция равна head , то удаляем первый элем
     * 2) обход по цилу пока не найдем элем по позиции
     * 3) меныем ссылку предедущего на след
     * **/

    public void delByPos(int position){
        MyNode node = head;
        if(position == 0) {
            head = node.getNext();
            return;
        }
        for(int i = 0; node !=null && i < position-1; i++){
            node = node.getNext();
        }
        if(node == null && node.getNext()==null){
            return;
        }
        MyNode next = node.getNext().getNext();
        node.setNext(next);
    }

    /**
     * Delete all list considered as deleting head
     * O(1)
     * **/
    public void deleteAll(){
        head = null;
    }
    /**
     * Размер связанного списка
     * O(n)
     * */

    public int size(){
        int count = 0;
        MyNode node = head;
        while(node!=null){
            count++;
            node = node.getNext();
        }

        return count;
    }

    /**
     * Search elem in LinkedList
     * **/
    public boolean search(Object value){

        MyNode node = head;
        while(node!=null){
            if(node.getValue() == value){
                return true;
            }
            node = node.getNext();
        }

        return false;
    }
    /**
     * print Middle
     * **/

    public Object getMiddle(){
        int count = 0;
        MyNode mid = head;
        for(MyNode node = head; node !=null; node=node.getNext()){
            if(count%2 == 1){
                mid=mid.getNext();
            }
            count++;
        }
        if(mid!=null){
            return mid.getValue();
        }
        return null;
    }
    /**
     * Detect loop in Linked List
     * 1) Add all node to HashSet
     * 2) if hash set contain node return true
     * */

    public boolean detectLoop(){

        MyNode node = head;
        HashSet<MyNode> set = new HashSet<>();
        while(node!=null){
            if(set.contains(node)){
                return true;
            }
            set.add(node);
            node = node.getNext();
        }

        return false;
    }
    /**
     * Count nodes in loop
     * */
    public int countNodesLoop(){
        int count = 0;
        MyNode node = head, next = head;
        while (node != null && next != null && next.getNext() != null){
            node = node.getNext();
            next = next.getNext().getNext();

            if(node == next){
               for(MyNode i = node; node!=null; node = node.getNext()){
                   count++;
               }
            }
        }
        if(count >0) return count;
        return 0;
    }

    /**
     * IS polindrome its when word order similar from forward and backward. Ex: RADAR, TENET etc.
     * 1) first method:
     *    - adding nodes to stack
     *    - in another loop pop elem from stack and compare them
     * 2) second method
     *   - get middle of list
     *   - reverse first half
     *   - check elems for their equality
     *   - construct the original linked list by reversing the second half again and attaching it back to the first half
     *
     * **/
    private boolean isPolindrome(){
        MyNode node = head;
        Stack<MyNode> stack = new Stack<>();
        while(node!=null){
            stack.push(node);
            node = node.getNext();
        }
        MyNode loop = head;
        while (!stack.empty() && loop!=null){
            MyNode curr = stack.pop();
            if(curr.getValue() != loop.getValue()){
                return false;
            }
            loop = loop.getNext();
        }

        return true;
    }

    private boolean checkPolindrome(){
        MyNode slow_ptr =head, fast_ptr = head, second_half = null;
        MyNode prev_of_slow_ptr = head;
        MyNode middle = null;
        boolean res = true;
        if(head != null && head.getNext() !=null){
            while (fast_ptr != null && fast_ptr.getNext() !=null){
                fast_ptr = fast_ptr.getNext();
                prev_of_slow_ptr = slow_ptr;
                slow_ptr = slow_ptr.getNext();
            }

            if(fast_ptr != null){
                middle = slow_ptr;
                slow_ptr =slow_ptr.getNext();
            }
        }

        second_half = slow_ptr;
        prev_of_slow_ptr.setNext(null);
        reverseList(second_half);
        res =compareTwoList(head,second_half);

        reverseList(second_half);

        if(middle != null){
            prev_of_slow_ptr.setNext(middle);
            middle.setNext(second_half);
        }
        else prev_of_slow_ptr.setNext(second_half);

        return res;
    }


    /**
     * Проверяет является ли оба List одинаковыми
     * */
    public boolean compareTwoList(MyNode head1, MyNode head2){
        MyNode node1 = head1;
        MyNode node2 = head2;
        while (node1 != null && node2 != null){
            if(node1.getValue() != node2.getValue()){
                return false;
            }
            node1 = node1.getNext();
            node2 = node2.getNext();
        }

        if(node1 == null && node2 == null){
            return true;
        }
        return true;
    }


    /**
     * Reverse
     * */
    public MyNode reverseList(MyNode head) {
        MyNode current = head;
        MyNode next = null;
        MyNode prev = null;
        while (current!=null){
          next = current.getNext();
          current.setNext(prev);
          prev = current;
          current= next;
        }
        head = prev;


        return head;
    }

    public MyNode reverseListStack(MyNode head) {
      Stack<MyNode> stack = new Stack<>();
      MyNode node = head;
      while ( node !=null){
          stack.push(new MyNode(node.getValue()));
          node = node.getNext();
      }
      head = node;

      while (!stack.isEmpty() && node !=null){
          node.setNext(stack.pop());
          node = node.getNext();
      }

      node.setNext(null);



      return head;
    }

    /**
     * Удаляем повторяющеие строки в сортированном списке
     *
     * */

    public void removeDuplicates(MyNode head){
        MyNode node = head;

        while(node !=  null){
            MyNode curr = node;
            while(curr!= null && curr.getValue() == node.getValue()){
                curr = curr.getNext();
            }
            node.setNext(curr);
            node = node.getNext();
        }
    }

    /**
     * Удалить повторяющиеся элементы в сортированном списке
     * алгоритм:
     * 1) проходим по листу и сохраняем как текушую
     * 2) проходим еще один раз по списку начиная с текущей
     * 3) если равны значение пропускаем node
     * **/
    public void removeAllDuplicated(MyNode head){
        MyNode node = head;

        while(node !=  null){
            MyNode curr = node;
            /** если находится прерывается цикл и берем повторяющий элемент*/
            while(curr!= null && curr.getValue() == node.getValue()){
                curr = curr.getNext();
            }
            node.setNext(curr);
            node = node.getNext();
        }
    }
    /**
     * Удалить повторяющиеся элементы в несортированном списке
     * алгоритм:
     * 1) проходим по листу
     * 2) если значение нет в сет сохраняем в сет и сохраняем пред значение
     * 3) если есть то в предедущий сохраняем последующий элемент
     * **/

    public void removeDuplicatedSet(MyNode head){
        HashSet<Object> set = new HashSet<>();
        MyNode node = head;
        MyNode prev = null;
        while(node !=  null){
            if(!set.contains(node.getValue())){
                set.add(node.getValue());
                prev=node;
            }else {
               prev.setNext(node.getNext());
            }

           node = node.getNext();
        }

    }

    /***
     * Обьеденить два списка
     *
     * */

    public static class IntNode{
        Integer val;
        IntNode next;

        public IntNode(Integer val) {
            this.val = val;
            this.next = null;
        }
    }

    public void appendIntNode(IntNode head, int val){
        if(head == null){
            System.err.println("Node не может быть пустым");
        }
        IntNode new_node = new IntNode(val);
        IntNode last = head;
        while(last.next!=null){
            last = last.next;
        }
        last =new_node;
    }

    /**
     * Обьеденить две сортированных списков
     * **/
    public IntNode mergeTwoSortedList(IntNode l1, IntNode l2){
        IntNode node = new IntNode(0);
        IntNode temp = node;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                temp.next = l1;
                l1 = l1.next;

            }else{
                temp.next = l2;
                l2 = l2.next;
            }

            temp = temp.next;
        }

        if(l1 != null){
            temp.next = l1;
        }
        if(l2 != null){
            temp.next = l2;
        }
        return node.next;
    }

    /**  Intersection of two unsorted list*/
    public IntNode getIntersectionNode(IntNode headA, IntNode headB) {

        IntNode node = new IntNode(0);
        IntNode temp = node;
        IntNode node1 = headA, node2 = headB;
        while(node1 != null){
            if(node2 == null){
                node2 = headB;
                temp = node;
                node1 = node1.next;
            }
            IntNode new_node =null;
            if(node1!=null && node2 !=null && node1.val == node2.val){
                new_node = new IntNode(node1.val);
                node1 = node1.next;
                temp.next = new_node;
                temp = temp.next;
            }
            node2 = node2.next;
        }
        return node.next;
    }

    /**  Intersection of two sorted list*/
    public IntNode getIntersectionNode1(IntNode headA, IntNode headB) {
        IntNode node = new IntNode(0);
        IntNode temp = node;
        IntNode node1 = headA, node2 = headB;
        while(node1 != null && node2 !=null){
            if(node1.val == node2.val){
                IntNode new_node = new IntNode(node1.val);
                temp.next = new_node;
                temp = temp.next;
                node1 = node1.next;
                node2 = node2.next;
            }else if(node1.val < node2.val){
                node1 = node1.next;
            }else{
                node2 = node2.next;
            }
        }

        return node.next;
    }

    /** Version 2 Intersection of two unsorted list**/

    public IntNode getIntersectionNode2(IntNode headA, IntNode headB) {

        IntNode node1 = headA, node2 = headB;
        while(node1 != node2){
           if(node1 == null){
               node1 = headA;
           }else{
               node1 = node1.next;
           }
           if(node2 == null){
               node2 = headB;
           }else {
               node2 = node2.next;
           }


        }

        return headA;
    }


    /**
     * Алгоритм обнаружение цикла
     * 1)
     *
     * */

    public boolean hasCycle(MyNode head) {
        MyNode node = head;
        HashSet<MyNode> set = new HashSet<>();
        while(node != null){
            if(set.contains(node.getNext())){
                return true;

            }
            set.add(node);
            node = node.getNext();
        }
        return false;
    }




    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.head =new MyNode(2);
        MyNode second = new MyNode(3);
        MyNode third = new MyNode(4);
        linkedList.head.setNext(second);
        second.setNext(third);
        //traversion
        System.out.println("traverse: ");
        linkedList.printList();/// 2,3,4
        //adding new head
        System.out.println("\nadd to head: ");
        linkedList.push(1);
        linkedList.printList();///1,2,3,4
        //adding after
        System.out.println("\nadd after: ");
        linkedList.pushAfter(second,5);
        linkedList.printList();///1,2,3,5,4
        //adding to the end
        System.out.println("\nadd to the end: ");
        linkedList.append(8);
        linkedList.printList();///1,2,3,5,4,8
        //delete to the end
        System.out.println("\ndelete to the end: ");
        linkedList.delete(5);
        linkedList.printList();///1,2,3,4,8
        //delete by position
        System.out.println("\ndelete 3 position: ");
        linkedList.delByPos(3);
        linkedList.printList();///1,2,3,8
        //delete by position
        System.out.println("\nSize: " +linkedList.size());
        //search 8 in LinkedList
        System.out.println("\nIs 8 in List: " +linkedList.search(8));
        //search middle of list
        System.out.println("\nMiddle List: " +linkedList.getMiddle());
        third.setNext(second);
        System.out.println("\nDetect loop: " +linkedList.detectLoop());

        linkedList.isPolindrome();

        linkedList.append(9);
        linkedList.append(15);

        /**Merge two list*/
        IntNode list = new IntNode(1);
        list.next = new IntNode(9);
        list.next.next = new IntNode(1);
        list.next.next.next = new IntNode(2);
        list.next.next.next.next = new IntNode(4);

        IntNode list2 =  new IntNode(3);
        list2.next = new IntNode(3);
        list2.next.next = new IntNode(1);
       // list2.next.next.next = new IntNode(8);
       // list2.next.next.next.next = new IntNode(4);
       // list2.next.next.next.next.next = new IntNode(5);

       /* IntNode res = linkedList.mergeTwoSortedList(list, list2);
        System.out.println("Merge two list: ");
        while (res!=null){
            System.out.print(res.val + "-");
            res = res.next;
        }*/

        IntNode res1 = linkedList.getIntersectionNode(list, list2);
        System.out.println("\nIntersection two list: ");
        while (res1!=null){
            System.out.print(res1.val + "-");
            res1 = res1.next;
        }






        System.out.println("\nRemove duplicates ");
        linkedList.printList();
        linkedList.removeDuplicatedSet(linkedList.head);
        System.out.println("\n");
        linkedList.printList();
        System.out.println("\n");

        /**IS POLINDROME*/
        MyLinkedList polindrome = new MyLinkedList();
        polindrome.head = new MyNode("R");
        polindrome.head.setNext(new MyNode("A"));
        polindrome.head.getNext().setNext(new MyNode("D"));
        polindrome.head.getNext().getNext().setNext(new MyNode("A"));
        polindrome.head.getNext().getNext().getNext().setNext(new MyNode("R"));

        /**Traverse RADAR**/
        polindrome.printList();
        System.out.println("\n Is RADAR polindrome " + polindrome.isPolindrome() );
        System.out.println("\nCheck if polindrome by compariong middle list " + polindrome.checkPolindrome());
        System.out.println("\n Is RADAR reverse ");
       // polindrome.reverseList(polindrome.head);
        polindrome.printList();
       // polindrome.reverseListStack(polindrome.head);
        System.out.println("\n\n");
        polindrome.removeDuplicates(polindrome.head);
        polindrome.printList();




    }
}
