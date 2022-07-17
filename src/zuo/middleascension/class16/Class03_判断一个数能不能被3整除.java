package zuo.middleascension.class16;

/**
 * 输入n，则该数为 1 2 3 .. n
 * 如输入10 --> 12345678910
 * 12345678910该数能不能被3整除，等价于 1+2+3+..+10能不能被3整除
 *
 * @author xiaoliang
 * @date 2021/10/09 10:27
 **/
public class Class03_判断一个数能不能被3整除 {

    /**
     * 输入n 则表示该数为 1 2 3 .. n
     * @param n
     * @return
     */
    public static boolean canDivThree(int n){
        return n*(n-1)/2%3 == 0;
    }


}
