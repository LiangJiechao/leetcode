package b;

/**
 * @description:
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 *示例 2：
 * 输入：s = "PAYPALISHIRING", numRows = 4
 * 输出："PINALSIGYAHRPI"
 * 解释：
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 *
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 链接：https://leetcode-cn.com/problems/zigzag-conversion
 * @author xiaoliang
 * @date 2021/7/1 16:40
 * @version 1.0
 */
public class ZConvert {

    public String convert(String s, int numRows) {
        if(numRows==1){
            return s;
        }
        char[][] arr = new char[numRows][s.length()];
        int change=0;
        int i=0,j=0;
        for(char ch : s.toCharArray()){
            if(change==0){
                arr[i][j]=ch;
                if(i==numRows-1){
                    //改变方向
                    change=1;
                    i--;
                    j++;
                }else {
                    i++;
                }
            }else { //change=1
                arr[i][j]=ch;
                if(i==0){
                    //改变方向
                    change=0;
                    i++;
                    j++;
                }else {
                    i--;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < numRows; k++) {
            for (int l = 0; l < s.length(); l++) {
                if(Character.isLetter(arr[k][l])||arr[k][l]==','||arr[k][l]=='.'){
                    sb.append(arr[k][l]);
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ZConvert obj = new ZConvert();
        obj.convert("AB",1);
    }
}
