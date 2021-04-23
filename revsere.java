package helloword.leetcode;

public class revsere {

    public static int revsereNum (int a) {
        int b = 0;
        while (a!=0)  {
            b=b*10+(a%10);
            a=a/10;
        }
        if (b>(Math.pow(2,31)-1) || b <(Math.pow(-2,31))){
            return  0;
        }
        return 0;
    }

}
