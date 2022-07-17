package recur;

/**
 * 
 * @author xiaoliang
 * @date 2021/09/17 12:02
 **/
public class 倒序输出一个正整数 {

    public static void fun(int num){

        // base case
        if (num==0){
            return;
        }
        // else
        System.out.print(num%10);
        num/=10;
        fun(num);
    }

    public static String fun(int num,String res){

        // base case
        if (num==0){
            return res;
        }else {
            res+=(num%10);
            num/=10;
            return fun(num,res);
        }
    }

    public static void main(String[] args) {
        int num = 12345600;
        String res = "";
        res= fun(num,res);
        System.out.println(res);
    }
}
