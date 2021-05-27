package kz.algorithm.letcode;

import kz.algorithm.week1.QuickUnionWeightedComp;

public class JumpGame {
    public static boolean canJump1(int[] nums) {
        QuickUnionWeightedComp quwc = new QuickUnionWeightedComp(nums.length* nums.length);
        if(nums.length == 1 ) return true;
        for(int i = 0; i<nums.length; i++){
            if(nums[i]>0 || nums[i] != 0 ){
                for(int j =1; j<=nums[i]; j++){
                    if(i == 0){
                        quwc.union(i,j);
                    }else{
                        quwc.union(i,i+j);
                    }
                }
            }

        }
        if(quwc.connected(0, nums.length-1) )return true;


        return false;
    }

    public static boolean canJump(int[] nums) {
        int lastPos =nums.length -1;
        for(int i = nums.length-1; i >= 0; i-- ){
            if(i+nums[i] >= lastPos){
                lastPos = i;
            }
        }
        return lastPos == 0;

    }


    public static void main(String[] args) {
        System.out.println(canJump(new int[]{2,1,5,0,4,6}));
    }
}
