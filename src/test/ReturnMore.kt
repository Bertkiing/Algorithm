package test

import java.util.*

/**
 * @author bertking
 * @date 2019/7/24
 * 使用Pair<T,K> & Tripe<T,K,L> 返回多个参数
 *
 * 使用vararg关键字实现边长参数
 */
fun main(args: Array<String>) {
    println("———使用Pair让函数返回两个值———")
    println("Pair:${returnMore2()}")
    println("Pair first value :${returnMore2().first}")
    println("Pair second value :${returnMore2().second}")

    println("———使用Triple让函数返回三个值———")
    println("Tripe:${returnMore3()}")
    println("Tripe first value :${returnMore3().first}")
    println("Tripe second value :${returnMore3().second}")
    println("Tripe second value :${returnMore3().third}")

    println("--使用vararg关键字来实现不定长度参数--")
    moreParams("A", "B", "C", "D", "E", "F", "G")
    println()
    moreParams("AE86", "FC", "FD", "R32", "EVO")

    println()
    val strings = arrayOf("B", "E", "R", "T", "K", "I", "N", "G")
    moreParams(*strings)

    println()
    val list = arrayListOf<String>()
    list.add("D")
    list.add("L")
    moreParams(*(list.toTypedArray()))

}

/**
 * 函数返回2个值
 */
fun returnMore2(): Pair<String, Int> {
    return Pair("bertking", 27)
}

/**
 * 函数返回3个值
 */
fun returnMore3(name: String = "Bertking"): Triple<String, Int, Boolean> {
    if (name == "Bertking") {
        return Triple(name, 27, true)
    } else {
        return Triple(name, 20, false)
    }
}

/**
 * 使用vararg关键字不定参数
 */
fun moreParams(vararg names: String) {
    names.forEach { print("$it,") }
}