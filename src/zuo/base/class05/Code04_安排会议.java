package zuo.base.class05;

import java.util.Arrays;

/**
 * 贪心算法：贪心的思路要对，就是要确定怎么贪心才是正确的贪心
 * 贪心算法，安排时间开会 BestArrange
 * 谁先结束谁优先安排
 *
 * @author xiaoliang
 * @date 2021/09/16 16:08
 **/
public class Code04_安排会议 {

    static class Program {
        int start;
        int end;

        public Program(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getEnd() {
            return end;
        }
    }

    public static int bestArrange(Program[] programs, int start) {
//        Arrays.sort(programs, Comparator.comparingInt(Program::getEnd));
        Arrays.sort(programs, (p1, p2) -> {
            return p1.end - p2.end;
        });
        int result = 0;
        for (Program program : programs) {
            if (program.start <= start) {
                start = program.end;
                result++;
            }
        }
        return result;
    }
}
