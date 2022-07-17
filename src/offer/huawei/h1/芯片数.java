package offer.huawei.h1;

import java.util.Scanner;

/**
 * 作者：牛客433911733号
 * 链接：https://www.nowcoder.com/discuss/919142?type=post&order=create&pos=&page=1&ncTraceId=&channel=-1&source_id=search_post_nctrack&gio_id=24B388B3E038C6EC048F97CF747D6AA7-1651025920168
 * 来源：牛客网
 *
 * 1.芯片上可以承载A、B两种业务，其中每一个芯片为10G容量，A业务需要2.5G，B业务需要10G，A和B业务不能同时在一块芯片上运行（大概是这个意思）
 * 输入：
 * 芯片个数M
 * 业务个数N
 * 业务种类：A B A【类似】
 * 输出：
 * 最后一个业务所在的芯片数和在该芯片上的顺序号
 * 例如：
 * 输入：
 * 5
 * 6
 * A B A B A A
 * 输出：
 * 1 4
 * @author xiaoliang
 * @date 2022/03/30 18:57
 **/
public class 芯片数 {

    /**
     * 5
     * 6
     * A B A B A A
     *
     * 1
     * 4
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.next();
        }
        String last = arr[n-1];
        if (last.equals("A")){
            int aCnt = 0;
            int bCnt = 0;
            int aGrid = 0;
            for (int i = 0; i < n; i++) {
                if (arr[i].equals("A")){
                    aCnt++;
                    if (aCnt%4==0){
                        aGrid++;
                    }
                }else {
                    bCnt++;
                }
            }

        }else {
            // last.equals("B")

        }

        int indexA = 0;
        int indexB = m-1;
        int xinpianshu = 0;
        for (int i =0;i<n;i++) {
            String num = arr[i];
            if(num.equals("A")){
                indexA++;
            }else if (num.equals("B")){
                indexB++;
            }
        }
        if (indexA%4!=0) {
            xinpianshu+=1;
        }
        xinpianshu += (indexA/4+indexB);
        System.out.println(xinpianshu);
        System.out.println(indexB);

    }
}
