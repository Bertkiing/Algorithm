package leecode.array

import java.util.*

/**
 * @author bertking
 * @date 2020/1/13
 *
 * 合并有序数组时，【从后往前遍历】比较好
 *
 * https://leetcode-cn.com/problems/merge-sorted-array/
 */

fun main(args: Array<String>) {
    val nums1 = intArrayOf(0)
    val nums2 = intArrayOf(1)
    merge1(nums1,0,nums2,1)

}

fun merge1(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {

    var s1 = m - 1
    var s2 = n - 1
    var count = m + n - 1



    while (s1 >= 0 && s2 >= 0) {
        if (nums1[s1] >= nums2[s2]) {
            nums1[count--] = nums1[s1--]
        } else {
            nums1[count--] = nums2[s2--]
        }
    }
    /**
     * 这行代码应该是不需要的
     */
    while (s1 > 0) {
        nums1[count--] = nums1[s1--]
    }

    while (s2 >= 0) {
        nums1[count--] = nums2[s2--]
    }

    println("Result:${nums1.toList()}")
}


/**
 * 将 num2 拷贝至 num1中，再对num1进行排序
 */
fun merge2(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
    System.arraycopy(nums2, 0, nums1, m, n)
    Arrays.sort(nums1)
}