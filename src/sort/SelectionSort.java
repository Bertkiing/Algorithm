package sort;

/**
 * Created by king on 2018/1/1.
 * 选择排序：
 *
 */
public class SelectionSort {
    public static final int LEN = 10;

    public static void main(String[] args) {
        int[] arr = new int[]{
                5, 3, 9, 2, 8, 1, 7, 4, 6
        };

        int[] arr1 = new int[]{
                5, 5, 5, 5, 5, 5, 5, 5, 5
        };

        int[] arr2 = new int[]{
                1, 2, 3, 4, 5, 6, 7, 8, 9
        };


        long curTime = System.currentTimeMillis();
        sort(arr);
        System.out.println();
        System.out.println("排序所耗费的时间:" + (System.currentTimeMillis() - curTime) + "ms");
        selectionSort(arr);
    }

    private static void sort(int[] arr) {
        for (int j = 0; j < arr.length; j++) {
            System.out.println();
            int minIndex = getMinIndex(arr, j);
            System.out.print("minIndex = " + minIndex + ":::交换后:::");
            int temp = arr[minIndex];
            arr[minIndex] = arr[j];
            arr[j] = temp;
            for (int i : arr) {
                System.out.print(i + ",");
            }
        }


    }

    private static int getMinIndex(int[] arr, int index) {
        int minIndex = index;
        System.out.print("比较次数：" + (arr.length - 1 - index) + ":");
        for (int i = index; i < arr.length; i++) {
            if (arr[i] < arr[minIndex]) {
                minIndex = i;
            }
        }
        return minIndex;
    }


    private static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {

            /******找出数组中的最小值 START*****/
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            /******找出数组中的最小值 END*******/



            // 交换
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;


        }

        for (int i : arr) {
            System.out.print(i+",");
        }
    }
}
