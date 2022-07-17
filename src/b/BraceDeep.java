package b;

/**
 * @description:
 * 括号深度
 * 输入:
 * 输入包括一个合法的括号序列s,s长度length(2 ≤ length ≤ 50),序列中只包含'('和')'。
 * 输出:
 * 输出一个正整数,即这个序列的深度。
 * @author xiaoliang
 * @date 2021/6/25 20:17
 * @version 1.0
 */
public class BraceDeep {

    public static  int braceDeep(String str){

        int max = 0;
        int count =0;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i)=='('){
                count++;
                max = Math.max(max,count);
            }else {
                //')'
                count--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(BraceDeep.braceDeep("((()((()))))"));
    }
}
