package sort;

/**
 * 快排理解：
 * https://www.sczyh30.com/posts/Algorithm/algorithm-quicksort/
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

        while (i < j) {
            while (i < j && arr[j] > qivot) {
                j--;
            }

            if (i < j) {
                arr[i] = arr[j];
                i++;
            }

            while (i < j && arr[i] < qivot) {
                i++;
            }

            if (i < j) {
                arr[j] = arr[i];
                j--;
            }

        }
        arr[i] = qivot;
        return i;
    }


    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right || arr == null || arr.length <= 1) {
            return;
        }

        int j = partition(arr, left, right);
        quickSort(arr, left, j - 1);
        quickSort(arr, j + 1, right);
    }
}
