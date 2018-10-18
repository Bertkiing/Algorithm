package leecode.linkedlist;

/**
 * @题目： 237 Delete Node in a Linked List（删除链表中的一个节点）
 * @link https://leetcode.com/problems/delete-node-in-a-linked-list/description/
 * @author bertking
 * @date 2018/8/2
 */
public class Leecode237 {

    /**
     * In real work sometimes you need such smart workarounds to solve a seemingly impossible problem.
     * Real life is not just remembering some textbook algorithms.
     *
     * 通过让node.next覆盖其值，然后以此类推。该方法颠覆了我们教科书中找到前节点&后节点，然后直接指向的逻辑。
     * 另辟蹊径，十分巧妙。
     *
     * https://leetcode.com/problems/delete-node-in-a-linked-list/solution/
     *
     * //TODO 再次强调，思路很重要...
     *
     * 注意C语言要手动是否最后一个元素的内存...
     * @param node
     */
    public void deleteNode(ListNode node) {
        if(node.next == null) return;
        node.val = node.next.val;
        if(node.next.next != null){
            node.next = node.next.next;
        }else {
            node.next = null;
        }
    }




    static class ListNode{
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
