package algohub;

import java.util.Arrays;

/**
 * @author  Bertking
 * @题目：不使用额外的空间来翻转数组(Reverse an Array without using extra memory space(String reverse)
 * @讲解：https://www.youtube.com/watch?v=W-090WziKAs
 */
public class SwapWithoutExtraSpace {

    public void operation(int[] array){
        int start = 0;
        int end = array.length -1;

        while (start<end){
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;

            start ++;
            end --;
        }
    }


    public static void main(String[] args) {
        SwapWithoutExtraSpace test = new SwapWithoutExtraSpace();
        int[] array = {1,2,3,4,5};
        test.operation(array);
        System.out.println(Arrays.toString(array));
    }
}
