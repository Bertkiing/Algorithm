package test;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author bertking
 * @date 2019/11/9
 * https://blog.csdn.net/qq_40507857/article/details/81198662
 * 1.状态设计：dp[i]代表以a[i]结尾的LIS的长度
 * 2.状态转移：dp[i]=max(dp[i], dp[j]+1) (0<=j< i, a[j]< a[i])
 * 3.边界处理：dp[i]=1 (0<=j< n)
 * 4.时间复杂度：O(N^2)
 * <p>
 * array(数组): 1, 7, 3, 5, 9, 4, 8
 * dp[i]的值:   1, 2, 2, 3, 4, 4, 5
 */
public class LIS_Test {
    int[] dp = new int[100];

    private int LIS(int[] data) {
        int ans = 1;
        for (int i = 0; i < data.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (data[i] > data[j]) {
                    System.out.println("data[i] = " + dp[i] + ",data[j] = " + dp[j]);
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                } else {
                    System.out.println("=========data1[i] = " + data[i] + ",data1[j] = " + data[j]);
                }
            }
            ans = Math.max(ans, dp[i]);
            System.out.println("=the result:" + ans + ",dp[" + i + "] =" + dp[i]);

        }
        return ans;
    }

    private int length4LTS(int[] data) {
        if (data == null || data.length == 0) {
            return 0;
        }

        ArrayList<Integer> dp = new ArrayList<>();
        dp.add(data[0]);

        for (int i = 0; i < data.length; i++) {
            if (dp.contains(data[i])) {
                continue;
            } else if (data[i] > dp.get(dp.size() - 1)) {
                dp.add(data[i]);
            } else if (data[i] < dp.get(dp.size() - 1)) {
                int l = 0;
                int h = dp.size() - 1;
                while (l < h) {
                    int mid = (l + h) / 2;
                    if (dp.get(mid) < data[i]) {
                        l = mid + 1;
                    } else {
                        h = mid;
                    }
                }
                dp.set(h, data[i]);
            }
        }
        return dp.size();
    }

    private int length4LTS2(int[] data) {
        if (data == null || data.length == 0) {
            return 0;
        }



        ArrayList<Integer> dp = new ArrayList<>();
        dp.add(data[0]);

        for (int aData : data) {
            if (dp.contains(aData)) {
                continue;
            }

            if (aData > dp.get(dp.size() - 1)) {
                dp.add(aData);
            } else if (aData < dp.get(dp.size() - 1)) {
                int low = 0;
                int high = dp.size() - 1;

                for (int j = 0; j < high; j++) {
                    int mid = (low + high) / 2;
                    if (dp.get(mid) > aData) {
                        high = mid;
                    } else {
                        low = mid - 1;
                    }
                }
                dp.set(high, aData);
            }
        }
        return dp.size();
    }


    public static void main(String[] args) {
//        System.out.println("请输入个数n:");
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
        int n = 7;
//        int[] data =  {1,7,3,5,9,4,8};
        int[] data = {0};
//        System.out.println("请依次输入:");
//        for (int i = 0; i < n; i++) {
//            data[i] = scanner.nextInt();
//        }
//
//        System.out.println("-----------" + data.length);
//        for (int i = 0; i < n; i++) {
//            System.out.println(data[i]);
//        }
        LIS_Test test = new LIS_Test();
        System.out.println("Result:" + test.LIS(data));
        System.out.println("--------------" + test.length4LTS2(data));
    }

}
