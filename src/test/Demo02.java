package test;

public class Demo02 {
    public static void main(String[] args) {
        Demo02 demo02 = new Demo02();
        System.out.println(demo02.getName("bobo"));
    }

    public String getName(String name) {
        String res = "";
        try {
            res = name;
            return res;
        } finally {
            res = "波波烤鸭";
            return res; // 指令中返回的就不是栈帧顶部的数据了 而是 res 对应的栈帧位置
        }
    }
}