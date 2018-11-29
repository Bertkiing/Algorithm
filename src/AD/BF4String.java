package AD;

/**
 * @author bertking
 * @date 2018/11/28
 * @desc 字符串的模式匹配(BF算法)[BF(Brute Force...) - 暴力破解]
 * @link https://blog.csdn.net/zdp072/article/details/12956153
 *
 *
 * 通过BF算法，我们可以看出i 不断的回溯，导致性能问题。
 *
 * 来寻找一种: 让i不回溯，只移动j.
 * 这就是传说中的KMP算法...
 *
 *
 */
public class BF4String {
    /**
     * BF(Brute Force)算法是普通的模式匹配算法，又称为朴素匹配算法或蛮力算法，该算法最大缺点就是字符匹配失败指针就要回溯，所以性能很低。
     *
     * @param main 文本串
     * @param sub  模式串
     */
    public static int getMatchIndex(String main, String sub) {
        char[] mainChars = main.toCharArray();
        char[] subChars = sub.toCharArray();

        int i = 0; // 主串的下标
        int j = 0;// 字串的下标
        while (i < main.length() && j < sub.length()) {

            if (mainChars[i] == subChars[j]) {
                /**
                 * 1. 当前字符匹配成功，则两者都往下比较
                 */
                i++;
                j++;
            } else {
                /**
                 * 2. 如果匹配失败,则令i =  i-(j-1);  j = 0
                 */
                i = i - j + 1;
                j = 0;
            }
        }

        /**
         * 匹配成功，返回模式串sub在文本串main中的位置，否则返回-1
         */
        if (j == sub.length()) {
            return i - j;
        } else {
            return -1;
        }
    }


    public static void main(String[] args) {
        System.out.println("匹配成功的位置: " + getMatchIndex("", "God"));
        String mainStr = "BBC ABCDAB ABCDABCDABDE"; // 主串
        String subStr = "ABCDABD"; // 模式串
        System.out.println("匹配成功的位置1: " + getMatchIndex(mainStr, subStr));

    }

}
