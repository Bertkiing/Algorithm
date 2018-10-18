package algohub;

import java.util.Stack;

/**
 * @author Bertking
 *
 * 题目链接：https://soulmachine.gitbooks.io/algorithm-essentials/java/stack-and-queue/stack/min-stack.html
 *
 * <p>
 * 解法：由于要求获取最小值的时间复杂度为0(1).(in constant time)
 */
public class MinStack {
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();


    private void push(int x) {
        stack.push(x);
        /**
         * Looks at the object at the top of this stack without removing it from the stack.
         * 有时候这些API设计者还挺有意思。
         * peek:窥视，偷看
         *
         *
         * 注意和pop()的区别
         * pop(): Removes the object at the top of this stack and returns that object as the value of this function.
         *
         * pop:弹出
         */
        int minValue = minStack.isEmpty() ? x : Math.min(minStack.peek(), x);
        minStack.push(minValue);
    }


    private void pop(){
        stack.pop();
        minStack.pop();
    }

    public int top(){
       return stack.peek();
    }

    public int getMin(){
        return minStack.peek();
    }


    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        int[] testData = {18, 19, 21, 15, 17};
        for (int i = 0; i < testData.length - 1; i++) {
            minStack.push(testData[i]);
        }


        System.out.println("最小值："+minStack.getMin());


    }

}
