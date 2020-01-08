package leecode.palindromic

/**
 * @author bertking
 * @date 2020/1/7
 *
 * 结论: 偶数字母数 + 大于2的奇数字母数-1 + 为1的字符
 *
 * "abaac"
 *
 * 包含大小写字母的情况下，数组只需开辟58个空间即可
 * A的ASCII是65，a是97，所以最大z是122，122-65+1=58
 * 所以开辟58的数组就行。
 *
 * int [26] 用于字母 ‘a’ - ‘z’ 或 ‘A’ - ‘Z’
 * int [58] 用于字母 ‘a’ - ‘z’ 且 ‘A’ - ‘Z’
 * int [128] 用于ASCII码
 * int [256] 用于扩展ASCII码
 *
 *
 *
 */
fun main(args: Array<String>) {
    var s = "ddd"
    println("Result:${longestPalindrome2(s)}")


//    val array = Array<Int>(10){0}
//    println(array.toList())

}


fun longestPalindrome(s: String): Int {
    val map = HashMap<Char, Int>()
    var count = 0
    for (i in 0 until s.length) {
        if (map.containsKey(s[i])) {
            map.remove(s[i])
            count += 2
        } else {
            map[s[i]] = 1
        }
        println("MAP:$map,count:$count")
    }

    return count + (if (map.size > 0) 1 else 0)
}

/**
 * 统计元素个数法
 * https://leetcode-cn.com/problems/longest-palindrome/solution/zui-chang-hui-wen-chuan-by-leetcode/
 */
fun longestPalindrome11(s: String): Int {
    /**
     * 保存各个元素的出现的次数
     */
    val array = Array<Int>('z' - 'A' + 1) { 0 }

    /**
     * 第一次循环的目的是统计字母出现次数
     */
    for (c in s.toCharArray()) {
        array[c - 'A']++
    }
    println("Proceed:${array.toList().size}")
    println("Proceed:${array.toList()}")

    var ans = 0
    /**
     * 第二次循环是计算成对字母的长度
     */
    for (c in array) {
        /**
         * 当count中元素的个数是 >= 2时
         * 如 aaa 2 ; aaaa 4
         */
        ans += c / 2 * 2
    }

    /**
     * 这里：只要字符串长度大于结果，说明一定有不成对的出现，加一返回即可
     */
    if (s.length > ans) ans++

    return ans
}


fun longestPalindrome1(s: String): Int {
    /**
     * 保存各个元素的出现的次数
     */
    val array = Array<Int>('z' - 'A' + 1) { 0 }

    /**
     * 第一次循环的目的是统计字母出现次数
     */
    for (c in s.toCharArray()) {
        array[c - 'A']++
    }
    println("Proceed:${array.toList().size}")
    println("Proceed:${array.toList()}")

    var ans = 0
    /**
     * 第二次循环是计算成对字母的长度
     */
    for (c in array) {
        /**
         * 当count中元素的个数是 >= 2时
         * 如 aaa 2 ; aaaa 4
         */
        ans += c / 2 * 2

        /**
         * 这里 c % 2 == 1,即这个字符就只能是回文串中唯一的那个中心,且只能有一个
         */
        if (c % 2 != 0 && ans % 2 == 0) {
            ans += 1
        }
    }
    return ans
}


/**
 * 标记法
 * https://leetcode-cn.com/problems/longest-palindrome/solution/409-zui-chang-hui-wen-chuan-by-en-zhao/
 */
fun longestPalindrome2(s: String): Int {
    /**
     * 保存各个元素的出现的次数
     */
    val array = Array<Int>('z' - 'A' + 1) { 0 }

    var ans = 0

    for (c in s.toCharArray()) {
        if (array[c - 'A'] == 0) {
            array[c - 'A'] = 1
        } else if (array[c - 'A'] == 1) {
            ans += 2
            array[c - 'A']--
        }
    }

    println("Proceed:${array.toList()}")

    /**
     * 允许有一个单独的字符
     */
    for (i in array) {
        if (i == 1) {
            ans++
            break
        }
    }

    return ans
}