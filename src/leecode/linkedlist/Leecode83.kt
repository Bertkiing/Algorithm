package leecode.linkedlist

/**
 * @author bertking
 * @date 2020/1/8
 *
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/submissions/
 *
 * 解法:
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/solution/shan-chu-pai-xu-lian-biao-zhong-de-zhong-fu-yuan-2/
 */

fun main(args: Array<String>) {
    var head = ListNode(1)
    var node1 = ListNode(1)
    var node2 = ListNode(1)
//    var node3 = ListNode(3)
//    var node4 = ListNode(3)



    head.next = node1
    node1.next = node2
//    node2.next = node3
//    node3.next = node4

    printList(head)
    println("--------------")
    val deleteDuplicates = deleteDuplicates(head)
    printList(deleteDuplicates)
}

/**
 * 简单的问题，仅测试你操作列表的结点指针的能力。由于输入的列表已排序，
 * 因此我们可以通过将结点的值与它之后的结点进行比较来确定它是否为重复结点。
 * 如果它是重复的，我们更改当前结点的 next 指针，以便它跳过下一个结点并直接指向下一个结点之后的结点。
 */
fun deleteDuplicates(head: ListNode?): ListNode? {
    var head: ListNode? = head ?: return null
    var temp = head
    while (temp != null && temp.next != null) {
        if (temp.`val` == temp.next?.`val`) {
            temp.next = temp.next?.next
        }else{
            temp = temp.next
        }
    }
    return head
}

fun printList(head: ListNode?) {

    var head: ListNode? = head

    while (head != null) {
        println("value:${head.`val`}")
        head = head.next
    }
}