package recur;

/**
 * @author xiaoliang
 * @date 2021/09/17 11:59
 **/
public class 阶乘 {

    public static int fun(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n * fun(n - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println("fun(4) = " + fun(5));
    }
}
