package offer.huawei.niuke;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 第一行输入N，表示下面要输入多少个坐标
 * 往后的N行输入x y坐标，空格隔开。
 * 问，输入的N个坐标中能组成多少个正方形。
 *
 * 输入
 * 3
 * 0 0
 * 1 2
 * 3 1
 * 输出
 * 0 （3个点一定构不成一个正方形）
 *
 * 输入
 * 4
 * 0 0
 * 1 2
 * 3 1
 * 2 -1
 * 输出
 * 1
 * @author xiaoliang
 * @date 2022/03/29 11:32
 **/
public class 正方形个数 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<int[]> nums = new ArrayList<>(n+1);
        for (int i = 0; i < n; i++) {
            int[] temp = new int[2];
            temp[0] = scanner.nextInt();
            temp[1] = scanner.nextInt();
            nums.add(temp);
        }
        if (n<4){
            System.out.println(0);
            return;
        }

        // 按横坐标进行排序
        List<int[]> collect = nums.stream().sorted((i1, i2) -> {
            return i1[0] - i2[0];
        }).collect(Collectors.toList());

        LinkedList<int[]> path = new LinkedList<>();
        dfs(collect,0,path);
        System.out.println(res);
    }

    static int res = 0;
    private static void dfs(List<int[]> nums, int startIndex, LinkedList<int[]> path) {
        if (path.size() == 4){
            // 开始判断
            if (isValid(path)){
                res++;
            }
            return ;
        }

        // dfs获取所有组合
        for (int i = startIndex; i <nums.size() ; i++) {
            path.add(nums.get(i));
            dfs(nums,i+1,path);
            path.removeLast();
        }

    }

    private static boolean isValid(LinkedList<int[]> path) {

        int[] A = path.get(0);
        int[] B = path.get(1);
        int[] C = path.get(2);
        int[] D = path.get(3);
        // 相邻两条边 要相等
        boolean b = Math.pow(A[0] - B[0], 2) + Math.pow(A[1] - B[1], 2) == Math.pow(A[0] - C[0], 2) + Math.pow(A[1] - C[1], 2);
        // 对角线 要相等
        boolean b1 = Math.pow(A[0] - D[0], 2) + Math.pow(A[1] - D[1], 2) == Math.pow(B[0] - C[0], 2) + Math.pow(B[1] - C[1], 2);

        return b && b1;
    }
}
