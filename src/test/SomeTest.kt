package test

/**
 * @author bertking
 * @date 2019/9/27
 */
fun main(args: Array<String>) {
    countOne(11)
    println("--------------------")
    countOne2(11)

}

/**
 * 推荐使用
 */
fun countOne(num: Int): Int {
    println("$num 的二进制形式:${Integer.toBinaryString(11)}")
    var temp = num
    var count = 0
    while (temp != 0) {
        temp = temp and temp - 1
        count++
    }
    println("$num 的二进制形式中所含1的个数:${count}")
    return count
}


fun countOne2(num: Int): Int {
    println("$num 的二进制形式:${Integer.toBinaryString(11)}")
    var temp = 1
    var count = 0
    while (temp != 0) {
        if(num.and(temp) != 0){
            count++
        }
        temp = temp shl 1
    }
    println("$num 的二进制形式中所含1的个数:${count}")
    return count
}