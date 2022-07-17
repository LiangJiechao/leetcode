package zuo.middleascension.class16;

import java.util.HashMap;
import java.util.Map;

/**
 * 已知二叉树无重复节点，给定中序和先序遍历，求后序遍历顺序
 *
 * @author xiaoliang
 * @date 2021/09/30 15:24
 **/
public class Class02_中序和前序_求后序 {

    public static String getPostOrder(String inOrder, String preOrder) {
        if (inOrder == null || preOrder == null || inOrder.length() != preOrder.length()) {
            throw new RuntimeException("参数错误");
        }
        char[] inArr = inOrder.toCharArray();
        char[] preArr = preOrder.toCharArray();

        char[] postArr = new char[inOrder.length()];

        Map<Character, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inArr.length; i++) {
            // 用于加速找到中序中元素的下标
            inMap.put(inArr[i], i);
        }

        process(inArr, preArr, postArr,
                0, inArr.length - 1,
                0, preArr.length - 1,
                0, postArr.length - 1,
                inMap);
        return String.valueOf(postArr);
    }

    private static void process(char[] inArr, char[] preArr, char[] postArr,
                                int ini, int inj,
                                int prei, int prej,
                                int posti, int postj,
                                Map<Character, Integer> inMap) {

        char ch = preArr[prei];
        // 中序的划分index
        Integer index = inMap.get(ch);
        postArr[postj] = ch;

        if (posti == postj) {
            return;
        }

        // 递归算出左边
        process(inArr, preArr, postArr,
                ini, index - 1,
                prei + 1, prei + 1 + (index - ini - 1),
                posti, posti + (index - ini - 1),
                inMap);
        // 递归算出右边
        process(inArr, preArr, postArr,
                index + 1, inj,
                prei + (index - ini) + 1, prej,
                posti + (index - ini), postj - 1,
                inMap);
    }

    public static void main(String[] args) {
        String inOrder = "dbeac";
        String preOrder = "abdec"; // post = debca
//        String inOrder = "4251637";
//        String preOrder = "1245367"; // post=4526731
        String postOrder = getPostOrder(inOrder, preOrder);

        System.out.println(postOrder);
    }

}
