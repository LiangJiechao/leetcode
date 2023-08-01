package offer.s360.s20220924.s2;

import java.util.*;

/**
 * 小A的英语考了个不及格，老师很生气，并且发现他英语的语法几乎全错！于是老师决定好好教教他英语语法。
 * <p>
 * 老师想先从句子结构开始教他。一个句子至少需要包含主谓结构，即主语和谓语，并且主语在前，谓语在后。有些句子会在谓语后面加上宾语。避免复杂，本题中句子的顺序严格按照主语-谓语-宾语的顺序（即无宾语前置和倒装等情况）。
 * <p>
 * 老师给了小A三张单词表，分别是主语单词表、谓语单词表和宾语单词表。老师要让小A用这些单词表中的单词来造句，并且规定：谓语有且仅有一个单词，主语和宾语可以包含任意个单词（主语不可为空）。老师暂时不想让小A造出能保证意思通顺的句子，他只想让小A能够学会基本的句子结构就行。
 * <p>
 * 现在，小A根据这些单词造了m条句子，现在假设你是老师，你需要判断每条句子是否符合上述句子结构。
 * <p>
 * 输入描述
 * 第一行三个正整数n1,n2,n3，分别表示主语、谓语、宾语单词表的单词数；
 * <p>
 * 第二行包含n1个单词，单词仅由小写英文字母组成，每两个单词之间有一个空格，单词长度不超过10；
 * <p>
 * 第三行包含n2个单词，其他格式同上；
 * <p>
 * 第四行包含n3个单词，其他格式同上；
 * <p>
 * 第五行一个正整数m；
 * <p>
 * 接下来m行，每行一个句子。句子由若干单词（至少一个）组成，并且保证出现的单词都在上面的单词表内。每两个单词之间一个空格隔开。
 * <p>
 * 数据保证一个单词最多只可做一种句子成分。即每个单词仅会出现在一个单词表上。
 * <p>
 * 1≤n1,n2,n3≤1000,1≤m≤20,1≤句子单词数≤10
 * <p>
 * 输出描述
 * 对于每条句子，如果其符合句子结构，输出一行“YES”（不含引号），否则输出一行“NO”（不含引号）。
 * <p>
 * 样例输入
 * 3 3 3
 * i you he
 * am is are
 * yours his hers
 * 5
 * i am yours
 * you is his
 * he are hers yours
 * i am am yours
 * is his
 * 样例输出
 * YES
 * YES
 * YES
 * NO
 * NO
 *
 * @author xiaoliang
 * @date 2022/09/24 14:56
 **/
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n1 = scanner.nextInt();
        int n2 = scanner.nextInt();
        int n3 = scanner.nextInt();

        Set<String> zhuyuSet = new HashSet();
        Set<String> weiyuSet = new HashSet();
        Set<String> bingyuSet = new HashSet();

        for (int i = 0; i < n1; i++) {
            zhuyuSet.add(scanner.next());
        }
        for (int i = 0; i < n2; i++) {
            weiyuSet.add(scanner.next());
        }
        for (int i = 0; i < n3; i++) {
            bingyuSet.add(scanner.next());
        }

        int m = scanner.nextInt();

        /**
         * 3 3 3
         * i you he
         * am is are
         * yours his hers
         * 5
         * i am yours
         * you is his
         * he are hers yours
         * i am am yours
         * is his
         */
        String s1 = scanner.nextLine();
        for (int i = 0; i < m; i++) {
            String s = scanner.nextLine();
            String[] split = s.split(" ");
//            List<String> list = new ArrayList<>();
//            list.add(scanner.next());
//            String[] split = list.toArray(new String[0]);
            boolean zhuyuFlag = false;
            boolean weiyuFlag = false;
            boolean bingyuFlag = false;

            int j = 0;
            while (true) {
                if (j < split.length && zhuyuSet.contains(split[j])) {
                    j++;
                    zhuyuFlag = true;
                }else {
                    break;
                }
            }
            if (j < split.length && weiyuSet.contains(split[j])) {
                weiyuFlag = true;
                j++;
            }
            while (true) {
                if (j < split.length && bingyuSet.contains(split[j])) {
                    j++;
                }else {
                    break;
                }
            }
            if (j == split.length) {
                bingyuFlag = true;
            }

            if (zhuyuFlag && weiyuFlag && bingyuFlag) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

        }
    }

}
