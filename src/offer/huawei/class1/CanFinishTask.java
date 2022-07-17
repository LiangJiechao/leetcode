package offer.huawei.class1;

import java.util.*;
import java.util.stream.Collectors;

/**
 * [[3,5][3,4][3,9][2,8][2,13]]
 * 输入一堆任务，如[3,5]：表示 3是开始时间，5是任务截至时间，每个任务需要1个单位时间做完
 * 问是否能后完成任务
 *
 * @author xiaoliang
 * @date 2022/03/28 21:25
 **/
public class CanFinishTask {

    public boolean canFinishTask2(List<int[]> tasks) {

        // sort  按照时间跨度来排序
        List<int[]> sortNums = tasks.stream().sorted((i1, i2) -> {
            if (i1[1] - i1[0] < i2[1] - i2[0]) {
                return -1;
            } else if (i1[1] - i1[0] > i2[1] - i2[0]) {
                return 1;
            } else {
                return i1[0] - i2[0];
            }
        }).collect(Collectors.toList());

        Integer maxTime = tasks.stream().map(item -> item[1]).max((i1, i2) -> i1 - i2).get();
//        System.out.println(maxTime);
        boolean[] flag = new boolean[maxTime + 1];
        boolean res = true;
        for (int[] item : sortNums) {
            if (!flag[item[0]]) {
                flag[item[0]] = true;
                continue;
            }
            if (!flag[item[1]]) {
                flag[item[1]] = true;
                continue;
            }
            res = false;
            break;
        }

        return res;
//
    }

    public boolean canFinishTask(List<int[]> tasks) {

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((i1, i2) -> {
            return i1[1] - i2[1];
        });

        // sort
        List<int[]> collect = tasks.stream().sorted((i1, i2) ->
                i1[0] - i2[0]
        ).collect(Collectors.toList());

        boolean res = true;
        boolean flag = true;
        int time = collect.get(0)[0];
        int index = 0;
        while (index < collect.size() || !priorityQueue.isEmpty()) {
            int[] item = null;
            if (index < collect.size()) {
                item = collect.get(index);
            } else {
                flag = false;
            }

            if (flag && item[0] == time) {
                priorityQueue.offer(item);
                index++;
            } else {
                if (!priorityQueue.isEmpty()) {
                    int[] poll = priorityQueue.poll();
                    if (poll[1] >= time) {
                        time++;
                    } else {
                        res = false;
                        break;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{3, 3});
        list.add(new int[]{4, 4});
        list.add(new int[]{6, 6});
        list.add(new int[]{5, 5});
        list.add(new int[]{2, 6});
        list.add(new int[]{2, 5});
        System.out.println(new CanFinishTask().canFinishTask(list));
        System.out.println(new CanFinishTask().canFinishTask2(list));

        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            System.out.println(random.nextInt(10)); // 0-9
        }

//        Iterator<int[]> iterator = list.iterator();
//        System.out.println(iterator.hasNext());
//        System.out.println(iterator.hasNext());
//        System.out.println(iterator.hasNext());
//        System.out.println(iterator.hasNext());
//        System.out.println(iterator.hasNext());
    }
}
