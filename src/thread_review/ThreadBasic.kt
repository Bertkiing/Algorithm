package thread_review

/**
 * @author bertking
 * @date 2019/7/2一条单独的执行流，拥有自己的程序计数器,栈
 * 线程的基本概念：
 * 1. 线程表示
 */
class ThreadBasic : Thread() {
    /**
     * run()有点类似于单线程程序中的main()，线程从run()的第一条语句开始执行，直到结束
     */
    override fun run() {
        println("Thread name:${Thread.currentThread().name}")
        println("Hello,thread...")
    }
}

/**
 * Java 是单继承, So need implement Runnable接口实现线程
 */
class BasicRunnable:Runnable{
    override fun run() {
        println("Thread-name:${Thread.currentThread().name}")
        println("Hello,Thread by Runnable...")
    }
}



fun main(args: Array<String>) {
    val threadDemo = ThreadBasic()
    /**
     * 这里我们会发现:调用start() & run() 都是可以工作的，两者的区别是？
     *
     * start():表示启动该线程，使其成为一条单独的执行流。OS会分配线程相关的资源，每个线程会有各自的PC & 栈。OS会把这个线程作为一个独立的个体进行调度，
     * 分配时间片让其执行，执行的起点就是run()方法。
     *
     * 不调用start(),而直接调用run(): 其run()会执行，但是其是执行的main 线程中的，run()只不过是普通方法调用。
     *
     * 感觉两者的区别类似于:
     * 1. 直接start()：出行直接叫辆滴滴
     * 2. 直接run()： 出行挤公交车
     */
    threadDemo.start()
//    threadDemo.run()

    println("---------------------------")
    /**
     * 无论是通过继承Thread OR Runnable 接口来创建线程... 启动线程都是调用start()
     */
    val thread = Thread(BasicRunnable())
    thread.start()




}