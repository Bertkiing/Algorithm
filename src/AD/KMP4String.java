package AD;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author bertking
 * @date 2018/11/28
 * @link https://blog.csdn.net/zdp072/article/details/13161295
 * <p>
 * KMP算法的思想:设法利用这个已知信息，不要把"搜索位置"移回到已经比较过的位置，继续把它向后移，从而达到提高效率的目的...
 */
public class KMP4String {

    public static int getMatchIndex(char[] main, char[] sub) {
        int[] next = next(sub);
        int i = 0;
        int j = 0;
        while (i <= main.length - 1 && j <= sub.length - 1) {
            if (j == -1 || main[i] == sub[j]) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }

        if (j < sub.length) {
            return -1;
        } else {
            return i - sub.length;
        }
    }


    /***
     * 该数组要解决的问题：
     *  每趟匹配过程中产生失败时，子串该向右滑动多远，
     * IAW，当主串的第i个字符和子串的第j个字符失配时；
     * 下一趟比较开始时，主串的第i个字符应该与子串的哪个字符再去比较。
     * @param sub
     * @return 获得一个回退位置的数组
     *
     * 参考：https://blog.csdn.net/lanyage_csdn/article/details/80589220
     */
    public static int[] next(char[] sub) {
        int[] next = new int[sub.length];
        next[0] = -1;// next的第0位默认为-1，类似哨兵
        int i = 0; // 后缀指针
        int j = -1;// 前缀指针
        while (i < sub.length - 1) {
            if (j == -1 || sub[i] == sub[j]) {
                /**
                 * 前缀 & 后缀匹配成功，则继续向后匹配
                 */
                i++;
                j++;

//                if (sub[i] != sub[j]) {
//                    next[i] = j;
//                } else {
//                    next[i] = next[j];
//                }
                next[i] = j;
            } else {
                /**
                 * 当匹配失败时,则令i不变，j = next[j]
                 * 此举等价于：模式串 相对于 目标串 移动了 j - next[j]位。
                 *
                 *  PS : 匹配失败时：
                 *  模式串向右移动的位数 = 已匹配的字符数 - 对应的部分匹配值  = 失配字符所在位置 - 失配字符对应的next值
                 */
                j = next[j];
            }
        }
        return next;
    }

    public static void main(String[] args) {
        String mainStr = "BBC ABCDAB ABCDABCDABDE"; // 主串
        String subStr = "ABCDABD"; // 模式串
        char[] mainArr = mainStr.toCharArray(); // 主串数组
        char[] subArr = subStr.toCharArray(); // 模式串数组

        /**
         * 这里需要注意的是:直接输出Arrays.asList()，返回的是hashCode()
         */
        System.out.println(Arrays.asList(next(subArr)));
        System.out.println(Arrays.toString(next(subArr)));
        System.out.println(getMatchIndex(mainArr, subArr)); // KMP匹配字符串

    }
}
