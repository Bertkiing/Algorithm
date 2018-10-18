package leecode.linkedlist;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author bertking
 * @题目 234. Palindrome Linked List(节点是不是回文结构)
 * @link https://leetcode.com/problems/palindrome-linked-list/description/
 * @date 2018/8/3
 */
public class Leecode234 {


    /**
     * 看到回文结构，我这次机智地将其转化为"数组"来解决...
     * 😂，思路很重要啊... 自己想出来的，进步了啊...
     *
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if (head.next == null) return true;

        List<ListNode> nodes = new ArrayList<>();
        while (head != null) {
            nodes.add(head);
            head = head.next;
        }

        /**
         * 然后使用二分法来判断是否相等
         */
        int first = 0;
        int last = nodes.size() - 1;

        while (first < last) {
            if (nodes.get(first).val == nodes.get(last).val) {
                if (nodes.size() == 0 || nodes.size() == 1) {
                    break;
                }
            } else {
                return false;
            }
            first++;
            last--;
        }
        return true;
    }


    /**
     * 快慢指针解决该问题（首先想到，但是后来没想到，实在不应该啊...）
     * <p>
     * 参考：https://leetcode.com/problems/palindrome-linked-list/discuss/64501/Java-easy-to-understand/161407
     *
     * @param head
     * @return
     */
    public boolean isPalindrome2(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        if (fast != null) { // odd nodes:let right half smaller
            slow = slow.next;
        }

        slow = reverse(slow);
        fast = head;

        while (slow != null) {
            if (fast.val != slow.val) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }

    /**
     * Solution with even String reversal.(偶串反转解)
     * 暂时理解不了，先记录一下
     *
     * @param head
     * @return
     */
    public boolean isPalindrome3(ListNode head) {
        return head == null || recurse(head, head) != null;
    }

    /**
     * recurse(递归)
     *
     * @param node
     * @param head
     * @return
     */
    private ListNode recurse(ListNode node, ListNode head) {
        if (node == null) return head;
        ListNode res = recurse(node.next, head);
        if (res == null) {
            return res;
        } else if (res.val == node.val) {
            return (res.next == null ? res : res.next);
        } else {
            return null;
        }
    }


    /**
     * 借助于栈达到从尾端访问的目的，佩服... BUT Space O(n).... that's too bad....
     * 参考自：https://leetcode.com/problems/palindrome-linked-list/discuss/148220/Javathe-clear-method-with-stack
     */
    public boolean isPalindrome4(ListNode head) {
        ListNode temp = head;
        Stack stack = new Stack();

        /**
         * 该操作实质上是将temp这条链给存入到Stack中
         */
        while (temp != null) {
            stack.push(temp.val);
            temp = temp.next;
        }

        /**
         * 该操作依据Stack的先进后出的特性，从而达到temp的链从尾端 和 head链从首端以此进行比较。如果相同那自然就是回文，反之...
         */
        while (head != null) {
            if (head.val != (int) stack.pop()) {
                return false;
            }
            head = head.next;
        }
        return true;
    }


    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);

        listNode1.next = listNode2;
        listNode2.next = listNode3;

        Leecode234 leecode234 = new Leecode234();

        System.out.println(leecode234.isPalindrome(listNode1));
    }


    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
