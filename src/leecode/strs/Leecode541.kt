package leecode.strs

/**
 * @author bertking
 * @date 2020/1/15
 *
 *541. 反转字符串 II
 *
 * https://leetcode-cn.com/problems/reverse-string-ii/
 */
fun main(args: Array<String>) {
    val s = "abcdefg"
    println("Result:${reverse(s.toCharArray(),0,1)}")
}

/**
 * 相邻反转
 */
fun reverse(s: CharArray, low: Int, high: Int): String {
    var i = low
    var j = Math.min(s.size - 1, high)
    while (i < j) {
        var c = s[i]
        s[i] = s[j]
        s[j] = c

        i++
        j--
    }
    return String(s)
}


fun reverseStr(s: String, k: Int): String {
    var result = ""
    var cur = 0

    var length = s.length

    while (length >= 2 * k) {
        result += (s.substring(cur, cur + k).reversed()) + (s.substring(cur + k, cur + 2 * k))
        cur += 2 * k
        length -= 2 * k
    }

    // 特殊情况
    if (length < k) {
        result += s.substring(cur).reversed()
    } else if (length < 2 * k) {
        result += (s.substring(cur, cur + k).reversed()) + (s.substring(cur + k, cur + 2 * k))
    }
    return result
}


/**
 * 类似"分页"算法
 *
 * 本质上代码只需要判断<=k即可，
 * 如果满足就交换，然后指针再移k位，如果超过s结尾即结束；不超过继续+k
 */
fun reverseStr2(s: String, k: Int): String {

    val pageSize = if (s.length % k == 0) s.length / k else s.length / k + 1
    var result = ""

    for (i in 0 until pageSize) {

        val start = i * k
        /**
         * 避免数组越界
         */
        val end = Math.min(s.length, (i + 1) * k)

        val s1 = s.substring(start, end)

        println("S1 : $s1")

        if (i % 2 == 0) {
            result += s1.reversed()
        } else {
            result += s1
        }
    }
    return result

}

fun reverseStr5(s: String, k: Int): String {
    var a = s.toCharArray()

    for (start in 0 until s.length step 2 * k) {
        var i = start
        var j = Math.min(start + k - 1, s.length - 1)
        while (i < j) {
            var tmp = a[i]
            a[i++] = a[j]
            a[j--] = tmp
        }
    }
    return String(a)
}
