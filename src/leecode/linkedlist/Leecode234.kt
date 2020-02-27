package leecode.linkedlist

/**
 * @author bertking
 * @date 2020/1/16
 *
 * 234. 回文链表
 *
 * https://leetcode-cn.com/problems/palindrome-linked-list/
 */
fun main(args: Array<String>) {
    var head = ListNode(-1)
    var node1 = ListNode(-1)
    var node2 = ListNode(1)
//    var node3 = ListNode(1)
    head.next = node1
    node1.next = node2
//    node2.next = node3

    println("Result:${isPalindrome(head)}")

}


fun isPalindrome3(head: ListNode?): Boolean {
    var list = arrayListOf<Int>()
    var head = head
    while (head != null) {
        list.add(head.`val`)
        head = head.next
    }
    return list == list.reversed()
}


fun isPalindrome(head: ListNode?): Boolean {
    if (head == null || head.next == null) {
        return true
    }
    // 虚假节点
    val p = ListNode(-1)
    p.next = head

    var low: ListNode? = p
    var fast: ListNode? = p

    /**
     * 快慢指针不断迭代，找到中间节点
     */
    while (fast != null && fast.next != null) {
        low = low?.next
        fast = fast?.next?.next
    }

    var center: ListNode? = low?.next

    var pre: ListNode? = null

    /**
     * 反转链表的后半部分
     */
    while (center != null) {
        val tmp = center.next
        center?.next = pre
        pre = center
        center = tmp
    }


    /**
     * 将前半部分 & 后半部分 做对比
     */
    low?.next = null
    low = p.next
    while (pre != null) {
        if (low?.`val` != pre.`val`) {
            return false
        }
        low = low.next
        pre = pre.next
    }


    return true
}