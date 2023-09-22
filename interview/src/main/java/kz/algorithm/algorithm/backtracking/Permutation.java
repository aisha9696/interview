package kz.algorithm.algorithm.backtracking;

import java.sql.Array;
import java.util.*;

public class Permutation {
    public static List<List<Integer>> result = new LinkedList<>();

    public static List<List<Integer>> permute(int[] nums) {
        //decision tree
        List<Integer> dt = new LinkedList<>();

        for(int num : nums){
            dt.add(num);
        }

        dfs(new LinkedList<>(), dt);
        return result;
    }

    private static void dfs(List<Integer> perm, List<Integer> dt) {
        if(dt.size() == 0){

            result.add(perm);
            return;
        }
        for(Integer num: dt){

            List<Integer> tempPerm = new LinkedList<Integer>(perm);
            List<Integer> tempDt = new LinkedList<Integer>(dt);
            tempPerm.add(num);
            tempDt.remove(num);
            dfs(tempPerm, tempDt);
        }

    }



    public static Set<String> chars = new HashSet<>();
    public static int numTilePossibilities(String tiles) {
        Set<String> set = new HashSet<>();
        boolean[] vis = new boolean[tiles.length()];
        chDfs(tiles, "", set, vis);
        return set.size()-1;
    }


    public  static void chDfs(String tiles, String curr, Set<String> set, boolean[] vis){
        set.add(curr);
        for(int i=0; i<tiles.length(); i++){
            if(!vis[i]){
                vis[i]=true;
                chDfs(tiles, curr+tiles.charAt(i), set, vis);
                vis[i]=false;
            }
        }
    }


    public static List<List<Integer>> digits = new ArrayList<>();
   public static int dt[] = new int []{};
    public static List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        dt = nums;
       ddfs(new ArrayList<>(), 0);
       return digits;
    }

    private static void ddfs(List<Integer> subset, int index) {

        digits.add(new ArrayList<>(subset));
        for(int i = index; i< dt.length; i ++ ){
            subset.add(dt[i]);
            ddfs(subset, i+1);
            subset.remove(subset.size() -1);

        }

    }


    public static void main(String[] args) {
        subsets(new int []{1,2 ,3});
        System.out.println(numTilePossibilities("XA"));
    }
}
