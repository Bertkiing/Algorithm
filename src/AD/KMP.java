package AD;

import java.util.Arrays;

/**
 * @author bertking
 * @date 2018/11/29
 * @desc KMP算法
 * @link https://blog.csdn.net/v_JULY_v/article/details/7041827
 * <p>
 * 这里需要注意的是：
 * KMP 是用来解决BF算法的回溯问题。故两者在匹配成功的情况下,其处理是相同的。
 * <p>
 * 主要不同在于匹配失败的情况。
 * j = next[j]，意味着：模式串相对于文本串向右移动了j - next[j]位。
 * 当匹配失败时，模式串向右移动的位数为：失配字符所在位置 - 失配字符对应的next 值,
 * 即移动的实际位数：j - next[j],且此值大于等于1。
 * <p>
 * next数组的含义：代表当前字符之前的字符串中,有多大长度的相同的前缀后缀。
 * <p>
 * 即：某个字符失配时，该字符对应的next值会告诉你下一步匹配中，模式串应该跳到哪个位置(跳到next[j]的位置)。
 * if next[j] = 0 or -1，则跳到模式串的开头字符；
 * if next[j] = k & k > 0,则代表跳到 j 之前的某个字符，而不是跳到开头。[具体跳过了k个字符]
 */
public class KMP {
    public static int KMPSearch(String main, String sub) {
        int[] next = next(sub);

        /**
         * 主串的下标
         */
        int i = 0;
        /**
         * 模式串的下标
         */
        int j = 0;
        while (i < main.length() && j < sub.length()) {
            if (j == -1 || main.charAt(i) == sub.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }

        if (j == sub.length()) {
            return i - j;
        } else {
            return -1;
        }
    }

    public static int[] next(String sub) {
        int m = -1;
        int n = 0;
        int[] next = new int[sub.length()];
        next[0] = -1;
        while (n < sub.length() - 1) {
            if (m == -1 || sub.charAt(n) == sub.charAt(m)) {
                m++;
                n++;
//                next[n] = m;

                // 优化版本
                if (sub.charAt(n) != sub.charAt(m)) {
                    next[n] = m;
                } else {
                    next[n] = next[m];
                }

            } else {
                m = next[m];
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
        System.out.println(Arrays.toString(next(subStr)));
        System.out.println(KMPSearch(mainStr, subStr)); // KMP匹配字符串

    }

}
