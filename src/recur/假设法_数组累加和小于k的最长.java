package recur;

/**
 * 类似于窗口和小于k的滑动窗口，求其中 窗口的最大值
 * @author xiaoliang
 * @date 2021/09/29 09:31
 **/
public class 假设法_数组累加和小于k的最长 {

    public static int maxSubLessK(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            throw new RuntimeException("参数错误");
        }
        int maxLenght = -1;
        int cur = 0;
        int nowLenght = 0;
        int start = 0;
        for (int i = 0; i < arr.length; i++) {
            cur += arr[i];
            nowLenght++;
            if (cur < k) {
                maxLenght = Math.max(maxLenght, nowLenght);
            } else {
                while (cur != 0 && cur >= k) {
                    cur -= arr[start++];
                    nowLenght--;
                }
            }
        }
        return maxLenght;
    }

    public static void main(String[] args) {
        int[] arr = {3,2,1,3,2,4,5,2,2,1,1,1,1,4};
        int i = maxSubLessK(arr, 5);
        System.out.println(i);
    }
}
