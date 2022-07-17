package zuo.base.class02;

/**
 * 给定一个整数数组，给定一个值K，这个值在原数组中一定存在，要求把数组中小于K的元素放到数组的左边，
 * 大于K的元素放到数组的右边，等于K的元素放到数组的中间，最终返回一个整数数组，其中只有两个值，
 * 分别是等于K的数组部分的左右两个下标值。
 *
 * @author xiaoliang
 * @date 2021/09/12 15:46
 **/
public class Code05_NetherlandsFlag {

    /**
     * 简单版
     * 给定一个整数数组，给定一个值K，这个值在原数组中一定存在，要求把数组中小于等于K的元素放到数组的左边，
     * 大于K的元素放到数组的右边，最终返回一个整数数组
     */
    public static int[] partition(int[] arr, int L, int R, int K) {

        int i = L;
        int j = R;
        while (i <= j) {
            if (arr[i] <= K) {
                i++;
            } else {
                swap(arr, i, j);
                j--;
            }
        }
        System.out.println(i);
        return arr;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    /**
     * 2.0
     * 给定一个整数数组，给定一个值K，这个值在原数组中一定存在，要求把数组中小于K的元素放到数组的左边，
     * 大于K的元素放到数组的右边，等于K的元素放到数组的中间，最终返回一个整数数组
     */
    public static int[] partition2(int[] arr, int L, int R, int K) {
        int less = L-1; // i 表示小区，一开始小区和大区一个也没括上
        int more = R+1; // j 表示大区
        while (L <= R) {
            // 3种情况
            if(arr[L]<K){ // 放到最左边
                swap(arr,++less,L++);
            }else if(arr[L]>K){
                swap(arr,L,R--);
                more--;
            }else { // arr[less]==K
                L++;
            }
        }
        System.out.println("快排需要用上这两个坐标"+less+"--"+more);
        return arr;
    }

    public static void main(String[] args) {
//        int[] arr = CheckMachine.generateArray(10, 50);
//        for (int i :partition(arr,0,arr.length-1,25)){
//            System.out.print(i+" ");
//        }
        int[] arr = {5,5,7,1,6,5,5,6,3,7,2,5,5,9,1,0};
        for (int i :partition(arr,0,arr.length-1,5)){
            System.out.print(i+" ");
        }
    }
}
