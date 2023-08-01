package offer.yongyou.y20220925.y3;

/**
 * @author xiaoliang
 * @date 2022/09/25 16:54
 **/
public class Main {

    public int lengthOfList(int[] nums) {

        if(nums.length==1){
            return 1;
        }

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > dp[index]) {
                dp[++index] = nums[i];
                continue;
            }
            int left = 0;
            int right = index;
            // 找到大于等于nums[i]的最左边位置
            int first = 0;
            while (left <= right) {
                int mid = left + ((right - left) >> 1);
                if (dp[mid] >= nums[i]) {
                    right = mid - 1;
                    first = mid;
                } else {
                    left = mid + 1;
                }
            }
            dp[first] = nums[i];
        }
        return index + 1;
    }

    public static void main(String[] args) {
        int[] arr = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(new Main().lengthOfList(arr));
    }
}
