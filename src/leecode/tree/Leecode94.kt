package leecode.tree

import java.util.*
import kotlin.collections.ArrayList

/**
 * @author bertking
 * @date 2020/1/17
 *          1
 *     2         3
 *
 *  4    5    6      7
 *
 * 树的遍历的难点：--遍历到子节点的时候怎样重新返回到父节点
 *
 * 在Morris遍历中利用叶子节点中的左右空指针指向中序遍历下的前驱节点或后继节点。
 *
 */


fun main(args: Array<String>) {
    val root = TreeNode(1)

    val node1 = TreeNode(2)
    val node2 = TreeNode(3)

    root.left = node1
    root.right = node2


    val node3 = TreeNode(4)
    val node4 = TreeNode(5)


    node1.left = node3
    node1.right = node4


    val node5 = TreeNode(6)
    val node6 = TreeNode(7)


    node2.left = node5
    node2.right = node6


    Leecode94().inorderTraversal(root)


}

class Leecode94 {


    /**
     * n为树的节点数。空间复杂度都是O(h)，其中h为树的高度
     *
     * 由于我们每一次遍历肯定要访问到每一个节点，对于时间复杂度而言，我们已经没有了优化的空间。
     * 那么，对于空间复杂度，我们能否做进一步的优化呢？这就是Morris遍历所要做的事。
     *
     * Morris遍历：优化时间复杂度为O(1)
     *
     * https://www.cnblogs.com/AnnieKim/archive/2013/06/15/morristraversal.html
     */
    fun inorderTraversal(root: TreeNode?): List<Int> {
        val list = arrayListOf<Int>()
        if(root == null){
            return list
        }

        var cur = root
        while (cur != null){
            /**
             * 左子树为空的情况
             */
            if(cur.left == null){
                list.add(cur.`val`)
                cur = cur.right
            }else{
                var prev = cur.left
                println("Cur:${cur.`val`},prev:${prev?.`val`}")
                while (prev?.right != null && prev.right != cur){
                    prev = prev.right
                }
                println("最终的prev:${prev?.`val`}")

                if(prev?.right == null){
                    prev?.right = cur
                    cur = cur.left
                }else{
                    prev.right = null
                    list.add(cur.`val`)
                    cur = cur.right
                }
            }
        }
        println(list)
        return list
    }



    fun inorderTraversal3(root: TreeNode?): List<Int> {
        val list = arrayListOf<Int>()
        val stack = Stack<TreeNode?>()
        var root: TreeNode? = root
        while (root != null || stack.isNotEmpty()) {
            while (root != null) {
                stack.push(root)
                root = root?.left
            }

            root = stack.pop()
            list.add(root!!.`val`)
            root = root.right
        }
        return list
    }

    fun inorderTraversal1(root: TreeNode?): List<Int> {
        val list = arrayListOf<Int>()
        val stack = Stack<TreeNode?>()
        var current: TreeNode? = root
        while (current != null || !stack.isEmpty()) {
            if (current != null) {
                stack.push(current)
                current = current.left
            } else {
                current = stack.pop()
                list.add(current!!.`val`)
                current = current.right
            }
        }
        return list
    }


    /**
     * 递归
     */
    fun inorderTraversal2(root: TreeNode?): List<Int> {
        if (root == null) {
            return emptyList()
        }
        var list = arrayListOf<Int>()
        helper(root, list)
        return list.toList()
    }

    fun helper(root: TreeNode?, list: ArrayList<Int>) {
        if (root != null) {
            helper(root?.left, list)
            list.add(root!!.`val`)
            helper(root?.right, list)
        }
    }
}

