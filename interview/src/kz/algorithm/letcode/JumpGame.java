package kz.algorithm.letcode;

import kz.algorithm.week1.QuickUnionWeightedComp;

public class JumpGame {
    public static boolean canJump(int[] nums) {
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

    public static boolean canJump1(int[] nums) {
        int [] pos = new int[nums.length* nums.length];
        if(nums.length == 1 ) return true;
        for(int i = 0; i<nums.length; i++){
            if(nums[i]>0 || nums[i] != 0 ){
                for(int j =1; j<=nums[i]; j++){
                    if(i == 0){
                        int qid = pos[i];
                        int pid = pos[j];
                        for(int k = 0; k< pos.length;k++){
                            if(pos[k] == qid){
                                pos[k] = pid;
                            }
                        }
                    }else{
                        int qid = pos[i];
                        int pid = pos[i+j];
                        for(int k = 0; k< pos.length; k++){
                            if(pos[k] == qid){
                                pos[k] = pid;
                            }
                        }
                    }
                }
            }

        }

        if(pos[0] == pos[nums.length-1])return true;


        return false;
    }

    public static void main(String[] args) {
        System.out.println(canJump1(new int[]{3,2,1,0,4}));
    }
}
