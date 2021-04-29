package helloword.leetcode;

public class mergeKSortList {
    private  static ListNode mergeKSortedLists(ListNode[] lists){
    if (lists.length==0)
        return null;
    if (lists.length==1)
        return lists[0];
    if (lists.length==2)
        return  mergeTwoSortList.mergeTwoSortList_Solution1(lists[0],lists[1]);

     int mid = lists.length/2;
     ListNode[] l1=new ListNode[mid];
     for (int i = 0; i <mid ; i++) {
            l1[i]=lists[i];
     }
     // l1= 0~mid l2=mid-length
     ListNode[] l2=new ListNode[lists.length-mid];
     for (int j=0,i = mid; i <lists.length ; i++,j++) {
            l2[j]=lists[i];
     }

     return mergeTwoSortList.mergeTwoSortList_Solution1(mergeKSortedLists(l1), mergeKSortedLists(l2));
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(6);
        ListNode l2 = new ListNode(2, l1);
        ListNode l3 = new ListNode(1, l2);

        ListNode l4 = new ListNode(7);
        ListNode l5 = new ListNode(3, l4);
        ListNode l6 = new ListNode(2, l5);

        ListNode l7 = new ListNode(6);
        ListNode l8 = new ListNode(4, l7);
        ListNode l9 = new ListNode(2, l8);

        ListNode[] lists={l3,l6,l9};

        ListNode res= mergeKSortedLists(lists);

        System.out.println(res);
    }
}
