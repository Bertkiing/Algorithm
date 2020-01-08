package leecode

/**
 * @author bertking
 * @date 2020/1/7
 *
 * https://leetcode-cn.com/problems/maximum-subarray/
 */
fun main(args: Array<String>) {
    var array = intArrayOf(2, 3, -2, 4)
    println("Result:${maxProduct(array)}")
}

fun maxProduct(nums: IntArray): Int {
    var max = nums[0]
    for (i in 0 until nums.size) {
        var subResult = nums[0]
        for (j in i until nums.size) {
            subResult *= nums[j]

            if(subResult > max){
                max = subResult
            }
        }
        println("SubResult:$subResult")

    }
    return max
}