package kz.algorithm.data_structure.sort;

import java.util.Arrays;

public class InsertionSort extends ComparableClass {

    public  void sort(Comparable a[]) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                if (less(a[j], a[j - 1])) {
                    exch(a, j, j - 1);
                } else break;
            }
        }

    }

    /**
     * O(N*N) compares
     * O(N*N) changes
     * **/

    public void intSort(int []a){
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                if (a[j] < a[j - 1]) {
                    int swap = a[j];
                    a[j] = a[j-1];
                    a[j-1] = swap;
                } else break;
            }
        }
    }



    public static void main(String[] args) {
        InsertionSort ii = new InsertionSort();
        Comparable<Integer>[] a = new Comparable[]{7, 4, 5, 1, 3, 9, 10, 2, 6, 8, 0};
        System.out.println(ii.isSorted(a));
        ii.sort(a);
        System.out.println(ii.isSorted(a));
        int []new_a = new int[]{5, 10, 3, 9, 7, 1, 4, 8, 6, 0, 2};
        ii.intSort(new_a);
        Arrays.stream(new_a).forEach(i->{
            System.out.println(i);
        });
    }
}
