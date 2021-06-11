package helloword.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class combSum {
    List<List<Integer>> lists = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //需要对 candidates 排序
        Arrays.sort(candidates);
        backTracking(candidates, target, 0);
        return lists;
    }

    public void backTracking(int[] arr, int target, int index) {
        if(target==0){
            lists.add(new ArrayList(list));
            return;
        }
        for (int i = index; i < arr.length; i++) {
            if (arr[i]<=target){
                list.add(arr[i]);
                backTracking(arr, target-arr[i], i);
                list.remove(list.size() - 1);
            }
        }

    }

    public static void main(String[] args) {

        combSum c =new combSum();
        int[] nums={2,3,5};
        List<List<Integer>> res =c.combinationSum(nums,8);
        System.out.println(res);
    }

}