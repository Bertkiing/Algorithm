package leecode

/**
 * @author bertking
 * @date 2020/1/8
 *
 * https://leetcode-cn.com/problems/max-consecutive-ones/
 */
fun main(args: Array<String>) {
    var array = intArrayOf(1, 0, 1, 1, 1, 1)
    println("Result:${findMaxConsecutiveOnes1(array)}")
}

/**
 * 最优解法
 */
fun findMaxConsecutiveOnes(nums: IntArray): Int {
    var result = 0
    var max = 0
    for (num in nums) {
        if (num == 1) {
            result++
        } else {
            max = Math.max(result, max)
            result = 0
        }
    }
    return max
}

/**
 * 借用split方法
 */
fun findMaxConsecutiveOnes1(nums: IntArray): Int {
    var string = ""

    for (num in nums) {
        string += num
    }

    val split = string.split('0')

    return split.max()?.length ?: 0
}


