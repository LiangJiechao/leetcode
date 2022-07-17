package zuo.baseascension.class08;

/**
 * 马拉车算法，求最长回文串长度
 * 分为两种大情况:
 * 1，如果i在right右边，直接扩
 * 2. 如果i在right和left里面
 * 2.1 如果 i`（i关于middle 对称点）的回文范围在left到middle里面，免检区域为 pArr[i`] 不可扩
 * 2.2 如果 i`（i关于middle 对称点）的回文范围超过left，免检区域为 i`-left 也就是right - i 不可扩
 * 2.3 如果 i`（i关于middle 对称点）的回文范围正好在left，免检区域为 right - i 可扩
 *
 * @author xiaoliang
 * @date 2021/09/19 09:42
 **/
public class Code02_Manacher {

    /**
     * 求最长回文串长度
     *
     * @param str
     * @return
     */
    public static int maxLcpsLength(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        char[] mArr = manacherString(str);
        // 记录最大回文半径
        int[] pArr = new int[mArr.length];
        // 记录中间位置
        int mid = -1;
        //回文右边界再往右一个位置，最右值有效区域是R-1位置
        int right = -1;

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < mArr.length; i++) {
            //分为两种大情况
            //1，如果i在right右边，直接扩
            //2. 如果i在right和left里面
            //2.1 如果 i`（i关于middle 对称点）的回文范围在left到middle里面，免检区域为 pArr[i`] 不可扩
            //2.1 如果 i`（i关于middle 对称点）的回文范围超过left，免检区域为 i`-left 也就是right - i 不可扩
            //2.1 如果 i`（i关于middle 对称点）的回文范围正好在left，免检区域为 right - i 可扩

            pArr[i] = right > i ? Math.min(pArr[2 * mid - i], right - i) : 1;
            // 这里没有分类讨论，因为如果不可扩，会直接break
            while (i + pArr[i] < mArr.length && i - pArr[i] > -1) {
                if (mArr[i + pArr[i]] == mArr[i - pArr[i]]) {
                    pArr[i]++;
                } else {
                    break;
                }
            }

            if (i + pArr[i] > right) {
                right = i + pArr[i];
                mid = i;
            }
            max = Math.max(max, pArr[i]);
        }
        //回文子串的长度 = 回文半径 -1
        return max - 1;
    }

    public static char[] manacherString(String str) {

        char[] arr = str.toCharArray();
        char[] res = new char[arr.length * 2 + 1];
        int index = 0;

        for (int i = 0; i < res.length; i++) {
            // 等价于 res[i] = i % 2 == 0 ? '#' : arr[index++];
            res[i] = (i & 1) == 0 ? '#' : arr[index++];
        }
        return res;
    }

    public static int maxLcpsLength2(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        char[] mArr = manacherString(str);
        // 记录最大回文半径
        int[] pArr = new int[mArr.length];
        // 记录中间位置
        int mid = -1;
        //回文右边界再往右一个位置，最右值有效区域是R-1位置
        int right = -1;

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < mArr.length; i++) {
            //分为两种大情况
            //1，如果i在right右边，直接扩
            //2. 如果i在right和left里面
            //2.1 如果 i`（i关于middle 对称点）的回文范围在left到middle里面，免检区域为 pArr[i`] 不可扩
            //2.1 如果 i`（i关于middle 对称点）的回文范围超过left，免检区域为 i`-left 也就是right - i 不可扩
            //2.1 如果 i`（i关于middle 对称点）的回文范围正好在left，免检区域为 right - i 可扩

//            if (right < i) {
//                while (i + pArr[i] < mArr.length && i - pArr[i] > -1) {
//                    if (mArr[i])
//                }
//            }
//            pArr[i] = right > i ? Math.min(pArr[2 * mid - i], right - i) : 1;
            // 这里没有分类讨论，因为如果不可扩，会直接break
//            while (i + pArr[i] < mArr.length && i - pArr[i] > -1) {
//                if (mArr[i + pArr[i]] == mArr[i - pArr[i]]) {
//                    pArr[i]++;
//                } else {
//                    break;
//                }
//            }

//            if (i + pArr[i] > right) {
//                right = i + pArr[i];
//                mid = i;
//            }
//            max = Math.max(max, pArr[i]);
        }
        //回文子串的长度 = 回文半径 -1
        return max - 1;
    }
}
