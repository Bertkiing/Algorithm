package test;

import java.util.Scanner;

/**
 * @author bertking
 * @date 2019/11/5
 * <p>
 */
public class P1028Test {
    public static void main(String[] args) {
        System.out.print("输入一个整数:");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.print("输入结果:" + n);
        System.out.println("方案1:"+ answer1(n));


        System.out.println("方案2:" + answer2(n));

        System.out.println("方案3:" + finalAnswer(n));

    }

    /**
     * 发现规律: ans[i] = ans[i/2](i从1累计和) + 1
     *
     * @param n
     */
    private static int answer1(int n) {
        System.out.println("----------------");
        int[] array = new int[n + 1];
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ",");
        }
        System.out.println();
        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= i >> 1; j++) {
                array[i] += array[j];
            }

            array[i]++;
        }

        System.out.println("方案数：" + array[n]);
        System.out.println("-----------------");
        for (int i = 1; i < array.length; i++) {
            System.out.println(i + " = " + array[i]);
        }
        return array[n];
    }

    static int result = 1;

    /**
     * 0分
     * 递归暴搜：TLE
     *
     * @param count
     * @return
     */
    public static int answer2(int count) {
        for (int i = 1; i <= count >> 1; i++) {
            answer2(i);
            result++;
        }

        return result;
    }

    /**
     * DP：
     * <p>
     * ans[2n+2] = ans[2n+1] + ans[n+1]
     * <p>
     * 状态转移方程:
     * <p>
     * ans[n]  = ans[n/2]+ans[n−1] （n为偶数）
     * ans[n]  = ans[n−1]          （n为奇数）
     * ans[n]  = 1                 （n=1）
     *
     * @param n
     */
    public static int finalAnswer(int n) {
        int[] arr = new int[n+1];
        arr[1] = 1;
        for (int i = 2; i <= n; i++) {
            if (i % 2 == 0) {
                arr[i] = arr[i-1]+arr[i/2];
            } else {
                arr[i] = arr[i-1];
            }
        }
        for (int i = 1; i < arr.length; i++) {
            System.out.println(i + " = " + arr[i]);
        }
        return arr[n];
    }
}
