package leecode.double_pointer

/**
 * @author bertking
 * @date 2020/1/3
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 */

fun main(args: Array<String>) {
    val nums = intArrayOf(1, 1, 2)
    println(removeDuplicates(nums))
}

/**
 * 参考：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/solution/shan-chu-pai-xu-shu-zu-zhong-de-zhong-fu-xiang-by-/
 *
 * "双指针法"
 * 1. 慢指针 负责更新 不同元素元素 的位置，只有当碰到不同元素的时候才会更新。(慢指针跳跃式更新)
 * 2. 快指针 随着数组元素的遍历同步更新，直至数组遍历完成。
 */
fun removeDuplicates(nums: IntArray): Int {
    if (nums.size < 2) {
        return nums.size
    }

    var slower = 0
    var faster = 1

    while (faster < nums.size) {
        if (nums[slower] != nums[faster]) {
            slower++
            nums[slower] = nums[faster]
        }
        faster++
    }

    return slower + 1


}