package helloword.leetcode;

import org.jetbrains.annotations.NotNull;

public class removeDuplicate {

    public static void main(String[] args) {

    }

    // leet code 2-1-1
    private static  int removeDuplicate(@NotNull int[] m){

        if (m.length<=0)
        {
            return 0;
        }
        int index =0;
        for (int i = 1; i <m.length ; i++) {
            if (m[index]!=m[i]){
                m[++index]=m[i];
            }
        }
        return index+1 ;
    }
}
