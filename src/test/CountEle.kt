package test

/**
 * @author bertking
 * @date 2019/11/5
 */


fun main(args: Array<String>) {

    var data = intArrayOf(0)

    var dp = intArrayOf(0)

    var list = arrayListOf<Int>()

    var intArray = intArrayOf(0)

    println(lengthOfLIS(intArray))
}

fun lengthOfLIS(nums: IntArray): Int {
    if (nums.isEmpty()) return 0
    val dp = arrayListOf<Int>()
    dp.add(nums[0])
    for (n in nums) {
        if (dp.contains(n)) {
            continue
        }else if (nums.last() > dp.last()) {
            dp.add(nums.last())
        } else {
            var low = 0
            var high = dp.size - 1
            while (low < high) {
                val mid = (low + high) / 2
                if (dp[mid] > n) {
                    high = mid
                } else {
                    low = mid +1
                }
            }
            dp[high] = n
        }
    }
    return dp.size
}

