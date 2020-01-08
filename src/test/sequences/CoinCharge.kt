package test.sequences

/**
 * @author bertking
 * @date 2019/11/19
 */
class CoinCharge {

}

fun main(args: Array<String>) {
    val coins = arrayListOf<Int>(5, 5, 1)
    println(coinCharge(coins, 11))
    println("---------------------------")
    println(enhancedCoinCharge(coins,11))

}

/**
 * 一：暴力递归
 * @param coins 硬币种类
 * @param amount 金额
 */
fun coinCharge(coins: ArrayList<Int>, amount: Int): Int {
    if (amount == 0) return 0
    var result: Int = Int.MAX_VALUE
    for (coin in coins) {
        if (coin > amount) continue
        // 子问题
        val subResult = coinCharge(coins, amount - coin)
        // 子问题无解
        if (subResult == -1) continue

        result = Math.min(result, subResult + 1)
    }
    return if (result == Int.MAX_VALUE) -1 else result
}

fun enhancedCoinCharge(coins: ArrayList<Int>, amount: Int): Int {
    // 初始化备忘录
    val  memo = arrayListOf<Int>()
    for (e in 0..amount+1){
        memo.add(-2)
    }
    println("初始化便签:$memo")
    return helper(coins,amount,memo)
}

/**
 * @param coins
 * @param amount
 * @param memo(备忘录,便签)
 *
 * 所谓的备忘录，即通过"空间换时间"，
 * 备忘录都是通过List or 数组 or 字典 来存放当前下标下的方案
 */
private fun helper(coins: ArrayList<Int>, amount: Int, memo: ArrayList<Int>): Int {
    if (amount == 0) return 0
    if (memo[amount] != -2) return memo[amount]
    var result = Int.MAX_VALUE
    for (coin in coins) {
        if (amount < coin) continue

        val subResult = helper(coins, amount - coin, memo)
        // 子问题无解
        if (subResult == -1) continue

        result = Math.min(result, subResult + 1)
    }
    memo[amount] = if (result == Int.MAX_VALUE) -1 else result
    println("开始后的便签$result,$amount:$memo")
    return memo[amount]
}