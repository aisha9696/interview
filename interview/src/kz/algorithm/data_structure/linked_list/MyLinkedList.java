package kz.algorithm.data_structure.linked_list;

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


    }
}
