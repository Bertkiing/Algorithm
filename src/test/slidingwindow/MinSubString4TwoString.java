package test.slidingwindow;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 'a' = 97
 * '0' = 48
 *
 * @author bertking
 * @date 2019/12/16
 * <p>
 * 用 map 统计 T 的每个字母的出现次数，然后遍历 S，遇到相应的字母，就将相应字母的次数减 1，如果此时 map 中所有字母的次数都小于等于 0，那么此时的窗口一定包含了所有字母
 * <p>
 * 链接：https://leetcode-cn.com/problems/minimum-window-substring/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-1-3/
 */
public class MinSubString4TwoString {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t));
        System.out.println("--------------");
        System.out.println(minWindow1(s, t));

    }

    static String minWindow1(String s, String t) {
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }

        /**
         * 保存T中所有唯一字符(the unique characters)的数量
         */
        HashMap<Character, Integer> dicT = new HashMap<>();
        for (char c : t.toCharArray()) {
            int count = dicT.getOrDefault(c, 0);
            dicT.put(c, count + 1);
            System.out.println("字符" + c + " ,count: " + (count + 1));
        }

        int left = 0;
        int right = 0;
        // 保存最小窗口的左边界
        int ans_left = 0;
        int ans_right = -1;
        int ans_len = Integer.MAX_VALUE;
        //遍历字符串s
        while (right < s.length()) {
            char char_right = s.charAt(right);
            // 判断 map 中是否含有当前字符
            if (dicT.containsKey(char_right)) {
                // 当前的字符次数减1
                dicT.put(char_right, dicT.get(char_right) - 1);
                // 如果当前窗口包含所有字母，就进入循环
                while (match(dicT)){
                    // 当前窗口大小
                    int temp_len = right - left +1;
                }


            }
        }


        return "";
    }

    static boolean match(HashMap<Character, Integer> map) {
        for (Integer value : map.values()) {
            if (value > 0) {
                return false;
            }
        }
        return true;
    }


    /**
     * https://leetcode-cn.com/problems/minimum-window-substring/solution/hua-dong-chuang-kou-suan-fa-chao-xiang-xi-jie-xi-k/
     */
    static String minWindow(String s, String t) {
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        // 存储滑动窗口中的值
        int[] hash = new int[256];
        // 最小子串的长度
        int minLenght = s.length();
        //最小子串
        String results = "";

        for (char c : tt) {
            hash[c - '0']++;
        }

        System.out.println(Arrays.toString(hash));

        int left = 0;
        int right = 0;
        int count = tt.length;

        for (; right < ss.length; right++) {
            hash[ss[right] - '0']--;

            if (hash[ss[right] - '0'] >= 0) {
                count--;
            }

            while (left < right && hash[ss[left] - '0'] < 0) {
                hash[ss[left] - '0']++;
                left++;
            }

            if (count == 0 && minLenght >= right - left + 1) {
                minLenght = right - left + 1;
                results = s.substring(left, right + 1);
            }
        }

        return results;
    }
}
