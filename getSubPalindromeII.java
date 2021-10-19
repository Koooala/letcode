package helloword.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class getSubPalindromeII {


    public  static int getMin(String s){
        char[]  chars=s.toCharArray();
        int len=s.length();

        int [] dp =new int[len];
        for (int i = 0; i < len; i++) {
            dp[i]=i;
        }
        for (int i = 1; i <len ; i++) {
            if (isPailndorme(chars, 0, i)) {
                dp[i] = 0;
                continue;
            }
            for (int j = 0; j < i; j++) {
                if (isPailndorme(chars, j + 1, i)) {
                    dp[i] = Math.min(dp[i],dp[j]+1);

                }
            }
        }
      return dp[len-1];
    }


    public  static  boolean isPailndorme ( char[] arrs , int left ,int right ){
        while (left<right){
            if (arrs[left]!=arrs[right]){
                return  false;
            }
            left++;
            right--;
        }
        return  true;
    }

    public static void main(String[] args) {

        HashMap<String,Integer> mp=new HashMap<>();
        mp.put("s1",2);
        System.out.println(mp.get("s2").intValue());
    }
}



