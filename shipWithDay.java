package helloword.leetcode;

public class shipWithDay {
    public  static int f2(int[] w,int x){
        int day=0;
        for (int i = 0; i <w.length ;) {
            int cap =x;
            while (i<w.length){
                if (cap<w[i]) break;
                else  cap-=w[i];
                i++;
            }
            day++;
        }
        return day;
    }
    public static int shipWithDay(int[] weights,int days ){
        int left =0;
        int right =1;
        for (int w:weights){
            left=Math.max(w,left);
            right+=w;
        }
        while (left<right){
            int mid =left+(right -left)/2;
            if (f2(weights,mid)<=days) {
                right=mid;
            } else {
                left=mid+1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] a={1,2,3,4,5,6,7,8,9,10};
        int res =shipWithDay(a,5);
        System.out.println(res);
    }

}
