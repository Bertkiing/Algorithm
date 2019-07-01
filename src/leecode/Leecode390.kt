package leecode

/**
 * @author bertking
 * @date 2019/2/13
 *
 * https://segmentfault.com/a/1190000018129567
 *
 * https://leetcode.com/problems/elimination-game/discuss/87116/Java-Recursion-and-Proof
 */



fun main(args: Array<String>) {
   println(lastRemaining(4))
}

fun lastRemaining(n: Int): Int {
    return if (n == 1) {
        1
    } else {
        2 * (1 + n / 2 - lastRemaining(n / 2))
    }
}