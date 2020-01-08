package leecode


/**
 * @author bertking
 * @date 2020/1/8
 *
 * https://leetcode-cn.com/problems/reverse-integer/
 *
 *
 */
fun main(args: Array<String>) {
    val x = -1230
    println("Result:${reverse(x)}")
}
/**
 * 题解
 * https://leetcode-cn.com/problems/reverse-integer/solution/zheng-shu-fan-zhuan-by-leetcode/
 */
fun reverse(x: Int): Int {
    var x = x
    var result = 0

    while (x != 0) {
        val pop = x % 10
        x /= 10
        result = result * 10 + pop

        if (result > Int.MAX_VALUE / 10 || (result == Int.MAX_VALUE / 10 && pop > Int.MAX_VALUE % 10)) {
            return 0
        }

        if (result < Int.MIN_VALUE / 10 || (result == Int.MIN_VALUE / 10 && pop < Int.MIN_VALUE)) {
            return 0
        }

        println("POP : $pop , X : $x, Result:$result")

    }

    return result
}


/**
 * LOW
 * 借用字符串实现
 */
fun reverse1(x: Int): Int {
    return try {
        if (x < 0) {
            (x * -1).toString().reversed().toInt() * -1
        } else {
            x.toString().reversed().toInt()
        }
    } catch (e: Exception) {
        0
    }
}