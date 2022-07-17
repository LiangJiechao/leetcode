package recur;

/**
 * 写一个递归函数DigitSum(n)，输入一个非负整数，返回组成它的数字之和，
 * 例如，调用DigitSum(1729)，则应该返回1+7+2+9，它的和是19
 * @author xiaoliang
 * @date 2021/09/17 14:35
 **/
public class DigitSum {

    public static int digitSum(int num){

        if (num==0){
            return 0;
        }else{
//            int sum = 0;
//            sum+=num%10;
//            num/=10;
//            return sum+digitSum(num);
            return num%10+digitSum(num/=10);
        }
    }

    public static void main(String[] args) {
        System.out.println("digitSum(1729) = " + digitSum(172091));
    }
}
