package leecode

/**
 * @author bertking
 * @date 2020/1/19
 * https://labuladong.gitbook.io/algo/dong-tai-gui-hua-xi-lie/dong-tai-gui-hua-xiang-jie-jin-jie
 */

fun main(args: Array<String>) {
    println("Result:${fib(2)}")
}

/**
 *根据斐波那契数列的状态转移方程，当前状态只和之前的两个状态有关，
 * 其实并不需要那么长的一个 DP table 来存储所有的状态，
 * 只要想办法存储之前的两个状态就行了。所以，可以进一步优化，把空间复杂度降为 O(1)
 */
fun fib(N: Int): Int {
    if (N == 0) {
        return 0
    }

    if (N == 1) {
        return 1
    }

    var prev = 1
    var cur = 1

    for (i in 3..N){
        var sum = prev + cur
        prev = cur
        cur = sum
    }
    return cur
}


/**
 * 动态规划
 */
fun fib2(N: Int): Int {
    val dp = Array<Int>(N + 1) { 0 }

    dp[0] = 0
    dp[1] = 1
    for (i in 2..N) {
        dp[i] = dp[i - 1] + dp[i - 2]
    }
    return dp[N]
}

/**
 * 递归
 */
fun fib5(N: Int): Int {
    return when (N) {
        1 -> 1
        0 -> 0
        else -> fib5(N - 1) + fib5(N - 2)
    }
}