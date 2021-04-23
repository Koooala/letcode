package helloword.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class phoneNums {
    private static List<String> phoneNums(String s){
        HashMap<String,String> NumMap=new HashMap<>();
        NumMap.put("2","abc");
        NumMap.put("3","def");
        NumMap.put("4","ghi");
        NumMap.put("5","jkl");
        NumMap.put("6","mno");
        NumMap.put("7","pqrs");
        NumMap.put("8","tuv");
        NumMap.put("9","wxyz");

        List<String> result = new ArrayList<>();

        if (s.length() == 0) {
            return result;
        }
        result.add("");

        for (int i = 0; i <s.length() ; i++) {
            result=add(result,NumMap.get(String.valueOf(s.charAt(i))));
        }

        return result;
    }
    public  static  List<String> add (List<String> l,String s){
        List<String> nList=new ArrayList<>();
        for (String value : l) {
            for (int j = 0; j < s.length(); j++) {
                nList.add(value + s.charAt(j));
            }
        }
        return  nList;
    }
}
