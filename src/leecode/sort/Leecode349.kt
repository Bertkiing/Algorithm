package leecode.sort

/**
 * @author bertking
 * @date 2020/1/14
 *
 * 349. 两个数组的交集
 *
 * https://leetcode-cn.com/problems/intersection-of-two-arrays/
 */
fun main(args: Array<String>) {
    val nums1 = intArrayOf(4, 9, 5)
    val nums2 = intArrayOf(9, 4, 9, 8, 4)
    println("交集:${intersection(nums1, nums2).toList()}")
}

fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
    val set1 = hashSetOf<Int>()
    val set2 = hashSetOf<Int>()



    for (i in nums1) {
        set1.add(i)
    }


    for (i in nums2) {
        set2.add(i)
    }

    println("SET1:${set1.toList()}")
    println("SE2:${set2.toList()}")

    return if (set1.size <= set2.size) {
        intersation(set2, set1)
    } else {
        intersation(set1, set2)
    }

}

private fun intersation(set2: HashSet<Int>, set1: HashSet<Int>): IntArray {
    var list = arrayListOf<Int>()
    for (i in set2) {
        if (set1.contains(i)) {
            list.add(i)
        }
    }
    return list.toIntArray()
}

