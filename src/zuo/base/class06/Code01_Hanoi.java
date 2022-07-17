package zuo.base.class06;

/**
 * 暴力递归，汉诺塔问题
 * @author xiaoliang
 * @date 2021/09/16 16:12
 **/
public class Code01_Hanoi {

    public static void hanoi(int n) {
        func(n, "左", "中", "右");
    }

    /**
     * 分为三部分，左 ，中，右
     * 假如i个圆盘需要从 左 移动到 右
     * 1. 先将 1 ~ i-1个从 左 移动到 中
     * 2. 再将 第i个 从 左 移动到 右
     * 3. 再将第 1~ i-1从 中 移动到 右
     */
    private static void func(int i, String left, String mid, String right) {

        if (i==1){
            System.out.println(" Move 1 from " + left + " to " + right);
        }else {
            func(i-1,left,right,mid);
            System.out.println(" Move "+i+" from " + left + " to " + right);
            func(i-1,mid,left,right);
        }
    }


    public static void main(String[] args) {
        hanoi(4);
    }

}
