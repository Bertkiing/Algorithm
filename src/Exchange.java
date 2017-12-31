/**
 * Created by king on 2018/1/1.
 * <p>
 * 交换两个变量的值
 * 具体理解：可以参考
 * http://blog.csdn.net/beyond1123/article/details/52156347
 * <p>
 * 利用异或运算来进行交换两个变量，纯粹是为了应付变态的面试题而已：
 * http://blog.csdn.net/solstice/article/details/5166912
 */
public class Exchange {
    public static void main(String[] args) {
        int a = 2;
        int b = 3;
        exchange(a, b);
        System.out.println("--------------");
        exchange1(a, b);
        System.out.println("--------------");
        exchange2(a, b);

    }

    /**
     * 利用临时变量
     *
     * @param m
     * @param n
     */
    private static void exchange(int m, int n) {
        int temp = m;
        m = n;
        n = temp;
        System.out.println(" m = " + m + "\n n = " + n);
    }

    /**
     * 要避免 a + b 越界
     *
     * @param a
     * @param b
     */
    private static void exchange1(int a, int b) {
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println(" a = " + a + "\n b = " + b);
    }

    /**
     * 异或操作
     * <p>
     * 异或操作的性质：
     * 1.任意一个变量与其自身进行异或运算，结果为0;即 X ^ X  = 0;
     * 2.任何一个变量与0 进行异或运算，结果不变；即 X ^ 0 = X
     * 3.异或运算具有可结合性；即 X^ Y ^ C = (X ^ Z) ^ C = X ^ (Y ^ Z);
     * 4.异或运算具有可交换性：即 A ^ B = B ^ A
     * 由上可以得出如下结论：
     * 一个数异或另一个数两次，该数不变。
     * 参考自：http://blog.csdn.net/beyond1123/article/details/52156347
     * <p>
     * <p>
     * 避免两个变量相同
     *
     * @param x
     * @param y
     */
    private static void exchange2(int x, int y) {
        x = x ^ y;
        y = x ^ y;
        x = x ^ y;
        System.out.println(" x = " + x + "\n y = " + y);
    }


}
