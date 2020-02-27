package leecode.array

/**
 * @author bertking
 * @date 2020/1/10
 *
 * 题目不够好
 *
 *
 * https://leetcode-cn.com/problems/contains-duplicate-ii/
 */

fun main(args: Array<String>) {
    var array = intArrayOf(1, 2, 3, 1, 2, 3)
    println("Result:${containsNearbyDuplicate(array, 2)}")
}


fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
    val hashMap = HashMap<Int, Int>()

    for (i in 0 until nums.size) {
        if (hashMap.containsKey(nums[i])) {
            val i1 = hashMap[nums[i]] ?: 0
            if (Math.abs(i1 - i) <= k) {
                return true
            }
        }
        hashMap[nums[i]] = i
    }

    return false
}