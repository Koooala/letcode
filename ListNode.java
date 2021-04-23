package helloword.leetcode;

import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1), pre = dummyHead;
        int t = 0;
        while (l1 != null || l2 != null || t != 0) {
            if (l1 != null) {
                t += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                t += l2.val;
                l2 = l2.next;
            }
            pre.next = new ListNode(t % 10);
            pre = pre.next;
            t /= 10;
        }

        return dummyHead.next;
    }


    private static String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuffer s = new StringBuffer();
        for(int i =0;i<values.length;i++){
            while(num>=values[i]){
                s.append(symbols[i]);
                num -= values[i];
            }
        }
        return s.toString();
    }

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

    private  static  int[][] threeSum (int[] nums){
        Arrays.sort(nums);
        int[][] res = new int[0][];
        for (int i = 0; i <nums.length ; i++) {
            if ((i>0) && (nums[i]==nums[i-1])){
                continue;
            }
            int j =i+1;
            int k=nums.length-1;
            while (j<k){
                if (j>i+1 && nums[j]==nums[j-1]){
                    j++;
                    continue;
                }
                if (k<nums.length-1 && nums[k]==nums[k+1]){
                    k--;
                    continue;
                }
                int sum=nums[i]+nums[j]+nums[k];
                if (sum==0){
                    //golang 这样写：res= append(res, []int{nums[i], nums[j], nums[k]})
                    // todo 这样只会有一个结果
                    res= new int[][]{new int[]{nums[i],nums[j],nums[k]}};
                    j++;
                    k--;
                } else if (sum<0){
                    j++;
                } else {
                    k--;
                }

            }

        }
        return res;
    }

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

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;
        int i = 0;
        while (i < n && fast != null) {
            fast = fast.next;
            i++;
        }
        if(fast == null) return head.next;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
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

    public static void main(String[] args) {
        //  int[]  b={-1,1,0,-4,4,2,-1,-1,1};
        //  int[][] res=threeSum(b);
        List<String> nList=new ArrayList<>();
        nList=phoneNums("246");
        // String[] strs={"flower","flow","flight"};
        //String str=longestCommonPrefix(strs);
        //  int ress=RomanToInt("XIII");
        // String res=intToRoman(1203);
        //  System.out.println(Arrays.deepToString(res));
        System.out.print(nList);
    }
}
