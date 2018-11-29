package AD

import java.util.*
import java.util.LinkedList
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

/**
 * @author bertking
 * @date 2018/11/8
 *
 * 参考文章：https://blog.csdn.net/ryjflyshy/article/details/78250348
 *
 * https://blog.csdn.net/zhangxiangdavaid/article/details/37115355
 *
 *
 * https://blog.csdn.net/qq_37597859/article/details/79849668
 *
 *
 */
class Node(value: Int, lChild: Node?, rChild: Node?) {
    var value: Int = value
    var lChild: Node? = lChild
    var rChild: Node? = rChild
}


class BinaryTreeTraversal {

    /**
     * 递归先序遍历
     * @param root 根节点
     */
    fun preOrderRec(root: Node?) {
        if (root != null) {
            print(root.value.toString() + " ,")
            preOrderRec(root.lChild)
            preOrderRec(root.rChild)
        }
    }


    /**
     * 递归中序遍历
     * @param root 根节点
     */
    fun inOrderRec(root: Node?) {
        if (root != null) {
            inOrderRec(root.lChild)
            print(root.value.toString() + " ,")
            inOrderRec(root.rChild)
        }
    }

    /**
     * 递归后序遍历
     * @param root 根节点
     */
    fun postOrderRec(root: Node?) {
        if (root != null) {
            postOrderRec(root?.lChild)
            postOrderRec(root?.rChild)
            print(root?.value.toString() + " ,")
        }
    }

    /****************非递归实现********************/

    /**
     * @root 树的根节点
     * 利用【栈】实现非递归【先序遍历】二叉树
     *
     * 该实现方式具有可扩展性。
     * 思路：模拟递归的过程，将左子树不断压入栈，直到null为止，然后处理栈顶节点的右子树
     */
    fun preOrderStack(root: Node?) {
        var root: Node? = root ?: return // 遍历指针
        var stack = Stack<Node>()
        while (root != null || stack.isNotEmpty()) {
            while (root != null) {
                print(root.value.toString() + " ,")
                stack.push(root) // 先访问再入栈
                root = root.lChild
            }
            root = stack.pop()
            root = root.rChild
        }

    }

    /**
     *
     */
    fun preOrderStack1(root: Node?) {
        var root: Node? = root ?: return
        var stack = Stack<Node>()
        stack.push(root)
        while (stack.isNotEmpty()) {
            root = stack.pop()
            if (root != null) {
                print(root.value.toString() + " ,")
                stack.push(root.rChild)
                stack.push(root.lChild)
            }
        }

    }

    /**
     * 思路：
     *
     * 0. 判断根节点是否为空，将根节点入栈
     * 1. 若栈为空，退出循环
     * 2. 将栈顶元素弹出,访问弹出的节点
     * 3. 若弹出的右子树不为空则将其右子树入栈
     * 4. 若弹出的左子树不为空则将其左子树入栈
     * 5. 返回 1
     *
     *
     * 前序遍历 --- 》根左右
     *
     * 栈的顺序 --- 》右左根
     *
     */
    fun preOrderStack2(root: Node?) {
        var root: Node? = root
        var stack = Stack<Node>()
        if (root != null) {
            stack.push(root)
            while (stack.isNotEmpty()) {
                root = stack.pop()
                print(root.value.toString() + " ,")

                if (root.rChild != null) {
                    stack.push(root.rChild)
                }

                if (root.lChild != null) {
                    stack.push(root.lChild)
                }
            }
        }
    }


    /**
     * 利用【栈】实现非递归【中序遍历】二叉树
     *
     * 思路&先序遍历一样，只是处理节点的时机不同
     *
     *
     * 理解1：
     * 中序遍历 --》 先访问左子树，根节点，最后遍历右子树
     * 所以需要先把根节点入栈，然后一直把左子树入栈，直到左子树为null为止。
     *
     * 栈顶节点就是我们需要访问的节点，取栈顶节点进行访问。
     * 然后需要判断该节点的是否有右子树，如果没有右子树则取栈顶元素，否则，将该节点指向其右子树。
     *
     *
     * 理解2：
     * 中序遍历的递归定义：先左子树，根节点，右子树
     *
     * 非递归代码：代码跟着我们思维走
     * 我们的思维是什么？思维就是中序遍历的路径。
     * 假设我们看到二叉树。
     * 首先我们 会立刻找到左子树的最下边的节点
     *
     *
     *
     */
    fun inOrderStack(root: Node?) {
        var root: Node? = root ?: return
        var stack = Stack<Node>()
        while (root != null || stack.isNotEmpty()) {
            while (root != null) {
                stack.push(root)
                root = root.lChild
            }
            root = stack.pop()
            print(root.value.toString() + " ,")
            root = root.rChild

        }
    }

    fun inOrderStack1(root: Node?) {
        var root: Node? = root ?: return
        var stack = Stack<Node>()
        while (stack.isNotEmpty() || root != null) {

            /**
             * 一直遍历到左子树最下边
             */
            while (root != null) {
                stack.push(root)
                root = root.lChild
            }

            if (stack.isNotEmpty()) {
                root = stack.pop()
                print(root.value.toString() + " ,")
                root = root.rChild
            }

        }
    }


