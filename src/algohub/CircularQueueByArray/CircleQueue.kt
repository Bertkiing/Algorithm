package algohub.CircularQueueByArray

import java.lang.IllegalArgumentException

/**
 * @author bertking
 * @date 2019/7/31
 *
 * 数组--->循环队列
 *
 * 该方法是：
 * 考虑各个条件而实现的
 *
 * 经验之谈:
 * 一般循环的东西都可以通过%size的逻辑来处理
 * @see CircleQueue2
 */
class CircleQueue(size: Int) {
    var rear = -1
    var front = -1
    var size = size
    var array = IntArray(size)
    /**
     * 队列都是
     * 尾部入队 rear ++
     */
    fun enQueue(value: Int) {
        if ((front == 0 && rear == size - 1) || rear == front - 1) {
            throw IllegalArgumentException("Queue is FULL...")
        } else if (front == -1) {
            // Insert First Element(插入第一个元素的情况)
            rear = 0
            front = 0
            array[rear] = value
        } else if (rear == size - 1 && front != 0) {
            // 尾指针已到数组边界，头指针不在数组头部的情况
            rear = 0
            array[rear] = value
        } else {
            // 尾指针正常范围，头指针在数组头部的情况
            rear++
            array[rear] = value
        }
    }

    /**
     * 头部出队 front++
     */
    fun deQueue(): Int {
        if (front == -1) {
            throw IllegalArgumentException("The Queue is EMPTY...")
        }

        val data = array[front]
        array[front] = Int.MIN_VALUE
        when (front) {
            // front = rear 队列为空
            rear -> {
                front = -1
                rear = -1
            }
            // front 到数组边界，由于是循环队列，故重置下标为0
            size - 1 -> front = 0
            // 正常范围出队列，front++
            else -> front++
        }

        return data
    }


    fun displayQueue() {
        if (front == -1) {
            throw IllegalArgumentException("Queue is EMPTY...")
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


