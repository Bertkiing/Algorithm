package algohub;

import java.util.Stack;

public class LargestRectangleInHistogram {


    /**
     * For example :
     * Given heights = [2,1,5,6,2,3]
     * return 10
     * <p>
     * <p>
     * stack 1. 升序，2，小于计算
     * <p>
     * <p>
     * 执行过程：
     * stack 1,2,3
     * <p>
     * 2 : push
     * 1 : height 2  start  = -1 res 2
     * 5 : push
     * 6:  push
     * 2: height 6 start = 2 area = 6 res = 6
     * height 5 start = 1 ares = 10 res = 10
     * 3: push
     * 0: height = 2 start = 1 area = 8
     * height = 1 start = -1 area = 6
     * res = 10
     * <p>
     * time : O(n)
     * space :O(n)
     *
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        /**
         * 边界值
         */
        if (heights == null || heights.length <= 0) return 0;
        /**
         * 这里注意：stack里面存的是index,因为我们只要只要了index，就可以获取到对应的值；
         */
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        /**
         * 这里需要我们注意的是 <=
         * 因为 stack 存放的是升序的，
         * stack的逻辑：当遇到升序的，都直接存入；小于的时候才开始计算
         * 当都是升序的时候，就遇不到小于的逻辑，这样就无法计算，所以需要在后面加一个0，以便去计算
         */
        for (int i = 0, len = heights.length; i <= len; i++) {
            int h = i == heights.length ? 0 : heights[i];

            while (!stack.isEmpty() && h < heights[stack.peek()]) {
                int height = heights[stack.pop()];


                int start = stack.isEmpty() ? -1 : stack.peek();

                int area = height * (i - start - 1);
                res = Math.max(res, area);
            }
            stack.push(i);
        }
        return res;
    }


    public static void main(String[] args) {
        LargestRectangleInHistogram test = new LargestRectangleInHistogram();
        int[] heights = {2, 1, 5, 6, 2, 3};
        int area = test.largestRectangleArea(heights);
        System.out.println("1. The most area is :" + area);


        int area2 = test.largestRectangleArea2(heights);
        System.out.println("2. The most area is :" + area2);
    }


    /**
     * 复杂度O(n^2)
      * @param heights
     * @return
     */
    public int largestRectangleArea2(int[] heights) {
        /**
         * 先检查边界条件
         */
        if (heights == null || heights.length == 0) return 0;

        int max = 0;

        for (int cur = 0; cur < heights.length; cur++) {

            /**
             * heights[cur] > heights[cur+1] 这步是为了减少运算
             */
            if (cur == heights.length - 1 || heights[cur] > heights[cur + 1]) {
                int minHeight = heights[cur];
                for (int i = cur; i >= 0; i--) {
                    minHeight = Math.min(minHeight, heights[i]);
                    max = Math.max(max, minHeight * (cur - i + 1));
                }
            }
        }

        return max;
    }
}
