package helloword.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class permuteII {

    List<List<Integer>> ls;
    public  List<List<Integer>> permuteII (int[] nums){
        Arrays.sort(nums);
        boolean[] u= new boolean[nums.length];
        ls =new ArrayList<>() ;
        backTrackingII(new ArrayList<>(),u,nums);
        return ls;
    }

    public  void backTrackingII(List<Integer> path,boolean[] used, int[] nums) {
        if (path.size() == nums.length) {
            // 所有数都填完了
            ls.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                // 剪枝
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            used[i] = true;
            path.add(nums[i]);
            backTrackingII(path, used, nums);
            path.remove(path.size() - 1);
            // 撤销操作
            used[i] = false;
        }

    }

    public static void main(String[] args) {
        permuteII p=new permuteII();
        int[] nums={1,1,3};
        List<List<Integer>> res =p.permuteII(nums);
        System.out.println(res);
    }
}
