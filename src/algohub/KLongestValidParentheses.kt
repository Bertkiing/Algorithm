package algohub

import java.util.*

class KLongestValidParentheses {
    fun longestValidParentheses(s: String): Int {
        if (s == null || s.length < 2) {
            return 0
        }

        var maxLen = 0
        var mostleft = -1
        val stack = Stack<Int>()

        for (i in 0 until s.length){
            if(s[i] == '('){
                stack.push(i)
            }else{
                if(stack.isEmpty()){
                    mostleft = i
                }else{
                    stack.pop()
                    if(stack.isEmpty()){
                        maxLen = Math.max(maxLen,i - mostleft)
                    }else{
                        maxLen = Math.max(maxLen,i - stack.peek())
                    }
                }
            }

        }

        return maxLen
    }
}

fun main(args: Array<String>) {
    val test = "(()())("
    println(test + " longest valid is " + KLongestValidParentheses().longestValidParentheses(test))

}