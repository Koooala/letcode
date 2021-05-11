package helloword.leetcode;

public class reverseKListGroup {
    private static  ListNode reverseKListGroup_solutions1 (ListNode head,int k){
       ListNode dummy= new  ListNode(-1);
       dummy.next =head;

       ListNode pre = dummy;
       ListNode curr =dummy;
       while (curr.next!=null){
           // 挪到 k 位置
           int cnt =0;
           while (cnt<k&&curr!=null){
               curr=curr.next;
               cnt ++;
           }
           if (curr==null) break;
           // 指向 head 开始
           ListNode start = pre.next;
           // 保存 curr.next 信息便于start.next=next;接上
           ListNode next =curr.next;
           curr.next=null;  // 断开
           // reverse_solution1 pre.next等价dummy.next 翻转
           pre.next=reverseList.reverse_solution1(start);
           // 翻转后接上
           start.next=next;
           // 更新位置
           pre=start;
           curr=pre;
       }
        return dummy.next;
    }

}
