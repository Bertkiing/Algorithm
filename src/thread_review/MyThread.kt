package thread_review

/**
 * @author bertking
 * @date 2019/8/9
 *
 *
 *
 *
 *
 */
class MyThread : Thread() {
    override fun run() {
        this.priority = 3
        for (i in 0.rangeTo(400)) {
            println("当前线程名称:${Thread.currentThread().name},优先级:${isAlive}")
        }
    }
}

fun main(args: Array<String>) {
    val thread = MyThread()

//    println("当前线程名称:${thread.name},isAlive:${thread.isAlive}")
////    thread.join(5000)
//    println("当前线程名称:${thread.name},isAlive:${thread.isAlive}")

    for (i in 0.rangeTo(4000)) {
        println("当前线程名称:${Thread.currentThread().name}")
        if (i == 100) {
            thread.start()
            thread.join(500)
        }

        if(i==501){
            println("线程死活:${thread.isAlive}")
        }

    }
}