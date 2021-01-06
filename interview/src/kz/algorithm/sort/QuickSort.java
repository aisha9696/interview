package kz.algorithm.sort;

import java.lang.reflect.Array;
import java.util.Arrays;

public class QuickSort {


    public void sortedInt(int a[], int left, int right) {
        if (left < right) {
            int partitioning = partition(a, left, right);

            sortedInt(a, left, partitioning - 1);
            sortedInt(a, partitioning + 1, right);
        }
    }

    public int partition(int a[], int left, int right) {
        int pivot = a[right];
        int j = left ;

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

    public static void main(String[] args) {
        int[] a = {1, 23, 6, -2, 64, 15, 3, -9, 0};
        QuickSort sort = new QuickSort();
        sort.sortedInt(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }
}
