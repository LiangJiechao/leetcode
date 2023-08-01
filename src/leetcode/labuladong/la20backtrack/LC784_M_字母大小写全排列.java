package leetcode.labuladong.la20backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串 s ，通过将字符串 s 中的每个字母转变大小写，我们可以获得一个新的字符串。
 * 返回 所有可能得到的字符串集合 。以 任意顺序 返回输出。
 *
 * 示例 1：
 * 输入：s = "a1b2"
 * 输出：["a1b2", "a1B2", "A1b2", "A1B2"]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/letter-case-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author liangjiechao
 * @date 2022/10/08 16:44
 **/
public class LC784_M_字母大小写全排列 {


    List<String> res = new ArrayList<>();

    public List<String> letterCasePermutation(String s) {

        // 先全部变为小写
        char[] arr = s.toCharArray();
        for(int i =0;i<s.length();i++){
            if(arr[i]>='A' && arr[i]<='Z'){
                arr[i]= Character.toLowerCase(arr[i]);
            }
        }
        backtrace(arr,0);
        return res;
    }

    private void backtrace(char[] arr, int startIndex) {

        res.add(new String(arr));

        for (int i = startIndex; i < arr.length; i++) {
            if (Character.isLetter(arr[i])){
                arr[i] = Character.toUpperCase(arr[i]);
                backtrace(arr,i+1);
                arr[i] = Character.toLowerCase(arr[i]);
            }
        }

    }

    public static void main(String[] args) {
        String s = "A1B2";
        System.out.println(new LC784_M_字母大小写全排列().letterCasePermutation(s));
    }



}
