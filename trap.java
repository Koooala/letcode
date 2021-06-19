package helloword.leetcode;

public class trap {
    public  static  int trap ( int[] nums){
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        int leftMax = Integer.MIN_VALUE;
        int rightMax =Integer.MIN_VALUE;

        for (int i = 0; i <nums.length ; i++) {
            leftMax =Math.max(leftMax,nums[i]);
            left[i]=leftMax;
        }

        for (int i = nums.length-1; i >=0 ; i--) {
            rightMax= Math.max(rightMax,nums[i]);
            right[i]=rightMax;
        }

        int res =0;
        for (int i = nums.length-1; i >=0 ; i--) {
            res+=Math.max(0,Math.min(right[i],left[i])-nums[i]);
        }
        return  res;
    }

    public static void main(String[] args) {
        int[] a={0,1,0,2,1,0,1,3,2,1,2,1};
        int res=trap(a);
        System.out.println(res);
    }
}
