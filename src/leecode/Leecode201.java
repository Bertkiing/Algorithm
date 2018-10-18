package leecode;

/**
 * @author Bertking
 * @题目： 201 Bitwise AND of Numbers Range
 */
public class Leecode201 {


    /**
     * 思路: https://leetcode.com/problems/bitwise-and-of-numbers-range/discuss/56729/Bit-operation-solution(JAVA)/160403
     * @param m
     * @param n
     * @return
     */
    public int rangeBitwiseAnd(int m, int n) {
        int i = 0;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            i++;
        }
        return m << i;
    }


    public int rangeBitwiseAnd2(int m,int n){
        if(m == 0){
            return 0;
        }

        int moveFactor = 1;
        while (m != n){
            m >>= 1;
            n >>= 1;
            moveFactor <<= 1;
        }

        return m * moveFactor;
    }


    public static void main(String[] args) {
        Leecode201 leecode201 = new Leecode201();
        System.out.println(leecode201.rangeBitwiseAnd(5,7));
        System.out.println(leecode201.rangeBitwiseAnd2(5,7));

    }


}
