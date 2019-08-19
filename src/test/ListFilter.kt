package test

/**
 * @author bertking
 * @date 2019/8/16
 *
 * 开发中使用：
 * Kotlin中：
 * 需要将String转化为Int时，切忌直接toInt()
 * 而是应该在合理的评估范围后，谨慎选择toBigInteger() OR toInt()
 *
 * Java中：
 *      Integer.parseInt(value)
 *      BigInteger(value)
 */

fun main(args: Array<String>) {
    var list = arrayListOf<Int>()
    for (i in 0..10) {
        list.add(i)
    }

    val filter = list.filter {
        it % 2 == 0
    }

    println("filter:${filter}")

    list.removeAll(filter)
    println("remove all :$list")
    list.addAll(0, filter)
    println(list)


    val test = "2222222222"
    // println("${test.toInt()}")//NumberFormatException
    println("使用toBigInteger:${test.toBigInteger()}")



}

