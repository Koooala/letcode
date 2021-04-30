package helloword.leetcode;

public class reverseList {
    public  static  ListNode reverse_solution1(ListNode list){
        ListNode dummy =new ListNode(-1);
        ListNode pre =list;
        while (pre!=null){
            // temp =a;a=b;b=temp
            ListNode pn=pre.next;
            pre.next=dummy.next;
            dummy.next=pn;
            // 更新 pre位置
            pre=pn;
        }
        return dummy.next;
    }

    public  static  ListNode reverse_solution2(ListNode list){
        if (list==null||list.next==null) return list;
        // 保存除头部以下节点
        ListNode temp=list.next;
        //翻转
        ListNode res =reverse_solution2(list.next);
        // 头和头部剩下交换
        temp.next=list;
        // 头尾=null
        list.next=null;
        return res;
    }
}
