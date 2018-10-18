package leecode;

/**
 * 题目：https://leetcode.com/problems/reverse-bits/description/
 *
 * @注意： 讲给定的无符号数的二进制翻转：即1000 -> 0001 ,not the 0111
 */
public class Leecode190 {
    // you need treat n as an unsigned value


    /**
     * The key is :
     * think the 'result' as a list to save the numbers.所以我们每次都获取the n 的最后一位，通过 n >>= 1
     *
     * @param n
     * @return
     */
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int end = n & 1;
            n >>= 1;
            result <<= 1;
            result |= end;
        }
        return result;
    }


    public int reverseBits2(int n) {
        int result = 0;
        if (n == 0) return 0;
        for (int i = 0; i < 32; i++) {
            result <<= 1;
            if((n&1) == 1){
                result += 1;
            }

            n >>= 1;
        }

        return result;
    }


    public int reverseBit3(int n){
        int result = 0;
        for (int i = 0; i < 32; i++) {
            /**
             * 容器左移1个，然后把移出来的末位放上原数n 的末尾；
             *
             * n >>= 1 即原数的末尾就不需要了，右移扔掉。
             */
            result = (result<<1) ^ (n&1);
            n >>=1;
        }
        return result;
    }


    public static void main(String[] args) {
        Leecode190 leecode190 = new Leecode190();
        int reverseBits = leecode190.reverseBits(4);
        System.out.println(reverseBits);
        System.out.println("-------------");
        int reverseBits2 = leecode190.reverseBits2(4);
        System.out.println(reverseBits2);
        System.out.println("-------------");
        int reverseBit3 = leecode190.reverseBit3(4);
        System.out.println(reverseBit3);
    }


}
