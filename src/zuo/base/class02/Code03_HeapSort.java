package zuo.base.class02;

/**
 * 堆排序
 *
 * @author xiaoliang
 * @date 2021/09/12 15:45
 **/
public class Code03_HeapSort {

    /**
     * 删除任意位置节点 向下调整一次的时间复杂度是 logN
     *
     * @param arr
     * @param index
     * @param heapSize 堆大小
     */
    public static void heapify(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1;
        while (left < heapSize) {
            int largeChild = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
            if (arr[largeChild] <= arr[index]) {
                // 不用继续往下调了
                break;
            }
            swap(arr, largeChild, index);
            index = largeChild;
            left = index * 2 + 1;
        }
    }

    /**
     * 增加一个新的节点 调整代价 时间复杂度是logN
     *
     * @param arr
     * @param index
     */
    public static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int heapSize = arr.length;

        for (int i = arr.length - 1; i >= 0; i--) {
            heapify(arr, i, heapSize);
        }
//        for (int i = 0; i < arr.length; i++) {
//            heapInsert(arr,i);
//        }

        // 第一个与最后一个位置交换，调整大根堆 循环以上
        swap(arr, 0, --heapSize);
        while (heapSize > 0) {
            heapify(arr, 0, heapSize);
            swap(arr, 0, --heapSize);
        }

    }

    public static void main(String[] args) {

        int[] arr = {3, 34, 13214, 2314, 341, 53, 341, 321432, 3214, 31, 53, 15, 123, 123};

        heapSort(arr);

        for (int i : arr) {
            System.out.print(i + " ");
        }

    }
}
