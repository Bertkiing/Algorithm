package leecode

/**
 * @author bertking
 * @date 2019/8/29
 *
 * 4.寻找两个有序数组的中位数
 * 难度：困难
 *
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-w-2/
 *
 * 难度系数主要在于:
 * 题目要求的时间复杂度为:O(log(m+n))
 * -----------------------------------
 * 看到log,我们要想到只有用到二分法才能达到。
 */

class Leecode4 {

}

/**
 * 第一种解法: 将两个数组合并成一个有序数组，然后再求其中位数
 * 时间复杂度:O(m + n)
 * 空间复杂度:O(m + n)
 */
class Solution1 {
    /**
     * 简单粗暴，先将两个数组合并，两个有序数组的合并也是归并排序中的一部分。然后根据奇数，还是偶数，返回中位数。
     */
    companion object {
        fun findMedianSortedArrays(num1: IntArray, num2: IntArray): Double {
            val size1 = num1.size
            val size2 = num2.size
            var nums = IntArray(size1 + size2)

            if (size1 == 0) {
                return findMedianInArray(num2)
            }

            if (size2 == 0) {
                return findMedianInArray(num1)
            }

            nums = mergeSortedArrays(num1, num2)

            return findMedianInArray(nums)

        }

        /**
         * 求单个数组的中位数
         */
        fun findMedianInArray(array: IntArray): Double {
            return if (array.size % 2 == 0) {
                // 偶数个元素
                (array[array.size / 2 - 1] + array[array.size / 2]) / 2.0
            } else {
                // 奇数个元素
                array[array.size / 2].toDouble()
            }
        }

        /**
         * 合并两个有序数组
         */
        fun mergeSortedArrays(num1: IntArray, num2: IntArray): IntArray {
            val size1 = num1.size
            val size2 = num2.size
            var nums = IntArray(size1 + size2)
            var count = 0
            var i = 0
            var j = 0
            while (count != size1 + size2) {
                if (i == size1) {
                    while (j != size2) {
                        nums[count++] = num2[j++]
                    }
                    break
                }

                if (j == size2) {
                    while (i != size1) {
                        nums[count++] = num1[i++]
                    }
                }

                if (num1[i] < num2[j]) {
                    nums[count++] = num1[i++]
                } else {
                    nums[count++] = num2[j++]
                }
            }
            return nums
        }
    }
}


/**
 * 相较于第一种借助空间合并数组的解法。
 * 其实，我们不需要将两个数组真的合并，just only find the 中位数即可
 *
 * len 表示 合并后数组的长度
 *      --->奇数 :  中位数：第(len+1)/2个元素 ；遍历次数： len/2 +1
 * len  |
 *      --->偶数 :  中位数：第len/2个元素&第len/2+1个元素 ；遍历次数： len/2 +1
 *
 * 综上所述(From the above)，无论len是奇数or偶数，都要遍历 len/2 +1 次
 *
 * 而中位数:
 *      奇数 需要最后一次遍历的结果;
 *      偶数 需要最后一次&上一次遍历的结果
 * 此处的代码逻辑(循环逻辑)：
 *      1. 两个变量left(上一次循环的结果),right(保存当前循环的结果)
 *      2. 在每次循环前，使left = right
 *      3. 这样，在最后的时候，left将得到right的值(即上一次循环的值)，而right正好更新为最后一次的结果
 * 循环中的代码逻辑(即:考虑 when A数组后移, when B数组后移):
 *      1. 使用aStart & bStart 分别表示当前指向A数组 & B数组的位置
 *      2.
 *         a). 如果aStart没到最后，且此时A[位置] < B[位置]，则A数组就可以后移；即(aStart < ALen && A[aStart] < B[bStart])
 *         b). 若B数组此时没有元素了，如果继续取元素B[bStart]，则IOE。所以需要判断bStart是否大于B数组长度.
 * Above all，循环中的逻辑为：
 *        (aStart < ALen &&( bStart >= BLen || A[aStart] < B[bStart])
 *
 * 时间复杂度:O(m+n)
 * 空间复杂度:O(1)
 *
 */
class Solution2 {
    companion object {
        fun findMedianSortedArrays(array1: IntArray, array2: IntArray): Double {
            val m = array1.size
            val n = array2.size
            val len = m + n
            /* right表示当前循环的结果,每次循环前将right赋值给left，使left表示上一次的结果 */
            var left = -1
            var right = -1

            /* 两者分别表示数组的当前下标  */
            var aStart = 0
            var bStart = 0


            for (i in 0..len / 2) {
                left = right
                if (aStart < m && (bStart >= n || array1[aStart] < array2[bStart])) {
                    right = array1[aStart++]
                } else {
                    right = array2[bStart++]
                }
            }
            /**
             * 注意这里判断奇偶性: x and 1 ==0
             */
            if ((len and 1) == 0) {
                return (left + right) / 2.0
            } else {
                return right.toDouble()
            }

        }
    }
}

/**
 * 题目要求:
 * 时间复杂度：O(log(m+n))
 * 看到log,我们要想到只有用到二分法才能达到。
 *
 * 这里我们需要换一种思路:
 * 求中位数 -------> 求第k个小数的一种特殊情况。
 * 而求第k个小数，是有一种算法的。
 *
 */
class Solution3 {

}


fun main(args: Array<String>) {
    val array1 = intArrayOf(1, 2, 4, 5)
    val array2 = intArrayOf(3, 6, 9, 10)


    val median = Solution1.findMedianSortedArrays(array1, array2)
    println("有序数组的中位数$median")

    println("------------------------------------")

    val mergedList = Solution1.mergeSortedArrays(array1, array2).toList()
    println("合并有序数组$mergedList")

    println("------------------------------------")

    val median2 = Solution2.findMedianSortedArrays(array1, array2)
    println("有序数组的中位数$median2")


}