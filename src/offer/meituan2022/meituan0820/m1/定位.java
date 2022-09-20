package offer.meituan2022.meituan0820.m1;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
/**
 * 作者：哈利波特/别大
 * 链接：https://www.nowcoder.com/discuss/1021868
 * 来源：牛客网
 * <p>
 * 题目描述：
 * 小团在地图上放了三个定位装置，想依赖他们来进行定位！
 * 小团的地图是一个n×n的一个棋盘，他在(x1,y1),(x2,y2),(x3,y3) xi,yi ∈ Z ∩ [1,n] 这三个位置分别放置了一个定位装置（两两不重叠）。
 * 然后小团在一个特定的位置(a,b)a,b ∈ Z ∩ [1,n]放置了一个信标。每个信标会告诉小团它自身到那个信标的曼哈顿距离，即对i=1,2,3 小团知道(|xi-a|+|yi-b|)，
 * 现在小团想让你帮他找出信标的位置！注意，题目保证最少有一个正确的信标位置。
 * 因为小团不能定位装置确定出来的信标位置是否唯一，如果有多个，输出字典序最小的那个。(a,b)的字典序比(c,d)小，当且仅当 a<c或者a==c∧b<d
 * <p>
 * 第一行一个正整数n，表示棋盘大小。
 * <p>
 * 第二行两个整数，分别表示x1与y1，即第一个定位器的位置。
 * <p>
 * 第三行两个整数，分别表示x2与y2，即第二个定位器的位置。
 * <p>
 * 第四行两个整数，分别表示x3与y3，即第三个定位器的位置。
 * <p>
 * 第五行三个整数，分别表示第一、二、三个定位器到信标的曼哈顿距离。第i个定位器到信标的曼哈顿距离即(|xi-a|+|yi-b|)
 * <p>
 * 数字间两两有空格隔开，对于所有数据， n≤50000,  1≤xi,yi≤n
 */

/**
 * https://www.nowcoder.com/discuss/1021868
 * 3      //格子的大小，点的坐标要满足[1, n]
 * 2 1    //第一个点
 * 2 2    //第二个点
 * 2 3    //第三个点
 * 2 1 2  //分别对应的三个距离
 *
 * 输出 1 2
 * @author xiaoliang
 * @date 2022/08/20 21:44
 **/
public class 定位 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] x = new int[3];
        int[] y = new int[3];
        int[] d = new int[3];
        for (int i = 0; i < 3; i++) {
            x[i] = scanner.nextInt();
            y[i] = scanner.nextInt();
        }
        for (int i = 0; i < 3; i++) {
            d[i] = scanner.nextInt();
        }


        // di = (|xi-a|+|yi-b|)
        Set<String>[] set = new HashSet[3];
        for (int i = 0; i < 3; i++) {
            set[i] = new HashSet<>();
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 1; j <= n; j++) {
                int dy = d[i] - Math.abs(x[i]-j);
                if (dy>=0){
                    int rangeYmin = Math.max(1,y[i]-dy);
                    int rangeYmax = Math.min(n,y[i]+dy);
                    for (int k = rangeYmin; k <= rangeYmax ; k++) {
                        if (Math.abs(y[i]-k) == dy){
                            set[i].add(j+"-"+k);
                        }
                    }
                }
            }
        }

        for (int i = 1; i < 3; i++) {
            set[0].retainAll(set[i]);
        }

        int resX = n;
        int resY = n;
        for (String s : set[0]) {
            String[] split = s.split("-");
            int tmpX = Integer.parseInt(split[0]);
            int tmpY = Integer.parseInt(split[1]);
            if (tmpX < resX ){
                resX = tmpX;
                resY = tmpY;
            }else if (tmpX == resX && tmpY < resY){
                resX = tmpX;
                resY = tmpY;
            }
        }
        System.out.println(resX+" "+resY);



        // n2 ==> 超时
        // (|xi-a|+|yi-b|)，
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <=n; j++) {
//                int flag = 0;
//                for (int k = 0; k < 3; k++) {
//                    if (Math.abs(x[k]-i)+Math.abs(y[k]-j)==d[k]){
//                        flag++;
//                    }else {
//                        break;
//                    }
//                }
//                if (flag==3){
//                    System.out.println(i+" "+j);
//                    return;
//                }
//            }
//        }
    }
}
