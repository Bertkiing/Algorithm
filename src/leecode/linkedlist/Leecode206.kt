package leecode.linkedlist

/**
 * @author bertking
 * @date 2020/1/9
 *
 * 206 && 92
 *
 * https://leetcode-cn.com/problems/reverse-linked-list/
 *
 * 指针操作集锦：
 * https://github.com/Alex660/Algorithms-and-data-structures/blob/master/algo/%E9%93%BE%E8%A1%A8_linkedList.md
 *
 */
fun main(args: Array<String>) {
    var head = ListNode(1)
    var node1 = ListNode(2)
    var node2 = ListNode(3)
    var node3 = ListNode(4)
    head.next = node1
    node1.next = node2
    node2.next = node3

    LinkedListUtil.printLists(head)

    println("----------")

    LinkedListUtil.printLists(reverseList(head))
}

/**
 * 双指针做法
 */
fun reverseList(head: ListNode?): ListNode? {
    var cur: ListNode? = head ?: return null

    var pre: ListNode? = null
    var next: ListNode? = null

    while (cur != null) {
       // 1. 临时存储当前指针后续内容
      var  next = cur.next
        // 将当前节点调转枪头
        cur.next = pre

        /**
         * 前进
         */
        pre = cur
        cur = next

    }
    return pre
}


