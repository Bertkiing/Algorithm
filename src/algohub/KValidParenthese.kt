package algohub

import java.util.*

/**
 * @author bertking
 * https://soulmachine.gitbooks.io/algorithm-essentials/content/java/stack-and-queue/stack/valid-parentheses.html
 */
class KValidParenthese {


    fun isValid(string: String): Boolean {
        val left = "([{"
        val right = ")]}"

        val stack = Stack<Char>()

        for (c in string) {
            if (left.indexOf(c) != -1) {
                stack.push(c)
            } else {
                if (stack.isNotEmpty() && stack.peek() == left[right.indexOf(c)]) {
                    stack.pop()
                } else {
                    return false
                }
            }
        }

        return stack.isEmpty()
    }

}


fun main(args: Array<String>) {
    val string = "()"
    print(string +" is valid ? "+KValidParenthese().isValid(string))
}