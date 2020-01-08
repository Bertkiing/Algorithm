package leecode.palindromic

/**
 * @author bertking
 * @date 2020/1/7
 * https://leetcode-cn.com/problems/valid-palindrome/
 *
 * 没有太大价值
 */
fun main(args: Array<String>) {
    var s = "A man, a plan, a canal: Panama"
    println("Result:${isPalindrome(s)}")
}

fun isPalindrome(s: String): Boolean {
    var s = s.toLowerCase()
    println(s)
    var ss = ""
    for (i in s) {
        val string = i.toString()
        if (string in "a".."z" || (string in "0".."9")) {
            println(string)
            ss += string
        }
    }

    println("SS:$ss")
    var i = 0
    var j = ss.lastIndex

    while (i < j){
        if(ss[i++] != ss[j--]){
            return false
        }
    }
    return true
}