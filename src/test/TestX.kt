package test

/**
 * @author bertking
 * @date 2019/8/9
 */

fun main(args: Array<String>) {
//    val list = ArrayList<Int>()
//    for (i in 1..10) {
//        list.add(i)
//    }
//
//    add(list)


    var value = ""
    println(value.takeLast(3))

}

private fun add(list: ArrayList<Int>) {
    var sum = 0
    val start = System.currentTimeMillis()

    println("取List的前n个元素:take() ${list.take(2)}")
    println("取List的后n个元素:takeLast() ${list.takeLast(2)}")
    println("从前面取满足条件的元素:takeWhile() ${list.takeWhile { it < 3 }}")
    println("从后面取满足条件的元素:takeLastWhile() ${list.takeLastWhile { it > 3 }}")

    println(list.dropWhile {
        it < 3
    })

    println("耗时:${System.currentTimeMillis() - start},sum=$sum")


}

private fun add3(list: ArrayList<Int>) {
    var sum = 0
    val start = System.currentTimeMillis()
    sum = list.reduce { acc, i ->
        i + acc
    }
    println("耗时:${System.currentTimeMillis() - start},sum=$sum")
}


private fun add2(list: ArrayList<Int>) {
    //    println(list)
    val start = System.currentTimeMillis()
    var sum = 0
    for (i in list) {
        if (i == 0) {
            sum = 0
        } else {
            sum += i
        }
    }
    println(sum)
    println("耗时:${System.currentTimeMillis() - start},sum=$sum")
}

private fun add1(list: ArrayList<Int>) {
    var sum = 0
    val start = System.currentTimeMillis()
    list.forEach {
        var key = it
//        println("the key:$key")
        val lastWhile = list.takeWhile {
            it <= key
        }
//        println("阶段Last:$lastWhile")

        sum = lastWhile.sum()

//        println("阶段Sum:$sum")
    }
    println("耗时:${System.currentTimeMillis() - start},sum=$sum")
}