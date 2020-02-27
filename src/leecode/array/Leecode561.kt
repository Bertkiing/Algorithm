package leecode.array

/**
 * @author bertking
 * @date 2020/1/10
 *
 * DONE
 *
 * https://leetcode-cn.com/problems/array-partition-i/submissions/
 */
fun main(args: Array<String>) {
    val array = intArrayOf(1, 2, 3, 2)
    println("Result:${arrayPairSum(array)}")
    //(1,2) (3,4),(5,6)

}

fun arrayPairSum(nums: IntArray): Int {
    return nums
            .sortedArray()
            .filterIndexed { index, _ ->
        index % 2 == 0
    }.sum()


}