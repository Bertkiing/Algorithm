package thread_review;

/**
 * @author bertking
 * @date 2019/8/12
 * <p>
 * wait()方法：阻塞当前线程等待notify(),notifyAll()方法的唤醒 或者 等待超时自动唤醒
 */
public class TestWait {
    /**
     * 此方法必须使用关键字synchronized修饰
     * 否则throw IllegalMonitorStateException
     */
    public synchronized void runWait(int i) {
        System.out.println("------Start------" + i);
        try {
            wait(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("------End------" + i);
    }

    public static void main(String[] args) {
        TestWait testWait = new TestWait();
        new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                testWait.runWait(i);
            }
        }).start();
    }

}
