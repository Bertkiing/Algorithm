package leecode.array

/**
 * @author bertking
 * @date 2020/1/9
 * https://leetcode-cn.com/problems/pascals-triangle/
 */
fun main(args: Array<String>) {
    println(generate(8))
}

fun generate(numRows: Int): List<List<Int>> {
    val lists = arrayListOf<List<Int>>()
    for (i in 0 until numRows) {
        val list = arrayListOf<Int>()
        for (j in 0..i) {
            if (j == 0 || j == i) {
                list.add(1)
            } else {
                list.add(lists[i - 1][j - 1] + lists[i - 1][j])
            }
        }
        lists.add(list)
    }
    return lists
}


