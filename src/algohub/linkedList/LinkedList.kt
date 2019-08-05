package algohub.linkedList

import java.lang.IllegalArgumentException

/**
 * @author bertking
 * @date 2019/8/1
 */
class LinkedList<T>() {
    // head of list
    var head: Node<T>? = null

    /**
     * print elements of linked list starting from head
     */
    fun printList() {
        var temp = head
        while (temp != null) {
            println("${temp.data} ")
            temp = temp?.next
        }
    }

    /**
     * 添加节点的时机:
     * 1. 单链表的头部
     * 2. 给定节点之后
     * 3. 单链表的尾部
     */


    /**
     * 头插法
     * 保证 header永远指向第一个节点即可
     * Time complexity : O(1)
     *
     * 扩展：链表的尾插法其实就是一个「栈」
     */
    fun headInsert(element: T) {
        var newNode = Node(element)
        // 判断当前链表是否是第一次赋值
//        if(head == null){
//            head = newNode
//        }else{
//            // 3.Make next of new Node as head...（使新节点的next做为head）将新节点连接到链表的头部
//            newNode.next = head!!
//            // 4.Move the head to point to new Node（移动头指针指向新节点）Header永远存储的是第一个节点的地址
//            head = newNode
//        }

        // 3.Make next of new Node as head...（使新节点的next做为head）将新节点连接到链表的头部
        newNode.next = head
        // 4.Move the head to point to new Node（移动头指针指向新节点）Header永远存储的是第一个节点的地址
        head = newNode
    }

    /**
     * 在指定的节点后面添加Node
     */
    fun insertAfterGivenNode(pre: Node<T>?, data: T) {
        // 1. Check if the given Node is null
        if (pre == null) {
            throw IllegalArgumentException("Given previous node cannot be null...")
        }
        // 2. Allocate the Node &
        // 3. Put in the data
        val newNode = Node<T>(data)
        // 4. 使新节点的next指向 pre 的next
        newNode.next = pre.next
        // 5. 使pre.next 指向 新节点
        pre.next = newNode
    }


    /**
     * 尾插法
     * 保证 新节点永远指向null
     * Time complexity : O(n)
     *
     * 扩展:
     * 1. 可以通过额外的指针来存储尾节点，这样就可以O(1)
     * 2. 链表的尾插法其实就是一个「队列」
     */
    fun append(element: T) {
        var newNode = Node<T>(element)

        /**
         * 如果是空链表，使新节点做为head
         */
        if (head == null) {
            head = newNode
        } else {
            // 1.因为新节点将要做为最后一个节点，故其next为null
            newNode.next = null
            // 遍历链表直到找到最后一个节点
            var last = head
            while (last?.next != null) {
                last = last.next
            }
            // 最后一个节点指向新节点
            last?.next = newNode
        }
    }


    /******
     * *
     * *
     * * 删除节点操作
     *
     * 1. 删除指定元素
     * 2. 删除指定位置
     *
     * **********/

    /**
     * 删除指定元素
     * @param key 指定元素
     */
    fun deleteNode(key: T) {
        // Store head node
        var temp = head
        var prev: Node<T>? = null
        /**
         * 要找的节点刚好是head节点
         */
        if (temp != null && temp.data == key) {
            head = temp.next
        } else {

            // 查找要删除的节点并找到它的前一个节点
            while (temp != null && temp.data != key) {
                prev = temp
                temp = temp.next
            }

            if (temp == null) {
                // 没找到该节点
                return
            } else {
                // 从链表中断开此节点
                prev?.next = temp.next
            }
        }
    }

    /**
     * 删除指定位置
     * @param position 位置
     */
    fun deleteNodeByPosition(position: Int) {
        if (head == null) return
        // 存储head Store head node...
        var temp: Node<T>? = head
        // 删除head
        if (position == 0) {
            head = temp?.next
        } else {
            // 找到待删除节点的前一个节点 注意这里是i < position -1
            for (i in 0 until position - 1) {
                if (temp != null) {
                    temp = temp.next
                } else {
                    break
                }
            }
            // position 超过节点数量
            if (temp == null || temp.next == null) {
                return
            }
            // temp?.next 是将要被删除的节点， 存储将要被删除节点的下一个节点
            val next = temp?.next?.next
            // 从链表中断开待删除节点
            temp?.next = next
        }
    }

