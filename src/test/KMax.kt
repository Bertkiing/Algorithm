package test

/**
 * @author bertking
 * @date 2019/3/11
 */

fun main(args: Array<String>) {
    val a = 1
    val b = 2
    val c = 3
    println(maxOf(a, b, c))


    val d = 0.8
    println(d == 2.0)

//    IChartViewDraw ---- Car
//    Index  ----------   Color

    var list = arrayListOf<Car<*>>()

    list.add(Audi())
    val element = BMW()
    val bmwColor = BMWColor()
    bmwColor.getColor()
    element.printColor(bmwColor)
    list.add(element)

}


interface Color {

}


class BMWColor : Color {
    fun getColor(){
        println("M")
    }
}

class AudiColor : Color {

}


interface Car<T> {
    fun printColor(t: T)
}

class BMW : Car<BMWColor> {
    override fun printColor(t: BMWColor) {
        println("BMW ...")
    }

}

class Audi : Car<AudiColor> {
    override fun printColor(t: AudiColor) {
        println("Audi ...")
    }

}