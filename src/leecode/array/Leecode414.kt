package leecode.array

/**
 * @author bertking
 * @date 2020/1/10
 */
fun main(args: Array<String>) {
    var array = intArrayOf(1,2,2,1)
    println("Result:${thirdMax(array)}")
}


fun thirdMax(nums: IntArray): Int {
    val set = HashSet<Int>()
    for (n in nums){
        set.add(n)
    }


    val index = if (set.size > 2) 2 else 0
    return set.toList().sortedDescending()[index]
}

