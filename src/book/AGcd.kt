package book

/**
 * @author bertking
 * @date 2019/7/15
 */

fun main(args: Array<String>) {
    val result = gcd(0, 15)
    println(result)
}



fun gcd(p: Int, q: Int): Int {
    if (q == 0) {
        return p
    }

    var r = p % q
    return gcd(q,r)
}