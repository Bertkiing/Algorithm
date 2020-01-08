package leecode

import java.util.ArrayList



/**
 * @author bertking
 * @date 2020/1/3
 *
 * https://leetcode-cn.com/problems/permutations/comments/
 */
fun main(args: Array<String>) {
    var nums = intArrayOf(1,2,3)
    println(permute(nums))
}

fun permute(nums: IntArray): List<List<Int>> {
    val res = ArrayList<List<Int>>()
    val visited = IntArray(nums.size)
    backtrack(res, nums, ArrayList(), visited)
    return res
}

fun backtrack(res: ArrayList<List<Int>>, nums: IntArray, tmp: ArrayList<Int>, visited: IntArray) {
    if (tmp.size == nums.size) {
        /**
         * 注意这里的区别
         */
//        res.add(tmp)
        res.add(ArrayList(tmp))
        return
    }

    for (i in 0 until nums.size) {
        if (visited[i] == 1) continue
        visited[i] = 1
        tmp.add(nums[i])
        backtrack(res, nums, tmp, visited)
        visited[i] = 0
        tmp.removeAt(tmp.lastIndex)
    }

}