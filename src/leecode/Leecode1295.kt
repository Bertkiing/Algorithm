package leecode

/**
 * @author bertking
 * @date 2020/1/3
 */
fun main(args: Array<String>) {
    var nums = intArrayOf(12, 345, 2, 6, 7896)
    println("Result :${findNumbers(nums)}")
    println("Result2 :${findNumbers2(nums)}")

}


fun findNumbers(nums: IntArray): Int {
    var count = 0
    for (num in nums) {
        if (num.toString().length % 2 == 0) {
            count++
        }
    }
    return count
}


fun findNumbers2(nums: IntArray): Int {
    var count = 0
    for (num in nums){
        if(isDouble(num)){
            count ++
        }
    }
    return count
}

fun isDouble(num: Int): Boolean {
    var num = num
    var count = 0
    while (num > 0) {
        count++
        num /= 10
    }

    return count % 2 == 0
}