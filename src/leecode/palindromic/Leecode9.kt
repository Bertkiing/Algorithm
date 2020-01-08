package leecode.palindromic

/**
 * @author bertking
 * @date 2020/1/7
 *
 * https://leetcode-cn.com/problems/palindrome-number/
 */

fun main(args: Array<String>) {

    var x = 1345431

    println("Result:$x 是回文数:${isPalindrome9(x)}")
}

/**
 *
 * https://leetcode-cn.com/problems/palindrome-number/solution/dong-hua-hui-wen-shu-de-san-chong-jie-fa-fa-jie-ch/
 *
 * 反转一半数字：
 * 1. 将数字转换为字符串，并检查是否是回文。这需要额外的空间
 * 2. 将数字本身反转，再与原始数字比对。若反转后出现的结果大于Int.MAX_VALUE,则整数溢出。
 *
 *
 *
 * https://leetcode-cn.com/problems/palindrome-number/solution/hui-wen-shu-by-leetcode/
 */
fun isPalindrome(x: Int): Boolean {
    var x = x
    /**
     * 所有负数都不可能是"回文"
     */
    if (x < 0) return false

    /**
     * 如果数字的最后一位是0，而为了使该数字为回文，则其第一位数字必须是0，只有0满足该属性
     */
    if (x % 10 == 0 && x != 0) {
        return false
    }


    var revertedNumber = 0
    while (x > revertedNumber) {
        revertedNumber = revertedNumber * 10 + x % 10
        x /= 10
    }

    /**
     * 当数字长度为奇数时，通过revertedNumber/10去除中间的数字
     *
     * 例如：12321 ，
     * while循环结束后：x = 12, revertedNumber = 123.
     *
     * 由于中间的数不影响回文，所以我们可以简单地将其去除
     */
    return x == revertedNumber || x == revertedNumber / 10

}


/**
 * 前后夹击
 */
fun isPalindrome91(x: Int): Boolean {
    if (x < 0) return false
    var x = x.toString()
    var i = 0
    var j = x.length - 1
    while (i < j) {
        println("i = $i,j = $j")
        if (x[i++] != x[j--]) {
            return false
        }
    }
    return true
}


/**
 * 前后夹击
 * 可惜需要转化为字符串
 */
fun isPalindrome9(x: Int): Boolean {
    if (x < 0) return false
    var x = x.toString()

    var i = 0
    var j = x.length - 1
    while (i < j) {
        println("i = $i,j = $j")
        if (x[i++] != x[j--]) {
            return false
        }
    }
    return true
}


/**
 * 最 Low
 */
fun isPalindrome10(x: Int): Boolean {
    var x = x.toString()
    return x.reversed() == x
}