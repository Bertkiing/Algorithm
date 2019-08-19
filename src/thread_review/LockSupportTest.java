package thread_review;

import java.util.concurrent.locks.LockSupport;

/**
 * @author bertking
 * @date 2019/8/14
 *
 * @ref http://ifeve.com/locksuppor-source/
 * @ref https://www.jianshu.com/p/f1f2cd289205
 *
 * <p>
 * JUC(java.util.concurrent)
 * <p>
 * LockSupport和CAS一样是JUC很多控制机制的基础(其底层都是依赖Unsafe)
 * <p>
 * 关于LockSupport的分析：
 * <p>
 * LockSupport类主要有两个方法:
 * 1. park() 阻塞当前线程.是否阻塞取决于permit是否可用
 * （permit相当于1，0的开关，default：0.）调用unpark()就将其+1，变成1。但是调用多次不会累积。（Unlike with Semaphores
 *  though, permits do not accumulate. There is at most one）
 *  如果permit == 0, 或者发生如下3种情况:
 *   (1. 其它线程调用unpark()
 *   (2. 其它线程interrupt()该线程
 *   (3. The call spuriously (that is, for no reason) returns.
 *
 * 2. unpark() 对于给定线程，让permit变为可用
 *
 */
public class LockSupportTest {
    public static void main(String[] args) {
//        test1();
//        test2();
        test3();
    }

    /**
     * 第一次阻塞不会执行，第二次阻塞才会执行
     * 因为unpark()函数不会累计
     */
    private static void test3() {
        System.out.println("====start======");
        LockSupport.unpark(Thread.currentThread());
        LockSupport.unpark(Thread.currentThread());
        LockSupport.parkNanos(1000000000);
        LockSupport.parkNanos(1000000000);
        System.out.println("====end======");
    }

    /**
     * 不会阻塞
     * 因为当前线程调用unpark()，相当于给了一个permit
     */
    private static void test2() {
        System.out.println("====start======");
        LockSupport.unpark(Thread.currentThread());
        LockSupport.parkNanos(1000000000);
        System.out.println("====end======");
    }

    private static void test1() {
        System.out.println("====start======");
        LockSupport.parkNanos(1000000000);
        System.out.println("====end======");
    }
}
