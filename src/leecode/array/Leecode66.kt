package leecode.array

/**
 * @author bertking
 * @date 2020/1/13
 *
 *
 * https://leetcode-cn.com/problems/plus-one/submissions/
 */
fun main(args: Array<String>) {
    var digits = intArrayOf(9)
    println("Result:${plusOne(digits).toList()}")
}

fun plusOne(digits: IntArray): IntArray {
    for (i in digits.lastIndex.downTo(0)) {
        digits[i]++
        digits[i] = digits[i] % 10
        if (digits[i] != 0) return digits
    }

    val list = arrayListOf<Int>()
    list.add(1)
    for (i in 0 until digits.size) {
       list.add(0)
    }
    return list.toIntArray()
}
