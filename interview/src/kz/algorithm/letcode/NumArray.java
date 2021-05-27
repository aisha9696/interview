package kz.algorithm.letcode;

public class NumArray {


        private int prefixSum [];

        public NumArray(int[] nums) {
            this.prefixSum = new int[nums.length];
            prefixSum[0] = nums[0];

            for(int i=1; i<nums.length; i++){
                prefixSum[i] = this.prefixSum[i-1] + nums[i];
            }

        }

        public int sumRange(int i, int j) {
            return prefixSum[j]-prefixSum[i-1];
        }

}
