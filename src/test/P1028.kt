package test

/**
 * @author bertking
 * @date 2019/11/4
 */
class P1028 {
}

fun main(args: Array<String>) {
    println("Input a  number please:")
    val readLine = readLine()
    val n = readLine?.toInt() ?:0
    println("输入:$n")

    val array = arrayListOf<Int>()
    array[0] = 0
    array[1] = 0

    for (ele in array){
        println(ele)
    }

    for (i in (1..n)){

        for (j in (1..i/2)){

        }
        array[i] = array[i-1]+1
        println(array[i])
    }

}