package helloword.leetcode;

public class firstMissPositive {
//如果整数都出现，那么最后数组排列应该是[1,2,3,4,5,…,n]，每个都是递增1。
//只要不满足nums[i]-nums[i-1]不等于1，那么就找到了最小的未出现的整数。
//强行另数组下标和存的值产生联系-> 令数字i出现在下标为i-1的位置，如果会越界则不做处理。
//比如[3,4,-1,1]->[-1,4,3,1]->[-1,1,3,4]->[1,-1,3,4];
    public static int firstMissingPositive(int[] nums) {
        for(int i=0;i<nums.length;){
            if(nums[i]>0&&nums[i]<=nums.length&&nums[i]!=nums[nums[i]-1]){
                //确定nums[i]的值对应的下标不越界，同时排除num[i]本身位置正确或者nums[i]应该放入的位置nums[i]-1原本就是nums[i](如[1,1])
                int index = nums[i];//
                nums[i] = nums[index -1];
                nums[index -1]=index;
                //换位置之后需要继续判断换过来的值是否在对的位置上，因此不能i++;
            }else{
                i++;
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=i+1){
                return i+1;
            }
        }
        return nums.length+1;
    }

    public static void main(String[] args) {
        int[] a={5,1,3,2};
        int res=firstMissingPositive(a);
        System.out.println(res);
    }

}
