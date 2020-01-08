package test.sequences

/**
 * @author bertking
 * @date 2019/11/15
 * 斐波那契数列
 * 1、1、2、3、5、8、13、21、34、……
 * 在数学上，斐波那契数列以如下被以递推的方法定义：F(1)=1，F(2)=1, F(n)=F(n-1)+F(n-2)（n>=3，n∈N*）
 */
fun main(args: Array<String>) {
    println("暴力破解: "+fib(7))
    println("带备忘录的递归: "+enhanceFib(7))
    println("动态规划: "+ dPFib(7))
}

/**
 * 一:暴力的递归算法
 *
 * PS：但凡遇到需要递归的问题，最好都画出递归树，这对你分析算法的复杂度，寻找算法低效的原因都有巨大帮助。
 *
 * 递归算法的时间复杂度计算:子问题个数乘以解决一个子问题所需要的时间。
 *
 * 子问题个数，即递归树中节点的总数。显然二叉树节点总数为指数级别，所以子问题个数为 O(2^n)。
 *
 * TODO 动态规划问题的第一个性质：重叠子问题
 */
fun fib(n: Int): Int {
    if (n == 1 || n == 2) return 1
    return fib(n - 1) + fib(n - 2)
}

/**
 * 二:带备忘录的递归解法
 * 带「备忘录」的递归算法，把一棵存在巨量冗余的递归树通过「剪枝」，
 * 改造成了一幅不存在冗余的递归图，极大减少了子问题（即递归图中节点）的个数
 * 时间复杂度:O(n),比起暴力算法，是降维打击。
 *
 * 带备忘录的递归解法的效率已经和动态规划一样了。
 * 实际上，这种解法和动态规划的思想已经差不多了，只不过这种方法叫做「自顶向下」，
 * 动态规划叫做「自底向上」。
 */
fun enhanceFib(n: Int): Int {
    if (n < 1) return 0
    // 初始化 "备忘录"
    val list = arrayListOf<Int>()
    for (i in 0..n) {
        list.add(0)
    }

    // 初始化 "最简单情况"
    list[1] = 1
    list[2] = 1
    return noteBook(list, n)

}

/**
 * 备忘录
 */
fun noteBook(list: ArrayList<Int>, n: Int): Int {
    /**
     * list[n] == 0 此处表示"没有被计算过"
     */
    if (n > 0 && list[n] == 0) {
        list[n] = noteBook(list, n - 1) + noteBook(list, n - 2)
    }
    return list[n]
}

/**
 * 三：动态规划
 */
fun dPFib(n: Int): Int {
    /**
     * dp-table。
     */
//    var dp = List(n+1) {
//        0
//    }
//    dp = ArrayList(dp)

    val dp = Array(n+1){
        0
    }
    /**
     * 这里需要注意：dp[0] 空闲不使用。
     */
    dp[1] = 1
    dp[2] = 1
    for (i in 3..n) {
        dp[i] = dp[i - 1] + dp[i - 2]
    }
    return dp[n]
}
