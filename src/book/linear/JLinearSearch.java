package book.linear;

/**
 * @author bertking
 * @date 2018/10/15
 * 线性查找的分析：
 * https://www.hackerearth.com/zh/practice/notes/sentinel-linear-search/
 *
 */
public class JLinearSearch {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};


        System.out.println(linearSearch(arr, 3));

        System.out.println(betterLinearSearch(arr, 3));

        System.out.println(sentinelLinearSearch(arr, 9));

    }


    /**
     * 最普通的线性查找
     * 循环 n 次
     * 比较 2n +1 次
     * (包括：
     * index < array.size; -->  n + 1 comparisons </>
     * <p>
     * array[i] < des; --> n comparisons</>
     * <p>
     * 通过分析：调用该方法每次都会比较2n+1次，就算第一次就找到的情况下，也是如此
     *
     * @param array 数组
     * @param des   目标
     * @return
     */
    static int linearSearch(int[] array, int des) {
        int result = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == des) {
                result = i;
            }
        }
        return result;
    }

    /**
     * 较好的线性查找:
     * 我们在查找到目标后,就不再比较后面的啦
     * <p>
     * 最好情况下，只需要比较2次；
     * 正常情况下，如果在第i次找到,则比较了2i 次
     * 最坏情况下下，也需要比较2n +1 次
     *
     * @param array
     * @param des
     * @return
     */
    static int betterLinearSearch(int[] array, int des) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == des) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 更高效的线性查找算法
     * <p>
     * better-linear-search 每进行一次循环需要做两步操作：
     * 1. 测试 i < array.length;()
     * 2. 测试 array[i] == des;
     * <p>
     * 首先：第一步是防止数组越界问题，但是如果我们确定目标des一定存在于数组当中，则直接放心大胆地招，而无需担心越界。
     * <p>
     * 但是我们无法确切知道目标des是否一定在array中。
     * <p>
     * 所以我们可以先将array[array.length-1]的值保存起来。再将目标des赋值给array[array.length-1]
     * 这样一旦我们找到des,就可以验证是否真正找到了目标。PS：des被称为信号量sentinel
     *
     * @param arr
     * @param des
     * @return
     */
    static int sentinelLinearSearch(int[] arr, int des) {
        int last = arr[arr.length - 1];
        arr[arr.length - 1] = des;
        int i = 0;
        while (arr[i] != des) {
            i++;
        }

        if (i == arr.length - 1) {
            arr[arr.length - 1] = last;
        }

        if (i < arr.length - 1 || arr[arr.length - 1] == des) {
            return i;
        }
        return -1;
    }


}
