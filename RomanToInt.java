package helloword.leetcode;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt {

    private static int RomanToInt(String s) {
        String[] arr = s.split("");
        Map<String,Integer> a=new HashMap<>();
        a.put("I",1);
        a.put("V",5);
        a.put("X",10);
        a.put("L",50);
        a.put("C",100);
        a.put("D",500);
        a.put("M",1000);
        int sum=0;
        for(int i=0;i<arr.length;i++){
            if(i<arr.length-1) {
                if (a.get(arr[i]) >= a.get(arr[i + 1])) {
                    sum += a.get(arr[i]);
                } else {
                    sum -= a.get(arr[i]);
                }
            }else{
                sum += a.get(arr[i]);
            }
        }
        return sum;
    }
}
