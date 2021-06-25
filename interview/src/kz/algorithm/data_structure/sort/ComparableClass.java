package kz.algorithm.data_structure.sort;

import java.util.Comparator;

public class ComparableClass {
    protected static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    protected static void exch(Comparable[] a, int i, int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    protected static boolean isSorted(Comparable a[]) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) return false;
        }
        return true;
    }

    protected static boolean less(Comparator c,Comparable v, Comparable w) {
        return c.compare(v,w) < 0;
    }


    protected static boolean isSorted(Comparator c,Comparable a[]) {
        for (int i = 1; i < a.length; i++) {
            if (less(c,a[i], a[i - 1])) return false;
        }
        return true;
    }
}
