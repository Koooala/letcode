package helloword.leetcode;

public class binarySerach {
    private static int binarySerach(int[]  arr ,int target ){
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
}
