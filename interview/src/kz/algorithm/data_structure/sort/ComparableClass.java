package kz.algorithm.data_structure.sort;

public class ComparableClass {
    protected static boolean less(Comparable v, Comparable w){
        return v.compareTo(w)<0;
    }
    protected static void exch(Comparable []a, int i, int j){
        Comparable swap = a[i];
        a[i] = a[j];
        a[i] = swap;
    }

    protected static boolean isSorted(Comparable a[]){
        for(int i = 0; i<a.length; i++){
            if(less(a[i], a[i+1]))return false;
        }
        return true;
    }
}
