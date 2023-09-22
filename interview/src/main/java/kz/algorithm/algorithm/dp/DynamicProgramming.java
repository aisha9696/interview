package kz.algorithm.algorithm.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class DynamicProgramming {
    // memorization
    private static long  fibonacci(int n){
        long [] memo = new long [n+1];

       for(int i =0;i<=n;i++ ){
            if(i<2) memo[i] = i;
            else memo[i] = memo[i-1] + memo[i-2];
       }
       return memo[n];
    }

    //tabulation

    private static long tab_fib(int n){
        long tab[] = new long [n+2];
        int tab1[] = new int [n+1];

        tab[1] = 1;
        for(int i = 0; i<n; i++){
            tab[i+1] +=tab[i];
            tab[i+2] +=tab[i];
        }
        return tab[n];

    }

    public static int getMaximumGenerated(int n) {
        int nums [] = new int[n+1];
        int max = 0;
        if(n >= 0) {nums [0] = 0; max = 0;}

        if(n >= 1) {nums [1] = 1; max = 1;}

        for(int i = 2; i<=n; i++){
            if(i % 2 == 0) nums[i] = nums[i/2];
            else nums[i] = nums[i/2] + nums[i/2 + 1];

            if(max < nums[i]) max =nums[i];
        }
        return max;

    }
    //memorization
    private static long gridTraveler(int m, int n, HashMap<String, Long> memo){
        String key = m + "-"+n;
        if(memo.containsKey(key)) return memo.get(key);
        if(n == 1 && m == 1) return 1;
        if(n ==0 || m == 0) return 0;
        memo.put(key, gridTraveler(n-1,m,memo) +gridTraveler(n,m-1,memo));
        return memo.get(key);
    }

    //tabulation

    private static long gridTabTraveler(int n, int m){
        long [][]arr  = new long [n+1][m+1];
        arr[1][1] =1;
        for (int i= 0; i < n; i++){
            for(int j = 0; j <m; j++){
                long current = arr[i][j];
                if(j+1<=n)  arr[i][j+1] += current;
                if(i+1<=m) arr[i+1][j] += current;
            }
        }
        return arr[n][m];
    }

    /*private static boolean canCunstract (String target, String[] wordBank, HashMap<String, Boolean> memo){
        if(memo.containsKey(target)) return
        if(target.isEmpty()) return true;
        for(String word : wordBank){
            if(target.indexOf(word) == 0){
                String suffix = target.substring(word.length());
                if(canCunstract(suffix,wordBank)==true){
                    return true;
                };
            }
        }
        return false;
    }*/

    public static boolean canSum(int target, int[] numbers){
        boolean []table = new boolean[target+1];
        table[0] =true;
        for(int i = 0; i<=target; i++){
            if(table[i] == true){
                for (int num: numbers){
                    table[i+num] = true;
                }
            }
        }

        return table[target];
    }
        
    /**
     * задача о разрезании стержня
     * как оптимально разрезать стержень длиной N чтобы получить максимальный прибыль 
     * Табоица длины и цены стержня
     * Длина | 1 | 2 | 3 | 4 | 5  | 6  | 7  | 8  | 9  | 10 |  
     * Цена  | 1 | 5 | 8 | 9 | 10 | 17 | 20 | 20 | 24 | 30 |
     * */
    
    // memorization
    public static int memo_cut_rod(int [] p , int n){
        int [] r = new int [n+1];
        Arrays.fill(r,-1);
        return memo_cut_rod_aux(p,n,r);
    }

    private static int memo_cut_rod_aux(int[] p, int n, int[] r) {
        int q =Integer.MIN_VALUE;
        if(r[n] >=0) return r[n];
        if(n == 0 ) {q =0;}
        else {

            for(int i =1; i<n; i++){
                q = Math.max(q, p[i] + memo_cut_rod_aux(p,n-i, r));
            }
            r[n] =q;
        }

        return q ;
    }


    private static int tab_bottom_up(int [] p , int n){
        int [] r = new int [n+1];
        Arrays.fill(r,-1);
        r[0] = 0;

        for(int j = 0; j<n; j++){
            int q =  Integer.MIN_VALUE;
            for(int i = 1; i <=j;i++){
                q = Math.max(q, p[i] + r[j-i]);
            }
            r[j] = q;
        }
        return r[n];
    }

    public static void main(String[] args) {

        //System.out.println(tab_fib(50));
        //System.out.println(gridTraveler(18,18,new HashMap<>()));
     //   System.out.println(gridTabTraveler(3,4));
      //  System.out.println(canSum(7, new int[]{3,4,5}));
      //  System.out.println(getMaximumGenerated(0));

        int []price = new int []{0,1,5,8,9,10,17,20,20,24,30};
        System.out.println(tab_bottom_up(price,8));
    }
}
