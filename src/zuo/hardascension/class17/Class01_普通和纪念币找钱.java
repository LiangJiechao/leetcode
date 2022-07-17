package zuo.hardascension.class17;

/**
 * 给2个数组，一种是普通币数组，里面硬币有任意个；一种是纪念币数组，里面硬币只有一个
 * 给点钱数，找钱，问有几种找法
 *
 * @author xiaoliang
 * @date 2021/10/25 19:28
 **/
public class Class01_普通和纪念币找钱 {

    public static int coins(int[] arr1, int[] arr2, int m) {

        if (arr1 == null || arr2 == null || m < 0) {
            throw new RuntimeException("参数错误");
        }

        // 建立普通币的dp数组，和纪念币的dp数组
//        int[] dp1 = process(arr1, 0, m);
        // TODO: 2021/10/26
        return 0;
    }


}
