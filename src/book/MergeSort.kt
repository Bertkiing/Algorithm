package book

/**
 * @author bertking
 * @date 2018/10/18
 */

fun main(args: Array<String>) {
    var array = arrayOf(1, 2, 3, 4, 5)
    mergeSort(array, 0, array.lastIndex)
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

    var leftArray = intArrayOf(q - p + 1)
    for (i in 0..q){

    }


    var rightArray = intArrayOf(r - q)


    var A = intArrayOf(r - p + 1)

    var n1 = q - p + 1
    var n2 = r - q
    var B = intArrayOf(n1)
    var C = intArrayOf(n2)
    B[B.lastIndex] = Int.MAX_VALUE
    C[C.lastIndex] = Int.MAX_VALUE

    var i = 0
    var j = 0

    for (k in p until r) {
        if (B[i] < C[j]) {
            A[k] = B[i]
            i++
        } else {
            A[k] = C[j]
            j++
        }
    }
}