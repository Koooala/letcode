package helloword.leetcode;

public class strStr {
    public static   int strStr( String haystack ,String needle ){

        int m=haystack.length();
        int n=needle.length();
        if (m<n) return  -1;

        for (int i = 0; i <m-n ; i++) {
            int j = 0;
            for (j = 0; j <n ; j++) {
                if (haystack.charAt(i+j)!=needle.charAt(j)) {break;}
            }
            if (j == n) return i;
        }

        return -1;
    }

    public static void main(String[] args) {
        int a=strStr("hello","ll");

        System.out.println(a);
    }

}
