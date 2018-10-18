package algohub;

import java.util.Stack;

/**
 * @author Bertking
 *
 * @description :https://soulmachine.gitbooks.io/algorithm-essentials/content/java/stack-and-queue/stack/valid-parentheses.html
 * @题目 判断括号的有效性
 */
public class ValidParentheses {
    public static boolean isValid(String string){
        final String left = "([{";
        final String right = ")]}";

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if(left.indexOf(c) != -1){
                stack.push(c);
            }else{
                if(!stack.isEmpty()&&stack.peek() == left.charAt(right.indexOf(c))){
                    stack.pop();
                }else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String parentheses = "(){}[]";

        System.out.println(parentheses +" is valid? "+isValid(parentheses));
    }

}
