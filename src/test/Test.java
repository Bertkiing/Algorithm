package test;

import java.util.concurrent.*;

/**
 * 想更好的理解Callable,
 * <p>
 * 首先需要对Runnable的缺点:
 * 1. 无法获取返回值；
 * 2. 无法抛出一般异常(Checked Exception)，只能自己处理
 * <p>
 * 为了弥补Runnable的缺点，故引入Callable接口
 * 1. 先就第一点而言, 由于Callable会有返回值，但是别忘了本质是异步的，这就给获取结果带来了不确定性。另外也不确定到底是是否发生了异常。
 * 所以就引入了Future接口。
 * <p>
 * Future:
 * 由于返回结果不确定性，获取是一个阻塞式的操作，只有任务执行完了才返回，否则阻塞。
 * 所以Future接口就有了两个get()方法,阻塞的&非阻塞的
 * <p>
 * 因此 Future 必须跟Callable搭配在一起使用
 * <p>
 * 多线程的两种方式:
 * 1. 线程池
 * 2. 单开线程(即必须使用一个Thread来启动)
 * 到这里就尴尬了,Thread的构造函数只有接收Runnable,而且Runnable执行完并没有返回值。
 * <p>
 * So... FutureTask横空出世,该类同时继承Runnable,Future接口。
 * 这样就顺理成章的,把它传给Thread,然后开启线程获取结果。
 * (本质上可以把FutureTask看成是扩展的Runnable接口)
 * <p>
 * Callable
 * <p>
 * Future & Runnable ---> RunnableFuture ---> FutureTask
 * 关于RunnableFuture存在的significance(意义)
 * https://stackoverflow.com/questions/25092787/why-does-java-util-concurrent-runnablefuture-have-a-run-method
 */
public class Test {
    public static void main(String[] args) {
        Integer i = new Integer(6);
        int ii = 6;

        System.out.println(i == ii);
        System.out.println(i.equals(ii));

        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();


        /**
         * Callable 接口
         */
        MyCallable myCallable = new MyCallable();

        /**
         * 由于Thread的构造函数只支持Runnable
         * 所以才有了FutureTask;
         * FutureTask既继承Future接口,又继承Runnable接口
         */

        try {
            FutureTask<String> futureTask = new FutureTask<>(myCallable);
            Thread threadFutureTask = new Thread(futureTask);
            threadFutureTask.start();
            System.out.println(futureTask.get());
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }


        //   Executor  ---> ExecutorService ----> AbstractExecutorService ---> ThreadPoolExecutor

    }


}


class MyRunnable implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            System.out.println(1 / 0);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("有异常...");
        }
        System.out.println("Runnable当前线程:" + Thread.currentThread().getName());
        System.out.println("Runnable ...");
    }
}

class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(100);
        System.out.println("Callable当前线程:" + Thread.currentThread().getName());
        return "Hello,Callable";
    }
}
