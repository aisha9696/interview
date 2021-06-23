package kz.algorithm.data_structure.sort;

import java.util.Arrays;

public class SelectionSort extends  ComparableClass{
    /**
     *
     */
    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            exch(a, i, min);
        }
    }



    /**
     * O(n*n) время даже если массив сортированный
     * выбирем из цикла минимальный элемент и ставим постепенно на нужное место
     * **/
    public static void intSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[min] > a[j]) {
                    min = j;
                }
            }
            int swap = a[i];
            a[i] = a[min];
            a[min] = swap;

        }

    }

    public static void main(String[] args) {
        SelectionSort ss = new SelectionSort();
        Comparable<Integer> a[] = new Comparable[]{5, 11, 3, 9, 7, 1, 4, 13, 6, 0, 2};
        System.out.println(ss.isSorted(a));
        ss.sort(a);
        System.out.println(ss.isSorted(a));

        int []new_a = new int[]{5, 1, 3, 9, 7, 1, 4, 2, 6, 0, 2};
        ss.intSort(new_a);
        Arrays.stream(new_a).forEach(i->{
            System.out.println(i);
        });
    }

}
