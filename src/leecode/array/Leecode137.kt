package leecode.array

/**
 * @author bertking
 * @date 2020/1/16
 *
 * 137. 只出现一次的数字 II
 *
 *
 * 每个数字都出现了 3 次，只有一个数字出现了 1 次，
 * 找出这个数字。同样要求时间复杂度为 O（n），空间复杂度为 O（1）
 *
 * 面试题
 *
 */
fun main(args: Array<String>) {

    val nums = intArrayOf(0,1,0,1,0,1,99)
    println("Result:${Leecode137().singleNumber(nums)}")
}

class Leecode137 {

    fun singleNumber(nums: IntArray): Int {
        var ans = 0
        // 考虑每一位
        for (i in 0..32) {
            var count = 0
            // 考虑每一个数
            for (j in 0 until nums.size) {
                // 当前位是否为1
                if (nums[j].shr(i).and(1) == 1) {
                    count++
                }
            }
            // 1的个数是否是3的倍数
            if (count % 3 != 0) {
                println("i = $i,count:$count}，ans:$ans")

                /**
                 * 这里的或运算： n | 1 = n 或者 n + 1
                 * 本质上就是：ans = ans + (1.shl(i))
                 *
                 * https://leetcode.com/problems/single-number-ii/discuss/43297/Java-O(n)-easy-to-understand-solution-easily-extended-to-any-times-of-occurance
                 */
                ans = ans.or (1.shl(i))
            }
        }

        return ans
    }


    fun singleNumber5(nums: IntArray): Int {
        val sorted = nums.sorted()
        println("Sorted:$sorted")
        for (i in 0 until nums.size step 3) {
            println("I = $i")
            if (i == nums.size - 1) {
                return sorted[i]
            }

            if (sorted[i] != sorted[i + 1]) {
                return sorted[i]
            }

        }
        return -1
    }
}