    /**
     * 非递归实现【后序遍历】
     *
     * 后序遍历的难点在于:
     *   需要判断上次访问的节点是位于左子树，还是右子树
     *
     *   若是位于左子树，则需要跳过根节点，先进入右子树，再回头访问根节点
     *   若是位于右子树，则直接访问根节点
     *参考自：http://www.voidcn.com/article/p-warebwrv-bcq.html
     */
    fun postOrderStack1(root: Node?) {
        var root: Node? = root ?: return

        var stack = Stack<Node>()

        /**
         * 当前访问的节点
         */
        var curNode: Node? = root
        /**
         * 上次访问的节点
         */
        var lastVisitNode: Node? = null


        /**
         * 把curNode移到左子树的最下边
         */
        while (curNode != null) {
            stack.push(curNode)
            curNode = curNode.lChild
        }


        while (stack.isNotEmpty()) {
            curNode = stack.pop()

            /**
             * 重点：根节点被访问的前提，无右子树或者右子树已经被访问过
             */
            if (curNode?.rChild != null && curNode.rChild != lastVisitNode) {
                /**
                 * 根节点再次入栈
                 */
                stack.push(curNode)

                /**
                 * 进入右子树(此时右子树必不为空)
                 */
                curNode = curNode.rChild

                while (curNode != null) {
                    /**
                     * 再走到右子树的最左边
                     */
                    stack.push(curNode)
                    curNode = curNode.lChild
                }
            } else {
                /**
                 * 此时可以访问
                 */
                print(curNode.value.toString() + " ,")
                /**
                 * 修改最近被访问的节点
                 */
                lastVisitNode = curNode
            }

        }


    }


    /**
     * 逆向思维
     *
     * 后序遍历：左右根
     *
     * 我们可以理解为:根右左，然后将其反转即可...
     *
     * 参考：https://blog.csdn.net/GSCurry/article/details/77993483
     *
     */
    fun postOrder(root: Node?): ArrayList<Int> {
        var arrayList = arrayListOf<Int>()
        var root: Node? = root
        if (root != null) {
            var stack = Stack<Node>()
            stack.push(root)
            while (stack.isNotEmpty()) {
                val node = stack.pop()
                arrayList.add(node.value)


                /**
                 * 这里必须先让左子树入栈
                 */
                if (node.lChild != null) {
                    stack.push(node.lChild)
                }

                if (node.rChild != null) {
                    stack.push(node.rChild)
                }

            }

        }
        /**
         * 反转
         */
        arrayList.reverse()
        return arrayList
    }


    /**
     * 后序遍历不同于先序&中序，
     * 因为它先要处理完左右子树，然后再处理根节点(回溯)
     * 故需要一个记录哪些节点已经被访问的结构(可以在树结构里面加入一个标记)
     * 此处使用map实现
     *
     */
    fun postOrderStack(root: Node?) {
        var root: Node? = root ?: return

        var stack = Stack<Node>()

        var map = HashMap<Node, Boolean>()
        stack.push(root)

        while (stack.isNotEmpty()) {
            var peek = stack.peek()
            if (root?.lChild != null && !map.containsKey(peek.lChild)) {
                peek = peek.lChild
                while (peek != null) {
                    if (map.containsKey(peek)) {
                        break
                    } else {
                        stack.push(peek)
                        peek = peek.lChild;
                    }
                }
                continue
            }

            if (peek.rChild != null && !map.containsKey(peek.rChild!!)) {
                stack.push(peek.rChild)
                continue
            }

            var pop = stack.pop()
            map[pop] = true
            println(pop.value)
        }
    }

    /**
     * 【层次遍历】二叉树
     * 实现：借助队列实现，先将根节点入队列，只要队列不为空，然后出队列并访问
     * 接着访问该节点的左右子树依次入队列
     */
    fun levelTravel(root: Node?) {
        var root: Node? = root ?: return
        var queue = LinkedList<Node>()
        queue.add(root!!)

        while (queue.isNotEmpty()) {
            /**
             * poll()方法返回列表的头元素(第一个元素)后将其移除
             */
            val poll = queue.poll()
            print(poll.value.toString() + " ,")
            if (poll.lChild != null) {
                queue.add(poll.lChild!!)
            }

            if (poll.rChild != null) {
                queue.add(poll.rChild!!)
            }
        }


    }


}


fun main(args: Array<String>) {
    var six = Node(6, null, null)
    var five = Node(5, null, null)
    var four = Node(4, null, null)
    var three = Node(3, six, null)
    var two = Node(2, four, five)
    var one = Node(1, two, three)


    println("<------NLR先序遍历---递归----->")
    val traversal = BinaryTreeTraversal()
    traversal.preOrderRec(one)

    println()
    println("<------NLR先序遍历---非递归----->")
    traversal.preOrderStack(one)
    println()
    println("<------NLR先序遍历---非递归1----->")
    traversal.preOrderStack1(one)
    println()
    println("<------NLR先序遍历---非递归2----->")
    traversal.preOrderStack2(one)


    println()
    println("""

                *****中序遍历*****


    """.trimIndent())

    println("<------LNR中序遍历-----递归------>")
    traversal.inOrderRec(one)


    println()
    println("<------LNR中序遍历-----非递归------>")
    traversal.inOrderStack(one)

    println()
    println("<------LNR中序遍历-----非递归1------>")
    traversal.inOrderStack1(one)



    println()
    println("""

                *****后序遍历*****


    """.trimIndent())
    println("<------LRN后序遍历-----递归------>")
    traversal.postOrderRec(one)

    println()
    println("<------LRN后序遍历-----非递归------>")
    traversal.postOrderStack1(one)
    println()
    println("<------LRN后序遍历-----非递归1(逆向思维)------>")
    println(traversal.postOrder(one))



    println()
    println("""

                *****层次遍历*****


    """.trimIndent())
    println("<------层次遍历-----队列------>")
    traversal.levelTravel(one)



}