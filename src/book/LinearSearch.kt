package book

/**
 * @author bertking
 * @date 2018/10/14
 */

fun main(args: Array<String>) {
    var arr: Array<Int> = arrayOf(1, 2, 3, 4, 5, 6)
    val linearSearchResult = linearSearch(arr, 3)
    println(linearSearchResult)


    val betterLinearSearchResult = betterLinearSearch(arr, 3)
    println(betterLinearSearchResult)


    val sentinelLinearSearchResult = sentinelLinearSearch(arr, 3)
    println(sentinelLinearSearchResult)
}

/**
 * 该方法的缺点：
 * 每次都循环迭代array.size次
 */
fun linearSearch(array: Array<Int>, des: Int): Int {
    var temp = -1
    for (i in 0 until array.size) {
        println("线性查找i=$i")
        if (des == array[i]) {
            temp = des
        }
    }
    return temp
}

/**
 * 相对于上面的版本
 * 找到结果后直接返回结果，不再做多余的对比
 */
fun betterLinearSearch(array: Array<Int>, des: Int): Int {
    for (i in 0 until array.size) {
        println("改良版的线性查找i=$i")
        if (des == array[i]) return i
    }
    return -1
}




/**
 * @param des 信号量
 *
 * sentinel 哨兵
 */
fun sentinelLinearSearch(array: Array<Int>, des: Int): Int {
    var last = array.last()
    array[array.lastIndex] = des
    var index = 0
    while (array[index] != des) {
        println("最好的的线性查找i=$index")
        index++
    }
    array[array.lastIndex] = last

    if (index < array.size || array[array.lastIndex] == des) {
        return array[index]
    }

    return -1
}