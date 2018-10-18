package leecode;


import java.util.List;

/**
 * @TAG 链表(linked-list,翻转(reverse))
 *
 * @题目 翻转链表
 * 206. Reverse Linked List
 * @link https://leetcode.com/problems/reverse-linked-list/description/
 *
 * @Discuss https://leetcode.com/problems/reverse-linked-list/discuss/150881/Java-Solution-Discuss
 *
 * @author Bertking
 * @date 2018-7-31
 */
public class Leecode206 {


    /**
     * 递归的方案
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        return reverseList(head,null);
    }

    /**
     * 递归翻转
     * @param current
     * @param prev
     * @return
     */
    public ListNode reverseList(ListNode current,ListNode prev){
        if (current == null) {
            return prev;
        }

        ListNode next = current.next;
        current.next = prev;
        return reverseList(next,current);
    }


    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(4);
        ListNode listNode4 = new ListNode(5);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = null;

        Leecode206 leecode206 = new Leecode206();
        leecode206.reverseList(listNode);
        System.out.println(leecode206.reverseList(listNode));
    }

    /**
     * 迭代法
     */
    public ListNode reverseList2(ListNode head){
        if(head == null || head.next == null){
            return head;
        }

        ListNode node = null;
        while (head != null){
            ListNode tmp = head.next;
            head.next = node;
            node = head;
            head = tmp;
        }
        return node;
    }




    /**
     * 结点
     */
    static class ListNode{
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

}
