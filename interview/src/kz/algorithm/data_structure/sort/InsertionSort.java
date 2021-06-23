package kz.algorithm.data_structure.sort;

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

    public static void main(String[] args) {
        InsertionSort ii = new InsertionSort();
        Comparable<Integer>[] a = new Comparable[]{7, 4, 5, 1, 3, 9, 10, 2, 6, 8, 0};
        System.out.println(ii.isSorted(a));
        ii.sort(a);
        System.out.println(ii.isSorted(a));
    }
}
