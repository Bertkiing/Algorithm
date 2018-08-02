package leecode.linkedlist;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bertking
 * @date 2018/8/2
 * @description Middle of the Linked List
 * @link https://leetcode.com/problems/middle-of-the-linked-list/description/
 */
public class Leecode876 {

    /**
     * Two Pointer
     * <p>
     * Java O(n) time & O(1) space
     * <p>
     * 1. Idea is to use two pointer one slow , another fast.
     * 2. move fast pointer twice and slow pointer once.
     * 3. by the time fast pointer reaches the end, slow pointer will be in the middle
     * 4. return the slow pointer.
     * 5. dont forget to check fast.next ! = null coindition in while loop, otherwise you will get null pointer exception. happy coding :)
     *
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {
        if (head == null) return head;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }


    /**
     * Two Pointer
     * <p>
     * 和 前面的解决方案是一样的
     * We have two pointers that moves at different speed,
     * and the slow one will always point to the middle element when the fast one hit the end.
     * One small detail to notice is to check null when moving the fast pointer.
     *
     * @param head
     * @return
     */
    public ListNode middleNode2(ListNode head) {
        ListNode fast = new ListNode(0);
        fast.next = head;
        ListNode slow = fast;
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
        }
        return slow;
    }


    /**
     * Maybe it's a good idea...
     * <p>
     * Java O(n) time & O(1) space solution without using fast/slow pointer
     * <p>
     * https://leetcode.com/problems/middle-of-the-linked-list/discuss/155148/Java-O(n)-time-and-O(1)-space-solution-without-using-fastslow-pointer/161043
     *
     * @param head
     * @return
     */
    public ListNode middleNode3(ListNode head) {
        if (head == null) {
            return null;
        }
        int length = 0;

        /**
         * 这里设置current节点绝对不是吃饱撑得了。
         * 如果我们把头节点给破坏了(改变)。则我们将无法找到回去的路。
         */
        ListNode current = head;

        /**
         * 计算节点的长度
         */
        while (current != null) {
            length++;
            current = current.next;
        }

        length /= 2;


        /**
         * 到这里我们要去找中间节点，这时破坏head 是可以的，因为后面用不到了，所以可以
         *
         *
         * while(length >0){
         *     head = head.next;
         *     length --;
         * }
         *
         * return head;
         */
        current = head;
        while (length > 0) {
            current = current.next;
            length--;
        }

        return current;
    }


    /**
     * 好方法
     *
     * @param head
     * @return
     */
    public ListNode middleNode4(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode midNode = head;
        int length = 1;
        while (head.next != null) {
            head = head.next;
            length++;
            if (length % 2 == 0) {
                midNode = midNode.next;
            }
        }
        return midNode;
    }


    /**
     * 虽然Time:O(n) , Space:O(n)
     * 但是这个方法是：总是让人想笑还笑不出来。极致如此...
     * 当链表的长度太长，该方法不使用。
     *
     * @param head
     * @return
     */
    public ListNode middleNode5(ListNode head) {
        ListNode[] nodes = new ListNode[100];
        int t = 0;
        while (head.next != null) {
            nodes[t++] = head;
            head = head.next;
        }
        return nodes[t / 2];
    }

    /**
     * 既然可以使用数组，那就可以使用列表
     *
     * @param head
     * @return
     */
    public ListNode middleNode6(ListNode head) {
        List<ListNode> listNodes = new ArrayList<>();
        ListNode current = head;
        while (current.next != null) {
            listNodes.add(current);
            current = current.next;
        }
        listNodes.add(current);
        int mid = listNodes.size() % 2 == 1 ? (int) Math.floor(listNodes.size() / 2) : ((int) listNodes.size() / 2);
        return listNodes.get(mid);
    }


    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
