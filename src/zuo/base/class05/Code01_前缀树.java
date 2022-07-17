package zuo.base.class05;

/**
 * 前缀树 TrieTree
 * 实现 增 删 查
 *
 * @author xiaoliang
 * @date 2021/09/16 16:02
 **/
public class Code01_前缀树 {

    static class TrieNode {
        int pass;
        int end;
        // 26用来表示小写英文字母的单词，可以改用hashMap/TreeMap
        TrieNode[] next;

        public TrieNode() {
            pass = 0;
            end = 0;
            //用 0~25 表示a~z
            next = new TrieNode[26];
        }
    }

    static class Tire {
        TrieNode root;

        public Tire() {
            root = new TrieNode();
        }

        public void insert(String str) {

            if (str == null) {
                return;
            }
            char[] arr = str.toCharArray();
            TrieNode node = root; // 头是不存储东西的，存储的信息体现在边上
            for (int i = 0; i < arr.length; i++) {
                int index = arr[i] - 'a';
                if (node.next[index] == null) {
                    node.next[index] = new TrieNode();
                }
                node = node.next[index];
                node.pass++;
            }
            node.end++;
        }

        public void delete(String str) {

            if (search(str) != 0) {

                char[] arr = str.toCharArray();
                TrieNode node = root;

                for (int i = 0; i < arr.length; i++) {
                    int index = arr[i] - 'a';
                    // pass要减1
                    if (--node.next[index].pass == 0) {
                        node.next[index] = null;
                        return;
                    }
                    node = node.next[index];
                }
                node.end--;
            }
        }

        public int search(String str) {

            if (str == null) {
                return 0;
            }
            char[] arr = str.toCharArray();
            TrieNode node = root; // 头是不存储东西的，存储的信息体现在边上
            for (int i = 0; i < arr.length; i++) {
                int index = arr[i] - 'a';
                // 字典树里面没有
                if (node.next[index] == null) {
                    return 0;
                }
                node = node.next[index];
            }
            return node.end;
        }

        /**
         * 求以该字符串为前缀的字符串个数
         *
         * @param str
         * @return
         */
        public int prefixNumber(String str) {
            if (str == null) {
                return 0;
            }

            TrieNode node = root;
            char[] arr = str.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                int index = arr[i] - 'a';
                if (node.next[index] == null) {
                    return 0;
                }
                node = node.next[index];
            }
            return node.pass;
        }
    }

    public static void main(String[] args) {
        Tire tire = new Tire();

        tire.insert("abc");
        tire.insert("abc");
        tire.insert("abc");
        tire.insert("abc");
        tire.insert("abb");
        tire.insert("aba");
        tire.insert("ae");
        tire.insert("abf");
        tire.insert("abg");
        tire.insert("abq");

        tire.delete("abc");
        tire.delete("ab");

        int abc = tire.search("abc");
        System.out.println("abc = " + abc);

        int ab = tire.prefixNumber("ab");
        System.out.println("ab = " + ab);

    }
}
