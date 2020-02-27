package leecode.array

/**
 * @author bertking
 * @date 2020/1/6
 *
 *
 *
 * 求解最大子数组问题用Kadane's algorithm。
 * 卡登算法的思想是，给定一个数组A，假如我们已经知道了以数组第i个位置结尾的最大子数组为𝐵𝑖，
 * 那么在第i+1个位置结尾的最大子数组要么包含𝐵𝑖,要么不包含𝐵𝑖，
 * 如果将𝐵看作是动态规划当中的状态，那么状态转移方程是：𝐵𝑖+1=𝑚𝑎𝑥(𝐴𝑖,𝐴𝑖+𝐵𝑖)
 *
 * 清华2018原题
 *
 * https://leetcode-cn.com/problems/maximum-subarray/comments/
 *
 * https://zh.wikipedia.org/wiki/%E6%9C%80%E5%A4%A7%E5%AD%90%E6%95%B0%E5%88%97%E9%97%AE%E9%A2%98
 */

fun main(args: Array<String>) {
    var array = intArrayOf(-2)
    var array1 = intArrayOf(1)
    println("Result:${maxSubArray6(array)}")
}


fun maxSubArray(nums: IntArray): Int {
    var sumList = arrayListOf<Int>()
    var maxSum = 0
    for (i in 0 until nums.size) {
        var sum = 0
        for (j in i until nums.size) {
            sum += nums[j]
            if (sum > maxSum) {
                maxSum = sum
            }
//            println("I = $i,J = $j,sum = $sum")
        }
        sumList.add(maxSum)
//        println("Index:$i = $sum")
    }
    println(sumList)
    return sumList.sortedByDescending { it }.first()
}


/**
 * 通过遍历计算所有的和，求最大值
 * 暴力的滑动窗口(时间复杂度o(n^2))
 */
fun maxSubArray2(nums: IntArray): Int {
    if (nums.isEmpty()) return 0
    var maxSum = nums.first()
    for (i in 0 until nums.size) {
        var sum = 0
        for (j in i until nums.size) {
            sum += nums[j]
            if (sum > maxSum) {
                maxSum = sum
            }
            println("I = $i,J = $j,sum = $sum")
        }
        println("Index:$i = $maxSum")
    }
    return maxSum
}


/**
 * 扫描法，时间复杂度是O(n)
 *
 * 核心思想是，当加上一个正数时，和会增加；当加上一个负数时，和会减少。
 * 所以在数组遍历的过程中，一边累加数组元素，一边比较累加结果和0的关系，
 * 如果累加结果是负数，则应当把累加结果抛弃，并将累加结果清零。
 */
fun maxSubArray3(nums: IntArray): Int {
    var maxSum = nums[0]
    var sum = 0
    for (num in nums) {
        if (sum > 0) {
            sum += num
        } else {
            sum = num
        }
        maxSum = Math.max(maxSum, sum)
    }
    return maxSum
}

/**
 * 贪心算法:每一步都选择最佳方案，到最后就是全局最优的方案
 * 其实也就是动态规划的解决
 *
 * https://leetcode-cn.com/problems/maximum-subarray/solution/zui-da-zi-xu-he-by-leetcode/
 */
fun maxSubArray4(nums: IntArray): Int {
    var curSum = nums[0]
    var maxSum = nums[0]

    for (i in 1 until nums.size) {
        println("nums[$i] = ${nums[i]},curSum = $curSum,maxSum = $maxSum")
        /**
         * 当前元素位置的最大和
         */
        curSum = Math.max(nums[i], curSum + nums[i])
        /**
         * 迄今为止的最大和
         */
        maxSum = Math.max(maxSum, curSum)
    }
    return maxSum
}

/**
 * 动态规划(DP)
 *
 * 状态转移方程要参考：
 *  Kadane算法(卡登算法):
 *      给定一个数组A，假如我们已经知道了以数组第i个位置结尾的最大子数组为𝐵𝑖，那么在第i+1个位置结尾的最大子数组要么包含𝐵𝑖,要么不包含𝐵𝑖，
 *
 * 如果将𝐵看作是动态规划当中的状态，那么状态转移方程是：𝐵𝑖+1=𝑚𝑎𝑥(𝐴𝑖,𝐴𝑖+𝐵𝑖)
 * https://leetcode-cn.com/problems/maximum-subarray/solution/xiang-xi-jie-du-dong-tai-gui-hua-de-shi-xian-yi-li/
 */
fun maxSubArray5(nums: IntArray): Int {
    var maxSum = nums[0]
    for (i in 1 until nums.size) {
        nums[i] = Math.max(nums[i], nums[i] + nums[i - 1])
        maxSum = Math.max(maxSum, nums[i])
    }
    return maxSum
}


fun maxSubArray6(nums: IntArray): Int {
    var max_so_far = 0
    var max_ending_here = 0

    for (n in nums){
        max_ending_here += n

        if(max_ending_here < 0) {
            max_ending_here = 0
        }

        if(max_so_far < max_ending_here){
            max_so_far = max_ending_here
        }
    }

    return max_so_far
}