package leecode.linkedlist

import leecode.linkedlist.Leecode19.*

/**
 * @author bertking
 * @date 2019/12/31
 * 环形链表：https://leetcode-cn.com/problems/linked-list-cycle-ii/solution/shuang-zhi-zhen-qing-xi-ti-jie-zhen-zheng-cong-shu/
 *
 *
 * https://leetcode-cn.com/problems/linked-list-cycle-ii/solution/kuai-man-zhi-zhen-shu-xue-tui-dao-by-yuhhen/
 */

fun detectCycle(head: ListNode?): ListNode? {
    var fast = head
    var slow = head
    while (fast != null && fast.next != null) {
        // 两者第一次相遇，可以通过数学公式证明:两者再前进head ---> 相遇点的距离 a。就是
        fast = fast?.next?.next
        slow = slow?.next

        if (fast == slow) {
            // 让快指针从head处，与慢指针保持同步以1的速度前移，他们就会在环头再次相遇，这时候的节点即是所求节点
            fast = head
            while (slow != fast) {
                slow = slow?.next
                fast = fast?.next
            }
            return fast
        }
    }
    return null
}




