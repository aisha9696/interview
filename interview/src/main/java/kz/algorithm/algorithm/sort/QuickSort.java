package kz.algorithm.algorithm.sort;

//import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

/**
 * Быстрая сортировка
 * <p>
 * 1) является одним из самых эффективных алгоритмов
 * 2)
 */
public class QuickSort extends ComparableClass {


    public void sortedInt(int a[], int left, int right) {
        if (left < right) {
            int partitioning = partition(a, left, right);

            sortedInt(a, left, partitioning - 1);
            sortedInt(a, partitioning + 1, right);
        }
    }

    public int partition(int a[], int left, int right) {
        int pivot = a[right];
        int j = left;

        for (int i = left; i < right; i++) {
            if (a[i] < pivot) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                j++;
            }
        }
        int temp = a[j];
        a[j] = pivot;
        a[right] = temp;

        return j;
    }

    public static int partition(Comparable a[], int left, int right) {
        int i = left;
        int j = right + 1;
        while (true) {
            while (less(a[++i], a[left])) {
                if (i == right) break;
            }
            while (less(a[left], a[--j])) {
                if (j == left) break;
            }
            if (i >= j) break;
            exch(a, i, j);
        }
        exch(a, left, j);
        return j;
    }

    private void sort(Comparable a[], int L, int R) {
        if (R <= L) return;
        int j = partition(a, L, R);
        sort(a, L, j - 1);
        sort(a, j + 1, R);
    }

    private void sort(Comparable a[]) {
      //  StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    /**
     * If key is duplicated EX: k,a,n,a,d,a,b,b,n,k,n,n,d,d
     * efficient quicksort implementation Sedgewick
     * 3Way quick sort
     */

    public static void editedSort(Comparable a[], int L, int R) {
        if (R <= L) return;
        int lt = L, gt = R;
        Comparable v = a[L];
        int i = L;
        while (i <= gt) {
            int cmp = a[i].compareTo(v);
            if (cmp < 0) exch(a, lt++, i++);
            else if (cmp > 0) exch(a, i, gt--);
            else i++;
        }
        editedSort(a, L, lt - 1);
        editedSort(a, gt + 1, R);

    }


    public static void main(String[] args) {
        int[] a = {1, 23, 6, -2, 64, 15, 3, -9, 0};
        QuickSort sort = new QuickSort();
        sort.sortedInt(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));


        Comparable<Character>[] array = new Comparable[]{'q', 'u', 'i', 'c', 'k', 's', 'o', 'r', 't', 'e', 'x', 'a', 'm', 'p', 'l', 'e'};
        System.out.println(sort.isSorted(array));
        sort.sort(array);
        System.out.println(sort.isSorted(array));

        Shuffling shuffling = new Shuffling();
        shuffling.shuffle(array);
        System.out.println(sort.isSorted(array));
        sort.editedSort(array, 0, array.length - 1);
        System.out.println(sort.isSorted(array));
    }
}
