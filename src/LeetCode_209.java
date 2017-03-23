
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA
 * User: BertKing
 * Date: 2017/3/23
 * Time: 22:03
 * Project-Name: algorithm
 * Relate-link: https://leetcode.com/problems/minimum-size-subarray-sum/#/description
 */
public class LeetCode_209 {
    public static void main(String[] args) {

        int[] values = {2,3,1,2,4,3};
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个整数:");
        int i = scanner.nextInt();
        System.out.println("方案1:" + minSubArrayLeng(i,values));
        System.out.println("方案2:"+ minSubArrayLength(i,values));
        System.out.println("方案3:"+minSubArrayLen2(i,values));
        System.out.println("方案4:"+minSubArrayLen3(i,values));

    }

    /*********
     *
     * 暴力破解法
     简要思路为，对输入的数组中的每一个元素，分别计算出能够满足s条件的最小的数组的长度。
     *
     * *****/

    public static int minSubArrayLeng(int s, int[] nums){
        int cnt = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum = 0;
            cnt = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                cnt ++;
                if(sum >= s){
                     min = Math.min(min, cnt);
                    break;//防止超时
                }
            }
        }
       return min == Integer.MAX_VALUE ? 0:min;
    }


    /*****
     * Two Pointer 法
     * 简要思路为：在输入的数组中，通过两个指针的移动来找出满足s条件的最小的数组的长度
     * *******/

    public static  int minSubArrayLen2(int s,int[] nums){
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max += nums[i];
        }
        if(max < s)  return 0;

        int start = 0;
        int count = nums.length;
        int sum = 0;

        for (int end = 0; end < nums.length; end++) {
            sum += nums[end];

            if(sum >= s){
                while (start < end && (sum-nums[start] >= s)){
                    sum = sum - nums[start];
                    start ++;
                }
                count = Math.min(count,end-start +1);
            }
        }
        return count;
    }

    public static int minSubArrayLength(int s,int[] nums){
        if(nums == null || nums.length == 0) return 0;
        int min = 0,sum = 0,start = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >=s && start <= i){
                if(min == 0 || i-start+1 <min) min = i -start +1;
                sum -= nums[start++];
            }
        }

        return min ;
    }

    /****
     * 二分法
     * 参考自：http://mp.weixin.qq.com/s/ylPFaqmsjfBf1BDN1AB9CQ
     */
    public static int minSubArrayLen3(int s,int[] nums){
        if( nums == null || nums.length == 0) return 0;
        int beginLen = 1,endLen = nums.length,minLen = 0;
        while (beginLen <= endLen){
            int midLen = (beginLen+endLen) / 2;
            if(checkWithLen(midLen,s,nums)){
                endLen = midLen - 1;
                minLen = midLen;
            }else {
                beginLen = midLen + 1;
            }
        }
        return  minLen;
    }

    public static boolean checkWithLen(int len,int s,int[] nums){
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if(i >= len) sum -= nums[i -len];
            sum += nums[i];
            if(sum >= s) return true;
        }
        return false;
    }


}
