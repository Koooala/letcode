package helloword.leetcode;

public class maxVoL {
    public static  int getMaxVoL(int[] nums){
        int max =0;
        int i=0;
        int j=nums.length-1;
        while (i<j){
            max=Math.max(max,Math.min(nums[j],nums[i])*(j-i));
            if (nums[i] < nums[j]) {
                i++;
            } else {
                j--;
            }
        }
        return max;
    }
}
