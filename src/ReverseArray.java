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
        System.out.println("临时变量temp翻转数组：");
        int[] reverse = reverse(intArray);
        for (int i : reverse) {
            System.out.print(i + ",");
        }

        int[] intArray1 = new int[LENGTH];
        for (int i = 0; i < LENGTH; i++) {
            intArray1[i] = 10 + i;
        }
        System.out.println();
        System.out.println("异或操作翻转数组：");
        for (int i : reverse1(intArray1)) {
            System.out.print(i + ",");
        }


        int[] intArray2 = new int[LENGTH];
        for (int i = 0; i < LENGTH; i++) {
            intArray2[i] = 20 + i;
        }
        System.out.println();
        System.out.println("等价异或翻转数组：");
        for (int i : reverse2(intArray2)) {
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
     * 异或操作实现交换两个变量
     * 当 a ,b 相等时，该方法不适用。
     *
     * @param array
     * @return
     */
    private static int[] reverse1(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            array[i] = array[i] ^ array[array.length - 1 - i];
            array[array.length - 1 - i] = array[i] ^ array[array.length - 1 - i];
            array[i] = array[i] ^ array[array.length - 1 - i];
        }
        return array;
    }

    /**
     * 交换两个变量
     * a = a + b；
     * b = a - b; 此时 b = a;
     * a = a - b; 等价于 a + b - b;
     * 该方法的前提是：a + b 的值不能溢出
     *
     * @param array
     * @return
     */
    private static int[] reverse2(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            array[i] = array[i] + array[array.length - 1 - i];
            array[array.length - 1 - i] = array[i] - array[array.length - 1 - i];
            array[i] = array[i] - array[array.length - 1 - i];
        }
        return array;
    }

}
