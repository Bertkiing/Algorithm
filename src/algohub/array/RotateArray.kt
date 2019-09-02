package algohub.array

/**
 * @author bertking
 * @date 2019/8/8
 */
class RotateArray {
    /**
     * 借用 temp array...
     */
    fun leftRotate(array: IntArray, n: Int) {
        val tempArray = IntArray(n)
        for (i in 0 until array.size) {
            if (i < n) {
                tempArray[i] = array[i]
            } else {
                array[i - n] = array[i]
            }
        }
        println(tempArray.toList())
        for (i in 0 until n) {
            array[array.size - n + i] = tempArray[i]
        }
        println(array.toList())
    }


    fun leftRotate2(array: IntArray, n: Int) {
        var temp = 0
        for (i in 0 until n) {
            temp = array[array.size - 1]
        }
    }

}

fun main(args: Array<String>) {
    val array = intArrayOf(1, 2, 3, 4, 5)
    val rotateArray = RotateArray()
    rotateArray.leftRotate2(array, 3)
}