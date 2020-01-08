package algohub

/**
 * @author bertking
 * @date 2019/12/27
 * https://www.cnblogs.com/skywang12345/p/3610390.html
 *
 * https://wiki.hk.wjbk.site/baike-%E4%BA%8C%E5%8F%89%E5%A0%86
 *
 * https://blog.csdn.net/MoreWindows/article/details/6709644
 */
class MaxHeap<T : Comparable<T>> {

    var heap = arrayListOf<T>()

    /**
     * sift-down(下沉)
     * @param end 默认是最后的下标
     */
    private fun sinkDown(start: Int, end: Int = heap.lastIndex) {
        if(start >= heap.size) return
        var current = start
        var left = 2 * current + 1
        println("current:$current")
        val temp = heap[current]

        while (left < end) {
            if (left < end && heap[left] < heap[left + 1]) {
                left++
            }

            if (temp < heap[left]) {
                heap[current] = heap[left]
                current = left
                left = 2 * left + 1

            }
        }
        heap[current] = temp
    }

    /**
     * sift-up(上浮)
     * 避免插入元素破坏堆的性质
     *
     * 为了避免插入时，插入的节点A比其父节点大，则A将不再适合做子节点，自己去做父节点
     * 即：A在往上浮动，故称为："上浮操作"sift-up.
     */
    private fun sinkUp(start: Int) {
        /**
         * 当前节点的位置
         */
        var current = start
        /**
         * 父节点的位置
         */
        var parent = (current - 1) / 2

        /**
         * 当前节点的大小
         */
        val temp = heap[current]

        while (current > 0 && temp > heap[parent]) {
            /**
             * 互换父元素与子元素
             */
            heap[current] = heap[parent]
            current = parent
            parent = (parent - 1) / 2
        }
        heap[current] = temp
    }

    /**
     * 插入操作
     *
     * insert 方法先把要插入的元素添加到堆末尾，然后让其上浮到正确位置。
     */
    fun insert(element: T) {
        val size = heap.size
        heap.add(element)//添加元素，尾部添加
        sinkUp(size) //  上浮调整元素
    }

    /**
     * 删除操作
     * 1. 先用堆的最后一个元素 替换 待删除的元素;
     * 2. 删除最后一个元素
     * 3. 从index号位置开始自上向下做sift-down操作。
     */
    fun delete(data: T): T? {
        if (heap.isEmpty()) {
            return null
        }

        val index = heap.indexOf(data)
        if (index == -1) {
            return null
        }

        heap[index] = heap.last()
        heap.removeAt(heap.lastIndex)
        sinkDown(start = index)

        return data
    }


    fun deleteMax(): T? {
        return delete(heap.first())
    }


    override fun toString(): String {
        return "MaxHeap(heap=$heap)"
    }


}

fun main(args: Array<String>) {
    val maxHeap = MaxHeap<Int>()
    val array = intArrayOf(10, 40, 30, 60, 90, 70, 20, 50, 80)
    array.forEach {
        maxHeap.insert(it)
    }
    println("最大堆:$maxHeap")

    maxHeap.insert(85)

    println("添加85后的最大堆:$maxHeap")

//    maxHeap.delete(90)
//    print("删除90后的最大堆:$maxHeap")

    maxHeap.deleteMax()
    print("删除最大值后的最大堆:$maxHeap")


}