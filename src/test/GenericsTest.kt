package test

import java.lang.IllegalArgumentException
import kotlin.math.PI

/**
 * @author bertking
 * @date 2019/10/22
 */
class GenericsTest {


}

fun main(args: Array<String>) {
    val boxInt = Box<Int>(1)
    println(boxInt.value)


    val boxString = Box<String>("box")
    println(boxString.value)


    val value = boxTypeValue(5)

    actionByType(1)
    actionByType("hello")
    actionByType(PI)

    printDoubleValue(1.toDouble())
    printDoubleValue(null)

    sort(listOf(1,3,5,7,9))

//    sort(listOf(arrayOf(1,2)))

    onlyCanUseIntOrString(PI)


}

/**
 * 泛型类
 */
class Box<T>(t:T){
    var value = t
}

/**
 * Kotlin 泛型函数的声明与 Java 相同，类型参数要放在函数名的前面
 */
fun <T> boxTypeValue(value:T) = Box(value)

/**
 * 根据不同类型做处理
 */
fun <T> actionByType(value: T){
    when(value){
        is Int -> {
            println("Int value :$value")
        }
        is String -> {
            println("String value :$value")
        }

        is Double -> {
            println("Double value :$value")
        }
    }
}

/*******************泛型约束**********************
 *
 * 使用泛型约束来设定一个给定参数允许使用的类型
 *
 * Kotlin 中使用 : 对泛型的类型上限进行约束
 *
 * **/
/**
 * 1.约束泛型的类型只能为Double的子类，默认是Any?
 */
fun <T:Double?> printDoubleValue(t:T){
    println(t)
}

fun <T:Comparable<T>> sort(list: List<T>){
    println(list.sorted())
}

fun <T> onlyCanUseIntOrString(t:T){
    when(t){
        is Int -> { println("OK")}
        is String ->  { println("OK")}
        else -> {
            throw IllegalArgumentException("参数类型不匹配")
        }
    }
}

