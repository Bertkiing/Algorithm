package test;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.*;


/**
 * @author bertking
 * @date 2019/7/23
 * <p>
 * equals VS ==
 * https://stackoverflow.com/questions/767372/string-equals-versus?rq=1
 */
public class ExecutorTest {
    public static void main(String[] args) throws InterruptedException {

        String name = "bertking";
        String nick = new String("bertking");
        System.out.println(name.equals(nick));
        System.out.println(nick == name);



        System.out.println("-------------Executors.newCachedThreadPool()---------------");
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();

        Thread thread1 = new Thread(new MyRunnable());
        Thread thread2 = new Thread(new MyRunnable());
        Thread thread3 = new Thread(new MyRunnable());
        Thread thread4 = new Thread(new MyRunnable());

        newCachedThreadPool.execute(thread1);
        newCachedThreadPool.execute(thread2);
        newCachedThreadPool.execute(thread3);
        newCachedThreadPool.execute(thread4);

        Thread.sleep(100);
        System.out.println("------------newFixedThreadPool()------------");
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(2);
        newFixedThreadPool.execute(thread1);
        newFixedThreadPool.execute(thread2);
        newFixedThreadPool.execute(thread3);

        Thread.sleep(100);
        System.out.println("------------newSingleThreadExecutor()------------");
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        newSingleThreadExecutor.execute(thread1);
        newSingleThreadExecutor.execute(thread2);

        Thread.sleep(100);
        System.out.println("------------newScheduledThreadPool()------------");
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(2);
//        newScheduledThreadPool.schedule(thread1,5,TimeUnit.SECONDS);
//        newScheduledThreadPool.schedule(thread2,5,TimeUnit.SECONDS);
//        newScheduledThreadPool.schedule(thread3,5,TimeUnit.SECONDS);
//
        newScheduledThreadPool.scheduleAtFixedRate(thread1, 0, 1, TimeUnit.SECONDS);
//        newScheduledThreadPool.scheduleAtFixedRate(thread2,1,1,TimeUnit.SECONDS);

        newScheduledThreadPool.scheduleWithFixedDelay(thread1, 0, 1, TimeUnit.SECONDS);


        /****推荐使用带有ThreadFactory的ThreadPoolExecutor构造函数****/
        Thread.sleep(100);
        newScheduledThreadPool.shutdown();
        System.out.println("---------ThreadPoolExecutor---------");
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2,
                3,
                60,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue(1),
                new MyThreadFactory(),
                // 谨慎使用
                new ThreadPoolExecutor.CallerRunsPolicy()
        );
        threadPoolExecutor.execute(thread1);
        threadPoolExecutor.execute(thread2);
        threadPoolExecutor.execute(thread3);
        threadPoolExecutor.execute(thread4);

    }

    static class MyThreadFactory implements ThreadFactory {

        @Override
        public Thread newThread(@NotNull Runnable r) {
            Thread thread = new Thread(r);
            thread.setName("Thread_Factory:");
            return thread;
        }
    }

    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "Running...");
        }
    }
}
