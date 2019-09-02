package test

/**
 * @author bertking
 * @date 2019/9/2
 *
 * @href https://blog.csdn.net/u013064109/article/details/78786646
 *
 * 总结:
 * 1.let,also在中括号中必须用「it.属性」来获取对象的方法和属性
 * 2.with，apply，run可以直接写属性
 * 3. apply , also 的返回值是调用对象
 * 4. run 可以完美替代 let, also
 */
fun main(args: Array<String>) {
//    testApply()
//    testLet()
//    testWith()
//    testRun()
    testAlso()
}


/**
 * let函数:
 * 在函数块内可以通过 it 指代该对象。
 * 返回值:函数块的最后一行或指定return表达式。
 * 用法：object.let{}
 * 1. 在{}中用it代替object来访问其共有的属性和方法
 * 2. object?.let{} 避免对object的一系列判空操作或者一堆?.
 * 3. 作用域函数，明确一个变量特定作用域范围内使用
 */
fun testLet() {
    val name = "Hello,World"
    name.let {
        val split = it.split(",")
        it.toLowerCase()
        println("split[0]=${split[0]}")
        println("lowercase:${it.toLowerCase()}")
    }

    var string: String? = null
    string = "bert"
    val let: Int = string?.let {
        println("The string is $string")
        1000
    }
    println("let表达式返回最后一条语句的值:$let")

}

/**
 * with函数：
 * 使用方式:with(object){ }
 * 在函数块内可以通过 this 指代该对象。
 * 返回值:函数块的最后一行或指定return表达式。
 *
 * 适用场景:
 * 调用同一个类的多个方法or属性时，可以省去类名重复，直接调用类的方法即可
 */
fun testWith() {
    val name = "Bertking"
    /**
     * 由于with函数最后一个参数是一个函数，可以把函数提到圆括号的外部
     */
    with(name, {
        println("The name is $name, it's length = ${length}")
    })
    println("----------with的后一个参数{}放后面----------")
    val with = with(name) {
        println("The name is $name, it's length = ${name.length}")
        1000
    }
    println("with函数值:$with")
}

/**
 * run函数:
 * 一般用法: object.run{ }
 * run函数实际上可以说是let和with两个函数的结合体
 * 返回值:最后一行的值或者指定的return的表达式
 *
 * 使用场景:适用于let,with函数任何场景。
 * 因为run函数是let,with两个函数结合体，准确来说
 * 1.弥补了let函数在函数体内必须使用it参数替代对象，在run函数中可以像with函数一样可以省略，直接访问实例的公有属性和方法，
 * 2.弥补了with函数传入对象判空问题，在run函数中可以像let函数一样做判空处理
 */
fun testRun() {
    val autoCar: AutoCar? = AutoCar("BMW", "white")
    val run = autoCar?.run {
        println("The car branch is $branch, and the color is $color")
        1000
    }
    println("run函数的返回值:$run")
}

/**
 * apply函数
 * 一般用法:object.apply{ }
 * 从结构上来看apply函数和run函数很像，唯一不同点就是它们各自返回的值不一样
 *  run函数是以闭包形式返回最后一行代码的值，
 *  apply函数的返回的是传入对象的本身。
 */
fun testApply() {
    val list = arrayListOf<Int>()
    for (i in 0.rangeTo(5)) {
        list.add(i)
    }

    /**
     * apply函数:返回其调用对象本身
     */
    val apply = list.apply {
        add(100)
        add(1000)
        println(get(0))
    }

    println(apply)

    println("--------------------------")

    val arrayList = arrayListOf<Int>()
    arrayList.apply {
        try {
            println(arrayList[0])
        } catch (e: Exception) {
            e.printStackTrace()
            println("异常信息:${e.message}")
        }
    }
}

/**
 * also函数
 * 一般用法: object.also{ }
 * 适用于let函数的任何场景。
 * 和let函数的卫衣差别是:
 * let的返回值: 最后一行的返回值
 * also的返回值：返回当前的这个对象
 *
 */
fun testAlso() {
    val car = AutoCar("BenZ", "black")
    val also = car.also {
        println("The car branch is ${it.branch}, and the color is ${it.color}")
    }
    println("also函数的返回值为:$also")
    println("----------------------")
    val let = car.let {
        println("The car branch is ${it.branch}, and the color is ${it.color}")
        1000
    }
    println("let函数的返回值为:$let")


}


data class AutoCar(var branch: String, var color: String)