package leecode;

/**
 * @author bertking
 * @date 2018/8/1
 */
public class Leecode203 {
    /**
     * 非递归（non-recursive）即：迭代(iteration)
     * 递归 （recursive solution）函数的解法，方案不错，但是空间复杂度O(n).
     * 优化建议：使用非递归方法来
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }


    /**
     * 构造一个前驱节点，来遍历链表
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements2(ListNode head,int val){
        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;
        ListNode cur = head;
        ListNode prev = fakeHead;

        while (cur != null){
            if(cur.val == val){
                prev.next = cur.next;
            }else {
                prev = prev.next;
            }

            cur = cur.next;
        }
        return fakeHead.next;
    }


    /**
     * 没有构建头节点(Dummy head)，而是通过null来虚拟
     * 重点：需要判断prev是否为null.
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements3(ListNode head,int val){
        ListNode cur = head;
        ListNode prev = null;

        while (cur != null){
            if(cur.val == val){
                if(prev == null){
                    head = head.next;
                }else {
                    prev.next = cur.next;
                }
            }else {
                prev = cur;
            }

            cur = cur.next;
        }
        return head;
    }


    public ListNode removeElements4(ListNode head,int val){
        if(null == head) return null;
        ListNode traverse = head;
        while (traverse.next != null){
            if(traverse.next.val == val){
                traverse.next = traverse.next.next;
            }else {
                traverse = traverse.next;
            }
        }

        if(head.val == val) return head.next;

        return head;
    }



    public static void main(String[] args) {
        Leecode203 leecode203 = new Leecode203();
        ListNode listNode0 = new ListNode(1);
        ListNode listNode1 = new ListNode(1);
//        ListNode listNode2 = new ListNode(3);
//        ListNode listNode3 = new ListNode(4);
//        ListNode listNode4 = new ListNode(5);
//        ListNode listNode5 = new ListNode(6);

        listNode0.next = listNode1;
//        listNode1.next = listNode2;
//        listNode2.next = listNode3;
//        listNode3.next = listNode4;
//        listNode4.next = listNode5;

//        System.out.println(leecode203.removeElements2(listNode0,2).toString());




        System.out.println(leecode203.removeElements4(listNode0,1).toString());

    }


    /**
     * 节点定义
     */
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}
