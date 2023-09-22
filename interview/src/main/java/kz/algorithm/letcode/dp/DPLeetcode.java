package kz.algorithm.letcode.dp;

public class DPLeetcode {
    public static int coinChange(int[] coins, int amount) {
        int dp[] = new int [amount+1];
        dp[0] = 0;

        for(int i = 1; i < amount+1; ++i){
            for(int j = 0; j < coins.length; ++j){
                if(i - coins[j] == 0){
                    dp[i]=1;
                }else if(i-coins[j]>0 && dp[i-coins[j]] !=-1){
                    dp[i]=dp[i-coins[j]]+1;
                }else{
                    dp[i] = -1;
                }
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{1,2,5},11));

    }
}
