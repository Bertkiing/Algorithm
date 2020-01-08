package thread_review;

import java.util.concurrent.*;

/**
 * @author bertking
 * @date 2019/12/23
 */
public class TestCallableAndFuture {
    public static void main(String[] args) {
        runCallable();
        System.out.println("----------");
        runFutureTask();
    }

    private static void runCallable() {
        //1.实例化任务对象
        ServiceTask task = new ServiceTask();
        //2.实例化Executor框架中的线程池
        ExecutorService executor = Executors.newCachedThreadPool();
        //3.使用submit方法将任务提交给线程池
        Future<Integer> submit = executor.submit(task);
        //4.关闭线程池
        executor.shutdown();
        System.out.println("正在执行任务...");
        try {
            Thread.sleep(1000);
            // 这里使用Future的get()来获取执行结果
//            System.out.println("运行结果为:" + submit.get());

            //如果超时未取到结果，则抛出TimeoutException
            System.out.println(submit.get(1, TimeUnit.SECONDS));

        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            e.printStackTrace();
        }
    }

    private static void runFutureTask()
    {
        //1.实例化任务对象
        ServiceTask task = new ServiceTask();
        //2.实例化Executor框架中的线程池
        ExecutorService executor = Executors.newCachedThreadPool();

        /**
         * FutureTask是Future的实现类
         * public class FutureTask<V> implements RunnableFuture<V>{}
         *
         * public interface RunnableFuture<V> extends Runnable, Future<V> {}
         */
        FutureTask<Integer> result = new FutureTask<>(task);

        //3.使用submit方法将任务提交给线程池
        executor.submit(result);
        //4.关闭线程池
        executor.shutdown();
        System.out.println("正在执行任务...");
        try {
            Thread.sleep(1000);
            // 这里使用FutureTask的get()来获取执行结果
            System.out.println("运行结果为:" + result.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}

/**
 * 实现 Callable<T>
 */
class ServiceTask implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        Thread.sleep(2000);
        int result = 0;
        /**
         * 模拟很庞大的计算
         */
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                result += j;
            }
        }
        return result;
    }
}


