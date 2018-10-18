package leecode.linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * @题目： 141. Linked List Cycle（判断链表是否有环）
 * @link https://leetcode.com/problems/linked-list-cycle/description/
 * @author bertking
 * @date 2018/8/3
 */
public class Leecode141 {


    /**
     * 快慢指针非常之巧妙
     * 其思路适用于287. Find the Duplicate Number
     * https://leetcode.com/problems/find-the-duplicate-number/discuss/72845/Java-O(n)-time-and-O(1)-space-solution.-Similar-to-find-loop-in-linkedlist.
     *
     * 解法：想象两个跑步运动员在跑道上跑步，如果跑道是环形的，那么faster & slower必然会在某个位置相遇。
     * 参考自：https://leetcode.com/problems/linked-list-cycle/solution/
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {

        /**
         * 这里的两个运动员开始在同一位置(head)出发...
         */
        ListNode fast = head;
        ListNode slow = head;

        /**
         * faster还没到终点...
         */
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            /**
             * 两者相遇...即跑道是环形的
             */
            if(fast == slow){
                return true;
            }
        }
        return false;
    }


    /**
     * 抓住事务的本质
     * 判断链表是否存在环，我们可以通过检查每个节点是否在访问之前被访问过....
     * 所以可以通过唯一性来判断。
     *
     * @param head
     * @return
     */
    public boolean hasCycle2(ListNode head) {
        Set<ListNode> nodesVisited = new HashSet<ListNode>();
        while (head!= null){
            if(nodesVisited.contains(head)){
                return true;
            }else {
                nodesVisited.add(head);
            }
            head = head.next;
        }
        return false;
    }


    /**
     * 这招够阴的了...
     * 讲解：https://leetcode.com/problems/linked-list-cycle/discuss/146751/Java-Solution-better-than-current-solution-(iterate-list-once-no-extra-memory)
     *
     * 思路：将原来的链表中每一个元素的next都置为自己弄的那个元素(fakeHead)，随后走着走着如果发现有个元素的next是自己设置的那个，就说明来过这里。
     *
     * 不足之处：该解法不好回答follow up:(就是找到这个有两个元素指向的元素)
     *
     *
     * @param head
     * @return
     */
    public boolean hasCycl3(ListNode head) {
        ListNode fakeHead = new ListNode(0);
        if(head == null) return false;

        while (head.next != null){
            /**
             * 看链表的节点，一定不能单独地看一个节点：
             * temp = head. 则意味着 temp 和head 一样都是指的是以head为开头的链表。（可以想象自己拿着铁链的头，则就拿到了整条铁链）
             */
            ListNode temp = head;
            head = head.next;
            temp.next = fakeHead;
        }

        if(head == fakeHead){
            return true;
        }else {
            return false;
        }


    }


    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        Leecode141 leecode141 = new Leecode141();
        leecode141.hasCycl3(node1);
    }

    static class ListNode{
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
