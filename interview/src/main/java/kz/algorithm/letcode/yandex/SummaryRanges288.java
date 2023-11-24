package kz.algorithm.letcode.yandex;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges288 {

  /**
   * You are given a sorted unique integer array nums.
   * <p>
   * A range [a,b] is the set of all integers from a to b (inclusive).
   * <p>
   * Return the smallest sorted list of ranges that cover all the numbers in the array exactly. That
   * is, each element of nums is covered by exactly one of the ranges, and there is no integer x
   * such that x is in one of the ranges but not in nums.
   * <p>
   * Each range [a,b] in the list should be output as:
   * <p>
   * "a->b" if a != b "a" if a == b
   * <p>
   * Example : Input: nums = [0,1,2,4,5,7] Output: ["0->2","4->5","7"]
   */

  // сохранить в массив только если check =true
  // check может быть true если
  /**
   * если след элем не соответствует к nums[i]
   * */
  public static List<String> summaryRanges(int[] nums) {
    List<String> array = new ArrayList<>();

    for (int i = 0; i < nums.length; i++) {

      int start = nums[i];
      while (i+1 <nums.length && nums[i+1]-nums[i]==1){
        i++;
      }
      int end = nums[i];
      array.add(start == end? String.valueOf(start) : start +"->"+end);

    }
    return array;
  }

  ///
  public static void main(String[] args) {
    summaryRanges(new int[]{0, 1, 2, 4, 5, 7}).stream().forEach(ss->System.out.println(ss));
  }
}
