package leecode.linkedlist

/**
 * @author bertking
 * @date 2019/12/31
 *
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/submissions/
 *
 *  推崇: 双指针解法
 */
class Leecode19 {
    class ListNode(var value: Int) {
        var next: ListNode? = null
    }


}

/**
 * 多种解法
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/solution/19-shan-chu-lian-biao-de-dao-shu-di-nge-jie-dian-8/
 */
fun removeNthFromEnd(head: Leecode19.ListNode?, n: Int): Leecode19.ListNode? {
    if (head == null) return null
    if (n <= 0) return null


    var first = head
    var last = head

    var i = n
    while (i > 0) {
        println("Now:${first?.value}+$i")
        first = first?.next
        i--
    }
    // first = 5
    while (first?.next != null) {
        first = first?.next
        last = last?.next
    }

    /**
     * 当删除头节点时需要判断
     */
    return if (first == null) {
        head.next
    } else {
        last?.next = last?.next?.next
        head
    }
    println("Last:${last?.value}")

}

/**
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/solution/hua-jie-suan-fa-19-shan-chu-lian-biao-de-dao-shu-d/
 */
fun removeNthFromEnd2(head: Leecode19.ListNode?, n: Int): Leecode19.ListNode? {
    /**
     * 新增一个前置节点，是为了方便处理删除头结点的情况
     */
    val fakeNode: Leecode19.ListNode? = Leecode19.ListNode(-1)
    fakeNode?.next = head
    if(head == null) return null

    var first = fakeNode
    var last = fakeNode

    var i = n
    while (n > 0) {
        first = first?.next
        i--
    }

    // first = 5
    while (first?.next != null) {
        first = first.next
        last = last?.next
    }

    last?.next = last?.next?.next

    return fakeNode?.next
}


fun printLinkedList(node: Leecode19.ListNode?) {
    var node = node
    while (node != null) {
        println(node.value)
        node = node.next
    }
}


fun main(args: Array<String>) {
    val node1 = Leecode19.ListNode(1)
    val node2 = Leecode19.ListNode(2)
    val node3 = Leecode19.ListNode(3)
    val node4 = Leecode19.ListNode(4)
    val node5 = Leecode19.ListNode(5)

    node1.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = node5



    printLinkedList(removeNthFromEnd2(null, 1))
}
