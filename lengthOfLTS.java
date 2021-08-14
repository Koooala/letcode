package helloword.leetcode;

import java.util.Arrays;

public class lengthOfLTS {
    // leetCode 300
    public  int lengthOfLTSofSolveWithDP(int[] nums){
        int[] dp=new int[nums.length+1];
        Arrays.fill(dp,1);
        for (int i = 0; i <nums.length ; i++) {
            for (int j = 0; j <i ; j++) {
                if (nums[i]>nums[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            System.out.println(Arrays.toString(dp));
        }
        int res =1;
        for (int j : dp) {
            res = Math.max(res, j);
        }
        return res;
    }

    // 耐心排序，结果为通的数量
    public  int lengthOfLTSofSolveWithBinarySearch(int[] nums){
        int[] top = new int[nums.length];
        // 牌堆数初始化为 0
        int piles = 0;
        /***** 搜索左侧边界的二分查找 *****/
        for (int poker : nums) {
            // 要处理的扑克牌
            /***** 搜索左侧边界的二分查找 *****/
            int left = 0, right = piles;
            while (left < right) {
                int mid = (left + right) / 2;
                if (top[mid] > poker) {
                    right = mid;
                } else if (top[mid] < poker) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            // 没找到合适的牌堆，新建一堆
            if (left == piles) piles++;
            // 把这张牌放到牌堆顶
            top[left] = poker;
        }
        // 牌堆数就是 LIS 长度
        return piles;
    }

    public static void main(String[] args) {
        int [] nums= {10,9,2,5,3,7,101,18};
        lengthOfLTS l=new lengthOfLTS();
        int res=l.lengthOfLTSofSolveWithDP(nums);

        int res2=l.lengthOfLTSofSolveWithBinarySearch(nums);
        System.out.println(res2);

    }

}
