package algohub

import java.util.*

/**
 * @author bertking
 * @date 2019/7/29
 *
 *
 * 利用数组来实现栈：
 * 1. 栈的特点 --- 先进后出
 * 2. 数组的特点 --- 顺序存储，随机存取
 *
 * 实现细节：
 * 1. 栈一般都需要维持栈顶
 * 2. 存储结构
 *
 * 注意事项:
 * 1. 存 & 取要判断临界条件 且更新栈顶
 * 2. 取出来之后要避免内存泄漏
 *
 *  从根本上来讲, 该实现其实就是:从头存,从尾取...
 */
class StackByArray(size: Int = 0) {
//    var top = -1
//    var array = Array<Any?>(size) {}
//
//    fun push(element: Any): Boolean {
//        if (top == array.lastIndex) {
//            return false
//        }
//        /**
//         * 这里同样分步更容易理解
//         * top +=1
//         * array[top] = element
//         */
//        array[++top] = element
//        return true
//    }
//
//    fun pop(): Any? {
//        if (top == -1) {
//            return null
//        }
//        val topElement = array[top]
//        /**
//         * 这里其实分步更容易理解
//         * array[top] = null
//         * top --
//         */
//        array[top--] = null
//        return topElement
//    }
//

    var top = 0
    var array = Array<Any?>(size) {}

    fun push(element: Any): Boolean {
        if (top == array.size) {
            return false
        }
        /**
         * 这里同样分步更容易理解
         * top +=1
         * array[top] = element
         */
        array[top] = element
        top++
        return true
    }

    fun pop(): Any? {
        if (top == 0) {
            return null
        }
        top -= 1
        val topElement = array[top]
        /**
         * 这里其实分步更容易理解
         * array[top] = null
         * top --
         */
        array[top] = null // 避免内存泄漏
        return topElement
    }

    override fun toString(): String {
        return "StackByArray(top=$top, array=${Arrays.toString(array)})"
    }
}

fun main(args: Array<String>) {
    val stack = StackByArray(3)
    stack.push("1")
    stack.push("2")
    stack.push("3")
    println("The stack is $stack")
    println("------1st pop()-----")
    println(stack.pop())
    println(stack)
    println("------2nd pop()-----")
    println(stack.pop())
    println(stack)
    println("------3rd pop()-----")
    println(stack.pop())
    println(stack)
}