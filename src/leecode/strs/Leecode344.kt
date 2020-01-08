package leecode.strs

/**
 * @author bertking
 * @date 2020/1/8
 */
fun main(args: Array<String>) {
    val array = "hello".toCharArray()
    println("Normal:${array.toList()}")
    println("Result:${reverseString(array)}")
}

/**
 * 双指针
 */
fun reverseString0(s: CharArray) {
    var i = 0
    var j = s.size - 1

    while (i < j) {

        val temp = s[i]
        s[i] = s[j]
        s[j] = temp

        i++
        j--
    }

    println(s.toList())
}

/**
 * 两种写法
 */
fun reverseString(s: CharArray) {

    var reversedIndex = s.size - 1

    val midPoint = s.size / 2

    for (j in 0 until midPoint) {
        val temp = s[j]
        s[j] = s[reversedIndex]
        s[reversedIndex] = temp
        reversedIndex --
    }

    println(s.toList())
}


/***
 * 内部实现
 */
fun reverseString1(s: CharArray) {
    println("Result:${s.reverse()}")
}