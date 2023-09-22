package kz.algorithm.letcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GameOfLife {

    public static void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int [][]result = new int [m][n];
        for(int i = 0 ; i < m; i++){
            for(int j = 0 ; j < n; j++){
                //life
                result[i][j] = countOfLivedCell(i,j,board);
            }
        }
        for(int i = 0 ; i < m; i++){
            for(int j = 0 ; j < n; j++){
                if(board[i][j] == 1){

                    if(result[i][j]< 2){
                        board[i][j] = 0;
                    }else if(result[i][j] == 2 || result[i][j] == 3){
                        board[i][j] = 1;
                    }else if(result[i][j] >3){
                        board[i][j] = 0;
                    }
                }else if(board[i][j] == 0){ // died
                    if(result[i][j] == 3){
                        board[i][j] = 1;
                    }
                }else{
                    return ;
                }

            }

        }



        System.out.println(board);
    }
    public static int countOfLivedCell(int i, int j,int[][] board ){
        int count = 0;
        //left - up

        int m = board.length;
        int n = board[0].length;
        if(i -1 >= 0 && j -1 >= 0  && board[i-1][j-1] == 1){
            count++;
        }
        // up lrft
        if(i-1 >=0 && j >=0 && board[i-1][j] == 1){
            count++;
        }
        // right - up
        if(i -1 >= 0 && j +1 < n && board[i-1][j+1] == 1){
            count++;
        }
        //left
        if(i >=0 &&  j -1 >= 0  && board[i][j-1] == 1){
            count++;
        }
        //right
        if(i >=0 && j +1 < n  && board[i][j+1] == 1){
            count++;
        }
        // bottom left
        if(i+1 < m && j -1 >= 0  && board[i+1][j-1] == 1){
            count++;
        }

        //bottom
        if(i+1 < m && j>=0 &&  board[i+1][j] == 1){
            count++;
        }
        //bottom right
        if(i+1 < m &&  j+1 <n  && board[i+1][j+1] == 1){
            count++;
        }
        return count;
    }

    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map  =  new HashMap<>();
        int [] result = new int[k];
        for(int n : nums){
            if(!map.containsKey(n)){
                map.put(n,1);
            }else {
                map.replace(n,map.get(n)+1);
            }
        }
        int [] massiv = new int[10000];
        map.forEach((integer, integer2) -> {
            massiv[integer2] = integer;
        });
        int t =0;
        for (int i = 9999; i >= 0; i-- ){
            if(massiv[i] != 0 && k > 0){
                result[t++] = massiv[i];
                k--;
            }
        }
        return result;
    }

    public static int findKthLargest(int[] nums, int k) {

        Arrays.sort(nums);
        int result = 0;
        for(int i = nums.length -1; i >=-1 && k > 0; i--, k--){
            result = nums[i];
        }
        return result;
    }

    public static int[] productExceptSelf(int[] nums) {
        int maxnum = 1;
        int [] output= new int[nums.length];
        int zeros =0;
        for(int i = 0; i < nums.length; i++ ){
            if(nums[i] == 0){
                zeros ++;
                continue;
            }else{
                maxnum *=nums[i];
            }
        }

        for(int i = 0; i < nums.length; i++){
            if(zeros > 1){
                output[i] = 0;
            }
            else if(zeros == 1){
                if(nums[i] == 0 ){
                    output[i] = maxnum;
                }else{output[i] = 0;}
            }else{
                output[i] = maxnum / nums[i];
            }
        }
        return output;

    }
    public static void main(String[] args) {
        gameOfLife(new int [][]{{0,1,0},{0,0,1},{1,1,1},{0,0,0}});
        topKFrequent(new int []{-1,-1},1);
        findKthLargest(new int[]{3,2,3,1,2,4,5,5,6},5);
        productExceptSelf(new int []{-1,1,0,-3,3});
        System.out.println("Sot");
    }
}
