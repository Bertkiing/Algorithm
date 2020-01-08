package leecode

/**
 * @author bertking
 * @date 2019/12/16
 *
 * 最后一个单词的长度(简单)
 *
 * https://leetcode-cn.com/problems/length-of-last-word/solution/hua-jie-suan-fa-58-zui-hou-yi-ge-dan-ci-de-chang-d/
 */

fun main(args: Array<String>) {
    println(length("Hello World  "))
}


fun length(s: String): Int {
    /**
     * 先找到单词尾部
     */
    var end = s.length - 1
    while (end >= 0 && s[end] == ' '){
        println("END : $end")
        end--
    }


    if (end < 0) return 0

    /**
     * 找到单词尾部之后，再找到单词首部，
     */
    var start = end
    while (start >= 0 && s[start] != ' ') start--

    /**
     * 两者相减，即为单词长度
     */
    return end - start


//    val trim = s.trim()
//    val start =  trim.lastIndexOf(" ") + 1
//    return trim.substring(start).length


//
//    if (s.trim().isEmpty())
//        return 0
//
//    return s.trim().reversed().split(" ")[0].length
}