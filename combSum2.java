package helloword.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class combSum2 {
    List<List<Integer>> lists = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    public  List<List<Integer>> combinationSum(int[] candidates, int target) {
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
                if(i>index && arr[i] == arr[i-1]){continue;}
                list.add(arr[i]);
                backTracking(arr, target-arr[i], i+1);
                list.remove(list.size() - 1);
            }
        }

    }

    public static void main(String[] args) {

        combSum2 c =new combSum2();
        int[] nums={10,1,2,7,6,1,8,5};
        List<List<Integer>> res =c.combinationSum(nums,8);
        System.out.println(res);
    }

}
