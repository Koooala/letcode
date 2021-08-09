package helloword.leetcode;

public class rotateList {
    // 说是循环旋转，但其实本质上是将尾部前面第K个元素作为头，原来的头接到原来的尾上
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        int length = listLength(head);
        ListNode last = head;
        for (int i = 0; i < length - 1; i++) {
            // 找到最后一个
            last = last.next;
        }
        // 最后一个指向head
        last.next = head;

        int mod = k % length;
        int step = length - mod;
        for (int i = 0; i < step; i++) {
            last = last.next;
        }
        head = last.next;
        last.next = null;
        return head;
    }

    private static int listLength(ListNode head) {
        int ret = 0;
        ListNode cur = head;
        while (cur != null) {
            ret++;
            cur = cur.next;
        }
        return ret;
    }

    public static void main(String[] args) {
        ListNode l1=new ListNode(5);
        ListNode l2=new ListNode(4,l1);
        ListNode l3=new ListNode(3,l2);

        ListNode l4=new ListNode(2,l3);
        ListNode l5=new ListNode(1,l4);

        ListNode res=rotateRight(l5,2);


    }
}
