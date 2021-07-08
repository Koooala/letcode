package helloword.leetcode;

import java.util.ArrayList;
import java.util.List;

public class permute {
    List<List<Integer>> ls;
    public  List<List<Integer>> permuteI (int[] nums){
       ls =new ArrayList<>() ;
        backTracking(new ArrayList<>(),nums);
        return ls;
    }

    public  void  backTracking(List<Integer> l,int[] num){
      if (l.size()==num.length){
          ls.add(new ArrayList<>(l));
          return;
      }
        for (int j : num) {
            if (l.contains(j)) {
                continue;
            }
            l.add(j);
            backTracking(l, num);
            l.remove(l.size() - 1);
        }
    }

    public static void main(String[] args) {
        permute p=new permute();
        int[] nums={1,2,3};
        List<List<Integer>> res =p.permuteI(nums);
        System.out.println(res);
    }
}
