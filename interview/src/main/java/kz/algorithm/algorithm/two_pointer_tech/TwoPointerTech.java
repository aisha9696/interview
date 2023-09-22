package kz.algorithm.algorithm.two_pointer_tech;


import kz.algorithm.data_structure.linked_list.MyNode;

import java.util.Arrays;

public class TwoPointerTech {

    /**
     * Используется в структурах данных как String, List, Array, LinkedList
     * В зависимости массив отсортирован или нет реализация берет O(n Log n ) или O(n) время
     * Сущ два способа для использования этой техники в задач:
     *   -- Opposite directional - Two pointers, each starting from the beginning and the end until they both meet
     * ️ -- Equi- directional -One pointer moving at a slow pace, while the other pointer moves at twice the speed.
     * */

    /**
     * Задачa 1: In a sorted array, find if a pair exists with a given sum S
     */

    private static boolean pairExist(int arr[], int S) {
        int i = 0;              // starting pointer
        int j = arr.length - 1;  // end pointer
        while (i < j) {
            int curr = arr[i] + arr[j];
            if (curr == S) return true;
            else if (curr < S) i++;
            else j--;

        }
        return false;
    }



    /**
     * Задачa 2: Find the middle of a linked list
     */
    private static MyNode getMiddle(MyNode head) {
        MyNode slow = head;
        MyNode fast = head;
        while (fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        return slow;
    }

    /**
     * Задачa 3: Find the cycle of a linked list
     */
    private static boolean isCycleExist(MyNode head) {
        MyNode slow = head;
        MyNode fast = head;
        while (fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
            if (slow == fast) return true;
        }
        return false;
    }

    /**
     * Задача 4: Reverse an array in place.
     */
    private static int[] reverseArray(int array[]) {
        int i = 0;
        int j = array.length - 1;
        while (i < j) {
            swap(array, i, j);
            i++;
            j--;
        }
        return array;
    }

    private static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * Задача 5: Given an integer array sorted in non-decreasing order,
     * return an array of the squares of each number sorted in non-decreasing order.
     * пример; -4,-3,0,1,10
     * квадрат 16 9 0 1 100
     * сортировка 0 1 9 16 100
     */

    private static int[] sortedSquares(int arr[]) {
        int res[] = new int[arr.length];
        int i = 0;
        int j = arr.length - 1;
        int k = arr.length - 1;
        while (i < j) {
            if (Math.abs(arr[i]) > Math.abs(arr[j])) {
                res[k--] = arr[i] * arr[i];
                i++;
            } else {
                res[k--] = arr[j] * arr[j];
                j--;
            }
        }


        return res;
    }

    /**
     * Задача 6: Given a string s, find the length of the longest substring without repeating characters.
     */

    public static void main(String[] args) {
        //задача 1
        System.out.println(pairExist(new int[]{1, 3, 4, 5, 6, 7}, 5)); //true
        //задача 2

        MyNode list = new MyNode(1);
        list.setNext(new MyNode(2));
        list.getNext().setNext(new MyNode(3));
        list.getNext().getNext().setNext(new MyNode(4));
        list.getNext().getNext().getNext().setNext(new MyNode(5));
        list.getNext().getNext().getNext().getNext().setNext(new MyNode(6));
        System.out.println(getMiddle(list).getValue()); //4

        //задача 3
        MyNode cycledNode = new MyNode(7);
        list.getNext().getNext().getNext().getNext().getNext().setNext(cycledNode);
        cycledNode.setNext(list.getNext().getNext());
        System.out.println(isCycleExist(list));

        //Задача 4
        Arrays.stream(reverseArray(new int[]{1, 2, 3, 4, 6, 7})).forEach(s -> {
            System.out.print(s + "-");
        });
        System.out.println();

        //задача 5
        Arrays.stream(sortedSquares(new int[]{-7, -3, 2, 3, 11})).forEach(s -> {
            System.out.print(s + "-");
        });
    }
}
