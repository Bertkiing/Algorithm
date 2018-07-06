package sort;

/**
 * 冒泡排序不错的讲解：
 * https://blog.csdn.net/guoweimelon/article/details/50902597
 *
 *
 *
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] array = {1, 4, 2, 6, 9, 0};
        bubbleSort(array);
        for (int i : array) {
            System.out.println(i);
        }

        System.out.println("鸡尾酒排序");
        int[] arr = {1, 4, 2, 6, 9, 0};
        cocktail_sort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    /**
     * 只有加了标志位，才有可能将"Bubble Sort"的时间复杂度降低到O(n)
     * 否则就是O(n^2)
     *
     * 1. 时间复杂度：
     * 当完全"正序"时，冒泡排序的比较次数为n-1，移动次数为0。so. 最好情况的时间复杂度为O(n)
     * 当完全"逆序"时，即最坏的时间复杂度为O(n^2)
     *
     * 当"杂乱无章"时，即平均时间复杂度为O(n^2)
     *
     * 2. 空间复杂度
     *
     * 冒泡排序过程中需要一个临时变量进行两两交换，所需要的额外空间为1，因此空间复杂度为O(1)
     *
     *
     * 3. 稳定性
     *  冒泡排序在排序过程中，元素两两交换时，相同元素的前后顺序并没有改变。So...冒泡排序是一种"稳定排序算法"
     *
     *
     * @param array
     */
    public static void bubbleSort(int[] array) {
        /**
         * 标记变量：用于记录每趟冒泡排序是否发生数据元素位置交换；
         *
         * 如果没有交换，说明序列已经有序，无需再进行下去
         */
        boolean isChanged = true;
        for (int i = 0; i < array.length - 1 && isChanged; i++) {
            isChanged = false;
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j);
                    isChanged = true;
                }
            }
        }
    }

    private static void swap(int[] array, int j) {
        int temp = 0;
        temp = array[j];
        array[j] = array[j + 1];
        array[j + 1] = temp;
    }


    /**
     * 鸡尾酒排序：是冒泡排序的一种变形。
     * 该算法与冒泡排序的不同之处在于：排序是以"双向"在序列中进行排序的。
     * <p>
     * 鸡尾酒排序在于排序过程是先从低到高，然后从高到低；
     * 故可以得到比冒泡排序稍微好一点的效能；
     * <p>
     * 而冒泡排序则仅从低到高去比较序列里的每个元素。每次循环只能定位一个元素。
     * <p>
     * 以序列(2,3,4,5,1)为例：
     * <p>
     * 冒泡排序：
     * （1） 2,3,4,1,5
     * (2)  2,3,1,4,5
     * (3)  2,1,3,4,5
     * (4)  1,2,3,4,5
     * 使用冒泡排序需要 4 次
     * <p>
     * <p>
     * <p>
     * 鸡尾酒排序：
     * （1） 2,3,4,1,5
     * (2) 1,2,3,4,5
     *
     *  乱序情况下，鸡尾酒与冒泡的效率都非常差劲...
     *
     * @param array
     */
    public static void cocktail_sort(int[] array) {
        int j, left = 0;
        int right = array.length - 1;

        while (left < right) {
            for (j = left; j < right; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j);
                }
            }
            right--;

            for (j = right; j > left; j--) {
                if (array[j - 1] > array[j]) {
                    swap(array, j - 1);
                }
            }
            left++;
        }
    }

}
