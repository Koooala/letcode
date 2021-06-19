package helloword.leetcode;

public class mutiply {

    public static String mutiply(String num1, String num2){
        if (num1.equals("0")||num2.equals("0")){
            return  "0";
        }
        int[] ans =new int[num1.length()+num2.length()];
        for (int i = num1.length()-1; i >=0 ; i--) {
            int n1 =num1.charAt(i) -'0';
            for (int j = num2.length()-1; j >=0 ; j--) {
                int n2 =num2.charAt(j)-'0';
                int sum= ans[i+j+1]+n1*n2;
                ans[i+j+1]=sum%10;
                ans[i+j] += sum/10;
            }
        }

        StringBuilder sb=new StringBuilder();
        for (int i = 0; i <ans.length ; i++) {
            if (i==0&&ans[i]==0) continue;;
            sb.append(ans[i]);
        }
         return sb.toString();
    }

    public static void main(String[] args) {
        String res=mutiply("12","24");
        System.out.println(res);
    }


}
