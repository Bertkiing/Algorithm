package leecode.array

/**
 * @author bertking
 * @date 2020/1/13
 *
 * https://leetcode-cn.com/problems/remove-element/
 *
 * 双指针解法
 * 两种思路:
 * 1. 拷贝覆盖
 * 2. 交换删除
 *
 */
fun main(args: Array<String>) {
    val nums = intArrayOf(0, 1, 2, 2, 3, 0, 4, 2)
    println("Result:${removeElement(nums, 2)}")
}

/**
 * 思路1适用于删除数据量大且连续重复的数据，因为可以减少数据搬移的次数
 */
fun removeElement(nums: IntArray, `val`: Int): Int {
    var k = 0
    for (i in 0 until nums.size) {
        if (nums[i] != `val`) {
            nums[k] = nums[i]
            k++
        }
        println("nums:${nums.toList()}")
    }
    println("---Nums:${nums.toList()}")
    return k
}

/**
 *
 * 思路2适用于删除数据量小且无序的数据，因为数据搬移的次数取决于待删除数据的个数；
 *
 * https://leetcode-cn.com/problems/remove-element/solution/yi-chu-yuan-su-by-leetcode/
 */
fun removeElement2(nums: IntArray, `val`: Int): Int {
    var start = 0
    var lastIndex = nums.size - 1
    while (start < lastIndex) {
        if (nums[start] == `val`) {
            nums[start] = nums[lastIndex - 1]
            lastIndex--
        } else {
            start++
        }
    }
    return lastIndex
}