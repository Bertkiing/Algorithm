package test;

/**
 * @author bertking
 * @date 2019/7/23
 * <p>
 * Throwable 的两个直接子类: Exception & Error
 * <p>
 * Error: 不允许捕获
 * <p>
 * Exception 的分为Checked异常 和Runtime异常
 * <p>
 * 粗略地讲RuntimeException(类) & CheckedException(接口)
 * <p>
 * <p>
 * https://blog.csdn.net/derekjiang/article/details/4845757
 * <p>
 * https://blog.csdn.net/Androidlushangderen/article/details/54984681
 *
 * Thread下的中断相关的方法:
 * 1. isInterrupted() 判断Thread的中断状态
 * 2.
 *    interrupted() ---> 返回Thread的中断状态并清除中断状态(即:如果中断状态为true,则调用该方法后置其为false，若为false，则仅仅返回中断状态，此时等同于isInterrupted()
 *    interrupt() ---> 将线程的中断状态置为true...
 *
 */
public class TestException {
    public static void main(String[] args) {
        System.out.println("初始中断状态：" + Thread.currentThread().isInterrupted());
        Thread.currentThread().interrupt();
        System.out.println("执行完interrupt方法后，中断状态：" + Thread.currentThread().isInterrupted());

        System.out.println("首次调用interrupted方法返回结果：" + Thread.currentThread().interrupted());
        System.out.println("此时中断状态：" + Thread.currentThread().isInterrupted());
//        Thread.currentThread().interrupt();
        System.out.println("第二次调用interrupted方法返回结果：" + Thread.currentThread().interrupted());
        System.out.println("此时中断状态：" + Thread.currentThread().isInterrupted());

        System.out.println("------------");
    }
}
