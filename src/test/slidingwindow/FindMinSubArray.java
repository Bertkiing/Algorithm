package test.slidingwindow;


/**
 * @author bertking
 * @date 2019/12/
 *
 * 题目：209. 长度最小的子数组
 *
 * <p>
 * https://leetcode-cn.com/problems/minimum-size-subarray-sum/solution/cxiang-xi-ti-jie-hua-dong-chuang-kou-by-youlookdel/
 */
public class FindMinSubArray {
    public static void main(String[] args) {
        int[] array = {5, 1, 3, 5, 10, 7, 4, 9, 2, 8};
        int sum = 18;
        System.out.println("长度最小的子数组为:" + minSubArrayLength(sum, array));
        System.out.println("----------------------------------");
        System.out.println("长度最小的子数组为:" + minSubArrayLength2(sum, array));
    }

    static int minSubArrayLength(int s, int[] array) {
        // 滑动窗口中值的和
        int windowSum = 0;
        // 窗口的左边界
        int left = -1;
        // 子串长度
        int ans = Integer.MAX_VALUE;
        // 这里的i其实：滑动窗口的右边界
        for (int i = 0; i < array.length; i++) {
            while (windowSum + array[i] >= s) {
                /**
                 * 凡是涉及"滑动窗口的问题"都需要一个比较的过程
                 */
                ans = Math.min(i - left, ans);
                System.out.println("ans = " + ans+": left = "+left);
                windowSum -= array[left + 1];
                left += 1;
            }
            windowSum += array[i];
        }
        return ans;
    }


    static int minSubArrayLength2(int s, int[] array) {
        // 子串长度
        int ans = Integer.MAX_VALUE;
        // 滑动窗口中值的和
        int windowSum = 0;
        // 窗口的左边界
        int left = 0;
        //滑动窗口的右边界
        int right = 0;
        while (right < array.length){
            if(windowSum + array[right] <s){
                windowSum += array[right];
                right ++;
            }else {
                if(right - left+1 < ans){
                    ans = right - left +1;
                }
                windowSum -= array[left];
                left++;
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

}
