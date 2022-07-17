package zuo.middleascension.class12;

/**
 * 给定一个随机函数f()，能生成13~21的数，怎么改成生成52~81的随机函数
 * 思路：
 * 1. 先将随机函数f()转为生成0/1的随机函数，
 * 2. 81-52=29，所以将0/1随机函数改为 0~29的随机函数r(0~29) 0~29转二进制需要5位
 * 3. t(52~81) = r(0~29)+52
 * @author xiaoliang
 * @date 2021/09/25 08:54
 **/
public class Class06_随机问题 {

    // 随机函数f()，能生成13~21的数
    public static int f(){
        // Math.random() ==>随机生成 [0,1)的double类型的数
        // 或
//        Random random = new Random();
//        int j = random.nextInt(21-13+1)+13;

        return (int) (Math.random() * (21 - 13) + 13);
    }

    public static int r01(){
        int value = f();
        while (value == 17){
            value = f();
        }
        if (value<17){
            return 0;
        }else {
            return 1;
        }
    }

    public static int r029(){
        int value =0;
        for (int i = 0; i < 5; i++) {
            value = value<<1;
            value += r01();
        }
        while (value>29) {
            value = r029();
        }
        return value;
    }

    public static int t(){
        return r029()+52;
    }

    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            System.out.println(t());
        }
    }

}
