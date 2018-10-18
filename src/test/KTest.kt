package test

import java.math.BigDecimal
import java.text.DecimalFormat
import java.text.NumberFormat

fun main(args: Array<String>) {
    var value1:Double= 0.0001029
    println(value1)

    var value2 = 0.00004
    var numberFormat = NumberFormat.getInstance()
    numberFormat.isGroupingUsed = false
    // https://blog.csdn.net/huanghanqian/article/details/78035966
    numberFormat.maximumFractionDigits = 18
    println(numberFormat.format(value2))


    var bigDecimal = BigDecimal(value2.toString())
    println(value2.toString())
    println(bigDecimal.toString().toFloat())


}