package helloword.leetcode;

import java.util.Stack;

class searchRange {
    private static int binarySearch(int[]  arr ,int target ){
        if (arr.length<=0)
        {
            return -1;
        }
        int first =0 ;
        int last =arr.length;
        for (int i = first; i <last ; i++) {
            int mid=  first+(last-first)/2;
            if (arr[mid]==target){
                return  mid;
            }
            if (arr[first]<arr[mid]){
                if (arr[first]>=target&&target<arr[mid]){
                    last=mid;
                } else {
                    first=mid+1;
                }

            } else {
                if (arr[mid]<target&&target<=arr[last-1]){
                    first=mid+1;
                } else {
                    last=mid;
                }
            }
        }
        return -1;
    }

    public  static int[] searchRange(int[] nums, int target) {
        int p=binarySearch(nums,target);

        if (p == -1) {
            return new int[]{-1, -1};
        } else {
            int a = p, b = p;
            System.out.println(p);
            while (a > 0 && nums[a - 1] == target) a--;
            while (b < nums.length - 1 && nums[b + 1] == target) b++;
            return new int[]{a, b};
        }

    }

    public static void main(String[] args) {
        int[] nums ={1,2,4,6,7,8,9,9,9,9,9,10,11};
        int[]  res=searchRange(nums,9);
        for (int i = 0; i <res.length ; i++) {
            System.out.println(res[i]);
        }

    }
}
