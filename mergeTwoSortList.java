package helloword.leetcode;


public class mergeTwoSortList {

    public static ListNode mergeTwoSortList_Solution1(ListNode l1, ListNode l2){
      if (l1==null) return l2;
      if (l2==null) return l1;

      if (l1.val<l2.val){
          l1.next=mergeTwoSortList_Solution1(l1.next,l2);
          return l1;
      }else {
          l2.next=mergeTwoSortList_Solution1(l2.next,l1);
          return l2;
      }
    }

    private static ListNode mergeTwoSortList_Solution2(ListNode l1, ListNode l2){
       if (l1==null) return l2;
       if (l2==null) return l1;
       ListNode pre =new ListNode(0);
       ListNode end=pre;
       while (l1!=null&&l2!=null){
           if (l1.val<l2.val){
              end.next=l1;
              l1=l1.next;
           } else {
               end.next=l2;
               l2=l2.next;
           }
           end=end.next;
       }
       if (l1==null)
           end.next=l2;
       else
           end.next=l1;
        return pre.next;
    }

    public static void main(String[] args) {
    ListNode l1=new ListNode(4);
    ListNode l2=new ListNode(2,l1);
    ListNode l3=new ListNode(1,l2);

    ListNode l4=new ListNode(5);
    ListNode l5=new ListNode(3,l4);
    ListNode l6=new ListNode(2,l5);

    ListNode l7=mergeTwoSortList_Solution1(l3,l6);
    ListNode l8=mergeTwoSortList_Solution2(l3,l6);

    System.out.print(l7);
    System.out.print(l8);
    }
}

