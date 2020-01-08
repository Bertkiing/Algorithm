package leecode

/**
 * @author bertking
 * @date 2020/1/7
 *
 * 大写变小写、小写变大写 : ASCII码 ^= 32
 * 大写变小写、小写变小写 : ASCII码 |= 32
 * 小写变大写、大写变大写 : ASCII码 &= -33
 *
 * https://leetcode-cn.com/problems/to-lower-case/
 *
 */
fun main(args: Array<String>) {
    var s = "Hello"
    println("Result:${toLowerCase2(s)}")
}


fun toLowerCase2(str: String): String {
    var s = ""
    if (str.isNullOrBlank()) return ""

    for (c in str) {
        s += c.toInt().or(32).toChar()
    }

    return s
}

fun toLowerCase(str: String): String {
    return str.toLowerCase()
}

