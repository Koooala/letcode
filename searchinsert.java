package helloword.leetcode;

public class searchinsert {

    public  static  int searchinsert(int[] nums ,int target){

        for (int i = 0; i < nums.length; i++) {
            if (nums[i]>=target){
                return i ;
            }
        }
        return  nums.length;
    }

    public static void main(String[] args) {
        int[] nums ={1,2,4,6,7,8,10,11};
        int  res=searchinsert(nums,9);
        System.out.println(res);
    }
}
