package algohub

import java.util.*

/**
 * @author bertking
 * @date 2019/7/30
 *
 * 比较好的实现：
 * 因为存数据的时候已经将其「队列的特性」在存储过程中保证
 * 故只需后续操作只需对「出队列的Stack」进行操作即可...
 */
class QueueByStack2 {
    val stack4Enqueue = Stack<Any?>()
    val stack4Dequeue = Stack<Any?>()

    fun enQueue(element: Any?) {
        if (stack4Dequeue.isEmpty()) {
            stack4Dequeue.push(element)
        } else {
            /**
             * 为保证顺序，
             * 1. 需要先将「出队列」全部转移到「入队列」
             */
            while (stack4Dequeue.isNotEmpty()) {
                stack4Enqueue.push(stack4Dequeue.pop())
            }
            /**
             * 2. 将当前元素放入到「出队列」
             */
            stack4Dequeue.push(element)
            /**
             * 3. 再将「入队列」全部转移到「出队列」
             */
            while (stack4Enqueue.isNotEmpty()) {
                stack4Dequeue.push(stack4Enqueue.pop())
            }
        }
    }

    fun deQueue(): Any? {
        return stack4Dequeue.pop()
    }

    fun peek(): Any? {
        return stack4Dequeue.peek()
    }

    fun empty(): Boolean = stack4Dequeue.isEmpty()
}

fun main(args: Array<String>) {
    val queue = QueueByStack2()
    queue.enQueue(1)
    queue.enQueue(2)
    queue.enQueue(3)
    queue.enQueue(4)
    println("入队结束:$queue")

    println(queue.deQueue())
    println(queue.deQueue())
    println(queue.deQueue())
    println(queue.deQueue())
}