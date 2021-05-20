package helloword.leetcode;

public class twoDivide {

    public  static  int divdide(int dividend ,int divisor) {
       if (divisor==0)  return Integer.MAX_VALUE;
       if ((dividend==Integer.MIN_VALUE)&&(divisor==-1) )return Integer.MAX_VALUE;
       // 取符号
       // m=n*2^n1+ n*2^n2+ n*2^n3+ n*2^n4+ n*2^n5+d
       //  商 = n1+n2+...+
        int sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;//异或运算
        long ms = dividend;
        long ns = divisor;
        ms = Math.abs(ms);
        ns = Math.abs(ns);
        int num = 0;
        while(ms >= ns){
            long m = ns;
            long n = 1;
            while(ms >= (m << 1)){
                m <<= 1;
                n <<= 1;
            }
            num += n;
            ms -= m;
        }
        return num * sign;
    }

    public static void main(String[] args) {
        int s =divdide(30,3);
        System.out.println(s);
    }
}
