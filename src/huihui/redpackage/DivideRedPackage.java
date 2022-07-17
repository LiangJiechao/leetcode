package huihui.redpackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 微信分红包算法
 * @author xiaoliang
 * @date 2021/08/27 15:38
 **/
public class DivideRedPackage {

    /**
     * 拆红包，（二倍均值法）
     * 剩余红包金额m,剩余人数n
     * 思想：每次抢到的金额 = 随机区间[0.01, m/n*2-0.01]元
     * @author xiaoliang
     * @date 2021/08/27 15:40
     * @param totalAmount 红包总额
     * @param totalPeople 抢红包人数
     * @return java.util.List<java.lang.Integer> 红包划分列表
     */
    public static List<Integer> divideRedPackage(Integer totalAmount, Integer totalPeople){
        ArrayList<Integer> list = new ArrayList<>();
        Integer restAmount = totalAmount;
        Integer restPeople = totalPeople;

        Random random = new Random();
        for (int i = 0; i < totalPeople - 1; i++) {
            Integer amount = random.nextInt(restAmount/restPeople*2-1)+1;
            restAmount-=amount;
            restPeople--;
            list.add(amount);
        }
        list.add(restAmount);

        return list;
    }

    public static void main(String[] args) {
        List<Integer> list = divideRedPackage(1000, 5);
        list.forEach(System.out::println);
    }

}
