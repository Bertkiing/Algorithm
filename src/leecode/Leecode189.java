package leecode;

import java.util.Arrays;

/**
 * @author Bertking
 * <p>
 * 目前都是使用额外空间来解决的： time - O(n); space - O(n)
 * <p>
 * For 北美 ，面试还能遇到很多的
 * @题目 https://leetcode.com/problems/rotate-array/description/
 */
public class Leecode189 {

    /***
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        if (k <= 0) return;
        int length = nums.length;

        if (nums == null || length < 2) return;

        /**
         * 这个我们其实会发现，如果k == n * nums.length , 数组将会恢复原状。
         */
        while (k > nums.length) {
            k -= nums.length;
        }

        int[] temp = new int[length + k];
        for (int i = 0; i < length; i++) {
            temp[k + i] = nums[i];
        }

        System.out.println(Arrays.toString(temp));

        for (int i = 0; i < k; i++) {
            temp[i] = temp[length + i];

//            temp[i] = temp[temp.length];

        }

        System.out.println(Arrays.toString(temp));

        /**
         * 复制数组
         */
        int[] ints = Arrays.copyOf(temp, length);

        for (int i = 0; i < length; i++) {
            nums[i] = ints[i];
        }

        System.out.println(Arrays.toString(nums));

    }


    public static void main(String[] args) {
        Leecode189 leecode189 = new Leecode189();
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        leecode189.rotate(nums, k = 3);
        System.out.println(Arrays.toString(nums));

        System.out.println("------------------");
        int[] nums2 = {1, 2};
        int k2 = 6;
        leecode189.rotate(nums2, k2);
        System.out.println(Arrays.toString(nums2));
        System.out.println("------------------");
        int[] num3 = {1, 2};
        int k3 = 6;
        leecode189.rotate2(num3, k3);
        System.out.println(Arrays.toString(num3));
        System.out.println("------------------");
        int[] num4 = {1, 2};
        int k4 = 6;
        leecode189.rotate3(num4, k4);
        System.out.println(Arrays.toString(num3));

        System.out.println("---------5th-------------");
        int[] nums5 = {1, 2, 3,4,5,6,7};
        int k5 = 3;
        leecode189.rotate4(nums5, k5);

    }

    /**
     * 此算法非常漂亮
     * 但是其
     * 时间复杂度O(n)
     * 空间复杂度也为O(n)
     *
     * @param nums
     * @param k
     */
    public void rotate2(int[] nums, int k) {
        int[] temp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            temp[(i + k) % nums.length] = nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = temp[i];
        }

    }


    public void rotate3(int[] nums, int k) {

        while (k > nums.length) {
            k -= nums.length;
        }

        int[] tempArray;
        tempArray = Arrays.copyOf(nums, nums.length);

        for (int i = 0; i < nums.length; i++) {
            int swapToIndex = i + k;
            if (swapToIndex > nums.length - 1) {
                swapToIndex -= nums.length;
            }
            nums[swapToIndex] = tempArray[i];
        }
    }


    /**
     * 空间复杂度O(1)
     * 时间复杂度O(n)
     * @param nums
     * @param k
     */
    public void rotate4(int[] nums, int k) {
        int length = nums.length;
        k %= length;

        /**
         * 1. 先将数组整体翻转；
         * 2. 翻转 n - k 部分；
         * 3. 再翻转剩下的k部分；
         */

//        reverse(nums,0,nums.length-1);
//        System.out.println(Arrays.toString(nums));
//        reverse(nums,0,k-1);
//        System.out.println(Arrays.toString(nums));
//        reverse(nums,k,nums.length -1);
//        System.out.println(Arrays.toString(nums));

        /**
         * 必须将数组分为： n- k  & k这两个部分；
         * 1. 翻转 n - k 部分；
         * 2. 翻转 k 部分；
         * 3。合并后再全部翻转。
         */
        reverse(nums, 0, length - 1 - k);
        System.out.println(Arrays.toString(nums));

        reverse(nums, length-k, length - 1);
        System.out.println(Arrays.toString(nums));
//
        reverse(nums, 0, length - 1);
        System.out.println(Arrays.toString(nums));

    }


    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            start++;
            end--;
        }
    }


}
