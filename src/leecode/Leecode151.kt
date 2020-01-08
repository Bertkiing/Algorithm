package leecode

/**
 * @author bertking
 * @date 2020/1/3
 * https://leetcode-cn.com/problems/reverse-words-in-a-string/
 */

fun main(args: Array<String>) {
    var param = "a good   example"
    println("result:${reverseWords(param)}")
}

fun reverseWords(s: String): String {
    val split = s.trim().split(" ")
    println("$split")
    println("Reversed:${split.reversed()}")

    var s = ""
    for (i in split.reversed()){
        if(i.isNotBlank()){
            s +=" $i"
        }
    }

    return s.trim()
}
