package helloword.leetcode;

import java.util.Arrays;

public class threeSum {
    private  static  int[][] threeSum (int[] nums){
        Arrays.sort(nums);
        int[][] res = new int[0][];
        for (int i = 0; i <nums.length ; i++) {
            if ((i>0) && (nums[i]==nums[i-1])){
                continue;
            }
            int j =i+1;
            int k=nums.length-1;
            while (j<k){
                if (j>i+1 && nums[j]==nums[j-1]){
                    j++;
                    continue;
                }
                if (k<nums.length-1 && nums[k]==nums[k+1]){
                    k--;
                    continue;
                }
                int sum=nums[i]+nums[j]+nums[k];
                if (sum==0){
                    //golang 这样写：res= append(res, []int{nums[i], nums[j], nums[k]})
                    // todo 这样只会有一个结果
                    res= new int[][]{new int[]{nums[i],nums[j],nums[k]}};
                    j++;
                    k--;
                } else if (sum<0){
                    j++;
                } else {
                    k--;
                }

            }

        }
        return res;
    }
}
