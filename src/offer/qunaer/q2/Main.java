package offer.qunaer.q2;


/**
 * @author liangjiechao
 * @date 2022/10/12 16:27
 **/
public class Main {

    public static void main(String[] args) {
        System.out.println(new Main().Decrypt(4296, 1601, 4757) == 228);

    }


    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     * 解密
     *
     * @param encryptedNumber int整型 待解密数字
     * @param decryption      int整型 私钥参数D
     * @param number          int整型 私钥参数N
     * @return int整型
     */
    // 4296,1601,4757
    // 228
    public int Decrypt(int encryptedNumber, int decryption, int number) {
        // write code here

        int res = 0;
        int base = encryptedNumber;

//        int[] map = new int[number];
//        for (int i = 0; i < number; i++) {
//            map[(int)Math.pow(encryptedNumber,i+1)%number] = i+1;
//        }
//        return map[decryption%number+1];


        for (int i = 0; i < decryption; i++) {
            encryptedNumber *= base;
            res = encryptedNumber % number;
            encryptedNumber /= res;
        }

        return res;


    }
}
