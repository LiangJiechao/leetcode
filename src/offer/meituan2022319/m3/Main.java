package offer.meituan2022319.m3;

import java.util.Scanner;

/**
 * 比如在上一次同步之后，小团将A机器上的文件f修改成了版本f1， 并在f1没有同步到B机器上时将 B机器上的文件f修改成了版本f2， 则版本管理软件会检测到这一冲突并汇报给小团。
 * 否则版本管理软件会直接使用新版的文件覆盖另一台机器上的旧版文件， 此时不会汇报冲突。
 *
 * 在上一次同步之后，小团修改了他的游戏本上的许多文件和老爷机上的许多文件。 现在给出这些被修改的文件的编号， 请你求出版本管理软件会汇报多少个文件的冲突。
 *
 * 第一行有三个正整数，n(1<=n<=1000000000),m1(1<=m1<=30000),m2(1<=m2<=30000)。 代表文件总数，游戏本上的文件被修改了多少次，以及老爷机上的文件被修改了多少次。
 * 文件编号为1到n。小团的每一次修改都会影响到编号属于一个连续区间中的所有文件。
 *
 * 第二行和第三行中各有m1个正整数，代表游戏本上每次修改被影响到的文件范围。 第二行中的m1个数代表m1次修改中的左端点， 第三行中的m1个数代表m1次修改的右端点。
 *
 * 第四行和第五行中各有m2个正整数，代表老爷机上每次修改被影响到的文件范围。 第二行中的m2个数代表m2次修改中的左端点， 第三行中的m2个数代表m2次修改的右端点。
 *
 * @author xiaoliang
 * @date 2022/03/19 10:53
 **/
public class Main {



    public static void main(String[] args) {
        // n(1<=n<=1000000000),m1(1<=m1<=30000),m2(1<=m2<=30000)。
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m1 = scanner.nextInt();
        int m2 = scanner.nextInt();

        int[] between1Left = new int[m1];
        for (int i = 0; i < m1; i++) {
            between1Left[i] = scanner.nextInt();
        }
        int[] between1Right = new int[m1];
        for (int i = 0; i < m1; i++) {
            between1Right[i] = scanner.nextInt();
        }

        int[] between2Left = new int[m2];
        for (int i = 0; i < m2; i++) {
            between2Left[i] = scanner.nextInt();
        }
        int[] between2Right = new int[m2];
        for (int i = 0; i < m2; i++) {
            between2Right[i] = scanner.nextInt();
        }

        int res = 0;
        int index = 0;
        int start = 0;
        int end = n+1;
        // 第一次
        boolean flag = true;
        while (index < m1 && index < m2) {
//10 2 3
//3 5
//4 8
//1 5 7
//3 5 9
// res = 4
            
            if (!flag && between1Left[index]-start>=0){
                res +=Math.min(between1Right[index], end)-between1Left[index];
            }else if (!flag && between1Right[index]-start>=0){
                res +=between1Right[index]-start+1;
            }
            start = between1Left[index];
            end = between1Right[index];
            flag = false;
            
            if (between2Left[index]-start>=0){
                res +=Math.min(between2Right[index], end)-between2Left[index];
            }else if (between2Right[index]-start>=0){
                res +=between2Right[index]-start+1;
            }
            start = between2Left[index];
            end = between2Right[index];
           
            index++;
        }


        System.out.println(res);
    }
}
