package zuo.base.class06;

/**
 * 暴力递归：
 * 给定一个整型数组arr，代表数值不同的纸牌排成一条线。玩家A和玩家B依次拿走每张纸牌，
 * 规定玩家A先拿，玩家B后拿，但是每个玩家每次只能拿走最左或最右的纸牌，
 * 玩家A 和玩家B都绝顶聪明。请返回最后获胜者的分数
 *
 * @author xiaoliang
 * @date 2021/09/16 16:17
 **/
public class Code05_CardsInLine {

    /**
     * 先手选的
     * 第一次选，选择最好结果
     *
     * @param arr
     * @param left
     * @param right
     * @return
     */
    public static int f(int[] arr, int left, int right) {

        // base case：只剩下最后一个元素
        if (left == right) {
            return arr[left];
        }

        return Math.max(
                arr[left] + s(arr, left + 1, right),
                arr[right] + s(arr, left, right - 1)
        );
    }

    /**
     * 后手选的
     * 第二次选，选择最好结果，剩下最差的给别人
     *
     * @param arr
     * @param left
     * @param right
     * @return
     */
    public static int s(int[] arr, int left, int right) {
        // base case：只剩下最后一个元素
        // 因为是后手，所以只能给对方拿了
        if (left == right) {
            return 0;
        }
        return Math.min(
                f(arr, left + 1, right),
                f(arr, left, right - 1)
        );

    }

    public static int win1(int[] arr) {
        if (arr==null || arr.length==0){
            return 0;
        }

        return Math.max(
                f(arr, 0, arr.length - 1), // 玩家A 先手
                s(arr, 0, arr.length - 1)  // 玩家B 后手
        );
    }

    public static void main(String[] args) {
        int[] arr = {1, 19, 1, 33, 4, 5, 34, 41};

        System.out.println("win1(arr) = " + win1(arr));

    }
}
