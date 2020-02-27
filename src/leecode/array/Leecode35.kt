package leecode.array

/**
 * @author bertking
 * @date 2020/1/13
 *
 *
 * https://leetcode-cn.com/problems/search-insert-position/solution/hua-jie-suan-fa-35-sou-suo-cha-ru-wei-zhi-by-guanp/
 */
fun main(args: Array<String>) {
    val nums = intArrayOf(1, 3, 5, 6)
    println("Result:${searchInsert(nums, 2)}")
}

/**
 * var mid = low + (high-low) / 2 // 推荐
 *
 * var mid = (low+high) / 2 // 不推荐，可能内存溢出
 */
fun searchInsert(nums: IntArray, target: Int): Int {
    var low = 0
    var high = nums.size - 1

    while (low <= high) {
        var mid = low + (high-low) / 2

        if (target < nums[mid]) {
            high = mid
        } else {
            low = mid + 1
        }
    }
    return low
}


/***
 * 在数组有序的情况下，显然更适合用二分法
 */
fun searchInsert1(nums: IntArray, target: Int): Int {
    for (i in 0 until nums.size) {
        if (nums[i] >= target) {
            return i
        }
    }
    return nums.size
}


fun searchInsert2(nums: IntArray, target: Int): Int {
    var index = 0

    if (nums[0] > target) {
        return 0
    }

    if (nums[nums.size - 1] < target) {
        return nums.size
    }

    for (i in 0 until nums.size) {
        if (nums[i] == target) {
            return i
        }

        if (nums[i] < target && nums[i + 1] > target) {
            return i + 1
        }
    }
    return 0
}
