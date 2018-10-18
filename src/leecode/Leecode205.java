package leecode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Bertking
 * @题目 205. Isomorphic Strings（同形字符串）
 * @link https://leetcode.com/problems/isomorphic-strings/description/
 * @date 2018-8-1
 */
public class Leecode205 {
    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null) return false;
        if (s.length() != t.length()) return false;

        int length = s.length();
        for (int i = 0; i < length; i++) {

        }
        return true;
    }


    public static void main(String[] args) {
        Leecode205 leecode205 = new Leecode205();
        System.out.println(leecode205.isIsomorphic2("title", "siste"));
        System.out.println("------------");
        System.out.println(leecode205.isIsomorphic3("title", "siste"));
        System.out.println("------------");
        System.out.println(leecode205.isIsomorphic4("title", "siste"));
    }

    public boolean isIsomorphic2(String s, String t) {
        return isMatched(s, t) && isMatched(t, s);
    }

    public boolean isMatched(String s, String t) {
        if (s == null || t == null) return false;
        if (s.length() != t.length()) return false;

        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            if (!map.containsKey(sc)) {
                map.put(sc, tc);
            } else {
                if (map.get(sc) != tc) {
                    return false;
                }
            }
        }
        return true;
    }


    public boolean isIsomorphic3(String s, String t) {
        if (s == null || t == null) return false;
        if (s.length() != t.length()) return false;

        Map<Character, Integer> m1 = new HashMap<>();
        Map<Character, Integer> m2 = new HashMap<>();

        /**
         * 这里需要注意Map的put方法:
         * V put(K key, V value);
         * 即put()方法的返回值是value。
         *
         * Because Map的value is Integer,so for loop 里面的 i 类型为Integer
         *
         * == operator does the object comparison and since java caches integers from -128 to 127 hence ,
         * the above Integer == Integer is working for string's size less than 127
         *
         * The value of Map is Integer. So when you check if the value is equal, it will check for reference equality.
         *
         * 理解一下== 和 equals的区别： https://www.zhihu.com/question/26872848
         */
        for (Integer i = 0; i < s.length(); i++) {
            if (m1.put(s.charAt(i), i) != m2.put(t.charAt(i), i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * The array sm[] and tm[] is the hash map. if sm[sc] == 0, then there is no key sc in the map.
     * Since when you create the array sm[],the value is assigned to 0.
     * With sm[sc] = tc, we say that sc is the key and tc is the value.
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphic4(String s, String t) {
        char[] schars = s.toCharArray();
        char[] tchars = t.toCharArray();


        int length = s.length();
        if (length != t.length()) return false;


        char[] sm = new char[256];
        char[] tm = new char[256];

        for (int i = 0; i < length; i++) {
            char sc = schars[i];
            char tc = tchars[i];

            if (sm[sc] == 0 && tm[tc] == 0) {
                sm[sc] = tc;
                tm[tc] = sc;
            } else {
                if (sm[sc] != tc || tm[tc] != sc) {
                    return false;
                }
            }
        }
        return true;
    }

}

