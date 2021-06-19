package helloword.leetcode;

public class jumpII {
   // reference  https://www.cnblogs.com/lichen782/p/leetcode_Jump_Game_II.html
    public static int jump(int[] A) {
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
}
