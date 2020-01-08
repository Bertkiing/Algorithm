package leecode

/**
 * @author bertking
 * @date 2019/12/16
 */
fun main(args: Array<String>) {
    val string = "([]){}"
    println(isValid(string))
}

fun isValid(s: String): Boolean {
    var s = s;
    if (s.length % 2 != 0) return false

    while (s.contains("()") || s.contains("[]") || s.contains("{}")) {
        s = s.replace("()", "").replace("[]", "").replace("{}", "")
    }
    return s.isEmpty()
}
