package sort;

/**
 * 快排理解：
 * https://www.sczyh30.com/posts/Algorithm/algorithm-quicksort/
 * <p>
 * 该篇文章的图解非常到位：https://www.cnblogs.com/MOBIN/p/4681369.html
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] array = {36, 9, -7, 45, 23, 61, 15};
        quickSort(array, 0, array.length - 1);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

    }

    /**
     * 划分
     *
     * @param arr
     * @param head
     * @param tail
     */
    public static int partition(int[] arr, int head, int tail) {


        int i = head;
        int j = tail;

        // 选取第一个元素作为基准值
        int qivot = arr[i];

        while (i <= j) {
            while (i < j && arr[j] >= qivot) {
                j--;
            }
            /**
             * 需要先腾出空位，然后才能赋值占位
             */

            arr[i] = arr[j];


            while (i < j && arr[i] <= qivot) {
                i++;
            }
            arr[j] = arr[i];


        }
        arr[i] = qivot;
        return i;
    }


    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right || arr == null || arr.length <= 1) {
            return;
        }

        int j = part(arr, left, right);
        quickSort(arr, left, j - 1);
        quickSort(arr, j + 1, right);
    }


    /**
     * 最好理解的版本
     */

    public static int part(int arr[], int left, int right) {
        int temp = 0;
        if (arr.length == 1) {
            return 0;
        }

        if (left <= right) {
            // 基准值
            temp = arr[left];

            /**
             * 开始左右交替扫描，直到left = right
             */
            while (left != right) {
                /**
                 * 从右开始扫描比基准值大的，交换且 right--；
                 */
                while (right > left && arr[right] >= temp) {
                    right--;
                }
                arr[left] = arr[right];

                /**
                 * 从左往右扫描，找到第一个比基准值小的，交换
                 */
                while (right > left && arr[left] <= temp) {
                    left++;
                }
                arr[right] = arr[left];

            }
        }

        arr[right] = temp;
        return right;
    }


}
