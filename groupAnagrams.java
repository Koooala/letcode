package helloword.leetcode;

import java.util.*;

public class groupAnagrams {

    public static List<List<String>> group(String[] str){
        if (str.length==0) return  new ArrayList<>();
        Map<String,List> map=new HashMap<>();
        for (int i = 0; i < str.length; i++) {
            char[] ch=str[i].toCharArray();
            Arrays.sort(ch);
            String k = String.valueOf(ch);
            if (!map.containsKey(k)) map.put(k,new ArrayList());
            map.get(k).add(str[i]);
        }
        return new ArrayList(map.values());
    }
   /*func group (in []string ) (res map[string][]string){
	if len(in)==0 {
		return
	}
	resMap:=make(map[string][]string,0)
	for _, i := range in {
		r:=i
		s:=strings.Split(i,"")
		sort.Strings(s)
		resMap[strings.Join(s,"")]=append(resMap[strings.Join(s,"")],r)
	}

   return resMap
   }*/

    public static void main(String[] args) {
        String[] s={"eat","tea","eta","nat","tan","bat"};

        List<List<String>> res =group(s);
        System.out.println(res.toString());
    }

}
