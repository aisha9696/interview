package kz.algorithm.algorithm.sliding_window;

import java.util.HashMap;
import java.util.Map;

public class SlidingWindow {
    /**
     * Given a array of positive integers, find the subarrays of integers that add up to a given number
     * */
    public static int[] findSum(int sum, int[] array){

        if(array.length < 0 || sum <0){
            return null;
        }
        int l = 0;
        int r = 1;
        int result = array[l] + array[r];
        while (r< array.length ){
            if(result == sum){
                break;
            }
            else if(result < sum){
               result += array[++r];
            }
            else if(result > sum){
                result-=array[l++];
            }
        }
        int[] subarray = new int[r-l+1];
        int k = 0;
        for(int i = l; i<=r; i ++){
            subarray[k++] = array[i];
        }
        return subarray;

    }

    /**
     *  Given an array of integers, find maximum sum subarray of the required size.
     * */

    public static int getMaxSubarray(int size, int[] array){
        if(array.length < 0 || size <0){
            return 0;
        }

        int currentSum =0, maxSum =0, startIndex = 0;

        for(int i = 0; i<array.length-size; i++){
            for(int k = startIndex; k<startIndex+size;k ++){
                currentSum += array[k];
            }
            if(currentSum>maxSum){
                maxSum=currentSum;
            }
            currentSum = 0;
            startIndex++;
        }
        return maxSum;
    }

    public static int getMaxSubarray1(int size, int[] array){
        if(array.length < 0 || size <0){
            return 0;
        }

        int currentSum =0, maxSum =0, startIndex = 0;

        for(int i = 0; i<array.length-size; i++){
            for(int k = startIndex; k<startIndex+size;k ++){
                currentSum += array[k];
            }
            if(currentSum>maxSum){
                maxSum=currentSum;
            }
            currentSum = 0;
            startIndex++;
        }
        return maxSum;
    }

    /**
     *  given an array (negative, 0, positive ) integers find subaary that add up to a given numbers
     *  EX: -1, -4, 0, 5, 3, 2, 1   desired sum: 5
     *  Optimal solution: Kadanes algorithm TC : O(N)
     * */

    public static int[] findSumNegative(int sum, int[] array){

        if(array.length < 0 || sum <0){
            return null;
        }

        for(int  i =0 ; i< array.length; i++){

            array[i] +=sum;
        }
        int l = 0;
        int r = 1;
        int result = array[l] + array[r];
        while (r< array.length ){
            if(result-sum == sum){
                break;
            }
            else if(result < sum +sum){
                result += array[++r];
            }
            else if(result > sum +sum){
                result-=array[l++];
            }
        }
        int[] subarray = new int[r-l+1];
        int k = 0;
        for(int i = l; i<=r; i ++){
            subarray[k++] = array[i]-sum;
        }
        return subarray;

    }

    /**
     * sliding window tech with flipping swapping
     * Given an array of 0's and 1's, find the maximum sequence of continuous 1's that can be formed by flipping at-most k 0's to 1's
     * Example Input: [0, 1, 0, 1, 0, 0, 1, 1]
     * Max Flips (k): 2
     * TC O(n)
     * SC O(n)
     * */

    public static int findMaxFromZeroOne(int[] array, int maxFlips){
        if(array.length < 0 || maxFlips <0){
            return 0;
        }
        int l = 0;
        int r = 1;
        int max = array[l]==0?1:0;
        while (r< array.length ){
            if(max > maxFlips){
                max -= array[l++] ==0?1:0;
            }else if(array[r++] == 0){
                max++;
            }
        }
        return max;
    }
  /**
   * Given a string and n characters, find the shortest substring that contains all desired characters
   * Example Input: fa4chba4c
   * Desired Characters: abc
   * TC O(n)
   * SC O(1)
   * */
  public static String getShortestSubstring(String input, String characters){
        int windowStartIndex =0;
        int smallestWindowStartIndex=0, smallestWindowEndIndex =0;
        StringBuilder result = new StringBuilder();
      Map<Character, Integer> neededCharCounts = new HashMap<>() ;
      for(Character ch : characters.toCharArray()){
          if(neededCharCounts.containsKey(ch)){

              neededCharCounts.put(ch,neededCharCounts.get(ch)+1);
          }else{
              neededCharCounts.put(ch,1);
          }
      }
      char [] inputArray = input.toCharArray();

      int   missingCharCount = characters.length();
      for (int windowEndIndex = 0; windowEndIndex < input.length(); windowEndIndex++) {
          char ch = inputArray[windowEndIndex];

          if(neededCharCounts.containsKey(ch)){
              if(neededCharCounts.get(ch) > 0) missingCharCount --;
              neededCharCounts.put(ch, neededCharCounts.get(ch) -1);
          }
          if(missingCharCount !=0){
            char leftChar = inputArray[windowStartIndex];
              while (windowStartIndex < windowEndIndex && (!( neededCharCounts.containsKey(leftChar)) || neededCharCounts.get(leftChar) < 0)) {
                  if (neededCharCounts.containsKey(leftChar)) neededCharCounts.put(ch, neededCharCounts.get(ch) +1);
                  windowStartIndex++;
                  leftChar = inputArray[windowStartIndex];
              }
              if ( (windowEndIndex - windowStartIndex) < (smallestWindowEndIndex - smallestWindowStartIndex)) {
                  smallestWindowStartIndex = windowStartIndex;
                  smallestWindowEndIndex = windowEndIndex;
              }
          }
      }
      for(int i = smallestWindowStartIndex; i<smallestWindowEndIndex+1; i++){
          result.append(inputArray[i]);
      }
      return result.toString();
  }

    public static double findMaxAverage(int[] nums, int k) {
        if(nums.length < 0 || k <0){
            return 0;
        }


        int currentSum =0, maxSum =0, startIndex = 0;
        double maxDev = 0.0;

        for(int i = 0; i<=nums.length-k; i++){
            for(int s = startIndex; s<startIndex+k;s ++){
                currentSum += nums[s];
            }
            if(currentSum > maxSum){
                maxSum=currentSum;
            }
            currentSum = 0;
            startIndex++;
        }
        maxDev = (double) maxSum / k;

        return maxDev;
    }


    public static void main(String[] args) {
        findSum(9, new int []{1,2,3,4,5,6,7,8,9});
        System.out.println(getMaxSubarray(2,new int []{-1,2,3,1,-3,2}));
      // findSumNegative(5,new int []{-1,2,3,1,-3,2});
        findMaxFromZeroOne(new int[]{0,1,0,1,0,0,1,1}, 2);
        getShortestSubstring("gho8cbb","cbb");
        System.out.println(findMaxAverage(new int[]{1,12,-5,-6,50,3}, 4));
    }


}
