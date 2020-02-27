package leecode.strs

/**
 * @author bertking
 * @date 2020/1/15
 */
fun main(args: Array<String>) {
    val s = "Let's take LeetCode contest"
    println("Result:${reverseWords(s)}")
}

fun reverseWords(s: String): String {
    var result = ""
    s.split(" ").forEach {
        result += it.reversed()+" "
    }

    return result.trim()
}