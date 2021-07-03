package kz.algorithm.letcode.sort;

import edu.princeton.cs.algs4.In;

import java.util.*;

public class Leetcode {
    public static int largestPerimeter(int[] nums) {
        int max = 0;
        sort(nums);
        for (int i = 0; i < nums.length-2; i++) {
            int a = nums[i];
            int b = nums[i + 1];
            int c = nums[i + 2];
            if(a < b+c && max <(a+b+c) ){
                max = a+b+c;
            }
        }
        return max;
    }

    public static void sort(int[] a) {
        int N = a.length;

        for (int i = 0; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                if (a[j] > a[j - 1]) {
                    int swap = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = swap;
                } else break;
            }
        }

    }

    public static int[] frequencySort(int[] nums) {
        if(nums.length < 0) return null;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i<nums.length;i++){
            if(nums[i]>max) max =nums[i];
            if(nums[i]<min) min = nums[i];
        }

        int range = max - min +1;

        int count[] = new int[range];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i] - min]++;
        }
        int out []= new int[nums.length];

        TreeMap<Integer, List<Integer>> count_num = new TreeMap();

        for(int i = range-1; i >= 0; i--){
            if(count[i] == 0) continue;
            if(count_num.containsKey(count[i])){
                count_num.get(count[i]).add(i+min);
            }else{
                List<Integer> a = new ArrayList<>();
                a.add(i+min);
                count_num.put(count[i],a);
            }
        }
        int k = 0;
        for(Integer a: count_num.keySet()){
            for( Integer n :count_num.get(a)){
                int f = a;
                while (f !=0){
                    out[k++] = n;
                    f--;
                }
            }
        }


        return out;
    }

    /*public static String sortSentence(String s) {
        String [] arr = s.split(" ");
        TreeMap<Integer, String> num_str = new TreeMap<>();
        for(String a :arr){
           int num = Integer.parseInt(a.substring(a.length()-1));
           String str = a.substring(0,a.length()-1);
           num_str.put(num,str);
        }
        s = "";
        for(String a : num_str.values()){
            s += a +" ";
        }

        return s.trim();
    }*/

    public static String sortSentence(String s) {
        String [] arr = s.split(" ");
        String []res = new String[10];
        for(int i = 0; i<arr.length; i++){
            int num = Integer.parseInt(arr[i].substring(arr[i].length()-1));
            String str = arr[i].substring(0,arr[i].length()-1);
            res[num] = str;
        }
        s = "";
        for(int i = 1; i<10; i++){
            if(res[i] == null) continue;
            s += res[i] + " ";
        }

        return s;
    }
    //1,2,3,0,0,0
    //2,5,6
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;
        while(i >= 0 && j >= 0) {
            nums1[k--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
        }
        while(j >= 0) {
            nums1[k--] = nums2[j--];
        }

    }

    /*public static int[] frequencySort(int[] nums) {
        int[] bucket = new int[201]; //An array bucket to store frequency of numbers ranged between -100 to 100
        for(int num : nums) {
            bucket[num+100]++;
        }
        TreeMap<Integer, List<Integer>> map = new TreeMap(); //TreeMap to store numbers list by their frequency and in case of same frequency the list will be in descending order
        for(int i=200; i>=0; i--) {
            if(bucket[i] > 0) {
                if(!map.containsKey(bucket[i]))
                    map.put(bucket[i], new ArrayList<Integer>());
                List<Integer> temp = map.get(bucket[i]);
                temp.add(i-100);
                map.put(bucket[i], temp);
            }
        }
        int[] result = new int[nums.length];
        int index = 0;
        for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {  //Finally generate the result array
            int freq = entry.getKey();
            for(int num : entry.getValue())
                for(int i=0; i<freq; i++)
                    result[index++] = num;
        }
        return result;
    }*/
    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        if(arr1.length < 0 || arr2.length < 0) return null;
        int []res = new int[arr1.length];
        int k = 0;
        for(int i = 0; i <arr2.length; i++){
            for(int j = 0; j<arr1.length; j++){
                if(arr2[i] == arr1[j]){
                    res[k++] = arr1[j];
                    arr1[j] = -1;
                }
            }
        }
       Arrays.sort(arr1);
        for(int i = 0; i < arr1.length;i++){
            if(arr1[i]== -1){
                continue;
            }
            res[k++] = arr1[i];
        }

        return res;
    }

   /* public static int[] sortArrayByParityII(int[] nums) {
        if(nums.length <0) return null;
        int even [] = new int[nums.length/2];
        int odd [] = new int[nums.length/2];
        int e = 0;
        int o = 0;
        for(int i = 0; i<nums.length;i++){
            if(nums[i] %2 == 0){
                even[e++] = nums[i];
            }else {
                odd[o++] =  nums[i];
            }
        }

        Arrays.sort(even);
        Arrays.sort(odd);

        int out [] = new int[nums.length];
        int l = 0;
        for (int k=0,t =0; k < even.length || t < odd.length; k ++,t++){
            out[l++] = even[k];
            out[l++] =odd[t];
        }

        return out;
    }*/

    public static int[] sortArrayByParityII(int[] nums) {
        if(nums.length <0) return null;
        int [] res = new int[nums.length];
        int k =0, t = 1;
        for(int i = 0; i<nums.length;i++){
           if(nums[i] %2 == 0 ){
              int min_even = i;
              for(int j = i; j < nums.length; j++){
                  if(nums[min_even] >nums[j] && nums[j] %2 == 0){
                      min_even = j;
                  }
              }
               int swap = nums[i];
               nums[i] = nums[min_even];
               nums[min_even] = swap;
              res [k] = nums[i];
              k += 2;
           }else{
               int min_odd = i;
               for(int j = i; j < nums.length; j++){
                   if(nums[min_odd] >nums[j] && nums[j] %2 != 0){
                       min_odd = j;
                   }
               }
               int swap = nums[i];
               nums[i] = nums[min_odd];
               nums[min_odd] = swap;
               res [t] = nums[i];
               t+=2;
           }


        }

        return res;
    }


    public static void main(String[] args) {
        //largestPerimeter(new int[]{3,2,3,4});
        System.out.println(largestPerimeter(new int[]{3,3,6,2}));
        System.out.println(frequencySort(new int[]{-53,-53,52,52,52,52,-53,-53,52,-53,52,52,52,-53,52,52,-53,52,-53,52,-53,52,52,52,52,52,52,52,52,52,-53,52,-53,52,-53,52,52,52,-53,-53,52,-53,52,52,52,52,-53,-53,-53,-53,-53,52,52,-53,52,-53,52,52,52}));
        System.out.println(relativeSortArray(new int[]{2,3,1,3,2,4,6,7,9,2,19}, new int[]{2,1,4,3,9,6}));
        System.out.println(sortArrayByParityII(new int[]{10,3,4,7,9,6,5,8}));
        System.out.println(sortSentence("is2 sentence4 This1 a3"));
        merge(new int[]{1,2,3,0,0,0}, 3,new int[]{2,5,6},3);
    }
}
