package leecode;

import java.util.Stack;

/**
 * 155. Min Stack
 *
 *
 * @description https://leetcode.com/problems/min-stack/discuss/149670/Simple-single-stack-solution.
 * @author Bertking
 *
 * Ask your interviewer if you're allowed to use the java implementation of Stack,
 * otherwise, writing a Linked-List implementation is quite trivial, and the same approach can be used.
 * (无形装逼，最为致命...)
 */
public class Leecode155 {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());

        System.out.println("------------------");

        MinStack2 minStack2 = new MinStack2();
        minStack2.push(-2);
        minStack2.push(0);
        minStack2.push(-3);
        System.out.println(minStack2.getMin());
        minStack2.pop();
        System.out.println(minStack2.top());
        System.out.println(minStack2.getMin());

        System.out.println("----------------");
        MinStack3 minStack3 = new MinStack3();
        minStack3.push(-2);
        minStack3.push(0);
        minStack3.push(-3);
        System.out.println(minStack3.getMin());
        minStack3.pop();
        System.out.println(minStack3.top());
        System.out.println(minStack3.getMin());


    }
}

/**
 * 使用双栈解决，但是效率低
 */
class MinStack {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> tempStack = new Stack<>();

    /**
     * initialize your data structure here.
     */
    public MinStack() {

    }

    public void push(int x) {
        stack.push(x);
        if (tempStack.isEmpty()) {
            tempStack.push(x);
        } else {
            if (tempStack.peek() > x) {
                tempStack.push(x);
            } else {
                tempStack.push(tempStack.peek());
            }
        }

    }

    public void pop() {
        if (stack.isEmpty()) return;
        stack.pop();
        tempStack.pop();
    }

    public int top() {
        if (stack.isEmpty()) return 0;
        return stack.peek();
    }

    public int getMin() {
        if (tempStack.isEmpty()) return 0;
        return tempStack.peek();
    }


}

/**
 * 使用"链表"，效率更高
 */
class MinStack2 {
    Node head;

    public MinStack2() {
    }

    public void push(int x) {
        if (head == null) {
            head = new Node(x);
            head.min = x;
        } else {
            int min = head.min;
            Node tmp = new Node(x);
            tmp.next = head;
            head = tmp;
            head.min = Math.min(min, x);
        }
    }


    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }

    /**
     * 结点
     */
    private class Node {
        int val;
        Node next;
        int min;

        public Node(int val) {
            this.val = val;
        }
    }
}

/**
 * 使用"一个栈"来实现，其原理和"双栈"一样
 */
class MinStack3 {
    private Stack<Pair> stack;


    public MinStack3() {
        stack = new Stack<>();
    }


    public void push(int n) {
        if (stack.size() == 0) {
            Pair pair = new Pair(n, n);
            stack.push(pair);
        } else {
            Pair pair = new Pair(n, Math.min(n, stack.peek().min));
            stack.push(pair);
        }
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().element;
    }

    public int getMin() {
        return stack.peek().min;
    }


    class Pair {
        public int element;
        public int min;

        public Pair(int element, int min) {
            this.element = element;
            this.min = min;
        }
    }
}