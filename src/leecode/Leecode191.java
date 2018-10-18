package leecode;


/**
 * @author bertking
 * @date 2018 - 7-27 -21-30
 * <p>
 * 题目：https://leetcode.com/problems/number-of-1-bits/description/
 * 相关知识：https://zh.wikipedia.org/wiki/%E6%B1%89%E6%98%8E%E9%87%8D%E9%87%8F
 * 解法：https://leetcode.com/articles/number-1-bits/
 */
public class Leecode191 {
    // you need to treat n as an unsigned value


    /**
     * 我自己的最LOW解法
     *
     * @param n
     * @return
     */
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
        Leecode191 leecode191 = new Leecode191();
        int i = leecode191.hammingWeight(11);
        System.out.println(i);


        int mask = 1;
        System.out.println("-------左移运算--------");

        for (int j = 1; j < 5; j++) {
            System.out.println(mask << j);
            System.out.println(Integer.toBinaryString(mask << j));
        }

        System.out.println("----------------");

        System.out.println(leecode191.hammingWeight2(11));

        System.out.println(leecode191.hammingWeight3(11));

        System.out.println(leecode191.hammingWeight4(11));

        System.out.println(leecode191.hammingWeight5(11));

        System.out.println(leecode191.hammingWeight6(11));

        System.out.println("-------测试使用--------");

        System.out.println(-8 >>> 1);
        System.out.println(13 >>> 1);
        System.out.println(10 & 1);
    }

    /**
     * 循环&翻转
     *
     * @param n
     * @return
     */
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
     * 最优解
     *
     * @param n
     * @return
     */
    public int hammingWeight3(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            /**
             * 要理解n * (n-1)的本质
             */
            n &= (n - 1);
        }
        return count;
    }


    /**
     * 牛逼啊
     * @param n
     * @return
     */
    public int hammingWeight4(int n){
        return Integer.bitCount(n);
    }

    /**
     * 跟 2异曲同工之妙，
     * @param n
     * @return
     */
    public int hammingWeight5(int n){
        int count = 0;
        while (n != 0){
            count = count + (n&1);
            n >>>= 1;
        }
        return count;
    }


    public int hammingWeight6(int n){
        int count = 0;
        for (int i = 0; i <32 ; i++) {
            if((n & (0x00000001 << i)) != 0){
                count ++;
            }
        }
        return count;
    }


}
