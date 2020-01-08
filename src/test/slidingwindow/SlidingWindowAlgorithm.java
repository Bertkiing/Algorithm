package test.slidingwindow;


/**
 * @author bertking
 * @date 2019/12/6
 * <p>
 * Sliding window algorithm，
 * 滑动窗口算法
 * <p>
 * <p>
 * <p>
 * 经典问题
 * 给定一组大小为n的整数数组，计算长度为k的子数组和的最大值
 */
public class SlidingWindowAlgorithm {
    public static void main(String[] args) {
        int[] array = {-1, 4, 7, -3, 8, 5, -2, 6};
        int maxFromSubArray = getMaxFromSubArray(array, 3);
        System.out.println("最大子数组的和:" + maxFromSubArray);
        int maxFromSubArray2 = getMaxFromSubArray2(array, 3);
        System.out.println("最大子数组的和:" + maxFromSubArray2);
    }

    /**
     * 暴力破解 ———— 遍历所有子数组，求和比较
     *
     * @param array
     * @param k
     * @return
     */
    private static int getMaxFromSubArray(int[] array, int k) {
        if (array == null || array.length == 0) {
            return 0;
        }

        // 记录最大子数组第一个元素的下标
        int index = 0;
        // 记录最大子数组和
        int maxSum = 0;
        for (int i = 0; i < k; i++) {
            maxSum += array[i];
        }

        /**
         * 遍历所有子数组，求和并比较
         * 注意这里的起始下标为 1
         */
        for (int i = 1; i < array.length - k + 1; i++) {
            int curSum = 0;
            /**
             * 计算当前子数组的和
             * 注意这里是 i + j
             */
            for (int j = 0; j < k; j++) {
                curSum += array[i + j];
            }

            // 对所有的子数组和进行比较，并记录最大值
            if (curSum > maxSum) {
                maxSum = curSum;
                index = i;
                System.out.println("Index:" + index);
            }
        }
        return maxSum;
    }

    /**
     * 滑动窗口(Sliding window algorithm)
     *
     * 精髓：遍历时不嵌套循环计算所有值
     *
     * 即:外层遍历相当于「窗口向右移动，每次减去失效值，加上最新值」,即为当前窗口的和。然后进行再比较
     *
     * @param array
     * @param k
     * @return
     */
    private static int getMaxFromSubArray2(int[] array, int k) {
        int index = 0;
        int maxSum = 0;
        for (int i = 0; i < k; i++) {
            maxSum += array[i];
        }

        int curWindowSum = maxSum;
        for (int i = 1; i < array.length - k + 1; i++) {
            /**
             * 重点在这里：
             * 这里的i从1开始
             * 减去失效值(i-1)，加上最新值[k+(i-1)]
             */
            curWindowSum = curWindowSum - array[i - 1] + array[k + i - 1];

            if(curWindowSum > maxSum){
                maxSum = curWindowSum;
                index = i;
                System.out.println("最大子数组的第一个元素的下标:"+index);
            }
        }
        return maxSum;
    }
}
