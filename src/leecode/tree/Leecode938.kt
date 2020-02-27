package leecode.tree


/**
 * @author bertking
 * @date 2020/1/17
 */
fun main(args: Array<String>) {

}


fun rangeSumBST(root: TreeNode?, L: Int, R: Int): Int {
    if (root == null) return 0
    if (root.`val` in L..R) {
        return root.`val` + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R)
    } else if (root.`val` < L) {
        return rangeSumBST(root.right, L, R)
    } else {
        return rangeSumBST(root.left, L, R)
    }
}



fun inorderTraversal(root: TreeNode?): List<Int> {
    if(root == null){return emptyList()}
    var list = arrayListOf<Int>()
    helper(root,list)
    return list.toList()
}

fun helper(root:TreeNode?,list:ArrayList<Int>){
    if(root != null){
        helper(root.left,list)
        list.add(root.`val`)
        helper(root.right,list)
    }

}
