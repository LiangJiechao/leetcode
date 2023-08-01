package leetcode.labuladong.la22bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。
 * 每个拨轮可以自由旋转：例如把 '9' 变为 '0'，'0' 变为 '9' 。
 * 每次旋转都只能旋转一个拨轮的一位数字。
 * <p>
 * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
 * <p>
 * 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
 * <p>
 * 字符串 target 代表可以解锁的数字，你需要给出解锁需要的最小旋转次数，如果无论如何不能解锁，返回 -1 。
 * <p>
 * 输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
 * 输出：6
 * 解释：
 * 可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。
 * 注意 "0000" -> "0001" -> "0002" -> "0102" -> "0202" 这样的序列是不能解锁的，
 * 因为当拨动到 "0102" 时这个锁就会被锁定。
 *
 * @author xiaoliang
 * @date 2022/03/10 10:32
 **/
public class La2_LC752_M_打开转盘锁 {

    /**
     * 指定位置 +1
     *
     * @param s
     * @param i
     * @return
     */
    String plusOne(String s, int i) {
        char[] chars = s.toCharArray();
        if (chars[i] == '9') {
            chars[i] = '0';
        } else {
            chars[i] += 1;
        }
        return String.valueOf(chars);
    }

    /**
     * 指定位置 -1
     *
     * @param s
     * @param i
     * @return
     */
    String subOne(String s, int i) {
        char[] chars = s.toCharArray();
        if (chars[i] == '0') {
            chars[i] = '9';
        } else {
            chars[i] -= 1;
        }
        return String.valueOf(chars);
    }

    // 还有一种解法是双向BFS

    /**
     * 有⼀个⽐较⼩的优化：可以不需要 dead 这个哈希集合，
     * 可以直接将这些元素初始化到 visited 集合中，
     * 效果是⼀样的，可能更加优雅⼀些。
     * @param deadends
     * @param target
     * @return
     */
    public int openLock(String[] deadends, String target) {

        Set<String> deadSet = new HashSet<>(deadends.length);
        for (String s : deadends) {
            deadSet.add(s);
        }

        Set<String> visited = new HashSet<>();
        visited.add("0000");

        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        int step = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();
            for (int i = 0; i < size; i++) {

                String poll = queue.poll();
                /* 判断是否到达终点 */
                if (deadSet.contains(poll)) {
                    continue;
                }
                if (target.equals(poll)) {
                    return step;
                }

                /* 将⼀个节点的未遍历相邻节点加⼊队列 */
                for (int j = 0; j < 4; j++) {
                    String up = plusOne(poll, j);
                    if (!visited.contains(up)) {
                        queue.offer(up);
                        visited.add(up);
                    }

                    String down = subOne(poll, j);
                    if (!visited.contains(down)) {
                        queue.offer(down);
                        visited.add(down);
                    }
                }

            }
            step++;
        }
        return -1;
    }

}
