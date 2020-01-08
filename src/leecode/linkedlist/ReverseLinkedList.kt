package leecode.linkedlist


/**
 * @author bertking
 * @date 2019/9/23
 *
 * 反转链表
 * https://www.cnblogs.com/edisonchou/p/4769537.html
 *
 */
class ReverseLinkedList {

    fun reverseList(head: Node?): Node? {
        if (head == null) return head
        var reversedHead: Node? = null
        // 指针1：当前节点
        var currentNode: Node? = head
        // 指针2:当前节点的前一个节点
        var prevNode: Node? = null

        while (currentNode != null) {
            // 指针3:当前节点的后一个节点
            val nextNode = currentNode.next


            // 到达链表尾部
            if (nextNode == null) {
                reversedHead = currentNode
            }

            // 将当前节点的后一个节点指向前一个节点
            currentNode.next = prevNode
            // 将前一个节点指向当前节点
            prevNode = currentNode
            // 将当前节点指向后一个节点
            currentNode = nextNode

        }
        return reversedHead
    }


}

class Node constructor(var value: Int) {
    var next: Node? = null

    constructor(value: Int, next: Node?) : this(value) {
        this.next = next
    }

}

fun main(args: Array<String>) {
    var head = Node(0)
    var node1 = Node(1)
    var node2 = Node(2)
    var node3 = Node(3)


    head.next = node1
    node1.next = node2
    node2.next = node3


    val list = ReverseLinkedList()
    printList(head)
    println("------反转后-----")
    val head1 = list.reverseList(head)
    printList(head1)
}

fun printList(head: Node?) {
    var tempHead = head
    while (tempHead != null) {
        println(tempHead.value)
        tempHead = tempHead.next
    }
}
