package algohub.linkedList

/**
 * @author bertking
 * @date 2019/8/1
 *
 * Linked list  Node 单链表的节点
 */
class Node<T>(var data: T) {
    var next: Node<T>? = null
    override fun toString(): String {
        return "Node(data=$data, next=$next)"
    }
}
