/**
 * Created by king on 2017/12/31.
 * 描述：翻转数组
 */
public class ReverseArray {
    public static final int LENGTH = 10;

    public static void main(String[] args) {
        int[] intArray = new int[10];
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = i;
        }
        System.out.println("翻转数组1：");
        int[] reverse = reverse(intArray);
        for (int i : reverse) {
            System.out.print(i + ",");
        }

        int[] intArray1 = new int[LENGTH];
        for (int i = 0; i < LENGTH; i++) {
            intArray1[i] = 10 + i;
        }
        System.out.println();
        System.out.println("翻转数组2：");
        for (int i : reverse1(intArray1)) {
            System.out.print(i + ",");
        }

    }

    /**
     * 适用临时变量temp来交换两个变量
     *
     * @param array
     * @return
     */
    private static int[] reverse(int[] array) {
        // 注意这里只进行 数组长度的一半运算。
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
        return array;
    }

    /**
     * 第二种方案来实现
     *
     * @param array
     * @return
     */
    private static int[] reverse1(int[] array) {
        for (int start = 0, end = array.length - 1; start <= end; start++, end--) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
        }
        return array;
    }

}
