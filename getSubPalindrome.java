package helloword.leetcode;

import java.util.ArrayList;
import java.util.List;

public class getSubPalindrome {

    public static  List<List<Character>> res;
    public  static List<Character> path;
    public  static List<List<Character>> getsub(String s){
        int len =s.length();
        char[] arrs =s.toCharArray();
        f(arrs,len,0,path,res);
        return  res;
    }

    //
    public  static  void  f(char[] arrs, int len, int cur , List<Character> path,List<List<Character>> res) {
        if (cur==len){
            res.add(new ArrayList<>(path));
            //
        }
        for (int i = 0; i < len; i++) {
            if (isPailndrome(arrs,cur,i)){
                path.add(arrs[i]);
                f(arrs,len,cur+1,path,res);
                path.remove(i-1);
            }
        }
    }

    public  static  boolean isPailndrome(char[] str ,int left ,int right){
        while (left<right){
            if (str[left]!=(str[right])){
                return  false;
            }
            left--;
            right++;
        }
        return true;
    }
}
