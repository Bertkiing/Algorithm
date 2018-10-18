package leecode.linkedlist;

/**
 * @author bertking
 * @题目 21. Merge Two Sorted Lists(合并2个有序的链表)
 * @link https://leetcode.com/problems/merge-two-sorted-lists/description/
 * @date 2018/8/2
 */
public class Leecode21 {

    /**
     * 分析的相当之不错 https://leetcode.com/problems/merge-two-sorted-lists/discuss/9772/java-solution-with-real-world-concerns-real-world-concerns
     * <p>
     * 解析：O(n) in the worst case.
     * It would be when you go through the entire list 1 to find an element smaller than the smallest element in list 2 (or vice versa).
     * 递归将会遍历链表List 1 找出小于 List2 中的最小值
     * <p>
     * PS：（or vice versa）反之亦然...
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }


    /**
     * iterative one (迭代来实现)
     * <p>
     * But 多使用了一个头指针
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode current = head;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        /**
         * 参考自：https://leetcode.com/problems/merge-two-sorted-lists/discuss/150170/Java-Easy-Merge-Sort-Method-BEATS-100-INSANE-RUN-TIME!
         */
        current.next = (l2 == null ? l1 : l2);

//        if (l1 != null) {
//            current.next = l1;
//        } else {
//            current.next = l2;
//        }
        return head.next;
    }


    /**
     * iterative one （迭代）
     * <p>
     * 不借助头指针
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoList3(ListNode l1, ListNode l2) {
        ListNode head;
        // First element,即找到头节点
        if (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                head = l1;
                l1 = l1.next;
            } else {
                head = l2;
                l2 = l2.next;
            }
        } else {
            head = l1 == null ? l2 : l1;
            return head;
        }

        ListNode temp = head;
        // Reset of the list

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }

        temp.next = l1 != null ? l1 : l2;
        return head;
    }


    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
