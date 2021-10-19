package helloword.leetcode;

public class longestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String result = strs[0];
        if (strs.length == 1) return strs[0];
        for (int i = 0; i < strs.length; i++) {
            if (!strs[i].startsWith(result)) {
                result = result.substring(0, result.length() - 1);
                i--;
            }
        }

        return result;
    }

    public static  int getSubMax(String s){
        if (s.length()==0) return  0;

        int[] m=new int[255];
        for (int i = 0; i <255 ; i++) {
            m[i]=-1;
        }
        int cur =0,len=0,pre=-1;
        char[] ch=s.toCharArray();
        for (int i = 0; i <ch.length ; i++) {
            System.out.println("i:"+i);
            pre=Math.max(pre,m[ch[i]]);
            System.out.println("pre:"+pre);
            cur=i-pre;
            System.out.println("cur:"+cur);
            len= Math.max(len,cur);
            System.out.println("len:"+len);
            m[ch[i]]=i;
        }
        return len;
    }

    public static void main(String[] args) {
        String s="asbac";
        int ans=getSubMax(s);
        System.out.println(ans);
    }

}
