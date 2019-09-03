package search

/**
 * @author bertking
 * @date 2019/9/3
 *
 * 二分查找适用于"有序列表"
 *
 * 关于mid =(high + low) /2 的改进
 * https://juejin.im/post/5ca4b511518825440a4ba0af
 */
class BinarySearch {
    companion object {
        /**
         * @param intArray
         * @param target 待寻目标
         * @return 目标元素的下标
         */
        fun binarySearch(intArray: IntArray, target: Int): Int {
            var low = 0
            var high = intArray.lastIndex
            while (low <= high) {
                // 这里为了避免超时，一般将（high+low）/2 改写 low+(high -low)/2或者 (low + high) >>> 1 或 Kotlin中的 (low + high) ushr 1.
                val mid = (high + low) / 2

                when {
                    intArray[mid] > target -> {
                        high = mid - 1
                    }

                    intArray[mid] < target -> {
                        low = mid + 1
                    }

                    /* 相等，即找到目标 */
                    else -> {
                        return mid
                    }
                }
            }
            return -1
        }

        /**
         * 递归实现
         */
        fun binarySearch(intArray: IntArray, low: Int, high: Int, target: Int): Int {
            if (low > high) return -1
            // 这里为了避免超时，一般将（high+low）/2 改写
            val mid = low + (high - low) / 2

            if (target == intArray[mid]) return mid

            return if (target > intArray[mid]) {
                binarySearch(intArray, mid + 1, high, target)
            } else {
                binarySearch(intArray, low, mid - 1, target)
            }


        }

    }
}

fun main(args: Array<String>) {
    val intArray = intArrayOf(1, 3, 5, 9, 13, 20)
    println("目标下标为${BinarySearch.binarySearch(intArray, 9)}")

    println("目标下标为${BinarySearch.binarySearch(intArray, low = 0, high = intArray.lastIndex, target = 9)}")

    val sum = Int.MAX_VALUE + 1
    println(sum)

}