package leecode.array

/**
 * @author bertking
 * @date 2020/1/14
 *
 * 1287. 有序数组中出现次数超过25%的元素
 *
 *
 * threshold : 极限；临界值
 *
 * https://leetcode-cn.com/problems/element-appearing-more-than-25-in-sorted-array/
 */
fun main(args: Array<String>) {
    val arr = intArrayOf(1, 2, 3, 6, 6)
    println("Result:${findSpecialInteger(arr)}")
}


fun findSpecialInteger(arr: IntArray): Int {
    var i = 0
    var j = 0


    var count = 0

    while (i < arr.size) {
        while (j < arr.size && arr[i] == arr[j]) {
            count++
            j++
        }

        if (count > arr.size / 4) {
            return arr[i]
        } else {
            i += 1
            j = i
            count = 0
        }

    }
    return arr[i]
}


/**
 * 由于数组 arr 已经有序，那么相同的数在 arr 中出现的位置也是连续的。
 * 因此我们可以对数组进行一次遍历，并统计每个数出现的次数。只要发现某个数出现的次数超过数组 arr 长度的 25%，
 * 那么这个数即为答案
 */
fun findSpecialInteger1(arr: IntArray): Int {

    var cur = arr[0]
    var count = 0

    for (i in 0 until arr.size) {
        if (arr[i] == cur) {
            count++

            if (count * 4 > arr.size) {
                return cur
            }

        } else {

            cur = arr[i]
            count = 1

        }
    }

    return 0
}


/**
 * 根据题目要求，满足条件的整数 x 至少在数组 arr 中出现了 span = arr.length / 4 + 1 次，
 * 那么我们可以断定：数组 arr 中的元素 arr[0], arr[span], arr[span * 2], ... 一定包含 x
 */
fun findSpecialInteger2(arr: IntArray): Int {
    val threshold = arr.size / 4
    var i = 0
    while (i + threshold < arr.size) {
        println("Threshold + i:${i + threshold}， i = $i")
        if (arr[i + threshold] == arr[i]) {
            return arr[i]
        }
        i++
    }
    return 0
}

fun findSpecialInteger5(arr: IntArray): Int {
    val hashMap = hashMapOf<Int, Int>()
    for (i in arr) {
        if (hashMap.keys.contains(i)) {
            hashMap[i] = hashMap[i]!!.plus(1)

        } else {
            hashMap[i] = 1
        }
        if (hashMap[i]!! > arr.size / 4) {
            return i
        }
    }


    println(hashMap)
    return 0
}