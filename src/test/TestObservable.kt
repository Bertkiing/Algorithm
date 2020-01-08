package test

import kotlin.concurrent.thread


/**
 * @author bertking
 * @date 2019/12/17
 * ThreadLocal的解析：https://www.jianshu.com/p/bfba89d53977
 *
 *
 */
fun main(args: Array<String>) {
    // 通过ThreadLocal修饰的变量可以实现在各个线程之间互不干扰，相互隔离的效果
    val threadLocal = ThreadLocal<String>()

    threadLocal.set("AAA")

    Thread {
        threadLocal.set("BBB")
        println("get in "+ Thread.currentThread().name + " "+threadLocal.get())
    }.start()

    thread(start = true){
        threadLocal.set("CCC")
        println("get in c "+ Thread.currentThread().name + " "+threadLocal.get())
    }

    println("get in main "+ Thread.currentThread().name + " "+threadLocal.get())

    /**
     * 通过这个打印结果来看，我们有理由猜想ThreadLocal<T>是通过Map<Thread,T>来实现的
     * 其中key是当前的thread.value 就是通过set 或者initialValue设置的。
     *
     * 真相只有一个，ThreadLocal内部并不是这么实现的。
     */

}