package algohub.binaryTree

/**
 * @author bertking
 * @date 2019/8/5
 */
fun main(args: Array<String>) {
    var binaryTree: BinaryTree<Int>? = BinaryTree<Int>()

    /****
     * 构建二叉树
     *         1
     *      /    \
     *     2      3
     *    / \    /  \
     *   4   5  6    7
     */
    binaryTree?.root = Node(1)

    binaryTree?.root?.left = Node(2)
    binaryTree?.root?.right = Node(3)

    binaryTree?.root?.right?.left = Node(6)
    binaryTree?.root?.right?.right = Node(7)


    binaryTree?.root?.left?.left = Node(4)
    binaryTree?.root?.left?.right = Node(5)


    println("中序遍历:")
    binaryTree?.printInOrder(binaryTree?.root)
    println()
    println("前序遍历:")
    binaryTree?.printPreOrder(binaryTree?.root)
    println()

    println("后序遍历:")
    binaryTree?.printPostOrder(binaryTree?.root)
    println()

    println("中序遍历2:")
    binaryTree?.printInOrder2(binaryTree?.root)
    println()

}