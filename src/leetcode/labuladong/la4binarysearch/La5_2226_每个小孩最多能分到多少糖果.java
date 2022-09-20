package leetcode.labuladong.la4binarysearch;

/**
 * 
 * @author xiaoliang
 * @date 2022/08/14 21:58
 **/
public class La5_2226_每个小孩最多能分到多少糖果 {

    public int maximumCandies(int[] candies, long k) {

        long sum = 0;
        int max = candies[0];
        for (int candy : candies) {
            sum+=candy;
            max = Math.max(max,candy);
        }
        if (sum < k) {
            return 0;
        }
        int left = 0;
        int right = max; //Arrays.stream(candies).max().getAsInt();
        int res = 0;

        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (check(candies, k, mid)) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }

    private boolean check(int[] candies, long k, int mid) {
        if(mid == 0){
            return true;
        }
        long sum = 0;
        for (int candy : candies) {
            if (candy < mid) {
                continue;
            }
            sum += candy / mid;
        }
        return sum >= k;
    }

    public static void main(String[] args) {
        // candies = [5,8,6], k = 3
        int[] candies = {5,8,6};
        int k =3;
        System.out.println(new La5_2226_每个小孩最多能分到多少糖果().maximumCandies(candies, k));
    }
}
