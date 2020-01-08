package test.slidingwindow

import kotlin.math.min

/**
 * @author bertking
 * @date 2019/12/19
 */
fun main(args: Array<String>) {
    val s = "ADOBECODEBANC"
    val t = "ABC"
    println(minWindow(s, t))
}

fun minWindow(s: String, t: String): String {

    var start = 0
    var left = 0
    var right = 0
    var minLen = Int.MAX_VALUE

    var needs = HashMap<Char, Int>()
    var windows = HashMap<Char, Int>()

    t.forEach {
        needs[it] = needs.getOrDefault(it, 0) + 1
    }
    println(needs)

    var match = 0

    while (right < s.length) {
        val c = s[right]
        if (needs.containsKey(c)) {
            windows[c] = windows.getOrDefault(c, 0) + 1

            if (windows[c] == needs[c]) {
                match++
            }
        }

        right++


        while (match == needs.size) {
            println(match)
            if (right - left < minLen) {
                start = left
                minLen = right - left
            }
            if(left < s.length){
                println("s[left] = "+s[left])
                val c1 = s[left]
                if (needs.contains(c1)) {
                    windows[c1] = windows.getValue(c1) - 1
                    if(windows[c1]!! < (needs[c1] ?: 0)){
                        match --
                    }
                }
            }
            left ++
        }
    }

    return if(minLen == Int.MAX_VALUE)  "" else s.substring(start, minLen-1)

}