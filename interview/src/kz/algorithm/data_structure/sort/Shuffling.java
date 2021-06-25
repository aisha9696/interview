package kz.algorithm.data_structure.sort;

import edu.princeton.cs.algs4.StdRandom;

public class Shuffling extends ComparableClass{
    /**
     * Knuth shuffle
     * */

    public static  void shuffle(Comparable a[]){
        for(int i = 0; i<a.length;i++){
            int r = StdRandom.uniform(i+1);
            exch(a,i,r);
        }
    }
}
