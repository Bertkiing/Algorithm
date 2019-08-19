package thread_review;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author bertking
 * @date 2019/8/14
 * LockSupport
 * https://www.jianshu.com/p/f1f2cd289205
 */
public class MutilThreadTest {
    public static void main(String[] args) {
        Counter counter = new Counter();
        safeAdd2(counter);
    }

    private static void safeAdd1(Counter counter) {
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(() -> counter.addLock());
            thread.start();
        }
    }

    private static void safeAdd2(Counter counter) {
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(() -> counter.normalAdd());
            thread.start();
        }

    }


    private static void safeAdd(Counter counter) {
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(() -> counter.addSynchronized());
            thread.start();
        }
    }


    static class Counter {
        ReentrantLock lock = new ReentrantLock();
        public  int count = 0;
        public synchronized void addSynchronized() {
            try {
                Thread.sleep(1000);
                count += 1;
                System.out.println(Thread.currentThread().getName() + ":" + count);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void addLock() {
            try {
                lock.lock();
                Thread.sleep(1000);
                count += 1;
                System.out.println(Thread.currentThread().getName() + ":" + count);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }


        public  void normalAdd() {
            try {
//                Thread.sleep(1000);
                Thread.currentThread().wait(1000);
                count += 1;
                System.out.println(Thread.currentThread().getName() + ":" + count);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


