package zuo.baseascension.class09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 二叉树递归讨论的适用：看题目，要对三方（head，左子树，右子树）的信息进行整合时，可用
 * <p>
 * 求party中的快乐值最大，如果一个人来了，那么他的直接下属就不能来
 * 分析：
 * 分为两种情况：
 * 1.头参与： maxHappy = head.happy + head的直接下属不来的情况下的最大happy + ..
 * 2.头不参与： maxHappy = head.0 + max(直接下属来的情况下的maxHappy,直接下属不来的情况下的maxHappy)
 * 确定讨论返回信息： {comeMaxHappy, notComeMaxHappy}
 *
 * @author xiaoliang
 * @date 2021/09/20 09:26
 **/
public class Code02_MaxHappy {

    static class Employee {
        int happy;
        List<Employee> subordinates;

        public Employee(int happy) {
            this.happy = happy;
        }

        public Employee(int happy, List<Employee> subordinates) {
            this.happy = happy;
            this.subordinates = subordinates;
        }
    }

    static class ReturnData {
        int comeMaxHappy;
        int notComeMaxHappy;

        public ReturnData(int comeMaxHappy, int notComeMaxHappy) {
            this.comeMaxHappy = comeMaxHappy;
            this.notComeMaxHappy = notComeMaxHappy;
        }
    }

    public static int maxHappyInParty(Employee head) {
        if (head == null) {
            return 0;
        }
        ReturnData res = process(head);
        return Math.max(res.comeMaxHappy, res.notComeMaxHappy);
    }

    private static ReturnData process(Employee head) {
        // base case: 叶子节点
        if (head.subordinates == null || head.subordinates.isEmpty()) {
            return new ReturnData(head.happy, 0);
        }

        int comeMaxHappy = head.happy;
        int notComeMaxHappy = 0;

        for (Employee sub : head.subordinates) {
            ReturnData subData = process(sub);
            comeMaxHappy += subData.notComeMaxHappy;
            notComeMaxHappy += Math.max(subData.comeMaxHappy, subData.notComeMaxHappy);
        }
        return new ReturnData(comeMaxHappy, notComeMaxHappy);
    }

    public static void main(String[] args) {

        Employee e = new Employee(100, new ArrayList<>());
        Employee d = new Employee(50, new ArrayList<>());

        Employee b = new Employee(70, Arrays.asList(e));
        Employee c = new Employee(20, Arrays.asList(d));

        Employee a = new Employee(40, Arrays.asList(b, c));

        System.out.println(maxHappyInParty(a));

    }

}
