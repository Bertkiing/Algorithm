package test

/**
 * @author bertking
 * @date 2020/1/17
 */
fun main(args: Array<String>) {
    val n = 10
    var count = 0
    var list = arrayListOf<Int>()

    for (i in n.downTo(2)){
        println("I = $i")
        if(judge(i)){
            list.add(i)
            count++
        }
    }

    println("小于$n 的质数个数$count,列表为$list")
}

fun judge(num: Int): Boolean {
    for (i in 2 until Math.sqrt(num.toDouble()).toInt()+1) {
        if (num % i == 0) {
            return false
        }
    }
    return true
}