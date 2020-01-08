package test.slidingwindow;

import java.util.HashMap;

/**
 * @author bertking
 * @date 2019/12/13
 */
public class LongestSubStringWithoutRepeat {
    public static void main(String[] args) {
    String string = "abcabccbb";
        System.out.println(lengthOfLongestSubstring(string));
    }

    static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        int left = 0;
        int right = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int ans = 0;

        while (right < s.length()) {
            /**
             * 说明有重复字符
             */
            if (map.containsKey(s.charAt(right))) {
                if(map.get(s.charAt(right))+1 > left){
                    int key = s.charAt(right) + 1;
                    left = map.get(key);
                }
//                left = Math.max(left, map.get(s.charAt(right)) + 1);
            }

            map.put(s.charAt(right), right);
            ans = Math.max(ans, right - left + 1);

            right ++;
        }

        return ans;
    }
}
