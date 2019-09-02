package test

/**
 * @author bertking
 * @date 2019/8/22
 */
fun main(args: Array<String>) {

    val list1 = arrayListOf<Int>()
    for (i in 0..5) {
        list1.add(i)
    }
    list1[2] = 10
    println("list1 = $list1")

    val list2 = arrayListOf<Int>()
    for (i in 0..5) {
        list2.add(i)
    }

    println("list2 = $list2")


    list1.removeAll(list2)
    println("list1 - list2 = $list1)}" )
//    list2.removeAll(list1)
//    println("list2 - list1 = $list2" )

}