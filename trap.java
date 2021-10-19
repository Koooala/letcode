package helloword.leetcode;

import java.util.*;

public class trap {
    public  static  int trap ( int[] nums){
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        int leftMax = Integer.MIN_VALUE;
        int rightMax =Integer.MIN_VALUE;

        for (int i = 0; i <nums.length ; i++) {
            leftMax =Math.max(leftMax,nums[i]);
            left[i]=leftMax;
        }

        for (int i = nums.length-1; i >=0 ; i--) {
            rightMax= Math.max(rightMax,nums[i]);
            right[i]=rightMax;
        }

        int res =0;
        for (int i = nums.length-1; i >=0 ; i--) {
            res+=Math.max(0,Math.min(right[i],left[i])-nums[i]);
        }
        return  res;
    }

    public static int trap6(int[] height) {
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        int current = 0;
        while (current < height.length) {
            //如果栈不空并且当前指向的高度大于栈顶高度就一直循环
            while (!stack.empty() && height[current] > height[stack.peek()]) {
                int h = height[stack.peek()]; //取出要出栈的元素
                stack.pop(); //出栈
                if (stack.empty()) { // 栈空就出去
                    break;
                }
                int distance = current - stack.peek() - 1; //两堵墙之前的距离。
                int min = Math.min(height[stack.peek()], height[current]);
                sum = sum + distance * (min - h);
            }
            stack.push(current); //当前指向的墙入栈
            current++; //指针后移
        }
        return sum;
    }


    public static void main(String[] args) {
        int[] a={0,1,0,2,1,0,1,3,2,1,2,1};
        int res=trap6(a);
        System.out.println(res);
    }
}