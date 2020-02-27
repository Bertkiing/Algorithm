package leecode.array

/**
 * @author bertking
 * @date 2020/1/14
 * TODO
 * 15. 三数之和
 * https://leetcode-cn.com/problems/3sum/
 *
 * 该题的难点在于：列表相等的判断
 *
 *为保证不重复，首先对数组进行排序，但不可去重。
 * 当target取值相同时，直接跳过即可，这是保证不重复需要注意的其中一点。
 *
 * 另一点是在寻找两数之和满足target值时，若遇到相同元素（相同元素一定相邻），可直接跳过。
 *
 *
 */
fun main(args: Array<String>) {
    val nums = intArrayOf(-1, 0, 1, 2, -1, -4)
    println("Result:${threeSum5(nums)}")
}


fun threeSum(nums: IntArray): List<List<Int>> {
    val listList = arrayListOf<ArrayList<Int>>()

    for (i in 0 until nums.size - 2) {
        for (j in i + 1 until nums.size - 1) {
            for (k in j + 1 until nums.size) {
                if (nums[i] + nums[j] + nums[k] == 0) {
                    listList.add(arrayListOf(nums[i], nums[j], nums[k]))
                }
            }
        }
    }
    // TODO 去重
    return listList.toList()
}


fun threeSum5(nums: IntArray): List<List<Int>> {

    val listList = arrayListOf<ArrayList<Int>>()

    if (nums == null || nums.size < 3) {
        return emptyList()
    }
    // 对数组进行排序
    nums.sort()

    // 直接返回空数组
    if(nums.first() >0 || nums.last() <0){
        return emptyList()
    }


    println("Sorted:${nums.sorted()}")

    // 遍历排序后数组
    for (i in 0 until nums.size) {
        /**
         * 剪枝
         *
         * 若 nums[i]>0 ：因为已经排序好，所以后面不可能有三个数加和等于 0，直接返回结果。
         */
        if (nums[i] > 0) {
            break
        }

        /**
         * 去重
         *
         * 对于重复元素：跳过，避免出现重复解
         *
         * 当不是第一个元素的时候，如果该元素和前面的元素相等则continue
         */
        if (i > 0 && nums[i] == nums[i - 1]) {
            continue
        }


        var left = i + 1

        var right = nums.size - 1

        while (left < right) {
            val sum = nums[i] + nums[left] + nums[right]
            when {
                sum == 0 -> {
                    println("I:${nums[i]},Left:${nums[left]},Right:${nums[right]}")
                    listList.add(arrayListOf(nums[i], nums[left], nums[right]))
                    // 跳过相等元素
                    while (left < right && nums[left] == nums[left + 1]) {
                        left += 1
                    }
                    // 跳过相等元素
                    while (left < right && nums[right] == nums[right - 1]) {
                        right -= 1
                    }

                    left += 1
                    right -= 1
                }
                // nums[R] 太大，R左移
                sum > 0 -> {
                    right -= 1
                }
                // nums[R] 太小，L右移
                else -> {
                    left += 1
                }
            }
        }
    }

    return listList.toList()
}