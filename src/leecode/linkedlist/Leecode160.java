package leecode.linkedlist;

/**
 * @author bertking
 * @date 2020/1/17
 */
public class Leecode160 {

    public static void main(String[] args) {

    }

    /**
     * 设 相同部分为C
     *               |
     * 则 A1 + C + B1| +C
     * 后 B1 + C + A1| +C
     *               |
     *
     * 则 当ha == hb 时，即是相交的第一个节点
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if(headA == null||headB == null) {
            return null;
        }

        ListNode ha = headA;
        ListNode hb = headB;

        while (ha != hb){
            /**
             *  A1 + C + B1
             */
            ha = (ha == null) ? headB : ha.getNext();
            /**
             * B1 + C + A1
             */
            hb = (hb == null) ? headA : hb.getNext();
        }


        return ha;
    }

}
