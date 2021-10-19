package helloword.leetcode;

import java.util.PriorityQueue;

public class mereKSortList {
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

    private  static ListNode mergeKSortedListsSolve2(ListNode[] lists){

        if (lists.length==0) return null;
        ListNode dummy =new ListNode(-1);
        ListNode p =dummy;

        PriorityQueue<ListNode> qp =new PriorityQueue<>(
                lists.length,(a,b)->(a.val-b.val)
        );

        for (ListNode head :lists){
            if (head!=null){
                qp.add(head);
            }
        }
       while (!qp.isEmpty()){
           ListNode cur =qp.poll();
           p.next=cur;
           if (cur.next!=null){
               qp.add(cur.next);
           }
           p=p.next;
       }

        return dummy;
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

        ListNode res= mergeKSortedListsSolve2(lists);


        System.out.println(res);
    }
}
