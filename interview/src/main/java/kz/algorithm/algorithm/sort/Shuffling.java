package kz.algorithm.algorithm.sort;

//import edu.princeton.cs.algs4.StdRandom;

import java.util.Random;

public class Shuffling extends ComparableClass{
    /**
     * Knuth shuffle
     * */

    public static  void shuffle(Comparable a[]){
        for(int i = 0; i<a.length;i++){
           // int r = StdRandom.uniform(i+1);
            Random r = new Random();
            exch(a,i,r.nextInt());
        }
    }
}
