package helloword.leetcode;

public class pow {

    public  static double binPow(double n,double x){
        double res = 1.0;
        for(int i = (int) n; i != 0; i /= 2){
            if(i % 2 != 0){
                res *= x;
            }
            x *= x;
        }
        return  n < 0 ? 1 / res : res;
    }
}
