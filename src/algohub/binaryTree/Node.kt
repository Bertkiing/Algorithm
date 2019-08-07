package algohub.binaryTree

/**
 * @author bertking
 * @date 2019/8/5
 * 二叉树的Node
 */
class Node<T>(var key: T) {
    var left: Node<T>? = null
    var right: Node<T>? = null
    override fun toString(): String {
        return "Node(key=$key)"
    }
}