package zuo.baseascension.class08;

/**
 * @author xiaoliang
 * @date 2021/09/18 15:02
 **/
public class Code01_KMP {

    /**
     * 实现与String.indexOf()一样
     * 使用kmp算法
     * @param s
     * @param m
     * @return
     */
    public static int getIndexOf(String s, String m) {

        if (s == null || m == null || m.length() < 1 || s.length() < m.length()) {
            return -1;
        }

        char[] ss = s.toCharArray();
        char[] ms = m.toCharArray();

        int[] next = getNextArray(ms);

        int si = 0;
        int mi = 0;
        while (si < ss.length && mi < ms.length) {
            if (ss[si] == ms[mi]) {
                si++;
                mi++;
            } else if (next[mi]!=-1) {
                mi = next[mi];
            } else {
                // next[mi]==-1，此时 mi=0
                si++;
            }
        }

        return mi==ms.length ? si-mi :-1;
    }

    /**
     * 计算出所有相同前缀，返回next[]
     *
     * @param ms
     * @return
     */
    private static int[] getNextArray(char[] ms) {

        if (ms.length == 1) {
            return new int[]{-1};
        }
        int[] next = new int[ms.length];
        next[0] = -1;
        next[1] = 0;

        //从下标为2开始设置next[]
        int pos = 2;
        // cn表示 pos-1上的信息，也表示next[]中需要和pos-1位置上比较的位置
        int cn = 0;
        while (pos < next.length) {
            if (ms[pos - 1] == ms[cn]) {
                // pos-1与cn上的值相等，生成pos上的值，继续写下一个
                next[pos++] = ++cn;
            } else if (cn == 0) {
                // 在pos位置上的没有相同前缀
                next[pos++] = 0;
            } else {
                cn = next[cn];
            }
        }
        return next;
    }

    public static void main(String[] args) {
        String str = "abcabcababaccc";
        String match = "ababa";

        System.out.println(getIndexOf(str, match));
        System.out.println(str.indexOf(match));
    }

}
