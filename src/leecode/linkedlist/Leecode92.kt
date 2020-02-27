package leecode.linkedlist

/**
 * @author bertking
 * @date 2020/1/9
 *
 * https://leetcode-cn.com/problems/reverse-linked-list-ii/
 *
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 *
 * https://leetcode-cn.com/problems/reverse-linked-list-ii/solution/bu-bu-chai-jie-ru-he-di-gui-di-fan-zhuan-lian-biao/
 *
 */
fun main(args: Array<String>) {
    var head = ListNode(1)
    var node1 = ListNode(2)
    var node2 = ListNode(3)
    var node3 = ListNode(4)
    var node4 = ListNode(5)

    head.next = node1
    node1.next = node2
    node2.next = node3
    node3.next = node4

    LinkedListUtil.printLists(head)
    println("---------")
    LinkedListUtil.printLists(reverseBetween(head, 2, 4))
}

/**
 * 分段拼接
 *
 * https://leetcode-cn.com/problems/reverse-linked-list-ii/solution/ji-bai-liao-100de-javayong-hu-by-reedfan-6/#comment
 * 将 链表分为 3 个部分:
 * 1. m 之前的部分
 * 2. m..n 部分
 * 3. n 之后的部分
 */
fun reverseBetween(head: ListNode?, m: Int, n: Int): ListNode? {
    if (head == null) return null
    /**
     * 伪节点
     */
    var res = ListNode(0)
    res.next = head

    var cur: ListNode? = res
    /* 1. 找到需要反转的起点的前一个节点  */
    for (i in 1 until m) {
        cur = cur?.next
    }
    /* 2. 需要反转部分(n..m）的起点 */
    var start: ListNode? = cur?.next
    var next: ListNode? = null
    var pre: ListNode? = null
    for (i in m..n) {
        // 原地反转链表的逻辑
        next = start?.next
        start?.next = pre

        pre = start
        start = next
    }

    /* 3. 将反转的起点的next指向 n之后的部分*/
    cur?.next?.next = next

    /* 4. (n..m)的前一个节点的next节点 指向 (n..m)反转后的头节点*/
    cur?.next = pre


    return res.next
}


fun reverseBetween2(head: ListNode?, m: Int, n: Int): ListNode? {
    if (m == n) return head
    // 设置头节点，处理m=1的情况
    var fake = ListNode(0)

    var prev: ListNode? = fake
    var tail: ListNode? = null


    for (i in 1..n) {

        when {
            i < m -> {
                prev = prev?.next
            }
            i == m -> {
                tail = prev?.next
            }
            else -> {
                val temp = tail?.next
                tail?.next = tail?.next?.next
                temp?.next = prev?.next
                prev?.next = temp
            }
        }
    }
    return fake.next
}