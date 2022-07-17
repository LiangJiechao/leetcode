package zuo.middleascension.class15;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

/**
 * 找工作：[{难度,报酬},{难度,报酬}...]
 * 思路，把数组按难度升序排，难度相同按报酬降序排
 * 把难度相同，但报酬低的删掉
 *
 * @author xiaoliang
 * @date 2021/09/29 10:28
 **/
public class Class04_找工作难度报酬 {

    static class Job {
        int hard;
        int money;

        public Job(int hard, int money) {
            this.hard = hard;
            this.money = money;
        }
    }

    static class JobComparator implements Comparator<Job> {

        @Override
        public int compare(Job o1, Job o2) {
            // 把数组按难度升序排，难度相同按报酬降序排
            return o1.hard == o2.hard ? o2.money - o1.money : o1.hard - o2.hard;
        }
    }

    public static int[] getMoney(Job[] job, int[] ability) {
        Arrays.sort(job, new JobComparator());
        TreeMap<Integer, Integer> map = new TreeMap<>();

        map.put(job[0].hard, job[0].money);

        // 把难度相同，但报酬低的删掉
        Job pre = job[0];
        for (int i = 1; i < job.length; i++) {
            if (job[i].hard != pre.hard && job[i].money > pre.money) {
                map.put(job[i].hard, job[i].money);
                pre = job[i];
            }
        }
        int[] ans = new int[ability.length];
        for (int i = 0; i < ability.length; i++) {
            // TreeMap.floorKey
            // 获取指定键对应的条目；
            // 如果不存在这样的条目，则返回小于指定键的最大键的条目；
            // 如果不存在这样的条目，则返回null
            Integer key = map.floorKey(ability[i]);
            ans[i] = key != null ? map.get(key) : 0;
        }
        return ans;
    }

    public static void main(String[] args) {
        Job[] job={new Job(3,3),
                new Job(3,2),
                new Job(3,5),
                new Job(4,3),
                new Job(6,6),
                new Job(5,6)};
        int[] ability = {1,2,3,4,5,6,7,8,9};
        int[] money = getMoney(job, ability);
        for (int item : money) {
            System.out.print(item+" ");
        }
    }
}
