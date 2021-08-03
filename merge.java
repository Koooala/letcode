package helloword.leetcode;


import java.util.Arrays;
import java.util.Comparator;

public class merge {
    public int[][] merge(int[][] intervals) {
        // 排序 左边界排序
        Arrays.sort(intervals, Comparator.comparingInt(r -> r[0]));
        int slow=0;
        // 快慢指针指向数组
        // 如果 A数组的 右边界小于 B数数组的有边界  慢指针移动 -- 不合并
        // 否则 A数数组的 有边界取A B两个数组有边界值较大的 -- 合并
        for (int fast=0;fast<intervals.length;fast++){
            if (intervals[slow][1]<intervals[fast][0]) intervals[++slow]=intervals[fast];
            else intervals[slow][1]=Math.max(intervals[slow][1],intervals[fast][1]);
        }
        return Arrays.copyOf(intervals,slow+1);
    }

    public static void main(String[] args) {
        int[][] intA ={{1,3},{2,6},{8,10},{15,18},{2,4}};
        merge m=new merge();
        int[][] res =m.merge(intA);
        System.out.println(Arrays.deepToString(res));
    }
}

