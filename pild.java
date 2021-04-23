package helloword.leetcode;

// 回文
public class pild {

    public String  pild(String s){
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            String s1 = expand(s, i, i);
            String s2 = expand(s, i, i+1);
            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;
        }
        return res;
    }

    public static  String expand (String s , int left , int right){
        while (left>=0 && right<= s.length()){
            if (s.charAt(left)==s.charAt(right)){
                left --;
                right++;
            }else {
                break;
            }
        }
        return s.substring(left + 1, right);
    }
}
