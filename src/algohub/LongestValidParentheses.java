package algohub;

import java.util.Stack;

/**
 * @author bertking
 * 题目：https://soulmachine.gitbooks.io/algorithm-essentials/content/java/stack-and-queue/stack/longest-valid-parentheses.html
 *
 * 视频讲解地址：https://www.youtube.com/watch?v=M1Vw5Tk1rw4（需翻墙）
 *
 * 凡是跟括号相关的问题，优先考虑Stack...
 */
public class LongestValidParentheses {

    public int longValid(String string) {
        /**
         * 先考虑临界环境
         */
        if(string == null || string.length()<2){
            return 0;
        }

        int maxLen = 0;
        int leftmost = -1;

        /**
         * )()())
         * (()
         */
        Stack<Integer> stack = new Stack<>();


        for (int i = 0, len = string.length(); i < len; i++) {
            if (string.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (stack.isEmpty()) {
                    leftmost = i;
                } else {
                    /**
                     * 配对成功的情况
                     */

                    stack.pop();

                    if (stack.isEmpty()) {
                        maxLen = Math.max(maxLen, i - leftmost);
                    } else {
                        maxLen = Math.max(maxLen, i - stack.peek());
                    }

                }
            }
        }
        return maxLen;
    }




    public static void main(String[] args) {
        String test = "(()())())()";
        System.out.println(test + " longest valid is " + new LongestValidParentheses().longValid(test));


    }
}
