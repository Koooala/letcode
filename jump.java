package helloword.leetcode;

public class jump {
   // reference  https://www.cnblogs.com/lichen782/p/leetcode_Jump_Game_II.html
    public static int jumpII(int[] A) {
        int ret = 0;
        int last = 0;
        int curr = 0;
        for (int i = 0; i < A.length-1; ++i) {
            if (i > last) {
                last = curr;
                ++ret;
            }
            curr = Math.max(curr, i+A[i]);
        }
        return ret;
    }


    //  55 [2,3,1,1,4]
    public boolean canJump(int[] nums) {
         int maxEach =0;
        for (int i = 0; i <nums.length ; i++) {
            if (i>maxEach) return  false;
            maxEach=Math.max(maxEach,i+nums[i]);
            if (maxEach>=nums.length-1) return true;
        }
      return false;
    }

    public static void main(String[] args) {

        jump j =new jump();
        int [] a ={2,3,1,1,4};
        boolean res = j.canJump(a);
        System.out.println(res);
    }
}
