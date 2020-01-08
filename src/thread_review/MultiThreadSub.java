package thread_review;

/**
 * @author bertking
 * @date 2019/12/20
 */
public class MultiThreadSub {
    public static void main(String[] args) {
        MyRunnable thread = new MyRunnable();

        for (int i = 9; i >= 0; i--) {
            Thread thread1 = new Thread(thread, "name =" + i);
            thread1.start();
        }

    }
}

class MyRunnable implements Runnable {
    private  int count = 10;

    @Override
     public void run() {
        count--;
        System.out.println("线程:" + Thread.currentThread().getName() + ",count = " + count);
    }
}
