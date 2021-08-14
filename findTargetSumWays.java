package helloword.leetcode;

public class findTargetSumWays {
    public static int res = 0;
    public  static int findTargetSumWays(int[] nums ,int target){
        if (nums.length==0) return 0;
        backtrack(nums,0,target);
        return res;
    }
    public  static  void  backtrack(int[] nums,int i,int rest){
        if (i==nums.length){
            if (rest==0) {
                res++;
            }
            return;
        }
        backtrack(nums,i+1,rest-nums[i]);
        backtrack(nums,i+1,rest+nums[i]);
    }

/*    sum(A) - sum(B) = target
    sum(A) = target + sum(B)
    sum(A) + sum(A) = target + sum(B) + sum(A)
      2 * sum(A) = target + sum(nums)

      假如我们将所有元素都看成一定重量的物品，[+,+,-,-,+,....+]则S代表的物理意义就是正号物品选择一次，
负号物品不但不选择并且还需要从背包拿出同样重量的物品。（当然S并不只是只有一种正负号向量，它有多种情况。）
所有元素的和sum，[+,+,+,....+]代表的物理意义是所有物品都选择一次。
sum + S代表的物理意义，就是某些物品选择两次。（S中的负号物品与sum中对应的正号抵消，S中的正号物品将选择两次）
      */
    public  static  int DpSolve(int[] nums ,int target){
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum < target || (sum + target) % 2 == 1) {
            return 0;
        }
        int w = (sum + target) / 2;
        int[] dp = new int[w + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int j = w; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }
        return dp[w];
    }

    public static void main(String[] args) {
        int[] v = {1,1,1,1,1};
       int res= findTargetSumWays(v,3);
       int res1=DpSolve(v,3);
       System.out.println(res);
        System.out.println(res1);
    }

}
