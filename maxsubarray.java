package helloword.leetcode;

import java.sql.Array;
import java.util.Arrays;

public class maxsubarray {
    public  int solve (int[] in){
         int sum = 0,ans =0;
        for (int j : in) {
            sum = sum + j;
            ans = Math.max(sum, ans);
            sum = Math.max(sum, 0);
        }
        return  ans;
    }

    public int maxSubArray(int[] A) {
        int[] dp = new int[A.length];//dp[i] means the maximum subarray ending with A[i];
        dp[0] = A[0];
        int max = dp[0];
        for(int i = 1; i < A.length; i++){
            dp[i] = A[i] + (Math.max(dp[i - 1], 0));
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public int getCoins(int[] coins ,int target){

        int[] dp=new int[target+1];
        Arrays.fill(dp,target);
        dp[0]=0;
        for (int i = 0; i <dp.length ; i++) {
            for (int coin :coins){
                if (i<coin) {
                    continue;
                }
                dp[i]=Math.min(dp[i],1+dp[i-coin]);
            }
        }
       return dp[target];
    }

    public static  int uniquePath (int m ,int n){
        int[] dp=new int[n+1];
        Arrays.fill(dp,0);
        dp[0]=1;

        for (int i = 0; i <m ; i++) {
            for (int j = 1; j <n ; j++) {
                dp[j]=dp[j]+dp[j-1];
            }
        }
      return dp[n-1];
    }

    public static void main(String[] args) {
        maxsubarray m=new maxsubarray();
        int[] a={1,3,5};
        int res =m.getCoins(a,11);
        System.out.println(res);
        int abn =uniquePath(3,7);
        System.out.println(abn);
    }
}
