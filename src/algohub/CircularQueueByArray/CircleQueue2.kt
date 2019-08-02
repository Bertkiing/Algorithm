package algohub.CircularQueueByArray

import java.lang.IllegalArgumentException

/**
 * @author bertking
 * @date 2019/8/1
 * @throws IllegalArgumentException Queue is Empty or Full
 *
 * 利用% 实现逻辑
 */
class CircleQueue2(size: Int) {
    var rear = -1
    var front = -1
    var size = size
    var array = IntArray(size)
    /**
     * 入队列
     */
    fun enQueue(value: Int) {
        if ((rear + 1) % size == front) {
            throw IllegalArgumentException("The Queue is FULL...")
        }

        if (front == -1) { //condition 4 empty Queue...
            front = 0
            rear = 0
            array[rear] = value
        } else {
            // next position 4 rear
            rear = (1 + rear) % size

            array[rear] = value
        }
    }

    /**
     * 出队列
     */
    fun deQueue(): Int {
        // condition 4 empty queue
        if (front == -1) {
            throw IllegalArgumentException("The Queue is Empty...")
        } else if (front == rear) {
            // condition 4 only one element
            val data = array[front]
            front = -1
            rear = -1
            return data
        } else {
            val data = array[front]
            front = (front + 1) % size
            return data
        }
    }

    fun displayQueue() {
        if (front == -1) {
            throw IllegalArgumentException("The Queue is Empty")
        }
        print("Elements in Circle Queue are :")
        if (rear >= front) {
            for (i in front..rear) {
                print(array[i])
            }
        } else {
            for (i in front until size) {
                print(array[i])
            }

            for (i in 0..rear) {
                print(array[i])
            }
        }
        println()
    }
}