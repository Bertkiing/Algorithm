package leecode.linkedlist

/**
 * @author bertking
 * @date 2020/1/9
 */
object LinkedListUtil {

    fun printLists(head: ListNode?) {
        var head: ListNode? = head

        while (head != null) {
            println("value:${head.`val`}")
            head = head.next
        }
    }
}