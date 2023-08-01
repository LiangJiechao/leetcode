package leetcode;

/**
 * 你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。
 * 由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。
 * 假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。
 * 你可以通过调用 bool isBadVersion(version) 接口来判断版本号 version 是否在单元测试中出错。
 * 实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。
 * <p>
 * 思路：二分法，查找最左的错误版本，就是寻找最左边的 true , 类似于二分找firstIndex
 * <p>
 * 输入：n = 5, bad = 4
 * 输出：4
 * 解释：
 * 调用 isBadVersion(3) -> false
 * 调用 isBadVersion(5) -> true
 * 调用 isBadVersion(4) -> true
 * 所以，4 是第一个错误的版本。
 * <p>
 * 输入：n = 1, bad = 1
 * 输出：1
 *
 * @author xiaoliang
 * @date 2021/10/18 09:39
 **/
public class LC278_E_第一个错误的版本 {

    // 可以通过调用 bool isBadVersion(version) 接口来判断版本号 version 是否在单元测试中出错。
    // 找最左边的 true
    public static int firstBadVersion(int n) {
        if (n < 1) {
            throw new RuntimeException("参数错误");
        }
        // 因为调用函数的是版本号，所以不是数组中的下标
        int L = 1;
        int R = n;
        int mid;
        int mostLeftError = n;

        while (L <= R) {
            mid = L + ((R - L) >> 1);
            if (isBadVersion(mid)) {
                // 错误的版本
                mostLeftError = mid;
                R = mid - 1;
            } else {
                // 正确的版本
                L = mid + 1;
            }
        }
        return mostLeftError;
    }

    public static boolean isBadVersion(int version) {
        boolean[] arr = {false, false, false, false, true, true};
        return arr[version];
    }

    public static void main(String[] args) {
        System.out.println(firstBadVersion(5));
    }
}
