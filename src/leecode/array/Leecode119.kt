package leecode.array

/**
 * @author bertking
 * @date 2020/1/9
 */
fun main(args: Array<String>) {
    println(getRow(3))
}

/**
 * 为了节省内存，使用一个数组来记录前一个数组的值
 */
fun getRow(rowIndex: Int): List<Int> {
    var dp = Array<Int>(rowIndex + 1) { 0 }
    dp[0] = 1

    for (i in 1..rowIndex) {
        /**
         * 求第i行，则先需要给第i-1行后面补个1。
         *
         * 然后从 倒数第2项 --> 正数第2项 PS:每一项等于该项与前一项之和。
         *
         * 想想为何只能倒着算
         */
        for (j in i.downTo(1)) {
            dp[j] = dp[j] + dp[j - 1]
        }

        println("第${i}行:${dp.toList()}")
    }
    return dp.toList()
}


fun getRow1(rowIndex: Int): List<Int> {
    var dp = Array<Int>(rowIndex) {
        1
    }

    for (i in 2 until dp.size) {
        for (j in (i - 1).downTo(1)) {
            dp[j] = dp[j] + dp[j - 1]
            println("i:$i =  ${dp[j]}")
        }
    }
    return dp.toList()
}