    /*******************
     * 获取链表的长度
     *
     * Iterative 迭代
     * Recursive 递归
     *
     * @href https://www.geeksforgeeks.org/find-length-of-a-linked-list-iterative-and-recursive/
     *
     ******************/
    fun getCountByIterative(): Int {
        var temp: Node<T>? = head
        var count = 0
        while (temp != null) {
            count++
            temp = temp.next
        }
        return count
    }

    fun getCountByRecursive(node: Node<T>?): Int {
        if (node == null) {
            return 0
        } else {
            return getCountByRecursive(node?.next) + 1
        }
    }


    fun swapNodes(x: T, y: T) {
        // Nothing to do if x & y are same
        if (x == y) return

        // Search for x (跟踪preX and curX)
        var preX: Node<T>? = null
        var curX = head

        while (curX != null && curX.data != x) {
            preX = curX
            curX = curX.next
        }


        // Search for y (跟踪preY and curY)
        var preY: Node<T>? = null
        var curY = head
        while (curY != null && curY.data != y) {
            preY = curY
            curY = curY.next
        }

        // X 和 Y 有一个不存在
        if (curX == null || curY == null) {
            return
        }

        if (preX != null) {
            preX.next = curY
        } else {
            head = curY
        }

        if (preY != null) {
            preY.next = curX
        } else {
            head = curX
        }

        // 交换 两个节点的尾部指针
        var temp = curX.next
        curX.next = curY.next
        curY.next = temp
    }

    fun swapNodes2(x: T, y: T) {
        var tempHead = head
        // 如果X & Y相等，无需交换
        if (x == y) {
            return
        }

        var xPointer: Node<T>? = null
        var yPointer: Node<T>? = null

        //遍历链表，并且存储x,y的指针
        while (tempHead?.next != null) {
            if (tempHead?.next?.data == x) {
                xPointer = tempHead
            }

            if (tempHead?.next?.data == y) {
                yPointer = tempHead
            }

            tempHead = tempHead.next
        }

        /**
         * if we have found both x and y in linked list
         * swap current pointer & next pointer
         */
        if (xPointer != null && yPointer != null){
            var temp = xPointer.next
            xPointer.next = yPointer.next
            yPointer.next = temp

            temp = xPointer.next?.next
            xPointer.next?.next = yPointer.next?.next
            yPointer.next?.next = temp
        }

    }


}


fun main(args: Array<String>) {
    val linkedList = LinkedList<Int>()
    val first = Node(1)
    var second = Node(2)
    var third = Node(3)

    linkedList.head = first
    first?.next = second
    second.next = third

    println("头插法")
    linkedList.headInsert(1)
    linkedList.headInsert(2)
    linkedList.headInsert(3)
    linkedList.headInsert(4)
    linkedList.printList()
    println("头节点的下一个节点后面插入一个元素...")
    linkedList.insertAfterGivenNode(linkedList.head?.next, 5)
    linkedList.printList()
    println("尾插法")
    linkedList.printList()
    println("删除元素...")
    linkedList.deleteNode(40)
    linkedList.printList()
    print("按位置删除元素...")
    linkedList.deleteNodeByPosition(1)
    linkedList.printList()

    println("链表长度...")
    println("Iterative:${linkedList.getCountByIterative()}")
    println("Recursive:${linkedList.getCountByRecursive(linkedList.head)}")

    println("========================")
    val linkedList2 = LinkedList<Int>()
    linkedList2.append(50)
    linkedList2.append(40)
    linkedList2.append(30)
    linkedList2.append(20)
    linkedList2.append(10)
    linkedList2.printList()
    println("交换10,50")
    linkedList2.swapNodes(10,50)
    linkedList2.printList()
    println("第二种方式交换10,50")
    linkedList2.swapNodes(10,50)
    linkedList2.printList()

}