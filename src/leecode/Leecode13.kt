package leecode

/**
 * @author bertking
 * @date 2020/1/3
 */


fun main(args: Array<String>) {
    var roman = "III"
    println("$roman = ${romanToInt3(roman)}")
}

/**
 * 要找出其中的规律：
 * 妙:
 * https://leetcode-cn.com/problems/roman-to-integer/solution/yong-shi-9993nei-cun-9873jian-dan-jie-fa-by-donesp/
 *
 * 精粹在于:其实只要每次比较后一个和前一个的值的大小关系即可：
 * 前值小于后值，减去前值
 * 前值大于或等于后值，加上前值
 * 最后一个值必然是加上的
 *
 */
fun romanToInt(s: String): Int {
    var s = s
    var sum = 0

    var preNum = romanUnit(s[0])
    for (i in 1 until s.length) {
        var curNum = romanUnit(s[i])
        /**
         * 这里必须先判断 "<"
         */
        if (preNum < curNum) {
            sum -= preNum
        } else {
            sum += preNum
        }
        preNum = curNum
    }
    sum += preNum

    return sum
}

fun romanToInt3(s: String): Int {
    var s = s
    var sum = 0
    var hashMap = hashMapOf<String, Int>(
            "M" to 1000,
            "D" to 500,
            "C" to 100,
            "L" to 50,
            "X" to 10,
            "V" to 5,
            "I" to 1
    )


    var preNum = hashMap[s[0].toString()] ?: 0

    for (i in 1 until s.length) {
        var curNum = hashMap[s[i].toString()] ?: 0

        if (preNum < curNum) {
            sum -= preNum
        } else {
            sum += preNum
        }

        preNum = curNum
    }

    sum += preNum

    return sum
}


fun romanUnit(s: Char): Int {
    return when (s.toString()) {
        "I" -> {
            1
        }

        "V" -> {
            5
        }

        "X" -> {
            10
        }

        "L" -> {
            50
        }

        "C" -> {
            100
        }

        "D" -> {
            500
        }

        "M" -> {
            1000
        }

        else -> 0
    }
}

/**
 * 先特殊再一般
 */
fun romanToInt2(s: String): Int {
    var s = s
    var sum = 0
    val array = arrayOf("CM", "CD", "XC", "XL", "IX", "IV")
    val intValueArray = intArrayOf(900, 400, 90, 40, 9, 4)
    for (i in 0 until array.size) {
        val unit = array[i]
        if (s.contains(unit)) {
            sum += intValueArray[i]
            println("SUM:$sum")
            s = s.replaceFirst(unit, "")
        }
    }

    println("S:$s")
//    sum += romanToInt(s)

    return sum
}


fun romanUnit2(s: String): Int {
    return when (s) {
        "I" -> {
            1
        }

        "V" -> {
            5
        }

        "X" -> {
            10
        }

        "L" -> {
            50
        }

        "C" -> {
            100
        }

        "D" -> {
            500
        }

        "M" -> {
            1000
        }

        "IV" -> {
            4
        }

        "IX" -> {
            9
        }

        "XL" -> {
            40
        }

        "XC" -> {
            90
        }

        "CD" -> {
            400
        }

        "CM" -> {
            900
        }
        else -> 0
    }
}