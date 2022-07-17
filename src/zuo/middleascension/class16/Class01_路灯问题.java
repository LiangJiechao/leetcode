package zuo.middleascension.class16;

/**
 * 给定一个字符串，有'.'和'x'两种，'x'表示墙，'.'表示需要照亮的地方，问至少需要多少盏灯
 *
 * @author xiaoliang
 * @date 2021/09/30 14:47
 **/
public class Class01_路灯问题 {

    // 贪心算法
    public static int needLight(String str) {
        if (str == null || str.length() == 0) {
            throw new RuntimeException("参数错误");
        }
        char[] arr = str.toCharArray();
        int light = 0;
        for (int i = 0; i < arr.length;) {
            if (arr[i] == 'x') {
                i++;
            } else { // arr[i] == '.'
                if (i + 1 < arr.length) {
                    if (arr[i + 1] == 'x') {
                        light++;
                        i += 2;
                    } else {
                        // arr[i+1] == '.'
                        light++;
                        i += 3;
                    }
                }else {
                    // 最后一个元素是灯
                    light++;
                    break;
                }
            }
        }
        return light;
    }

    public static void main(String[] args) {
        String str = "x.x.x..xxx..xx.x.x..x...xxxxx...xxx.";  // 10个
        int i = needLight(str);
        System.out.println(i);
    }
}
