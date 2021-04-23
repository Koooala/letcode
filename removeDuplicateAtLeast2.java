package helloword.leetcode;

import org.jetbrains.annotations.NotNull;

public class removeDuplicateAtLeast2 {
    private static  int removeDuplicateAtLeast2(@NotNull int[] n){

        if (n.length-2<=0)
        {
            return 0;
        }
        int index =2;
        for (int i = 2; i <n.length ; i++) {
            if (n[index-2]!=n[i]){
                n[++index]=n[i];
            }
        }
        return index+1 ;
    }
}
