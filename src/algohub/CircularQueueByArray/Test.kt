package algohub.CircularQueueByArray

/**
 * @author bertking
 * @date 2019/8/1
 * 参考自:@see https://www.geeksforgeeks.org/circular-queue-set-1-introduction-array-implementation/
 */

fun main(args: Array<String>) {
    println("--------------实现1--------------")
    val circleQueue = CircleQueue(3)
    // Insert
    circleQueue.enQueue(1)
    circleQueue.enQueue(2)
    circleQueue.enQueue(3)
    circleQueue.displayQueue()

//    circleQueue.enQueue(4) // FULL

    circleQueue.deQueue()
    circleQueue.deQueue()
    circleQueue.displayQueue()
    circleQueue.enQueue(5)
    circleQueue.displayQueue()
    println("--------------实现2--------------")
    val circleQueue2 = CircleQueue2(3)
    // Insert
    circleQueue2.enQueue(1)
    circleQueue2.enQueue(2)
    circleQueue2.enQueue(3)
    circleQueue2.displayQueue()

//    circleQueue.enQueue(4) // FULL

    circleQueue2.deQueue()
    circleQueue2.deQueue()
    circleQueue2.displayQueue()
    circleQueue2.enQueue(5)
    circleQueue2.displayQueue()

}