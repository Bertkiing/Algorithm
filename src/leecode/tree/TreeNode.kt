package leecode.tree

/**
 * @author bertking
 * @date 2020/1/17
 */
class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
    override fun toString(): String {
        return "TreeNode(`val`=$`val`, left=$left, right=$right)"
    }
}