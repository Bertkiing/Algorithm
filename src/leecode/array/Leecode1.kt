package leecode.array

import java.lang.IllegalArgumentException

/**
 * @author bertking
 * @date 2020/1/13
 *
 * https://leetcode-cn.com/problems/two-sum/
 *
 *
 *  对于数组循环的问题，可以考虑使用HashMap来降低时间复杂度
 *
 */
fun main(args: Array<String>) {
    val nums = intArrayOf(3,3)
    println("Result:${twoSum(nums,6).toList()}")
}





/**
 *
 * 一边哈希
 *
 * 通过以空间换取速度的方式，我们可以将查找时间从 O(n) 降低到 O(1)。
 * 哈希表正是为此目的而构建的，它支持以 近似 恒定的时间进行快速查找。我用“近似”来描述，
 * 是因为一旦出现冲突，查找用时可能会退化到 O(n)。
 * 但只要你仔细地挑选哈希函数，在哈希表中进行查找的用时应当被摊销为 O(1)。
 *
 */
fun twoSum(nums: IntArray, target: Int): IntArray {

    val map = HashMap<Int,Int>()
    for (i in 0..nums.size){
        if(map.containsKey(target-nums[i])){
            return intArrayOf(map[target-nums[i]]!!,i)
        }
        map[nums[i]] = i
    }
    throw IllegalArgumentException("")
}


/**
 * 两遍 哈希表
 * 把包含有 n 个元素的列表遍历两次。由于哈希表将查找时间缩短到 O(1) ，所以时间复杂度为 O(n)
 * 时间复杂度：O(n)
 */
fun twoSum1(nums: IntArray, target: Int): IntArray {
    val map = HashMap<Int,Int>()
    for (i in 0 until nums.size){
        map[nums[i]] = i
    }

    for (i in 0 until nums.size){
        var complement = target - nums[i]
        if(map.containsKey(complement)){
            return intArrayOf(i,map[complement]!!)
        }
    }

    throw IllegalArgumentException("No two sum solution")
}


/**
 * 暴力解决
 * 时间复杂度为O(n^2)
 */
fun twoSum2(nums: IntArray, target: Int): IntArray {
    val intArray = intArrayOf(0,0)
    for (i in 0 until nums.size){
        for (j in i+1 until nums.size){
            if(nums[i]+nums[j] == target){
                println("i = $i,j = $j")
                intArray[0] = i
                intArray[1] = j
            }
        }
    }
    return intArray
}