package book.binary

/**
 * @author bertking
 * @date 2018/10/16
 * 二分查找(折半查找)
 *
 * 二分查找必须要求数据是有序的。
 *
 * 其优点是查找的时间复杂度为O(lgn)
 */
fun main(args: Array<String>) {
    var array = arrayOf(1,2,3,4,5,6,7,8,9)
    println(binarySearch(array,5))
}

fun binarySearch(arr: Array<Int>, des: Int): Int {
    var p = 0;
    var r = arr.lastIndex
    var q = -1;

    while (p <= r) {
        q = (p + r) / 2
        if(arr[q] == des){
            return q
        }else{
            if(arr[q] > des){
                r = q-1
            }else{
                p = q+1
            }
        }
    }
    return -1
}