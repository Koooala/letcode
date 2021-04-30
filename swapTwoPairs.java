package helloword.leetcode;

public class swapTwoPairs {
    public  static  ListNode swapTwoPairs_solution1(ListNode head){
        if (head==null) return null;
        if (head.next==null) return  head;
        ListNode temp=head.next;
        head.next=swapTwoPairs_solution1(temp.next);
        temp.next=head;
        return temp;
    }

    public  static  ListNode swapTwoPairs_solution2(ListNode head){
        if (head==null) return null;
        if (head.next==null) return  head;
        // 1->2->3-4
        // 开始：O-> 1- > 2 - > 3 -> 4
        //      pre     temp = 2->3->4
        // 1指向 3 pre.next.next =tem.next
        // 2指向 1 temp.next=pre.net
        // 2->1->3->4
        // 这时候 pre -> 1 应该让 pre->2 pre.next=temp
        // o->2->-1->-3->4   至此 一轮完成
        //更新 pre-> 1  pre=temp.next 开始下一轮
       ListNode dummy =new ListNode(-1);
       ListNode pre =dummy;
       dummy.next=head;
       while (pre.next!=null&&pre.next.next!=null){
         ListNode temp=pre.next.next;
         pre.next.next=temp.next;
         temp.next=pre.next;
         pre.next=temp;

         pre=temp.next;
       }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1=new ListNode(5);
        ListNode l2=new ListNode(4,l1);
        ListNode l3=new ListNode(3,l2);
        ListNode l4=new ListNode(1,l3);
        l4.PrintValue();
        ListNode l5=swapTwoPairs_solution1(l4);
        ListNode l6 =swapTwoPairs_solution2(l4);
        l5.PrintValue();
        l6.PrintValue();

    }
}
