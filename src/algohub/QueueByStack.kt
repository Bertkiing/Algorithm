package algohub

import java.util.*

/**
 * @author bertking
 * @date 2019/7/29
 *
 *  使用「栈」来实现「队列」
 *  两者之前的区别与联系:
 *  1. 栈 -- 先进后出，只在一端(栈顶)操作(插入，删除)
 *  2. 队列 -- 先进先出，两头操作(队头插入，队尾删除)
 *
 *  SO...需要两个Stack来分别做为队头，队尾
 *
 *  关键点:
 *  1. 我们需要将负责队头的Stack，转移到队尾Stack再进行操作
 *  2. 两种实现分别是在enQueue()进行操作，或者是在deQueue()进行操作
 *
 *  注意点:
 *  推荐在enQueue()中进行操作，这样我们取或者删除的时候只需要简单地调用执行即可，而不必将栈间转移操作在多个方法中实现
 *
 */
class QueueByStack {
    val stack4Enqueue = Stack<Any>()
    val stack4Dequeue = Stack<Any>()

    fun enQueue(element: Any?): Boolean {
        stack4Enqueue.push(element)
        return true
    }

    /**
     * 在deQueue()时候实现，但是有局限性
     */
    fun pop(): Any? {
        var element: Any? = null

        /**
         * 如果出队队列为空，则把入队队列的元素都给push到出队队列中
         */
        if (stack4Dequeue.empty()) {
            while (stack4Enqueue.isNotEmpty()) {
                val pop = stack4Enqueue.pop()
                stack4Dequeue.push(pop)
            }
        }
        /**
         * 这里是重点：虽然跟上方的condition if是互斥关系,但是不能直接else，否则第一个元素将会一直返回null
         * 原因：当stack4Enqueue不为空  &&   stack4Dequeue 为空 时，直接return null啦...
         *
         */
        if (stack4Dequeue.isNotEmpty()) {
            element = stack4Dequeue.pop()
        }

        return element
    }

    fun peek(): Any? {
        var element: Any? = null

        if (stack4Dequeue.empty()) {
            while (stack4Enqueue.isNotEmpty()) {
                val pop = stack4Enqueue.pop()
                stack4Dequeue.push(pop)
            }
        }

        if (stack4Dequeue.isNotEmpty()) {
            element = stack4Dequeue.peek()
        }
        return element
    }

    fun empty(): Boolean {
        return stack4Enqueue.isEmpty() && stack4Dequeue.isEmpty()
    }

    override fun toString(): String {
        return "QueueByStack($stack4Enqueue)"
    }
}

fun main(args: Array<String>) {
    val queueByStack = QueueByStack()
    queueByStack.enQueue(1)
    queueByStack.enQueue(2)
    queueByStack.enQueue(3)
    queueByStack.enQueue(4)
    println("入队结束:$queueByStack")

    println(queueByStack.pop())
    println(queueByStack.pop())
    println(queueByStack.pop())
    println(queueByStack.pop())

}