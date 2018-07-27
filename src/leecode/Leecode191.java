package test;





/**
 * 题目：
 * 相关知识：https://zh.wikipedia.org/wiki/%E6%B1%89%E6%98%8E%E9%87%8D%E9%87%8F
 * 解法：https://leetcode.com/articles/number-1-bits/
 */
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        String string = Integer.toBinaryString(n);
        System.out.println(string);
        int count = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.hammingWeight(11);
        System.out.println(i);


        int mask = 1;
        System.out.println("-------左移运算--------");

        for (int j = 1; j < 5; j++) {
            System.out.println(mask << j);
            System.out.println(Integer.toBinaryString(mask << j));
        }

        System.out.println("----------------");

        System.out.println(solution.hammingWeight2(11));

        System.out.println(solution.hammingWeight3(11));
    }


    public int hammingWeight2(int n) {
        int count = 0;
        int mask = 1;

        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                count++;
            }
            /**
             * 左移一位
             */
            mask <<= 1;
        }
        return count;
    }

    /**
     * https://leetcode.com/articles/number-1-bits/
     * @param n
     * @return
     */
    public int hammingWeight3(int n){
        int count = 0;
        while (n != 0){
            count++;
            /**
             * 要理解n * (n-1)的本质
             */
            n &= (n-1);
        }
        return count;
    }
}
