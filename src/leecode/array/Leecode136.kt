package leecode.array

/**
 * @author bertking
 * @date 2020/1/15
 *
 * 136. 只出现一次的数字
 * （PS:某个元素只出现一次以外，其余每个元素均出现了2次）
 *
 *
 * 交换律：a ^ b ^ c <=> a ^ c ^ b
 * 任何数于0异或为任何数 0 ^ n => n
 * 相同的数异或为0: n ^ n => 0
 *
 *
 *
 * https://leetcode-cn.com/problems/single-number/
 */
fun main(args: Array<String>) {


    println(4.xor(6))
    println(6.xor(4))
    println("-------------")



    val array = intArrayOf(4,1,2,1,2)
    println("Result:${singleNumber2(nums = array)}")
}

/**
 * 时间复杂度为O(n*lgn)
 * 空间复杂度为O(n)
 */
fun singleNumber2(nums: IntArray): Int {

    val nums = nums.sorted()
    println("sorted = $nums")

    val length = nums.size

    for (i in 0..length step 2){
        println("i = $i")

        val cur = nums[i]

        if(i == length -1){ // //如果遍历到最后一个元素,说明该元素为single number
            return cur
        }


        if(cur != nums[i+1]){
            return cur
        }
    }
    return -1
}

fun singleNumber(nums: IntArray): Int {
    var ans = nums[0]
    if (nums.size > 1) {
        for (i in 1 until nums.size) {
            ans = ans.xor(nums[i])
        }
    }
    return ans
}

/**
 * 容易理解，但执行效率不如上面的
 */
fun singleNumber1(nums: IntArray): Int {
    var ans = 0
    for (i in 0 until nums.size) {
        ans = ans.xor(nums[i])
    }
    return ans
}