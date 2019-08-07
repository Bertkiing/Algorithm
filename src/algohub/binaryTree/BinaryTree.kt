package algohub.binaryTree

import java.util.*

/**
 * @author bertking
 * @date 2019/8/5
 */
class BinaryTree<T>() {
    var root: Node<T>? = null

    /************
     * 二叉树遍历
     ***********/

    /***************START*******递归遍历(traverse tree by recursion)**************************************/
    // 中序遍历(left , root , right)
    fun printInOrder(node: Node<T>?) {
        if (node == null) return
        printInOrder(node.left)
        print("${node.key} ")
        printInOrder(node.right)
    }

    // 前序遍历(root,left,right)
    fun printPreOrder(node: Node<T>?) {
        if (node == null) return
        print("${node.key} ")
        printPreOrder(node?.left)
        printPreOrder(node?.right)
    }

    // 后序遍历(left,right,root)
    fun printPostOrder(node: Node<T>?) {
        if (node == null) return
        printPostOrder(node?.left)
        printPostOrder(node?.right)
        print("${node.key} ")
    }


    fun printLevelOrder(node: Node<T>?){
        val queue = LinkedList<Node<T>?>()
        queue.add(node)
    }

    /***************END*******递归遍历(traverse tree by recursion)**************************************/

    /**
     * 非递归形式的中序遍历
     * https://blog.csdn.net/zhangxiangDavaid/article/details/37115355
     */
    fun printInOrder2(node: Node<T>?) {
        if (node == null) return

        val stack = Stack<Node<T>?>()
        var temp = node

        while (temp != null || stack.isNotEmpty()) {
            //一直遍历左子树，直到左子树为null为止
            while (temp != null) {
                stack.push(temp)
                temp = temp?.left
            }

            temp = stack.pop()
            print("${temp?.key} ")
            temp = temp?.right
        }
    }


}

