package leecode

/**
 * @author bertking
 * @date 2019/8/20
 *
 * 题目:移除链表元素203
 *
 * 常规解法:
 * 1. 定义一个新的链表prev
 * 2. 从头开始遍历给定链表，
 *      2.1): 若该节点的值 != value ,则尾插到新链表(prev)；
 *      2.2): 若该节点的值 == value ,则将该节点的下一个节点尾插到新链表；
 * 3. 如果该链表为空,则直接返回空，这里还需要考虑一点：判断处理第一个节点
 *
 */
class Solution {
    /**
     * 递归的三大要素：
     * 1. 明确这个函数想要做什么
     * 2. 寻找递归结束条件
     * 3. 找出函数的等价关系式
     *
     * 此处思路:heap.value == value 就传递head.next ,相当于跳过这个节点
     */
    fun removeElements(head: ListNode?, value: Int): ListNode? {
        if (head == null) return head
        head.next = removeElements(head.next, value)
        return if (head.value == value) {
            head.next
        } else {
            head
        }
    }


    /**
     * 直接进行判断
     * 若等于 val ，则让 heap 指向它的下一个结点继续判断。
     */
    fun removeElements2(head: ListNode?, value: Int): ListNode? {
        var head = head
        var prev: ListNode? = null
        var cur = head
        while (cur != null) {
            if (cur.value == value) {
                if (cur == head) {
                    head = head.next
                } else {
                    prev?.next = cur.next
                }
            } else {
                prev = cur
            }
            cur = cur.next
        }
        return head
    }

    // 先不管第一个结点的数据，将结点处理完后判断第一个结点，若结点的值为 val ，返回该结点的下一个结点的引用
    fun removeElements3(head: ListNode?, value: Int): ListNode? {
        if (head == null) {
            return null
        }

        var prev: ListNode? = null
        var cur: ListNode? = head.next

        while (cur != null) {
            if (cur.value == value) {
                prev?.next = cur.next
            } else {
                prev = cur
            }
            cur = cur.next
        }

        if (head.value == value) {
            return head.next
        }
        return head
    }

    //3.强行给链表的第一个结点找一个前驱，最后返回前驱的下一个结点
    fun removeElements4(head: ListNode?, value: Int): ListNode? {
        val tempHead = ListNode(-1)
        tempHead.next = head
        var prev: ListNode? = tempHead
        var cur = head
        while (cur != null) {
            if (cur.value == value) {
                prev?.next = cur.next
            } else {
                prev = cur
            }
            cur = cur.next
        }
        return tempHead.next
    }


    /**
     * 打印链表
     */
    fun printList(head: ListNode?) {
        if (head == null) return
        var temp = head
        while (temp != null) {
            println(temp.value)
            temp = temp.next
        }
    }


    //3.强行给链表的第一个结点找一个前驱，最后返回前驱的下一个结点
    fun removeElements5(head: ListNode?, value: Int): ListNode? {
        val tempHead = ListNode(-1)
        tempHead.next = head
        var prev: ListNode? = tempHead
        var cur = head
        while (cur != null) {
            if (cur.value == value) {
                prev?.next = cur.next
            } else {
                prev = cur
            }
            cur = cur.next
        }
        return tempHead.next
    }


    // 这种写法直接忽略了head.value == value 的情况
    fun removeElements6(head: ListNode?, value: Int): ListNode? {
        var head = head
        var prev: ListNode? = null
        var cur = head
        while (cur != null) {
            if (cur.value == value) {
                if(cur == head){
                    head = head?.next
                }else{
                    prev?.next = cur.next
                }
            } else {
                prev = cur
            }
            cur = cur.next
        }
        return head
    }


}

class ListNode(value: Int) {
    var value: Int = 0
    var next: ListNode? = null

    init {
        this.value = value
    }
}


fun main(args: Array<String>) {
    val node = ListNode(2)
    val node2 = ListNode(2)
    val node3 = ListNode(2)
    val node4 = ListNode(3)

    node.next = node2
    node2.next = node3
    node3.next = node4

    val solution = Solution()
    val nodeRemoved = solution.removeElements(node, 1)
    solution.printList(nodeRemoved)
    println("方案二.....")
    solution.printList(solution.removeElements2(node, 2))
}