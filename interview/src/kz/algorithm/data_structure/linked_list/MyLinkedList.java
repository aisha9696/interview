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
            if(curr != loop){
                return false;
            }
            loop = loop.getNext();
        }

        return true;
    }

    private boolean checkPolindrome(){


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

        /**IS POLINDROME*/
        MyLinkedList polindrome = new MyLinkedList();
        polindrome.head = new MyNode("R");
        polindrome.head.setNext(new MyNode("A"));
       // polindrome.head.getNext().setNext(new MyNode("D"));
       // polindrome.head.getNext().getNext().setNext(new MyNode("A"));
       // polindrome.head.getNext().getNext().getNext().setNext(new MyNode("R"));
        /**Traverse RADAR**/
        polindrome.printList();
        System.out.println("\n Is RADAR polindrome " + polindrome.isPolindrome() );





    }
}
