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

    /**
     * @link https://www.geeksforgeeks.org/level-order-tree-traversal/
     * 层次遍历(利用Queue)
     * Time Complexity : O(n)
     * */
    fun printLevelOrder(node: Node<T>?) {
        val queue = LinkedList<Node<T>?>()
        queue.add(node)
        while (queue.isNotEmpty()) {
            val temp = queue.poll()
            print("${temp?.key} ")

            // Enqueue left child
            if (temp?.left != null) {
                queue.add(temp.left)
            }
            // Enqueue right child
            if (temp?.right != null) {
                queue.add(temp.right)
            }
            println("The Queue size:$queue")
        }
    }

    /* 获取树的高度 */
    fun getHeightOfTree(root: Node<T>?): Int {
        if (root == null) {
            return 0
        } else {
            // 计算每个subtree 的高度
            val leftHeight = getHeightOfTree(root?.left)
            val rightHeight = getHeightOfTree(root?.right)

            return if (leftHeight > rightHeight) leftHeight + 1 else rightHeight + 1
        }
    }

    /* Print nodes at the given level */
    fun printGivenLevel(root: Node<T>?, level: Int) {
        if (root == null) return
        if (level == 1) {
            print("${root?.key} ")
        } else {
            printGivenLevel(root.left, level - 1)
            printGivenLevel(root.right, level - 1)
        }
    }

    /* 层次遍历 */
    fun printLevelOrder2() {
        val height = getHeightOfTree(root)
        for (i in 1..height) {
            printGivenLevel(root, i)
        }
    }


  


}

