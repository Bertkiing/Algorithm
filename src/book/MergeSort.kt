package book

/**
 * @author bertking
 * @date 2018/10/18
 */

fun main(args: Array<String>) {

}

fun mergeSort(arr: Array<Int>, p: Int, r: Int) {
    var q = (p + r) / 2
    if (p < r) {
        mergeSort(arr, p, q);
        mergeSort(arr, q + 1, r)
        merge(arr, p, q, r)
    }
}

fun merge(arr: Array<Int>, p: Int, q: Int, r: Int) {
    var n1 = q - p + 1
    var n2 = r - q
    var B = intArrayOf(n1)
    var C = intArrayOf(n2)
}