package leecode

/**
 * @author bertking
 * @date 2020/1/3
 * https://leetcode-cn.com/problems/longest-common-prefix/
 */
fun main(args: Array<String>) {
    val array = arrayOf("dog","racecar","car")
    println("resutl:${longestCommonPrefix3(array)}")
}

/**
 * 暴力破解(水平扫描法)
 * 缺点:数组的后面有一个非常短的字符串，依然要进行数组长度的比较。
 */
fun longestCommonPrefix(strs: Array<String>): String {

    var comPrefix = ""
    return if (strs.isEmpty()) {
        comPrefix
    } else {
        /**
         * 找出最小值更耗性能
         */
//        strs.sortBy { it.length }
//        println("排序后:${strs.toList()}")
        comPrefix = strs[0]
        for (i in 1 until strs.size) {
            /**
             * 使用indexOf 比 startsWith节约时间
             */
            while (strs[i].indexOf(comPrefix) != 0) {
                comPrefix = comPrefix.substring(0, comPrefix.length - 1)
            }
        }
        comPrefix
    }
}


/**
 * 分治算法
 * https://leetcode-cn.com/problems/longest-common-prefix/solution/zui-chang-gong-gong-qian-zhui-by-leetcode/
 */
fun longestCommonPrefix2(strs: Array<String>): String {
    if (strs.isEmpty()) {
        return ""
    } else {
        return longestCommonPrefix2(strs, 0, strs.lastIndex)
    }

}


fun longestCommonPrefix2(strs: Array<String>, start: Int, end: Int): String {
    return if (start == end) {
        strs[start]
    } else {
        var mid = (start + end) / 2
        val leftLCP = longestCommonPrefix2(strs, 1, mid)
        val rightLCP = longestCommonPrefix2(strs, mid + 1, end)
        commonPrefix(leftLCP,rightLCP)
    }

}

fun commonPrefix(left:String, right:String):String{
    val min = Math.min(left.length, right.length)
    for (i in 0..min){
        if(left[i] != right[i]){
            return left.substring(0,i)
        }
    }
    return left.substring(0,min)
}


/**
 * 水平扫描法(竖直扫描更贴切)
 *
 *
 * 最坏情况: 数据为n个长度为m个相同的字符串，算法会进行S = m * n 次比较
 * 最好情况: 将进行 S = n * minLen次比较。
 */
fun longestCommonPrefix3(strs: Array<String>): String{

    if(strs.isEmpty()){
        return ""
    }

    val comPrefix = strs[0]
    for (i in 0 until comPrefix.length){

        val c = comPrefix[i]

        for (j in 0 until strs.size){
            val eachLine = strs[j]
            if(i == eachLine.length || eachLine[i] != c ){
                return comPrefix.substring(0,i)
            }
        }

    }
    return comPrefix
}