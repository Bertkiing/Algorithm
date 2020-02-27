package leecode.strs

import com.sun.jdi.IntegerValue

/**
 * @author bertking
 * @date 2020/1/14
 *
 * 67. 二进制求和
 * https://leetcode-cn.com/problems/add-binary/
 */
fun main(args: Array<String>) {
    var a = "1010"
    var b = "1011"
    println(a.toInt(2).toString().toInt(2))

    println(   addBinary5(a, b))
}

/**
 * 溢出
 */
fun addBinary5(a: String, b: String): String {
   val sum =  a.toInt(2) + b.toInt(2)
    return Integer.toBinaryString(sum)
}