package zuo;

import java.util.Arrays;
import java.util.Random;

import static zuo.base.class01.Code02_BubbleSort.bubbleSort;

/**
 * 对数器
 * @author xiaoliang
 * @date 2021/09/12 11:28
 **/
public class CheckMachine {

    /**
     * 随机生成一个整型数组
     * @param length 数组长度
     * @param maxNum 数组的最大值 0 ~ maxNum
     * @return
     */
    public static int[] generateArray(int length,int maxNum){

        Random random = new Random();

        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
//            arr[i] =  (int)(Math.random()*maxNum);
            arr[i] =  random.nextInt(maxNum); //[0,100)
        }
        return arr;
    }

    // for test
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    // for test
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    // for test
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }


    // for test
    public static void main(String[] args) {
        int testTime = 5000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            int[] arr3 = copyArray(arr1);
            bubbleSort(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                printArray(arr3);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

//        int[] arr = generateArray(maxSize, maxValue);
//        printArray(arr);
//        bubbleSort(arr);
//        printArray(arr);
    }
}
