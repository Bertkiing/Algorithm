package leecode.array

/**
 * @author bertking
 * @date 2020/1/9
 *
 * 数组基础
 * https://leetcode-cn.com/problems/contains-duplicate/
 */


fun main(args: Array<String>) {
    var array = intArrayOf(1, 2, 3,4,5,6,7,8,9)
    println("Result:${containsDuplicate3(array)}")
}

/**
 * 借用 Set
 * 当判断又重复的时候，直接返回true
 */
fun containsDuplicate(nums: IntArray): Boolean {
    val set = hashSetOf<Int>()
    for (n in nums) {
        if (set.contains(n)) {
            return true
        }
        set.add(n)
    }
    return nums.size != set.size
}

/**
 * 暴力破解的优化版本
 * 排序经常是很好的预处理方法。
 */
fun containsDuplicate1(nums: IntArray): Boolean {
    // 1. 先排序
    val sorted = nums.sorted()
    for (i in 0 until sorted.size - 1) {
        if (sorted[i] == sorted[i + 1]) return true
    }
    return false
}

/**
 * 暴力破解
 */
fun containsDuplicate2(nums: IntArray): Boolean {
    for (i in 0 until nums.size) {
        println("I = $i :")
        for (j in i+1 until nums.size) {
            println("   J = $j")
            if(nums[i] == nums[j]) return true
        }
    }

    return false
}

/**
 * 暴力破解2
 */
fun containsDuplicate3(nums: IntArray): Boolean {
    for (i in 0 until nums.size) {
        println("I = $i :")
        for (j in 0 until i) {
            println("   J = $j")
            if(nums[i] == nums[j]) return true
        }
    }
    return false
}


