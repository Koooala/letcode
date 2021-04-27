package helloword.leetcode;

import java.util.ArrayList;
import java.util.List;

public class genBracket {
    private List<String> res = new ArrayList<>();
    public List<String> genBracket(int n){
        dfs("", n, 0, 0);
        return res;
    }

    public void dfs(String ans, int n, int lc, int rc) {
        // 剪枝 右边扣号数量大于左边
        if(rc > lc || lc > n) return;
        // 满足结果
        if(lc == n && lc == rc) res.add(ans);
        // 遍历+递归
        dfs(ans+'(', n, lc+1, rc);
        dfs(ans+')', n, lc, rc+1);
    }

    //
    private static List<List<Integer>> per (int[] nums){
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> trace=new ArrayList<>();
        bracktrace(nums,trace,ans);
        return  ans;
    }

    // 全排列
    public  static void bracktrace(int[] nums ,List<Integer> trace,List<List<Integer>> ans){
        if (trace.size()==nums.length){
            ans.add(new ArrayList<>(trace));
        }else {
            for (int num : nums) {
              if (trace.contains(num)) continue;
                trace.add(num);
                bracktrace(nums, trace, ans);
                trace.remove(trace.size() - 1);
            }
        }

    }

    public static void main(String[] args) {
        int[] nums ={1,2,4};
        List<List<Integer>> ans=per(nums);
        String s=ans.toString();
        System.out.println(s);

        genBracket g=new genBracket();
        List<String> str=g.genBracket(3);
        System.out.println(str);
    }
}
