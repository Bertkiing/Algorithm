package sort;

/**
 * Created by king on 2018/1/2.
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = new int[]{
                5, 3, 9, 2, 8, 1, 7, 4, 6
        };

        insertSort(arr);
    }

    /**
     * 插入排序
     *
     * @param arr
     */
    private static void insertSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j - 1] < arr[j]) {
                    swap(arr, j - 1, j);
                } else {
                    break;
                }
            }
        }
        for (int i : arr) {
            System.out.print(i + ",");
        }
    }


    /**
     * 交换操作
     *
     * @param arr
     * @param i
     * @param j
     */
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
